import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Lab3 {

    public static class Car {
        String brand;
        String model;
        int year;
        int maxSpeed;
        double price;

        public Car(String brand, String model, int year, int maxSpeed, double price) {
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.maxSpeed = maxSpeed;
            this.price = price;}

        @Override
        public String toString() {
            return "Car{" +
                    "brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", year=" + year +
                    ", maxSpeed=" + maxSpeed +
                    ", price=" + price +
                    '}';}

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Car car = (Car) obj;
            return year == car.year
                    && maxSpeed == car.maxSpeed
                    && Double.compare(car.price, price) == 0
                    && Objects.equals(brand, car.brand)
                    && Objects.equals(model, car.model);}
    }

    public static void sortCars(Car[] cars) {
        if (cars == null) return;
        Arrays.sort(cars, Comparator.comparingInt((Car c) -> c.year)
                .thenComparing((Car c) -> c.brand, Comparator.reverseOrder()));}

    public static Car findCar(Car[] cars, Car target) {
        if (cars == null || target == null) return null;
        for (Car car : cars) {
            if (car.equals(target)) {
                return car;}}
        return null;
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--test")) {
            runTests();
            return;}

        Car[] cars = {
                new Car("BMW", "X5", 2020, 240, 50000),
                new Car("Audi", "A6", 2020, 250, 48000),
                new Car("Toyota", "Camry", 2019, 210, 30000),
                new Car("Mercedes", "E200", 2020, 250, 52000),
                new Car("Ford", "Focus", 2018, 190, 18000)};

        System.out.println("Початковий масив:");
        for (Car car : cars) {
            System.out.println(car);}

        sortCars(cars);

        System.out.println("\nВідсортований масив:");
        for (Car car : cars) {
            System.out.println(car);}

        Car target = new Car("Audi", "A6", 2020, 250, 48000);
        Car foundCar = findCar(cars, target);

        if (foundCar != null) {
            System.out.println("\nЗнайдено об'єкт:\n" + foundCar);
        } else {
            System.out.println("\nОб'єкт не знайдено.");}
    }

    private static void runTests() {
        System.out.println("Запуск вбудованих тестів...");

        Car car1 = new Car("BMW", "X5", 2020, 240, 50000);
        Car car2 = new Car("BMW", "X5", 2020, 240, 50000);
        Car car3 = new Car("Audi", "A6", 2020, 250, 48000);
        
        if (!car1.equals(car2)) throw new RuntimeException("Тест 1 ФЕЙЛ: однакові машини не рівні!");
        if (car1.equals(car3)) throw new RuntimeException("Тест 1 ФЕЙЛ: різні машини визнані рівними!");

        Car[] testArray = {
                new Car("BMW", "X5", 2020, 240, 50000),
                new Car("Audi", "A6", 2020, 250, 48000),
                new Car("Ford", "Focus", 2018, 190, 18000)
        };
        sortCars(testArray);
        if (!testArray[0].brand.equals("Ford") || !testArray[1].brand.equals("BMW") || !testArray[2].brand.equals("Audi")) {
            throw new RuntimeException("Тест 2 ФЕЙЛ: Сортування працює неправильно!");
        }

        Car target = new Car("Audi", "A6", 2020, 250, 48000);
        Car found = findCar(testArray, target);
        if (found == null) throw new RuntimeException("Тест 3 ФЕЙЛ: Машину, яка є в масиві, не знайдено!");

        Car fakeTarget = new Car("Lada", "9", 1999, 120, 500);
        if (findCar(testArray, fakeTarget) != null) throw new RuntimeException("Тест 3 ФЕЙЛ: Знайдено машину, якої немає в масиві!");

        System.out.println("УСІ ТЕСТИ ПРОЙДЕНО УСПІШНО! ✅");
    }
}