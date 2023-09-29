package leetCodeSolutions.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://leetcode.com/problems/reverse-vowels-of-a-string
class ReverseVowelsInStringTest {
    String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (!isVowel(chars[i])) i++;
            if (!isVowel(chars[j])) j--;
            if (isVowel(chars[i]) && isVowel(chars[j])) {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }
        }
        return new String(chars);
    }

    boolean isVowel(Character c) {
        return switch (String.valueOf(c).toLowerCase()) {
            case "a", "e", "i", "o", "u" -> true;
            default -> false;
        };
    }

    @Test
    void test() {
        assertEquals("holle", reverseVowels("hello"));
        assertEquals("leotcede", reverseVowels("leetcode"));
    }
}
