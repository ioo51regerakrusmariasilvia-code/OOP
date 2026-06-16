public class Lab2 {
    public static void main(String[] args) {
        // Рядки Івана Франка з різною кількістю слів для наочного сортування
        String text = "Колупайте сю скалу. Нехай ні жар, ні холод не спиняє вас. " +
                      "Переносіть і труд, і спрагу, і голод, бо вам призначено скалу сесю розбить.";

        System.out.println("Оригінальний текст:");
        System.out.println(text);
        System.out.println("\nРезультат сортування:");

        processText(text);
    }

    public static void processText(String text) {
        if (text == null) {
            System.out.println("Помилка: Текст не існує (null)!");
            return;
        }
        
        if (text.trim().isEmpty()) {
            System.out.println("Помилка: Рядок порожній!");
            return;
        }

        String[] sentences = text.split("\\.");

        for (int i = 0; i < sentences.length - 1; i++) {
            for (int j = 0; j < sentences.length - i - 1; j++) {
                
                int count1 = countWords(sentences[j]);
                int count2 = countWords(sentences[j + 1]);

                if (count1 > count2) {
                    String temp = sentences[j];
                    sentences[j] = sentences[j + 1];
                    sentences[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < sentences.length; i++) {
            String trimmed = sentences[i].trim(); 
            if (!trimmed.isEmpty()) {
                System.out.println("Слів: " + countWords(trimmed) + " -> " + trimmed + ".");
            }
        }
    }

    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }
}