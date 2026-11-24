package com.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головний клас програми для керування одягом.
 * Демонструє роботу класів, копіювання об'єктів,
 * статичних членів, перерахувань та агрегації.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Clothes> clothesList =
            new ArrayList<>();
    private static final ClothesStore store =
            new ClothesStore("Fashion Store");

    /**
     * Запускає головне меню програми.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("     ПРОГРАМА ОБЛІКУ ОДЯГУ");
        System.out.println("====================================");

        boolean running = true;

        while (running) {
            System.out.println("\n========== ГОЛОВНЕ МЕНЮ ==========");
            System.out.println("1. Створити новий об'єкт одягу");
            System.out.println("2. Вивести всі об'єкти");
            System.out.println("3. Створити копію об'єкта");
            System.out.println("4. Показати кількість створених об'єктів");
            System.out.println("5. Додати об'єкт до магазину");
            System.out.println("6. Показати товари магазину");
            System.out.println("7. Завершити роботу");
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
                    copyClothes();
                    break;
                case "4":
                    showObjectCount();
                    break;
                case "5":
                    addToStore();
                    break;
                case "6":
                    showStore();
                    break;
                case "7":
                    running = false;
                    System.out.println("Програму завершено.");
                    break;
                default:
                    System.out.println(
                            "Помилка! Введіть число від 1 до 7.");
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

            ClothingSize size = readEnum(
                    "Розмір " + enumValues(ClothingSize.values()) + ": ",
                    ClothingSize.class);

            ClothingType type = readEnum(
                    "Тип " + enumValues(ClothingType.values()) + ": ",
                    ClothingType.class);

            double price = readDouble("Ціна: ");
            String brand = readText("Бренд: ");
            int quantity = readInt("Кількість: ");

            Clothes clothes = new Clothes(
                    name, size, type, price, brand, quantity);

            clothesList.add(clothes);

            System.out.println("Об'єкт успішно створено!");
            System.out.println(clothes);

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
            System.out.println((i + 1) + ". " + clothesList.get(i));
        }
    }

    /**
     * Створює копію вибраного об'єкта за допомогою конструктора копіювання.
     */
    private static void copyClothes() {
        if (clothesList.isEmpty()) {
            System.out.println("Немає об'єктів для копіювання.");
            return;
        }

        showClothes();

        int index = readInt("Введіть номер об'єкта для копіювання: ");

        if (index < 1 || index > clothesList.size()) {
            System.out.println("Об'єкта з таким номером немає.");
            return;
        }

        Clothes copy = new Clothes(clothesList.get(index - 1));
        clothesList.add(copy);

        System.out.println("Копію успішно створено!");
        System.out.println(copy);
    }

    /**
     * Виводить загальну кількість створених об'єктів.
     */
    private static void showObjectCount() {
        System.out.println(
                "Кількість створених об'єктів Clothes: "
                        + Clothes.getObjectCount());
    }

    /**
     * Додає вибраний об'єкт одягу до магазину.
     */
    private static void addToStore() {
        if (clothesList.isEmpty()) {
            System.out.println("Спочатку створіть об'єкт одягу.");
            return;
        }

        showClothes();

        int index = readInt("Введіть номер об'єкта для додавання: ");

        if (index < 1 || index > clothesList.size()) {
            System.out.println("Об'єкта з таким номером немає.");
            return;
        }

        store.addClothes(clothesList.get(index - 1));

        System.out.println("Об'єкт додано до магазину "
                + store.getName() + ".");
    }

    /**
     * Виводить інформацію про товари, які агрегує магазин.
     */
    private static void showStore() {
        System.out.println("\n=== " + store.getName() + " ===");

        if (store.getClothesCount() == 0) {
            System.out.println("У магазині поки немає товарів.");
            return;
        }

        ArrayList<Clothes> storeClothes =
                new ArrayList<>(store.getClothes());

        for (int i = 0; i < storeClothes.size(); i++) {
            System.out.println((i + 1) + ". " + storeClothes.get(i));
        }

        System.out.println(
                "Кількість товарів у магазині: "
                        + store.getClothesCount());
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
                        "Помилка! Число повинно бути більшим за 0.");

            } catch (NumberFormatException e) {
                System.out.println(
                        "Помилка! Введіть ціле число.");
            }
        }
    }

    /**
     * Зчитує значення перерахування.
     *
     * @param message повідомлення для користувача
     * @param enumClass клас перерахування
     * @param <T> тип перерахування
     * @return вибране значення
     */
    private static <T extends Enum<T>> T readEnum(
            String message, Class<T> enumClass) {

        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim().toUpperCase();

            try {
                return Enum.valueOf(enumClass, value);
            } catch (IllegalArgumentException e) {
                System.out.println(
                        "Помилка! Введіть одне зі значень перерахування.");
            }
        }
    }

    /**
     * Формує рядок із доступних значень перерахування.
     *
     * @param values масив значень перерахування
     * @param <T> тип перерахування
     * @return рядок із доступними значеннями
     */
    private static <T extends Enum<T>> String enumValues(T[] values) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                result.append(", ");
            }

            result.append(values[i].name());
        }

        return result.toString();
    }
}
