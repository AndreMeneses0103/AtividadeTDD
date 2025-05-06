package br.edu.fatec.sjc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class NumberAscOrderTest {

    private CustomStack<Integer> stack;

    @Mock
    private CalculableStrategy<Integer> calculableStrategy;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        when(calculableStrategy.calculateValue(anyInt()))
                .thenAnswer(invocation -> invocation.getArgument(0));
    }

    @Test
    public void testSortWithSixNumbers() throws StackFullException {
        stack = new CustomStack<>(6, calculableStrategy);
        stack.push(12);
        stack.push(8);
        stack.push(25);
        stack.push(7);
        stack.push(1);
        stack.push(33);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack);
        List<Integer> result = sorter.sort();

        assertEquals(List.of(1, 7, 8, 12, 25, 33), result);
    }

    @Test
    public void testSortWithEmptyStack() {
        stack = new CustomStack<>(6, calculableStrategy);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack);
        List<Integer> result = sorter.sort();

        assertTrue(result.isEmpty());
    }

    @Test
    public void testSortWithStackEmptyException() {
        stack = new CustomStack<>(6, calculableStrategy);
        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack);

        try {
            sorter.sort();
            assertTrue(stack.isEmpty());
        } catch (RuntimeException e) {
            fail("A RuntimeException não deveria ser lançada.");
        }
    }

}
