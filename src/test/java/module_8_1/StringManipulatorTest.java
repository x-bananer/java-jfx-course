package module_8_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {
    @Test
    void concatenateTest() {
        assertEquals(new StringManipulator().concatenate("Hello", "World"), "HelloWorld");
        assertNotEquals(new StringManipulator().concatenate("Hello", "World"), "Hello World");
    }

    @Test
    void findLengthTest() {
        assertEquals(5, new StringManipulator().findLength("Hello"));
        assertNotEquals(4, new StringManipulator().findLength("Hello"));
    }

    @Test
    void convertToUpperCaseTest() {
        assertEquals("HELLO", new StringManipulator().convertToUpperCase("hello"));
        assertNotEquals("hello", new StringManipulator().convertToUpperCase("hello"));
    }

    @Test
    void convertToLowerCaseTest() {
        assertEquals("hello", new StringManipulator().convertToLowerCase("HELLO"));
        assertNotEquals("HELLO", new StringManipulator().convertToLowerCase("HELLO"));
    }

    @Test
    void containsSubstringTest() {
        assertTrue(new StringManipulator().containsSubstring("HelloWorld", "World"));
        assertFalse(new StringManipulator().containsSubstring("HelloWorld", "Java"));
    }
}