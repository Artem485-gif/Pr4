package com.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головний клас програми для керування одягом.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Clothes> clothesList =
            new ArrayList<>();

    /**
     * Запускає головне меню програми.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== МЕНЮ =====");
            System.out.println("1. Створити новий об'єкт");
            System.out.println("2. Вивести інформацію про всі об'єкти");
            System.out.println("3. Завершити роботу");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    createClothes();
                    break;
                case "2":
                    showClothes();
                    break;
                case "3":
                    running = false;
                    System.out.println("Програму завершено.");
                    break;
                default:
                    System.out.println(
                            "Помилка! Введіть число від 1 до 3.");
            }
        }

        scanner.close();
    }

    /**
     * Створює новий об'єкт одягу.
     */
    private static void createClothes() {
        try {
            System.out.println("\n=== Створення нового об'єкта ===");

            String name = readText("Назва одягу: ");
            String size = readText("Розмір: ");
            double price = readDouble("Ціна: ");
            String brand = readText("Бренд: ");
            int quantity = readInt("Кількість: ");

            Clothes clothes = new Clothes(
                    name, size, price, brand, quantity);

            clothesList.add(clothes);

            System.out.println("Об'єкт успішно створено!");

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    /**
     * Виводить інформацію про всі створені об'єкти.
     */
    private static void showClothes() {
        System.out.println("\n=== Список одягу ===");

        if (clothesList.isEmpty()) {
            System.out.println("Список порожній.");
            return;
        }

        for (int i = 0; i < clothesList.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + clothesList.get(i));
        }
    }

    /**
     * Зчитує непорожній текст із клавіатури.
     *
     * @param message повідомлення для користувача
     * @return введений текст
     */
    private static String readText(String message) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "Помилка! Поле не може бути порожнім.");
        }
    }

    /**
     * Зчитує та перевіряє додатне число.
     *
     * @param message повідомлення для користувача
     * @return введене число
     */
    private static double readDouble(String message) {
        while (true) {
            System.out.print(message);

            try {
                double value = Double.parseDouble(
                        scanner.nextLine().trim().replace(',', '.'));

                if (Double.isFinite(value) && value > 0) {
                    return value;
                }

                System.out.println(
                        "Помилка! Ціна повинна бути більшою за 0.");

            } catch (NumberFormatException e) {
                System.out.println(
                        "Помилка! Введіть числове значення.");
            }
        }
    }

    /**
     * Зчитує та перевіряє додатне ціле число.
     *
     * @param message повідомлення для користувача
     * @return введене ціле число
     */
    private static int readInt(String message) {
        while (true) {
            System.out.print(message);

            try {
                int value = Integer.parseInt(
                        scanner.nextLine().trim());

                if (value > 0) {
                    return value;
                }

                System.out.println(
                        "Помилка! Кількість повинна бути більшою за 0.");

            } catch (NumberFormatException e) {
                System.out.println(
                        "Помилка! Введіть ціле число.");
            }
        }
    }
}