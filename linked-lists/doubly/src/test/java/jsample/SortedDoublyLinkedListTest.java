package jsample;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedDoublyLinkedListTest {

    private SortedDoublyLinkedList<Integer> integerSortedDoublyLinkedList = new SortedDoublyLinkedList<>();

    private SortedDoublyLinkedList<String> stringSortedDoublyLinkedList = new SortedDoublyLinkedList<>();

    @BeforeEach
    public void setup() {
        stringSortedDoublyLinkedList.add("Set");
        stringSortedDoublyLinkedList.add("List");
        stringSortedDoublyLinkedList.add("Map");
    }

    @Test
    public void getAllDataTest1() {
        List<Integer> input = Arrays.asList(10, 20, 40, 2, 1);
        input.forEach(i -> integerSortedDoublyLinkedList.add(i));
        Collections.sort(input);
        AssertionsForInterfaceTypes.assertThat(integerSortedDoublyLinkedList.getAllData()).containsExactlyElementsOf(input);
    }

    @Test
    public void getAllDataTest2() {
        List<Integer> input = Arrays.asList(10, 2, 4, 11, 2, 0, 99, 4);
        input.forEach(i -> integerSortedDoublyLinkedList.add(i));
        Collections.sort(input);
        Collections.reverse(input);
        AssertionsForInterfaceTypes.assertThat(integerSortedDoublyLinkedList.getAllDataInReverseOrder()).containsExactlyElementsOf(input);
    }

    @Test
    public void getLastNodeTest() {
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.getLastNode().getData()).isEqualTo("Set");
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.remove("Set")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.getLastNode().getData()).isEqualTo("Map");
    }

    @Test
    public void containsTest1() {
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.contains("Set")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.contains("map")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.contains("List")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.contains("List1")).isFalse();
    }

    @Test
    public void removeTest1() {
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.remove("List")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.getAllData()).containsExactly("Map", "Set");
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.remove("List")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.getAllData()).containsExactly("Map", "Set");
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.remove("Set")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.getAllData()).containsExactly("Map");
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.remove("Map")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.getAllData()).isEmpty();
    }

    @Test
    public void removeTest2() {
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.remove("Set")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.getAllData()).containsExactly("List", "Map");
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.remove("List")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.getAllData()).containsExactly("Map");
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.remove("Map")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.getAllData()).isEmpty();
    }

    @Test
    public void removeTest3() {
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.remove("map")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.getAllData()).containsExactly("List", "Map", "Set");
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.remove("Map")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.getAllData()).containsExactly("List", "Set");
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.remove("List")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedDoublyLinkedList.getAllData()).containsExactly("Set");
    }
}
