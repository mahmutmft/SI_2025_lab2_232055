import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

public class SILab2Test {

    // Every Statement
    @Test
    void testEmptyItemsList() {
        List<Item> items = List.of();
        double result = SILab2.checkCart(items, "1234567890123456");
        assertEquals(0.0, result);
    }

    @Test
    void testName() {
        List<Item> items = List.of(new Item("coconut", 1, 100, 0.0));
        double result = SILab2.checkCart(items, "1234567890123456");
        assertEquals(100, result);
    }

    @Test
    void testPrice() {
        List<Item> items = List.of(new Item("coconut", 1, 300, 0.0));
        double result = SILab2.checkCart(items, "1234567890123456");
        assertEquals(300.0, result);
    }

    @Test
    void testDiscount() {
        List<Item> items = List.of(new Item("coconut", 2, 200, 0.1));
        double result = SILab2.checkCart(items, "1234567890123456");
        assertEquals(330, result);
    }

    @Test
    void testNoDiscount() {
        List<Item> items = List.of(new Item("coconut", 1, 100, 0.0));
        double result = SILab2.checkCart(items, "1234567890123456");
        assertEquals(100.0, result);
    }

    @Test
    void testCard() {
        List<Item> items = List.of(new Item("coconut", 1, 100, 0.0));
        RuntimeException error = assertThrows(RuntimeException.class, ()->{
            SILab2.checkCart(items,"1234а567890123456");
        });
        assertEquals("Invalid card number!", error.getMessage());
    }

    // Multiple Condition
    @Test
    void testAll() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("coconut", 5, 300, 0.0));
        double result = SILab2.checkCart(items, "1234567890123456");
        assertEquals(1500, result);
    }

    @Test
    void testLast() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("coconut", 15, 100, 0.0));
        double result = SILab2.checkCart(items, "1234567890123456");
        assertEquals(1470, result);
    }

    @Test
    void testSecond() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("coconut", 5, 200, 0.1));
        double result = SILab2.checkCart(items, "1234567890123456");
        assertEquals(870, result);
    }

    @Test
    void testFirst() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("coconut", 5, 350, 0.0));
        double result = SILab2.checkCart(items, "1234567890123456");
        assertEquals(1720, result);
    }
}

