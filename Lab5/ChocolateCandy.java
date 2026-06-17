package Lab5;

public class ChocolateCandy extends Sweets {
    private final double chocolateContent; 

    public ChocolateCandy(String name, double weight, double sugarContent, double chocolateContent) {
        super(name, weight, sugarContent);
        if (chocolateContent < 0 || chocolateContent > 100) {
            throw new IllegalArgumentException("Вміст шоколаду повинен бути від 0% до 100%.");
        }
        this.chocolateContent = chocolateContent;
    }

    @Override
    public double getChocolateContent() {
        return chocolateContent;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Шоколад: %.1f%%", chocolateContent);
    }
}