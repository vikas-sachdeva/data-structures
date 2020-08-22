package jsample;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MinHeapTest {

    private MinHeap<Integer> minHeap = new MinHeap<>();

    @Test
    public void containsTest() {
        List<Integer> list = Arrays.asList(33, 21, 23, 44, 1, 5, 7, 3, 99, 7, 4, 2);
        list.forEach(i -> minHeap.insert(i));
        Collections.sort(list);
        AssertionsForInterfaceTypes.assertThat(minHeap.contains(23)).isTrue();
        AssertionsForInterfaceTypes.assertThat(minHeap.contains(3)).isTrue();
        AssertionsForInterfaceTypes.assertThat(minHeap.contains(32)).isFalse();
        AssertionsForInterfaceTypes.assertThat(minHeap.contains(33)).isTrue();
        AssertionsForInterfaceTypes.assertThat(minHeap.contains(2)).isTrue();
        AssertionsForInterfaceTypes.assertThat(minHeap.contains(6)).isFalse();
    }

    @Test
    public void extractMinTest() {
        List<Integer> list = new Random().ints(50).boxed().collect(Collectors.toList());
        list.forEach(i -> minHeap.insert(i));
        Collections.sort(list);
        list.forEach(i -> AssertionsForInterfaceTypes.assertThat(minHeap.extractMin()).isEqualTo(i));
        AssertionsForInterfaceTypes.assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> minHeap.extractMin());
    }
}