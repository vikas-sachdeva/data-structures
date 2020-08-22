package jsample;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MaxHeapTest {

    private MaxHeap<Integer> maxHeap = new MaxHeap<>();

    @Test
    public void containsTest() {
        List<Integer> list = Arrays.asList(33, 21, 23, 44, 1, 5, 7, 3, 99, 7, 4, 2);
        list.forEach(i -> maxHeap.insert(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(maxHeap.contains(23)).isTrue();
        AssertionsForInterfaceTypes.assertThat(maxHeap.contains(3)).isTrue();
        AssertionsForInterfaceTypes.assertThat(maxHeap.contains(32)).isFalse();
        AssertionsForInterfaceTypes.assertThat(maxHeap.contains(33)).isTrue();
        AssertionsForInterfaceTypes.assertThat(maxHeap.contains(2)).isTrue();
        AssertionsForInterfaceTypes.assertThat(maxHeap.contains(6)).isFalse();
    }

    @Test
    public void extractMaxTest2() {
        List<Integer> list = new Random().ints(50).boxed().collect(Collectors.toList());
        list.forEach(i -> maxHeap.insert(i));
        Collections.sort(list, Collections.reverseOrder());
        list.forEach(i -> AssertionsForInterfaceTypes.assertThat(maxHeap.extractMax()).isEqualTo(i));
        AssertionsForInterfaceTypes.assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> maxHeap.extractMax());
    }
}