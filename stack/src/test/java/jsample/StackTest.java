package jsample;

import jsample.exceptions.StackUnderFlowException;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StackTest {

    private Stack<Integer> integerStack = new Stack<>();

    private Stack<String> stringStack = new Stack<>();

    @BeforeEach
    public void setup() {
        stringStack.push("First");
        stringStack.push("middle");
        stringStack.push("Last");
    }

    @Test
    public void pushPopTest1() {
        List<Integer> input = Arrays.asList(10, 20, 40, 2, 1);
        input.forEach(i -> integerStack.push(i));
        AssertionsForInterfaceTypes.assertThat(integerStack.pop()).isEqualTo(1);
        AssertionsForInterfaceTypes.assertThat(integerStack.pop()).isEqualTo(2);
        AssertionsForInterfaceTypes.assertThat(integerStack.pop()).isEqualTo(40);
        AssertionsForInterfaceTypes.assertThat(integerStack.pop()).isEqualTo(20);
        AssertionsForInterfaceTypes.assertThat(integerStack.pop()).isEqualTo(10);
    }

    @Test
    public void pushPopTest2() {
        AssertionsForInterfaceTypes.assertThatExceptionOfType(StackUnderFlowException.class).isThrownBy(() -> integerStack.pop());
        AssertionsForInterfaceTypes.assertThat(integerStack.isEmpty()).isTrue();
        List<Integer> input = Arrays.asList(10, 20);
        input.forEach(i -> integerStack.push(i));
        AssertionsForInterfaceTypes.assertThat(integerStack.isEmpty()).isFalse();
        AssertionsForInterfaceTypes.assertThat(integerStack.pop()).isEqualTo(20);
        AssertionsForInterfaceTypes.assertThat(integerStack.peek()).isEqualTo(10);
        AssertionsForInterfaceTypes.assertThat(integerStack.pop()).isEqualTo(10);
        AssertionsForInterfaceTypes.assertThatExceptionOfType(StackUnderFlowException.class).isThrownBy(() -> integerStack.peek());
        AssertionsForInterfaceTypes.assertThatExceptionOfType(StackUnderFlowException.class).isThrownBy(() -> integerStack.pop());
        AssertionsForInterfaceTypes.assertThat(integerStack.isEmpty()).isTrue();
    }

    @Test
    public void containsTest1() {
        AssertionsForInterfaceTypes.assertThat(stringStack.contains("First")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringStack.contains("Middle")).isFalse();
        AssertionsForInterfaceTypes.assertThat(stringStack.contains("Last")).isTrue();
        AssertionsForInterfaceTypes.assertThat(stringStack.contains("Last1")).isFalse();
    }
}