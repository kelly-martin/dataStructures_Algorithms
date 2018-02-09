import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTest {

    private static Stack empty = new Stack();
    private static Stack one = new Stack();
    private static Stack many = new Stack();

    @BeforeAll
    static void setUp() {
        one.push("one");
        many.push("one");
        many.push("two");
        many.push("three");
    }

    @Test
    void testEmpty() {
        assertEquals(true, empty.empty());
        assertEquals(false, one.empty());
        assertEquals(false, many.empty());
    }

    @Test
    void testSize() {
        assertEquals(0, empty.size());
        assertEquals(1, one.size());
        assertEquals(3, many.size());
    }

    @Test
    void testPush() {
        assertEquals(true, one.peek() == "one");
        assertEquals(true, many.peek() == "three");
    }

    @Test
    void testPop() {
        Stack pop = new Stack();
        pop.push("one");
        pop.push("two");
        pop.push("three");
        assertEquals(true, pop.pop() == "three");
        assertEquals(true, pop.pop() == "two");
        assertEquals(true, pop.pop() == "one");
    }

    @Test
    void testPeek() {
        Stack peek = new Stack();
        peek.push("one");
        peek.push("two");
        assertEquals(true, peek.peek() == "two");
        assertEquals(true, peek.pop() == "two");
        assertEquals(true, peek.peek() == "one");
        assertEquals(true, peek.pop() == "one");
        assertEquals(true, peek.peek() == null);

    }


}