package com.saman.datascience.datastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Stack unit tests")
class StackArrayImplTest {

    private final Stack<Integer> stack = new StackArrayImpl<>();

    @BeforeEach
    public void fillStackWithItemOne() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @AfterEach
    public void clearStack() {
        stack.clear();
    }

    @ParameterizedTest(name = "push {0}")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("push item to stack, it can push the same data.")
    @Order(1)
    public void push_addOneItemToStack_TopShouldBeZero(int n) {
        stack.push(n);
        assertEquals(3, stack.top());
    }

    @Test
    @DisplayName("pop item from stack, means get and remove top item.")
    @Order(2)
    public void pop_GetTheTopItem_ThenRemoveTheItem() {
        assertEquals(2, stack.top());

        Integer item;

        item = stack.pop();
        assertEquals(3, item.intValue());

        item = stack.pop();
        assertEquals(2, item.intValue());

        item = stack.pop();
        assertEquals(1, item.intValue());

        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("peek item from stack, means get top item but the top item never is deleted.")
    @Order(3)
    public void peek_GetTopItem_DoesNotRemoveTheItem() {
        assertEquals(2, stack.top());

        Integer item;

        item = stack.peek();
        assertEquals(3, item.intValue());

        item = stack.peek();
        assertEquals(3, item.intValue());

        assertEquals(2, stack.top());

    }

}