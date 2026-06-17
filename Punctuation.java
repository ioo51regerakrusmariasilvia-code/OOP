package Lab4;

public class Punctuation {
    private final char symbol;

    public Punctuation(char symbol) {
        this.symbol = symbol;}

    public char getSymbol() {
        return symbol;}

    @Override
    public String toString() {
        return String.valueOf(symbol);}
}