package module_8_2;

public class PalindromeChecker {
    public boolean isPalindrome(String string) {
        String formattedString1 = string.toLowerCase().replaceAll("[\\p{Punct}\\s]", "");
        String formattedString2 = new StringBuilder(formattedString1).reverse().toString();

        return formattedString1.equals(formattedString2);
    }
}
