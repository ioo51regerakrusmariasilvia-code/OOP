package Lab5;

public class Lollipop extends Sweets {
    private final String flavor; 

    public Lollipop(String name, double weight, double sugarContent, String flavor) {
        super(name, weight, sugarContent);
        this.flavor = flavor;
    }

    public String getFlavor() { return flavor; }

    @Override
    public double getChocolateContent() {
        return 0.0; 
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Смак: %s", flavor);
    }
}
