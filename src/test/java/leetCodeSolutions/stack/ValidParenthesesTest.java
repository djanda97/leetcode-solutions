package leetCodeSolutions.stack;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// https://leetcode.com/problems/valid-parentheses/
class ValidParenthesesTest {
    boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                default -> {
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    void test() {
        assertTrue(isValid("()"));
        assertTrue(isValid("()[]{}"));
        assertFalse(isValid("(]"));
    }
}
