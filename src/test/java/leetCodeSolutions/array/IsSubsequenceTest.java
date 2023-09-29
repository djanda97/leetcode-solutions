package leetCodeSolutions.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsSubsequenceTest {
    boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (j < t.length()) {
            if (i < s.length() && s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }

    @Test
    void test() {
        assertTrue(isSubsequence("abc", "ahbgdc"));
        assertFalse(isSubsequence("axc", "ahbgdc"));
    }
}
