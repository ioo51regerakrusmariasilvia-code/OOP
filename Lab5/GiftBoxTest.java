package Lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GiftBoxTest {

    private GiftBox giftBox;

    @BeforeEach
    void setUp() {
        giftBox = new GiftBox(2);
    }

    @Test
    void testValidCandyCreation() {
        ChocolateCandy candy = new ChocolateCandy("Ромашка", 15.0, 50.0, 30.0);
        assertEquals("Ромашка", candy.getName());
        assertEquals(15.0, candy.getWeight());
        assertEquals(50.0, candy.getSugarContent());
        assertEquals(30.0, candy.getChocolateContent());
    }

    @Test
    void testInvalidWeightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ChocolateCandy("Бракована", 0, 50.0, 30.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Lollipop("Льодяник", -5.5, 80.0, "М'ята");
        });
    }

    @Test
    void testInvalidSugarContentThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ChocolateCandy("Солодка", 10.0, 105.0, 50.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new JellySweet("Кисла", 10.0, -1.0, 10.0);
        });
    }

    @Test
    void testCalculateTotalWeight() {
        giftBox.add(new ChocolateCandy("Трюфель", 20.0, 30.0, 75.0));
        giftBox.add(new Lollipop("Півник", 15.5, 85.0, "Лимон"));
        giftBox.add(new JellySweet("Бджілка", 10.2, 60.0, 0.0));
        
        // Очікувана вага: 20.0 + 15.5 + 10.2 = 45.7
        assertEquals(45.7, giftBox.calculateTotalWeight(), 0.001);
    }

    @Test
    void testSortByWeight() {
        Sweets heavy = new ChocolateCandy("Важка", 50.0, 10.0, 20.0);
        Sweets medium = new Lollipop("Середня", 25.0, 40.0, "Апельсин");
        Sweets light = new JellySweet("Легка", 10.0, 40.0, 0.0);
        
        giftBox.add(medium);
        giftBox.add(heavy);
        giftBox.add(light);
        
        giftBox.sortByWeight();

        assertTrue(light.getWeight() < medium.getWeight());
        assertTrue(medium.getWeight() < heavy.getWeight());
    }

    @Test
    void testFindCandyByChocolateRangeSuccess() throws InvalidChocolateContentException {
        Sweets target = new ChocolateCandy("Шоколадна", 15.0, 40.0, 55.0);
        giftBox.add(new Lollipop("Льодяник", 10.0, 90.0, "М'ята"));    
        giftBox.add(target);

        Sweets result = giftBox.findCandyByChocolateRange(50.0, 60.0);
        
        assertNotNull(result);
        assertEquals("Шоколадна", result.getName());
    }

    @Test
    void testFindCandyThrowsInvalidChocolateContentException() {
        assertThrows(InvalidChocolateContentException.class, () -> {
            giftBox.findCandyByChocolateRange(60.0, 40.0);
        });
        
        assertThrows(InvalidChocolateContentException.class, () -> {
            giftBox.findCandyByChocolateRange(-5.0, 50.0);
        });
    }

    @Test
    void testFindCandyThrowsIllegalArgumentExceptionWhenNotFound() {
        giftBox.add(new ChocolateCandy("Кара-Кум", 15.0, 40.0, 50.0));

        assertThrows(IllegalArgumentException.class, () -> {
            giftBox.findCandyByChocolateRange(80.0, 90.0);
        });
    }

    @Test
    void testAddNullThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            giftBox.add(null);
        });
    }
}