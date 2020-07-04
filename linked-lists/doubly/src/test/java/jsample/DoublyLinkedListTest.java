package jsample;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();

    private DoublyLinkedList<String> stringDoublyLinkedList = new DoublyLinkedList<>();

    @BeforeEach
    public void setup() {
        stringDoublyLinkedList.addFirst("First");
        stringDoublyLinkedList.addLast("middle");
        stringDoublyLinkedList.addLast("Last");
    }

    @Test
    public void getAllDataTest1() {
        List<Integer> input = Arrays.asList(10, 20, 40, 2, 1);
        input.forEach(i -> integerDoublyLinkedList.addLast(i));
        AssertionsForInterfaceTypes.assertThat(integerDoublyLinkedList.getAllData()).containsExactlyElementsOf(input);
    }

    @Test
    public void getAllDataTest2() {
        List<Integer> input = Arrays.asList(10, 2, 4, 11, 2, 0, 99, 4);
        input.forEach(i -> integerDoublyLinkedList.addFirst(i));
        AssertionsForInterfaceTypes.assertThat(integerDoublyLinkedList.getAllDataInReverseOrder()).containsExactlyElementsOf(input);
    }

    @Test
    public void getLastNodeTest() {
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.getLastNode().getData()).isEqualTo("Last");
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.remove("Last")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.getLastNode().getData()).isEqualTo("middle");
    }

    @Test
    public void containsTest1() {
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.contains("First")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.contains("Middle")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.contains("Last")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.contains("Last1")).isFalse();
    }

    @Test
    public void removeTest1() {
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.remove("First")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.getAllData()).containsExactly("middle", "Last");
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.remove("First")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.getAllData()).containsExactly("middle", "Last");
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.remove("Last")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.getAllData()).containsExactly("middle");
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.remove("middle")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.getAllData()).isEmpty();
    }

    @Test
    public void removeTest2() {
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.remove("Last")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.getAllData()).containsExactly("First", "middle");
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.remove("First")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.getAllData()).containsExactly("middle");
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.remove("middle")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.getAllData()).isEmpty();
    }

    @Test
    public void removeTest3() {
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.remove("Middle")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.getAllData()).containsExactly("First", "middle", "Last");
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.remove("middle")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.getAllData()).containsExactly("First", "Last");
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.remove("First")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringDoublyLinkedList.getAllData()).containsExactly("Last");
    }
}
