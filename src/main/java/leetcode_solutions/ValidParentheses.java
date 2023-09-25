package leetcode_solutions;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
  public static boolean isValid(String s) {
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

  public static void main(String[] args) {
    String validParentheses = "(){}[]";
    String invalidParentheses = "{[)";
    System.out.printf("%s -> %b%n", validParentheses, isValid(validParentheses));
    System.out.printf("%s -> %b", invalidParentheses, isValid(invalidParentheses));
  }
}
