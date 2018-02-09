import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SetTest {

    private static Set empty = new Set();
    private static Set one = new Set();
    private static Set many = new Set();

    @BeforeAll
    static void setUp() {
        one.add("one");
        many.add("one");
        many.add("two");
        many.add("three");
    }

    @Test
    void testIsEmpty() {
        assertEquals(true, empty.isEmpty());
        assertEquals(false, one.isEmpty());
        assertEquals(false, many.isEmpty());
    }

    @Test
    void testSize() {
        assertEquals(0, empty.size());
        assertEquals(1, one.size());
        assertEquals(3, many.size());
    }

    @Test
    void testAdd() {
        assertEquals(1, one.size());
        assertEquals(3, many.size());
        assertEquals(true, one.contains("one"));
        assertEquals(true, many.contains("one"));
        assertEquals(true, many.contains("two"));
    }

    @Test
    void testRemove() {
        Set remove = new Set();
        remove.add("one");
        remove.add("two");
        remove.remove("one");
        assertEquals(false, remove.contains("one"));
        assertEquals(1, remove.size());
        assertEquals(true, remove.contains("two"));
    }

    @Test
    void testUnique() {
        Set unique = new Set();
        unique.add("unique");
        unique.add("element");
        unique.add("unique");
        assertEquals(true, unique.contains("unique"));
        assertEquals(true, unique.contains("element"));
        assertEquals(2, unique.size());
    }
}