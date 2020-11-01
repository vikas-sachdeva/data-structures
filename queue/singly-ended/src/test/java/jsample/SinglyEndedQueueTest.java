package jsample;

import jsample.exceptions.QueueEmptyException;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SinglyEndedQueueTest {

    private SinglyEndedQueue<Integer> integerSinglyEndedQueue = new SinglyEndedQueue<>();

    private SinglyEndedQueue<String> stringSinglyEndedQueue = new SinglyEndedQueue<>();

    @BeforeEach
    public void setup() {
        stringSinglyEndedQueue.enque("First");
        stringSinglyEndedQueue.enque("middle");
        stringSinglyEndedQueue.enque("Last");
    }

    @Test
    public void enqueDequeTest1() {
        List<Integer> input = Arrays.asList(10, 20, 40, 2, 1);
        input.forEach(i -> integerSinglyEndedQueue.enque(i));
        AssertionsForInterfaceTypes.assertThat(integerSinglyEndedQueue.deque()).isEqualTo(10);
        AssertionsForInterfaceTypes.assertThat(integerSinglyEndedQueue.deque()).isEqualTo(20);
        AssertionsForInterfaceTypes.assertThat(integerSinglyEndedQueue.deque()).isEqualTo(40);
        AssertionsForInterfaceTypes.assertThat(integerSinglyEndedQueue.deque()).isEqualTo(2);
        AssertionsForInterfaceTypes.assertThat(integerSinglyEndedQueue.deque()).isEqualTo(1);
    }

    @Test
    public void enqueDequeTest2() {
        AssertionsForInterfaceTypes.assertThatExceptionOfType(QueueEmptyException.class).isThrownBy(() -> integerSinglyEndedQueue.deque());
        AssertionsForInterfaceTypes.assertThat(integerSinglyEndedQueue.isEmpty()).isTrue();
        List<Integer> input = Arrays.asList(10, 20);
        input.forEach(i -> integerSinglyEndedQueue.enque(i));
        AssertionsForInterfaceTypes.assertThat(integerSinglyEndedQueue.isEmpty()).isFalse();
        AssertionsForInterfaceTypes.assertThat(integerSinglyEndedQueue.deque()).isEqualTo(10);
        AssertionsForInterfaceTypes.assertThat(integerSinglyEndedQueue.deque()).isEqualTo(20);
        AssertionsForInterfaceTypes.assertThatExceptionOfType(QueueEmptyException.class).isThrownBy(() -> integerSinglyEndedQueue.deque());
        AssertionsForInterfaceTypes.assertThat(integerSinglyEndedQueue.isEmpty()).isTrue();
    }

    @Test
    public void containsTest1() {
        AssertionsForInterfaceTypes.assertThat(stringSinglyEndedQueue.contains("First")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSinglyEndedQueue.contains("Middle")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringSinglyEndedQueue.contains("Last")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSinglyEndedQueue.contains("Last1")).isFalse();
    }

    @Test
    public void getAllDataTest1() {
        AssertionsForInterfaceTypes.assertThat(stringSinglyEndedQueue.getAllData()).containsExactly("First", "middle", "Last");
        stringSinglyEndedQueue.enque("temp");
        AssertionsForInterfaceTypes.assertThat(stringSinglyEndedQueue.getAllData()).containsExactly("First", "middle", "Last", "temp");
    }
}