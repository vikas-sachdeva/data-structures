package jsample;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashTableTest {

    private HashTable<String, String> hashTable = new HashTable<>();

    @Test
    public void addTest1() {
        List<Entry<String, String>> entryList = new ArrayList<>();
        entryList.add(new Entry<>("key1", "value1"));
        entryList.add(new Entry<>("key2", "value2"));
        entryList.add(new Entry<>("key3", "value3"));
        entryList.add(new Entry<>("key4", "value4"));
        entryList.add(new Entry<>("key5", "value5"));
        entryList.add(new Entry<>("key5", "value50"));
        entryList.add(new Entry<>("key5", "value51"));
        entryList.forEach(e -> hashTable.put(e.getKey(), e.getValue()));
        AssertionsForInterfaceTypes.assertThat(hashTable.getEntries()).containsExactlyInAnyOrderElementsOf(entryList);
        Arrays.asList(hashTable.getEntries()).forEach(System.out::println);
    }

    @Test
    public void addTest2() {
        List<Entry<String, String>> entryList = new ArrayList<>();
        entryList.add(new Entry<>("key1", "value1"));
        entryList.add(new Entry<>("key2", "value2"));
        entryList.add(new Entry<>("key3", "value3"));
        entryList.add(new Entry<>("key4", "value4"));
        entryList.add(new Entry<>("key5", "value5"));
        entryList.add(new Entry<>("key5", "value50"));
        entryList.add(new Entry<>("key5", "value51"));
        entryList.add(new Entry<>("key5", "value52"));
        entryList.add(new Entry<>("key5", "value53"));
        entryList.forEach(e -> hashTable.put(e.getKey(), e.getValue()));
        AssertionsForInterfaceTypes.assertThat(hashTable.getEntries()).containsExactlyInAnyOrderElementsOf(entryList);
        Arrays.asList(hashTable.getEntries()).forEach(System.out::println);
    }

    @Test
    public void removeTest1() {
        List<Entry<String, String>> entryList = new ArrayList<>();
        entryList.add(new Entry<>("key1", "value1"));
        entryList.add(new Entry<>("key2", "value2"));
        entryList.add(new Entry<>("key3", "value3"));
        entryList.add(new Entry<>("key4", "value4"));
        entryList.add(new Entry<>("key5", "value5"));
        entryList.add(new Entry<>("key5", "value50"));
        entryList.add(new Entry<>("key5", "value51"));
        entryList.add(new Entry<>("key5", "value52"));
        entryList.add(new Entry<>("key5", "value53"));
        entryList.forEach(e -> hashTable.put(e.getKey(), e.getValue()));
        AssertionsForInterfaceTypes.assertThat(hashTable.getEntries()).containsExactlyInAnyOrderElementsOf(entryList);
        AssertionsForInterfaceTypes.assertThat(hashTable.remove("key5")).isTrue();
        entryList.remove(new Entry<>("key5", "value5"));
        AssertionsForInterfaceTypes.assertThat(hashTable.getEntries()).containsExactlyInAnyOrderElementsOf(entryList);
        AssertionsForInterfaceTypes.assertThat(hashTable.remove("key51")).isFalse();
        AssertionsForInterfaceTypes.assertThat(hashTable.getEntries()).containsExactlyInAnyOrderElementsOf(entryList);
        AssertionsForInterfaceTypes.assertThat(hashTable.remove("key4")).isTrue();
        entryList.remove(new Entry<>("key4", "value4"));
        AssertionsForInterfaceTypes.assertThat(hashTable.getEntries()).containsExactlyInAnyOrderElementsOf(entryList);
        AssertionsForInterfaceTypes.assertThat(hashTable.remove("key5")).isTrue();
        entryList.remove(new Entry<>("key5", "value50"));
        AssertionsForInterfaceTypes.assertThat(hashTable.getEntries()).containsExactlyInAnyOrderElementsOf(entryList);
        AssertionsForInterfaceTypes.assertThat(hashTable.remove("key5")).isTrue();
        entryList.remove(new Entry<>("key5", "value51"));
        AssertionsForInterfaceTypes.assertThat(hashTable.getEntries()).containsExactlyInAnyOrderElementsOf(entryList);
        AssertionsForInterfaceTypes.assertThat(hashTable.remove("key5")).isTrue();
        entryList.remove(new Entry<>("key5", "value52"));
        AssertionsForInterfaceTypes.assertThat(hashTable.getEntries()).containsExactlyInAnyOrderElementsOf(entryList);
        AssertionsForInterfaceTypes.assertThat(hashTable.remove("key5")).isTrue();
        entryList.remove(new Entry<>("key5", "value53"));
        AssertionsForInterfaceTypes.assertThat(hashTable.getEntries()).containsExactlyInAnyOrderElementsOf(entryList);
        AssertionsForInterfaceTypes.assertThat(hashTable.remove("key5")).isFalse();
        Arrays.asList(hashTable.getEntries()).forEach(System.out::println);
    }

    @Test
    public void getValueTest1() {
        List<Entry<String, String>> entryList = new ArrayList<>();
        entryList.add(new Entry<>("key1", "value1"));
        entryList.add(new Entry<>("key2", "value2"));
        entryList.add(new Entry<>("key3", "value3"));
        entryList.add(new Entry<>("key4", "value4"));
        entryList.add(new Entry<>("key5", "value5"));
        entryList.add(new Entry<>("key5", "value50"));
        entryList.add(new Entry<>("key5", "value51"));
        entryList.add(new Entry<>("key5", "value52"));
        entryList.add(new Entry<>("key5", "value53"));
        entryList.forEach(e -> hashTable.put(e.getKey(), e.getValue()));
        AssertionsForInterfaceTypes.assertThat(hashTable.getEntries()).containsExactlyInAnyOrderElementsOf(entryList);
        AssertionsForInterfaceTypes.assertThat(hashTable.getValue("key1")).isEqualTo("value1");
        AssertionsForInterfaceTypes.assertThat(hashTable.getValue("key2")).isEqualTo("value2");
        AssertionsForInterfaceTypes.assertThat(hashTable.getValue("key5")).isEqualTo("value5");
        AssertionsForInterfaceTypes.assertThat(hashTable.getValue("key51")).isNull();
    }

    @Test
    public void containsTest1() {
        List<Entry<String, String>> entryList = new ArrayList<>();
        entryList.add(new Entry<>("key1", "value1"));
        entryList.add(new Entry<>("key2", "value2"));
        entryList.forEach(e -> hashTable.put(e.getKey(), e.getValue()));
        AssertionsForInterfaceTypes.assertThat(hashTable.getEntries()).containsExactlyInAnyOrderElementsOf(entryList);
        AssertionsForInterfaceTypes.assertThat(hashTable.contains("key1")).isTrue();
        AssertionsForInterfaceTypes.assertThat(hashTable.contains("key2")).isTrue();
        AssertionsForInterfaceTypes.assertThat(hashTable.contains("key3")).isFalse();
    }
}