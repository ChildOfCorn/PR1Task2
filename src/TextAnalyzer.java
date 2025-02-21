import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class TextAnalyzer {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String text;

        System.out.println("Оберіть джерело тексту:");
        System.out.println("1 - Зчитати з файлу");
        System.out.println("2 - Ввести вручну");
        int sourceChoice = scanner.nextInt();
        scanner.nextLine(); // Очистити буфер

        if (sourceChoice == 1) {
            System.out.println("Введіть шлях до файлу:");
            String filePath = scanner.nextLine();
            text = Files.readString(Path.of(filePath));
        } else {
            System.out.println("Введіть текст:");
            text = scanner.nextLine();
        }

        while (true) {
            System.out.println("\nОберіть операцію:");
            System.out.println("1 - Розбити текст на слова");
            System.out.println("2 - Фільтрувати слова, що починаються з певної літери");
            System.out.println("3 - Сортувати слова за алфавітом");
            System.out.println("4 - Підрахувати кількість унікальних слів");
            System.out.println("5 - Вийти");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистити буфер

            switch (choice) {
                case 1 -> {
                    List<String> words = Arrays.stream(text.split("\\s+")).toList();
                    System.out.println("Слова у тексті: " + words);
                }
                case 2 -> {
                    System.out.println("Введіть літеру для фільтрації:");
                    String letter = scanner.nextLine();
                    List<String> filteredWords = Arrays.stream(text.split("\\s+")).filter(word -> word.startsWith(letter)).toList();
                    System.out.println("Відфільтровані слова: " + filteredWords);
                }
                case 3 -> {
                    List<String> sortedWords = Arrays.stream(text.split("\\s+")).sorted().toList();
                    System.out.println("Відсортовані слова: " + sortedWords);
                }
                case 4 -> {
                    long uniqueWordCount = Arrays.stream(text.split("\\s+")).distinct().count();
                    System.out.println("Кількість унікальних слів: " + uniqueWordCount);
                }
                case 5 -> {
                    System.out.println("Вихід з програми.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}
