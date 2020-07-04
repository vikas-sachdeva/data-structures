package jsample;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> integerSinglyLinkedList = new SinglyLinkedList<>();

    private SinglyLinkedList<String> stringSinglyLinkedList = new SinglyLinkedList<>();

    @BeforeEach
    public void setup() {
        stringSinglyLinkedList.addFirst("First");
        stringSinglyLinkedList.addLast("middle");
        stringSinglyLinkedList.addLast("Last");
    }

    @Test
    public void getAllDataTest1() {
        List<Integer> input = Arrays.asList(10, 20, 40, 2, 1);
        input.forEach(i -> integerSinglyLinkedList.addLast(i));
        AssertionsForInterfaceTypes.assertThat(integerSinglyLinkedList.getAllData()).containsExactlyElementsOf(input);
    }

    @Test
    public void getAllDataTest2() {
        List<Integer> input = Arrays.asList(10, 20, 40, 2, 1);
        input.forEach(i -> integerSinglyLinkedList.addFirst(i));
        Collections.reverse(input);
        AssertionsForInterfaceTypes.assertThat(integerSinglyLinkedList.getAllData()).containsExactlyElementsOf(input);
    }

    @Test
    public void getLastNodeTest() {
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.getLastNode().getData()).isEqualTo("Last");
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.remove("Last")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.getLastNode().getData()).isEqualTo("middle");
    }

    @Test
    public void containsTest1() {
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.contains("First")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.contains("Middle")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.contains("Last")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.contains("Last1")).isFalse();
    }

    @Test
    public void removeTest1() {
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.remove("First")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.getAllData()).containsExactly("middle", "Last");
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.remove("First")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.getAllData()).containsExactly("middle", "Last");
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.remove("Last")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.getAllData()).containsExactly("middle");
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.remove("middle")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.getAllData()).isEmpty();
    }

    @Test
    public void removeTest2() {
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.remove("Last")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.getAllData()).containsExactly("First", "middle");
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.remove("First")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.getAllData()).containsExactly("middle");
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.remove("middle")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.getAllData()).isEmpty();
    }

    @Test
    public void removeTest3() {
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.remove("Middle")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.getAllData()).containsExactly("First", "middle", "Last");
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.remove("middle")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.getAllData()).containsExactly("First", "Last");
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.remove("First")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSinglyLinkedList.getAllData()).containsExactly("Last");
    }
}
