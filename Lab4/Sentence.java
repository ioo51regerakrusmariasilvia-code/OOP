package Lab4;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private final Object[] elements;

    public Sentence(Object[] elements) {
        this.elements = elements;}

    public Sentence(String sentenceStr) {
        List<Object> parsedElements = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < sentenceStr.length(); i++) {
            char ch = sentenceStr.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                currentWord.append(ch);
            } else {
                if (currentWord.length() > 0) {
                    parsedElements.add(new Word(currentWord.toString()));
                    currentWord.setLength(0);}
                parsedElements.add(new Punctuation(ch));}
        }
        if (currentWord.length() > 0) {
            parsedElements.add(new Word(currentWord.toString()));}

        this.elements = parsedElements.toArray();}

    public Object[] getElements() {
        return elements;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object element : elements) {
            sb.append(element.toString());}
        return sb.toString();
    }
}
