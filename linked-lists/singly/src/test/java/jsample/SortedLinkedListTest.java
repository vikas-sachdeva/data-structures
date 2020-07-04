package jsample;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedLinkedListTest {

    private SortedSinglyLinkedList<Integer> integerSortedSinglyLinkedList = new SortedSinglyLinkedList<>();

    private SortedSinglyLinkedList<String> stringSortedSinglyLinkedList = new SortedSinglyLinkedList<>();

    @BeforeEach
    public void setup() {
        stringSortedSinglyLinkedList.add("List");
        stringSortedSinglyLinkedList.add("Set");
        stringSortedSinglyLinkedList.add("Map");
    }

    @Test
    public void getAllDataTest1() {
        List<Integer> input = Arrays.asList(10, 20, 40, 2, 1);
        input.forEach(i -> integerSortedSinglyLinkedList.add(i));
        Collections.sort(input);
        AssertionsForInterfaceTypes.assertThat(integerSortedSinglyLinkedList.getAllData()).containsExactlyElementsOf(input);
    }

    @Test
    public void getAllDataTest2() {
        List<Integer> input = Arrays.asList(10, 2, 4, 11, 2, 0, 99, 4);
        input.forEach(i -> integerSortedSinglyLinkedList.add(i));
        Collections.sort(input);
        AssertionsForInterfaceTypes.assertThat(integerSortedSinglyLinkedList.getAllData()).containsExactlyElementsOf(input);
    }

    @Test
    public void getLastNodeTest() {
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.getLastNode().getData()).isEqualTo("Set");
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.remove("Set")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.getLastNode().getData()).isEqualTo("Map");
    }

    @Test
    public void containsTest1() {
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.contains("Set")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.contains("map")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.contains("List")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.contains("List1")).isFalse();
    }

    @Test
    public void removeTest1() {
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.remove("List")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.getAllData()).containsExactly("Map", "Set");
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.remove("List")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.getAllData()).containsExactly("Map", "Set");
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.remove("Set")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.getAllData()).containsExactly("Map");
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.remove("Map")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.getAllData()).isEmpty();
    }

    @Test
    public void removeTest2() {
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.remove("Set")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.getAllData()).containsExactly("List", "Map");
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.remove("List")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.getAllData()).containsExactly("Map");
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.remove("Map")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.getAllData()).isEmpty();
    }

    @Test
    public void removeTest3() {
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.remove("map")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.getAllData()).containsExactly("List", "Map", "Set");
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.remove("Map")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.getAllData()).containsExactly("List", "Set");
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.remove("List")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringSortedSinglyLinkedList.getAllData()).containsExactly("Set");
    }
}