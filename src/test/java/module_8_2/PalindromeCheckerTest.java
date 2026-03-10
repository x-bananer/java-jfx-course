package module_8_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {
    @Test
    public void isPalindromeTest() {
        PalindromeChecker p = new PalindromeChecker();

        assertTrue(p.isPalindrome("madam"));
        assertTrue(p.isPalindrome("A man, a plan, a canal, Panama"));

        assertFalse(p.isPalindrome("hello"));
        assertFalse(p.isPalindrome("openai"));
    }

}