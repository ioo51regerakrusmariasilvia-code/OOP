package Lab4;

public class Text {
    private final Sentence[] sentences;

    public Text(Sentence[] sentences) {
        this.sentences = sentences;}

    public Text(String rawText) {
        String cleanedText = rawText.replaceAll("[\\s\\t]+", " ").trim();

        String[] sentenceStrings = cleanedText.split("(?<=[.!?])\\s*");
        this.sentences = new Sentence[sentenceStrings.length];

        for (int i = 0; i < sentenceStrings.length; i++) {
            this.sentences[i] = new Sentence(sentenceStrings[i]);}
    }

    public Sentence[] getSentences() {
        return sentences;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            sb.append(sentences[i].toString());
            if (i < sentences.length - 1) {
                sb.append(" ");}}
        return sb.toString();
    }
}