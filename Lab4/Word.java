package Lab4;

public class Word {
    private final Letter[] letters;

    public Word(Letter[] letters) {
        this.letters = letters;
    }

    public Word(String wordStr) {
        this.letters = new Letter[wordStr.length()];
        for (int i = 0; i < wordStr.length(); i++) {
            this.letters[i] = new Letter(wordStr.charAt(i));}
    }

    public Letter[] getLetters() {
        return letters;}

    public Word toUpperCase() {
        return new Word(this.toString().toUpperCase());}

    public Word toLowerCase() {
        return new Word(this.toString().toLowerCase());}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Word word = (Word) obj;
        return this.toString().equalsIgnoreCase(word.toString());}

    @Override
    public int hashCode() {
        return this.toString().toLowerCase().hashCode();}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.toString());}
        return sb.toString();
    }
}
