package Lab5;
import java.util.Arrays;
import java.util.Comparator;

public class GiftBox {
    private Sweets[] items;
    private int size;

    public GiftBox(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Місткість повинна бути більшою за 0.");
        }
        this.items = new Sweets[capacity];
        this.size = 0;
    }

    public void add(Sweets sweet) {
        if (sweet == null) {
            throw new NullPointerException("Неможливо додавати порожні об'єкти.");
        }
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        items[size++] = sweet;
    }

    public double calculateTotalWeight() {
        double totalWeight = 0;
        for (int i = 0; i < size; i++) {
            totalWeight += items[i].getWeight();
        }
        return totalWeight;
    }

    public void sortByWeight() {
        if (size < 2) return;
        Arrays.sort(items, 0, size, Comparator.comparingDouble(Sweets::getWeight));
    }

    public Sweets findCandyByChocolateRange(double min, double max) throws InvalidChocolateContentException {
        if (min < 0 || max > 100 || min > max) {
            throw new InvalidChocolateContentException(
                    String.format("Некоректний діапазон: [%.1f%% - %.1f%%].", min, max));
        }

        for (int i = 0; i < size; i++) {
            double currentChocolate = items[i].getChocolateContent();
            if (currentChocolate >= min && currentChocolate <= max) {
                return items[i];
            }
        }
        
        throw new IllegalArgumentException(
                String.format("Цукерку з вмістом шоколаду в діапазоні [%.1f%%, %.1f%%] не знайдено.", min, max));
    }

    public void printGift() {
        if (size == 0) {
            System.out.println("Подарунок порожній.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println("- " + items[i]);
        }
    }
}