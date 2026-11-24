package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас магазину, який агрегує об'єкти одягу.
 */
public class ClothesStore {

    private String name;
    private final List<Clothes> clothes;

    /**
     * Створює магазин із заданою назвою.
     *
     * @param name назва магазину
     */
    public ClothesStore(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва магазину не може бути порожньою");
        }

        this.name = name;
        this.clothes = new ArrayList<>();
    }

    /**
     * Додає одяг до магазину.
     *
     * @param item об'єкт одягу
     */
    public void addClothes(Clothes item) {
        if (item == null) {
            throw new IllegalArgumentException("Одяг не може бути null");
        }

        clothes.add(item);
    }

    /**
     * Повертає назву магазину.
     *
     * @return назва магазину
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає список одягу магазину.
     *
     * @return список об'єктів одягу
     */
    public List<Clothes> getClothes() {
        return new ArrayList<>(clothes);
    }

    /**
     * Повертає кількість товарів у магазині.
     *
     * @return кількість товарів
     */
    public int getClothesCount() {
        return clothes.size();
    }
}