package Lab5;

public class Main {
    public static void main(String[] args) {
        System.out.println("Збирання дитячого подарунка");
        GiftBox gift = new GiftBox(3);

        try {
            gift.add(new ChocolateCandy("Кара-Кум", 15.5, 45.0, 55.0));
            gift.add(new Lollipop("Півник", 12.0, 90.0, "Полуниця"));
            gift.add(new JellySweet("Шалена Бджілка", 8.5, 60.0, 0.0));
            gift.add(new ChocolateCandy("Трюфель", 20.0, 35.0, 80.0));
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("Помилка додавання: " + e.getMessage());
        }

        System.out.println("\nВміст до сортування:");
        gift.printGift();

        System.out.printf("\nЗагальна вага: %.2f г\n", gift.calculateTotalWeight());

        System.out.println("\nСортування за вагою:");
        gift.sortByWeight();
        gift.printGift();

        System.out.println("\n=== Тест пошуку ===");
        try {
            Sweets found = gift.findCandyByChocolateRange(40.0, 60.0);
            System.out.println("Знайдено цукерку: " + found);
        } catch (InvalidChocolateContentException | IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
