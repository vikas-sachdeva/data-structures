package jsample;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BstTest {

    private RecursiveBst<Integer> integerRecursiveBst = new RecursiveBst<>();

    private Bst<Integer> integerBst = new Bst<>();

    @Test
    public void traversalTest1() {
        List<Integer> list = Arrays.asList(10, 20, 30, 3, 6, 5, 8, 1);
        list.forEach(i -> integerRecursiveBst.add(i));
        list.forEach(i -> integerBst.add(i));
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.preOrderTraversal()).containsExactly(10, 3, 1, 6, 5, 8, 20, 30);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.postOrderTraversal()).containsExactly(1, 5, 8, 6, 3, 30, 20, 10);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.levelOrderTraversal()).containsExactly(10, 3, 20, 1, 6, 30, 5, 8);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.reverseLevelOrderTraversal()).containsExactly(5, 8, 1, 6, 30, 3, 20, 10);

        AssertionsForInterfaceTypes.assertThat(integerBst.levelOrderTraversal()).containsExactly(10, 3, 20, 1, 6, 30, 5, 8);
        AssertionsForInterfaceTypes.assertThat(integerBst.reverseLevelOrderTraversal()).containsExactly(5, 8, 1, 6, 30, 3, 20, 10);
        AssertionsForInterfaceTypes.assertThat(integerBst.preOrderTraversal()).containsExactly(10, 3, 1, 6, 5, 8, 20, 30);

        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
    }

    @Test
    public void traversalTest2() {
        List<Integer> list = Arrays.asList(60, 50, 56, 77, 44, 59, 45, 71);
        list.forEach(i -> integerRecursiveBst.add(i));
        list.forEach(i -> integerBst.add(i));
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.preOrderTraversal()).containsExactly(60, 50, 44, 45, 56, 59, 77, 71);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.postOrderTraversal()).containsExactly(45, 44, 59, 56, 50, 71, 77, 60);

        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.levelOrderTraversal()).containsExactly(60, 50, 77, 44, 56, 71, 45, 59);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.reverseLevelOrderTraversal())
                .containsExactly(45, 59, 44, 56, 71, 50, 77, 60);

        AssertionsForInterfaceTypes.assertThat(integerBst.levelOrderTraversal()).containsExactly(60, 50, 77, 44, 56, 71, 45, 59);
        AssertionsForInterfaceTypes.assertThat(integerBst.reverseLevelOrderTraversal()).containsExactly(45, 59, 44, 56, 71, 50, 77, 60);
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerBst.inOrderTraversal()).containsExactlyElementsOf(list);
    }

    @Test
    public void containsTest() {
        List<Integer> list = Arrays.asList(33, 21, 23, 44, 1, 5, 7, 3, 99, 7, 4, 2);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.contains(23)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.contains(3)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.contains(32)).isFalse();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.contains(33)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.contains(2)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.contains(6)).isFalse();
    }

    @Test
    public void traversalTest3() {
        List<Integer> list = new Random().ints(50).boxed().collect(Collectors.toList());
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        System.out.println(integerRecursiveBst.inOrderTraversal());
    }

    @Test
    public void removeTest1() {
        integerRecursiveBst.add(100);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactly(100);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(100)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).doesNotContain(100).isEmpty();
    }

    @Test
    public void removeTest2() {
        List<Integer> list = Arrays.asList(100, 110);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(100)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).doesNotContain(100).containsExactly(110);
    }

    @Test
    public void removeTest3() {
        List<Integer> list = Arrays.asList(100, 90);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(100)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).doesNotContain(100).containsExactly(90);
    }

    @Test
    public void removeTest4() {
        List<Integer> list = Arrays.asList(100, 90, 110);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(100)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).doesNotContain(100).containsExactly(90, 110);
    }

    @Test
    public void removeTest5() {
        List<Integer> list = Arrays.asList(100, 90, 110, 105);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(100)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).doesNotContain(100).containsExactly(90, 105, 110);
    }

    @Test
    public void removeTest6() {
        List<Integer> list = Arrays.asList(100, 90, 110, 105, 107);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(100)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal())
                .doesNotContain(100)
                .containsExactly(90, 105, 107, 110);
    }

    @Test
    public void removeTest7() {
        List<Integer> list = Arrays.asList(100, 90, 110, 105, 107, 112, 106, 111, 113, 80, 95, 83);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(83)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(83)).isFalse();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(106)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(80)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(113)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal())
                .doesNotContain(83, 106, 80, 113)
                .containsExactly(90, 95, 100, 105, 107, 110, 111, 112);
    }

    @Test
    public void removeTest8() {
        List<Integer> list = Arrays.asList(100, 90, 110, 105, 107, 112, 106, 111, 113, 80, 95, 83);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(80)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(107)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal())
                .doesNotContain(80, 107)
                .containsExactly(83, 90, 95, 100, 105, 106, 110, 111, 112, 113);
    }

    @Test
    public void removeTest9() {
        List<Integer> list = Arrays.asList(100, 90, 110, 105, 107, 112, 106, 111, 113, 80, 95, 83);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(90)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(112)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal())
                .doesNotContain(90, 112)
                .containsExactly(80, 83, 95, 100, 105, 106, 107, 110, 111, 113);
    }

    @Test
    public void removeTest10() {
        List<Integer> list = Arrays.asList(100, 90, 110, 105, 107, 113, 106, 111, 112, 80, 95, 83);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(110)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal())
                .doesNotContain(110)
                .containsExactly(80, 83, 90, 95, 100, 105, 106, 107, 111, 112, 113);
    }

    @Test
    public void removeTest11() {
        List<Integer> list = Arrays.asList(100, 90, 110, 105, 107, 113, 106, 111, 112, 80, 95, 83);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(100)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal())
                .doesNotContain(100)
                .containsExactly(80, 83, 90, 95, 105, 106, 107, 110, 111, 112, 113);
    }

    @Test
    public void removeTest12() {
        List<Integer> list = Arrays.asList(100, 90, 110, 105, 107, 113, 106, 111, 112, 80, 95, 83);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(111)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(113)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(105)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(100)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal())
                .doesNotContain(111, 113, 105, 100)
                .containsExactly(80, 83, 90, 95, 106, 107, 110, 112);
    }

    @Test
    public void removeTest13() {
        List<Integer> list = Arrays.asList(100, 90, 110, 105, 107, 113, 106, 111, 80, 95, 83);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(110)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal())
                .doesNotContain(110)
                .containsExactly(80, 83, 90, 95, 100, 105, 106, 107, 111, 113);
    }

    @Test
    public void removeTest14() {
        List<Integer> list = Arrays.asList(100, 90, 110, 105, 107, 113, 106, 111, 80, 95, 83, 93);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(90)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal())
                .doesNotContain(90)
                .containsExactly(80, 83, 93, 95, 100, 105, 106, 107, 110, 111, 113);
    }

    @Test
    public void removeTest15() {
        List<Integer> list = Arrays.asList(100, 90, 110, 105, 107, 113, 106, 111, 80, 95, 83, 93, 94);
        list.forEach(i -> integerRecursiveBst.add(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal()).containsExactlyElementsOf(list);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.remove(90)).isTrue();
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.inOrderTraversal())
                .doesNotContain(90)
                .containsExactly(80, 83, 93, 94, 95, 100, 105, 106, 107, 110, 111, 113);
    }

    @Test
    public void findHeightTest1() {
        List<Integer> list = Arrays.asList(10, 20, 30, 3, 6, 5, 8, 1);
        list.forEach(i -> integerRecursiveBst.add(i));
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.findHeight()).isEqualTo(3);
    }

    @Test
    public void findHeightTest2() {
        List<Integer> list = Arrays.asList(60, 50, 56, 77, 44, 59, 45, 71);
        list.forEach(i -> integerRecursiveBst.add(i));
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.findHeight()).isEqualTo(3);
    }

    @Test
    public void findHeightTest3() {
        AssertionsForInterfaceTypes.assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> integerRecursiveBst.findHeight());
    }

    @Test
    public void findHeightTest4() {
        integerRecursiveBst.add(40);
        AssertionsForInterfaceTypes.assertThat(integerRecursiveBst.findHeight()).isEqualTo(0);
    }
}