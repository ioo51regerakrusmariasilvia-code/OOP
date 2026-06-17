public abstract class Sweets {
    private final String name;
    private final double weight; 
    private final double sugarContent; 

    protected Sweets(String name, double weight, double sugarContent) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва не може бути порожньою.");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Вага повинна бути більшою за 0.");
        }
        if (sugarContent < 0 || sugarContent > 100) {
            throw new IllegalArgumentException("Вміст цукру повинен бути від 0% до 100%.");
        }
        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
    }

    public String getName() { return name; }
    public double getWeight() { return weight; }
    public double getSugarContent() { return sugarContent; }

    public abstract double getChocolateContent();

    @Override
    public String toString() {
        return String.format("Тип: %s | Назва: '%s' | Вага: %.2fг | Цукор: %.1f%%",
                getClass().getSimpleName(), name, weight, sugarContent);
    }
}