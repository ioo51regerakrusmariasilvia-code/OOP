public class Lab2 {
    public static void main(String[] args) {
        runTests();

        String text = "Колупайте сю скалу. Нехай ні жар, ні холод не спиняє вас. " +
                      "Переносіть і труд, і спрагу, і голод, бо вам призначено скалу сесю розбить.";

        System.out.println("\nОригінальний текст:");
        System.out.println(text);
        System.out.println("\nРезультат сортування:");

        processText(text);
    }

    public static void runTests() {
        System.out.println("ЗАПУСК ЮНІТ ТЕСТІВ");
        
        // Тест 1: Перевірка підрахунку слів у короткому реченні
        int test1 = countWords("Колупайте сю скалу");
        if (test1 != 3) {
            throw new AssertionError("Тест 1 провалено! Очікувалось 3 слова, але отримано: " + test1);}

        int test2 = countWords("Нехай ні жар, ні холод не спиняє вас");
        if (test2 != 8) {
            throw new AssertionError("Тест 2 провалено! Очікувалось 8 слів, але отримано: " + test2);}

        int test3 = countWords("   ");
        if (test3 != 0) {
            throw new AssertionError("Тест 3 провалено! Очікувалось 0 слів для пробілів.");}

        System.out.println("✅ Усі юніт-тести успішно пройдено!");
    }



    public static void processText(String text) {
        if (text == null) {
            System.out.println("Помилка: Текст не існує (null)!");
            return;}
        
        if (text.trim().isEmpty()) {
            System.out.println("Помилка: Рядок порожній!");
            return;}

        String[] sentences = text.split("\\.");

        for (int i = 0; i < sentences.length - 1; i++) {
            for (int j = 0; j < sentences.length - i - 1; j++) {
                int count1 = countWords(sentences[j]);
                int count2 = countWords(sentences[j + 1]);

                if (count1 > count2) {
                    String temp = sentences[j];
                    sentences[j] = sentences[j + 1];
                    sentences[j + 1] = temp;}
            }
        }

        for (int i = 0; i < sentences.length; i++) {
            String trimmed = sentences[i].trim(); 
            if (!trimmed.isEmpty()) {
                System.out.println("Слів: " + countWords(trimmed) + " -> " + trimmed + ".");}}
    }

    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;}
        String[] words = sentence.trim().split("\\s+");
        return words.length;}
}