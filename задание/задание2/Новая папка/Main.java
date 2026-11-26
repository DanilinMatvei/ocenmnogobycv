import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                Integer year = YearUtils.readYear(scanner, "Введите год в формате yyyy");
                if (year == null) {
                    System.out.println("Ввод завершён.");
                    return;
                }
                System.out.println("Количество дней " + YearUtils.getDaysInYear(year));
            }
        }
    }
}

final class YearUtils {

    private YearUtils() {
    }

    static int getDaysInYear(int year) {
        if (year % 400 == 0) {
            return 366;
        } else if (year % 100 == 0) {
            return 365;
        } else if (year % 4 == 0) {
            return 366;
        } else {
            return 365;
        }
    }

    static String readLine(Scanner scanner, String prompt) {
        System.out.println(prompt);
        if (!scanner.hasNextLine()) {
            return null;
        }
        return scanner.nextLine().trim();
    }

    static Integer readYear(Scanner scanner, String prompt) {
        while (true) {
            String line = readLine(scanner, prompt);
            if (line == null) {
                return null;
            }
            if (!line.matches("\\d{4}")) {
                System.out.println("Ошибка: введите год в формате yyyy (4 цифры).");
                continue;
            }
            int year = Integer.parseInt(line);
            if (year < 1) {
                System.out.println("Ошибка: год должен быть больше нуля.");
                continue;
            }
            return year;
        }
    }

    static Integer readInt(Scanner scanner, String prompt) {
        while (true) {
            String line = readLine(scanner, prompt);
            if (line == null) {
                return null;
            }
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }
}

class fghj {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        while (true) {
            Integer year = YearUtils.readYear(scanner, "Введите год:");
            if (year == null) {
                break;
            }

            Integer days = YearUtils.readInt(scanner, "Введите количество дней:");
            if (days == null) {
                break;
            }

            int correctDays = YearUtils.getDaysInYear(year);

            if (days == correctDays) {
                score++;
            } else {
                System.out.println("Неправильно! В этом году " + correctDays + " дней!");
                break;
            }
        }

        System.out.println("Набрано очков: " + score);
        scanner.close();
    }
}