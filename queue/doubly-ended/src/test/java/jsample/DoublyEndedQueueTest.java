package jsample;

import jsample.exceptions.QueueEmptyException;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DoublyEndedQueueTest {

    private DoublyEndedQueue<Integer> integerDoublyEndedQueue = new DoublyEndedQueue<>();

    private DoublyEndedQueue<String> stringDoublyEndedQueue = new DoublyEndedQueue<>();

    @BeforeEach
    public void setup() {
        stringDoublyEndedQueue.enqueHead("First");
        stringDoublyEndedQueue.enqueTail("middle");
        stringDoublyEndedQueue.enqueTail("Last");
    }

    @Test
    public void enqueDequeTest1() {
        List<Integer> input = Arrays.asList(10, 20, 40, 2, 1);
        input.forEach(i -> integerDoublyEndedQueue.enqueTail(i));
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeHead()).isEqualTo(10);
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeHead()).isEqualTo(20);
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeHead()).isEqualTo(40);
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeHead()).isEqualTo(2);
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeHead()).isEqualTo(1);
    }

    @Test
    public void enqueDequeTest2() {
        List<Integer> input = Arrays.asList(10, 20, 40, 2, 1);
        input.forEach(i -> integerDoublyEndedQueue.enqueHead(i));
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeHead()).isEqualTo(1);
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeHead()).isEqualTo(2);
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeHead()).isEqualTo(40);
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeHead()).isEqualTo(20);
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeHead()).isEqualTo(10);
    }

    @Test
    public void enqueDequeTest3() {
        AssertionsForInterfaceTypes.assertThatExceptionOfType(QueueEmptyException.class)
                .isThrownBy(() -> integerDoublyEndedQueue.dequeHead());
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.isEmpty()).isTrue();
        List<Integer> input1 = Arrays.asList(10, 20);
        input1.forEach(i -> integerDoublyEndedQueue.enqueHead(i));
        List<Integer> input2 = Arrays.asList(40, 30);
        input2.forEach(i -> integerDoublyEndedQueue.enqueTail(i));
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.isEmpty()).isFalse();
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeHead()).isEqualTo(20);
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeTail()).isEqualTo(30);
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeTail()).isEqualTo(40);
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.dequeTail()).isEqualTo(10);
        AssertionsForInterfaceTypes.assertThatExceptionOfType(QueueEmptyException.class)
                .isThrownBy(() -> integerDoublyEndedQueue.dequeTail());
        AssertionsForInterfaceTypes.assertThat(integerDoublyEndedQueue.isEmpty()).isTrue();
    }

    @Test
    public void containsTest1() {
        AssertionsForInterfaceTypes.assertThat(stringDoublyEndedQueue.contains("First")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringDoublyEndedQueue.contains("Middle")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringDoublyEndedQueue.contains("Last")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringDoublyEndedQueue.contains("Last1")).isFalse();
    }

    @Test
    public void getAllDataTest1() {
        AssertionsForInterfaceTypes.assertThat(stringDoublyEndedQueue.getAllData()).containsExactly("First", "middle", "Last");
        AssertionsForInterfaceTypes.assertThat(stringDoublyEndedQueue.getAllDataInReverseOrder()).containsExactly("Last", "middle", "First");
        stringDoublyEndedQueue.enqueHead("temp");
        AssertionsForInterfaceTypes.assertThat(stringDoublyEndedQueue.getAllData()).containsExactly("temp", "First", "middle", "Last");
        AssertionsForInterfaceTypes.assertThat(stringDoublyEndedQueue.getAllDataInReverseOrder()).containsExactly("Last", "middle", "First", "temp");
        stringDoublyEndedQueue.enqueTail("temp");
        AssertionsForInterfaceTypes.assertThat(stringDoublyEndedQueue.getAllData())
                .containsExactly("temp", "First", "middle", "Last", "temp");
        AssertionsForInterfaceTypes.assertThat(stringDoublyEndedQueue.getAllDataInReverseOrder()).containsExactly("temp", "Last", "middle", "First", "temp");
    }
}