
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Lab3 {

    static class Car {
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
            if (this == obj) {
                return true;}

            if (obj == null || getClass() != obj.getClass()) {
                return false;}

            Car car = (Car) obj;

            return year == car.year
                    && maxSpeed == car.maxSpeed
                    && Double.compare(car.price, price) == 0
                    && Objects.equals(brand, car.brand)
                    && Objects.equals(model, car.model);
        }
    }

    public static void main(String[] args) {

        Car[] cars = {
                new Car("BMW", "X5", 2020, 240, 50000),
                new Car("Audi", "A6", 2020, 250, 48000),
                new Car("Toyota", "Camry", 2019, 210, 30000),
                new Car("Mercedes", "E200", 2020, 250, 52000),
                new Car("Ford", "Focus", 2018, 190, 18000)};

        System.out.println("Початковий масив:");

        for (Car car : cars) {
            System.out.println(car);}

        Arrays.sort(
                cars,
                Comparator.comparingInt((Car c) -> c.year)
                        .thenComparing((Car c) -> c.brand, Comparator.reverseOrder()));

        System.out.println("\nВідсортований масив:");

        for (Car car : cars) {
            System.out.println(car);}

        Car target = new Car(
                "Audi",
                "A6",
                2020,
                250,
                48000);

        boolean found = false;

        for (Car car : cars) {
            if (car.equals(target)) {
                found = true;
                System.out.println("\nЗнайдено об'єкт:");
                System.out.println(car);
                break;}}

        if (!found) {
            System.out.println("\nОб'єкт не знайдено.");}
    }
}
