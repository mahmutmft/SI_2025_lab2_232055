import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

public class SILab2Test {

    @Test
    void testEveryStatement() {
        List<Item> emptyItems = List.of();
        assertEquals(0.0, SILab2.checkCart(emptyItems, "1234567890123456"));

        List<Item> validName = List.of(new Item("coconut", 1, 100, 0.0));
        assertEquals(100.0, SILab2.checkCart(validName, "1234567890123456"));

        List<Item> price300 = List.of(new Item("coconut", 1, 300, 0.0));
        assertEquals(300.0, SILab2.checkCart(price300, "1234567890123456"));

        List<Item> discount = List.of(new Item("coconut", 2, 200, 0.1));
        assertEquals(330.0, SILab2.checkCart(discount, "1234567890123456"));

        List<Item> noDiscount = List.of(new Item("coconut", 1, 100, 0.0));
        assertEquals(100.0, SILab2.checkCart(noDiscount, "1234567890123456"));

        List<Item> invalidCardChar = List.of(new Item("coconut", 1, 100, 0.0));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(invalidCardChar, "1234а567890123456");
        });
        assertEquals("Invalid card number!", exception.getMessage());
    }

    @Test
    void testMultipleCondition() {
        List<Item> item1 = new ArrayList<>();
        item1.add(new Item("coconut", 5, 300, 0.0));
        assertEquals(1500.0, SILab2.checkCart(item1, "1234567890123456"));

        List<Item> item2 = new ArrayList<>();
        item2.add(new Item("coconut", 15, 100, 0.0));
        assertEquals(1470.0, SILab2.checkCart(item2, "1234567890123456"));

        List<Item> item3 = new ArrayList<>();
        item3.add(new Item("coconut", 5, 200, 0.1));
        assertEquals(870.0, SILab2.checkCart(item3, "1234567890123456"));

        List<Item> item4 = new ArrayList<>();
        item4.add(new Item("coconut", 5, 350, 0.0));
        assertEquals(1720.0, SILab2.checkCart(item4, "1234567890123456"));
    }
}
