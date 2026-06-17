package Lab4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Lab4 {

    public static class Car {
        Word brand;
        Word model;
        int year;
        int maxSpeed;
        double price;

        public Car(String brand, String model, int year, int maxSpeed, double price) {
            this.brand = new Word(brand);
            this.model = new Word(model);
            this.year = year;
            this.maxSpeed = maxSpeed;
            this.price = price;}

        @Override
        public String toString() {
            return "Car{brand='" + brand + "', model='" + model + "', year=" + year + ", maxSpeed=" + maxSpeed + ", price=" + price + "}";}

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;}
            if (!(obj instanceof Car car)) {
                return false;}
            return year == car.year 
                    && maxSpeed == car.maxSpeed 
                    && Double.compare(car.price, price) == 0 
                    && Objects.equals(brand, car.brand) 
                    && Objects.equals(model, car.model);}
    }

    public static void sortCars(Car[] cars) {
        if (cars == null) {
            return;
        }
        Arrays.sort(cars, Comparator.comparingInt((Car c) -> c.year)
                .thenComparing((Car c) -> c.brand.toString(), Comparator.reverseOrder()));
    }

    public static Car findCar(Car[] cars, Car target) {
        if (cars == null || target == null) {
            return null;}
        for (Car car : cars) {
            if (car.equals(target)) {
                return car;}}
        return null;
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--test")) {
            runTests();
            return;}

        System.out.println("РОБОТА З МАШИНАМИ (ЛАБА 3)");
        Car[] cars = {
                new Car("BMW", "X5", 2020, 240, 50000),
                new Car("Audi", "A6", 2020, 250, 48000),
                new Car("Ford", "Focus", 2018, 190, 18000)};

        sortCars(cars);
        System.out.println("Відсортований масив: " + Arrays.toString(cars));

        System.out.println("\nРОБОТА З ТЕКСТОМ (ЛАБА 4)");
        String rawText = "Це \t тест    нової   лаби.   Все працює \t чудово!";
        Text text = new Text(rawText);
        System.out.println("Очищений та розпарсений текст:\n" + text);
    }

    private static void runTests() {
        System.out.println("Запуск вбудованих тестів для Лабораторної №4");

        Car car1 = new Car("BMW", "X5", 2020, 240, 50000);
        Car car2 = new Car("BMW", "X5", 2020, 240, 50000);
        if (!car1.equals(car2)) {
            throw new RuntimeException("Тест 1 ФЕЙЛ: однакові машини не рівні!");}

        Car[] testArray = {
                new Car("BMW", "X5", 2020, 240, 50000),
                new Car("Ford", "Focus", 2018, 190, 18000)};
        sortCars(testArray);
        if (!testArray[0].brand.toString().equals("Ford")) {
            throw new RuntimeException("Тест 2 ФЕЙЛ: Сортування машин працює неправильно!");}

        String dirtyText = "Слово1 \t\t  Слово2       Слово3.";
        Text parsedText = new Text(dirtyText);
        String expected = "Слово1 Слово2 Слово3.";
        if (!parsedText.toString().equals(expected)) {
            throw new RuntimeException("Тест 3 ФЕЙЛ: Заміна пробілів та табуляцій не працює!");}

        Word testWord = new Word("java");
        if (!testWord.toUpperCase().toString().equals("JAVA")) {
            throw new RuntimeException("Тест 4 ФЕЙЛ: Метод toUpperCase() працює невірно!");}

        System.out.println("УСІ ТЕСТИ ЛАБОРАТОРНОЇ №4 ПРОЙДЕНО УСПІШНО!");
    }
}