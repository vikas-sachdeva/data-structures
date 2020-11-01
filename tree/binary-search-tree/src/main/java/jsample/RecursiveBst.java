package jsample;

import java.util.ArrayList;
import java.util.List;

public class RecursiveBst<T extends Comparable<T>> {

    private Node<T> root;

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (root == null) {
            root = node;
        } else {
            Node<T> parent = findSuitableNode(root, data);
            if (parent.getData().compareTo(data) > 0) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        }
    }

    private Node<T> findSuitableNode(Node<T> node, T data) {
        if (node.getData().compareTo(data) > 0) {
            if (node.getLeft() == null) {
                return node;
            } else {
                return findSuitableNode(node.getLeft(), data);
            }
        } else {
            if (node.getRight() == null) {
                return node;
            } else {
                return findSuitableNode(node.getRight(), data);
            }
        }
    }

    public List<T> preOrderTraversal() {
        List<T> list = new ArrayList<>();
        preOrderTraversal(root, list);
        return list;
    }

    private void preOrderTraversal(Node<T> node, List<T> list) {
        if (node != null) {
            list.add(node.getData());
            preOrderTraversal(node.getLeft(), list);
            preOrderTraversal(node.getRight(), list);
        }
    }

    public List<T> inOrderTraversal() {
        List<T> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private void inOrderTraversal(Node<T> node, List<T> list) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), list);
            list.add(node.getData());
            inOrderTraversal(node.getRight(), list);
        }
    }

    public List<T> postOrderTraversal() {
        List<T> list = new ArrayList<>();
        postOrderTraversal(root, list);
        return list;
    }

    private void postOrderTraversal(Node<T> node, List<T> list) {
        if (node != null) {
            postOrderTraversal(node.getLeft(), list);
            postOrderTraversal(node.getRight(), list);
            list.add(node.getData());
        }
    }

    private Node<T> find(T data) {
        return find(root, data);
    }

    private Node<T> find(Node<T> node, T data) {
        if (node == null || node.getData().equals(data)) {
            return node;
        } else {
            if (node.getData().compareTo(data) > 0) {
                return find(node.getLeft(), data);
            } else {
                return find(node.getRight(), data);
            }
        }
    }

    public boolean contains(T data) {
        return find(data) != null;

    }

    private FatherChildNodePair<T> findFatherChildNodePair(Node<T> parent, Node<T> node, T data) {
        if (node == null) {
            return null;
        }
        if (node.getData().equals(data)) {
            return new FatherChildNodePair<>(parent, node);
        } else {
            if (node.getData().compareTo(data) > 0) {
                return findFatherChildNodePair(node, node.getLeft(), data);
            } else {
                return findFatherChildNodePair(node, node.getRight(), data);
            }
        }
    }

    public boolean remove(T data) {
        FatherChildNodePair<T> fatherChildNodePair = findFatherChildNodePair(null, root, data);
        if (fatherChildNodePair == null) {
            return false;
        }
        Node<T> father = fatherChildNodePair.getFather();
        Node<T> node = fatherChildNodePair.getChild();
        if (father == null) {
            removeRootNode();
            return true;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            removeLeafNode(father, node);
        } else if (node.getLeft() == null || node.getRight() == null) {
            removeNodeWithOneChild(father, node);
        } else {
            removeNodeWithTwoChild(father, node);
        }
        return true;
    }

    public int findHeight() {
        if (root == null) {
            throw new IllegalStateException("Tree does not exist");
        }
        return findHeight(root);
    }

    private int findHeight(Node<T> node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return 0;
        }
        int leftSubTreeHeight = 0;
        int rightSubTreeHeight = 0;
        if (node.getLeft() != null) {
            leftSubTreeHeight = findHeight(node.getLeft());
        }
        if (node.getRight() != null) {
            rightSubTreeHeight = findHeight(node.getRight());
        }
        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
    }

    public List<T> levelOrderTraversal() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        int height = findHeight();
        for (int i = 0; i <= height; i++) {
            traverseElementAtLevel(list, root, i);
        }
        return list;
    }

    public List<T> reverseLevelOrderTraversal() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        int height = findHeight();
        for (int i = height; i >= 0; i--) {
            traverseElementAtLevel(list, root, i);
        }
        return list;
    }

    private void traverseElementAtLevel(List<T> list, Node<T> node, int level) {
        if (node == null) {
            return;
        }
        if (level == 0) {
            list.add(node.getData());
        } else {
            traverseElementAtLevel(list, node.getLeft(), level - 1);
            traverseElementAtLevel(list, node.getRight(), level - 1);
        }
    }

    private void removeRootNode() {
        if (root.getLeft() == null && root.getRight() == null) {
            removeLeafRootNode();
        } else if (root.getRight() == null || root.getLeft() == null) {
            removeRootNodeWithOneChild();
        } else {
            removeRootNodeWithTwoChild();
        }
    }

    private void removeRootNodeWithTwoChild() {
        Node<T> temp = root;
        if (root.getRight().getLeft() == null) {
            root = root.getRight();
            root.setLeft(temp.getLeft());
        } else {
            FatherChildNodePair<T> fatherChildNodePair = findLeftMostNode(root, root.getRight());
            root = fatherChildNodePair.getChild();
            root.setLeft(temp.getLeft());
            if (root.getRight() != null) {
                fatherChildNodePair.getFather().setLeft(root.getRight());
            } else {
                fatherChildNodePair.getFather().setLeft(null);
            }
            root.setRight(temp.getRight());
        }
    }

    private void removeRootNodeWithOneChild() {
        root = root.getLeft() == null ? root.getRight() : root.getLeft();
    }

    private void removeLeafRootNode() {
        root = null;
    }

    private void removeLeafNode(Node<T> father, Node<T> node) {
        if (father.getLeft() == node) {
            father.setLeft(null);
        } else {
            father.setRight(null);
        }
    }

    private void removeNodeWithOneChild(Node<T> father, Node<T> node) {
        if (father.getLeft() == node) {
            father.setLeft(node.getLeft() == null ? node.getRight() : node.getLeft());
        } else {
            father.setRight(node.getLeft() == null ? node.getRight() : node.getLeft());
        }
    }

    private void removeNodeWithTwoChild(Node<T> father, Node<T> node) {
        if (father.getLeft() == node) {
            if (node.getRight().getLeft() == null) {
                father.setLeft(node.getRight());
                father.getLeft().setLeft(node.getLeft());
            } else {
                FatherChildNodePair<T> fatherChildNodePair = findLeftMostNode(node, node.getRight());
                father.setLeft(fatherChildNodePair.getChild());
                father.getLeft().setLeft(node.getLeft());
                if (father.getLeft().getRight() != null) {
                    fatherChildNodePair.getFather().setLeft(father.getLeft().getRight());
                } else {
                    fatherChildNodePair.getFather().setLeft(null);
                }
                father.getLeft().setRight(node.getRight());
            }
        } else {
            if (node.getRight().getLeft() == null) {
                father.setRight(node.getRight());
                father.getRight().setLeft(node.getLeft());
            } else {
                FatherChildNodePair<T> fatherChildNodePair = findLeftMostNode(node, node.getRight());
                father.setRight(fatherChildNodePair.getChild());
                father.getRight().setLeft(node.getLeft());
                if (father.getRight().getRight() != null) {
                    fatherChildNodePair.getFather().setLeft(father.getRight().getRight());
                } else {
                    fatherChildNodePair.getFather().setLeft(null);
                }
                father.getRight().setRight(node.getRight());
            }
        }
    }

    private FatherChildNodePair<T> findLeftMostNode(Node<T> father, Node<T> node) {
        if (node.getLeft() == null) {
            return new FatherChildNodePair<>(father, node);
        }
        return findLeftMostNode(node, node.getLeft());
    }
}

class FatherChildNodePair<T> {

    private Node<T> father;

    private Node<T> child;

    public FatherChildNodePair(Node<T> father, Node<T> child) {
        this.father = father;
        this.child = child;
    }

    public Node<T> getFather() {
        return father;
    }

    public Node<T> getChild() {
        return child;
    }
}