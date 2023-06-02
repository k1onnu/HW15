import java.util.Scanner;

public class Main {
    private static final String LETTER_RANGE = " абвгдеёжзийклмнопрстуфхцчшщъыьэюя-АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static boolean isValid;
    private static int spaceCount;

    public static void main(String[] args) {
        printInformation();
    }
    private static void printInformation() {
        System.out.println("Введите ФИО:");
        String input = new Scanner(System.in).nextLine().trim();
        Information(input);
    }
    private static boolean rule(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') spaceCount++;
            if (!LETTER_RANGE.contains(String.valueOf(input.charAt(i)))) {
                isValid = false;
                break;
            }
        }
        return !isValid;
    }
    private static void Information(String input) {
        boolean rule = rule(input);
        if (rule && spaceCount == 2) {
            String[] words = input.split(" ");
            String[] fioArrays = {"Фамилия: ", "Имя: ", "Отчество: "};
            for (int i = 0; i < words.length; i++) System.out.println(fioArrays[i] + words[i]);
        } else {
            System.out.println("Введенная строка не является ФИО");
        }
    }
}