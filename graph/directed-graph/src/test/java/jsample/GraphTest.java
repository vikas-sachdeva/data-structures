package jsample;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GraphTest {

    private Graph graph = new Graph();

    private Node<Integer> integerNode;

    @BeforeEach
    public void init() {
        integerNode = new Node<>(50);
        Node<Integer> node20 = new Node<>(20);
        Node<Integer> node22 = new Node<>(22);
        Node<Integer> node24 = new Node<>(24);
        Node<Integer> node26 = new Node<>(26);
        Node<Integer> node17 = new Node<>(17);
        Node<Integer> node15 = new Node<>(15);
        Node<Integer> node13 = new Node<>(13);
        Node<Integer> node11 = new Node<>(11);
        Node<Integer> node9 = new Node<>(9);
        integerNode.addNodes(node20, node22);
        node20.addNodes(node24, node26);
        node22.addNodes(node26, node17);
        node24.addNodes(node26, node15, node13);
        node13.addNodes(node17, node11, node9);
        node17.addNodes(node11);
    }

    @Test
    public void dfsTest1() {
        AssertionsForInterfaceTypes.assertThat(graph.dfs(integerNode)).containsExactly(50, 22, 17, 11, 26, 20, 24, 13, 9, 15);
    }

    @Test
    public void dfsTest2() {
        AssertionsForInterfaceTypes.assertThat(graph.dfs(integerNode.getNodes().get(1)))
                                   .containsExactly(22, 17, 11, 26);
    }

    @Test
    public void dfsTest3() {
        AssertionsForInterfaceTypes.assertThat(graph.dfs(integerNode.getNodes().get(0).getNodes().get(0)))
                                   .containsExactly(24, 13, 9, 11, 17, 15, 26);
    }

    @Test
    public void bfsTest1() {
        AssertionsForInterfaceTypes.assertThat(graph.bfs(integerNode)).containsExactly(50, 20, 22, 24, 26, 17, 15, 13, 11, 9);
    }

    @Test
    public void bfsTest2() {
        AssertionsForInterfaceTypes.assertThat(graph.bfs(integerNode.getNodes().get(1)))
                                   .containsExactly(22, 26, 17, 11);
    }

    @Test
    public void bfsTest3() {
        AssertionsForInterfaceTypes.assertThat(graph.bfs(integerNode.getNodes().get(0).getNodes().get(0)))
                                   .containsExactly(24, 26, 15, 13, 17, 11, 9);
    }
}