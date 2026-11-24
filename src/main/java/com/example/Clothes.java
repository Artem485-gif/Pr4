package com.example;

import java.util.Objects;

/**
 * Клас для зберігання інформації про одяг.
 * Підраховує кількість створених об'єктів.
 */
public class Clothes {

    private String name;
    private ClothingSize size;
    private double price;
    private String brand;
    private int quantity;

    /**
     * Лічильник створених об'єктів.
     */
    private static int objectCount = 0;

    /**
     * Створює об'єкт одягу.
     *
     * @param name назва одягу
     * @param size розмір одягу
     * @param price ціна
     * @param brand бренд
     * @param quantity кількість
     */
    public Clothes(String name, ClothingSize size, double price,
                   String brand, int quantity) {
        setName(name);
        setSize(size);
        setPrice(price);
        setBrand(brand);
        setQuantity(quantity);
        objectCount++;
    }

    /**
     * Створює об'єкт одягу з текстовим значенням розміру.
     *
     * @param name назва одягу
     * @param size розмір одягу
     * @param price ціна
     * @param brand бренд
     * @param quantity кількість
     */
    public Clothes(String name, String size, double price,
                   String brand, int quantity) {
        this(name, parseSize(size), price, brand, quantity);
    }

    /**
     * Перетворює текст на значення перерахування ClothingSize.
     *
     * @param size текстове позначення розміру
     * @return значення перерахування
     */
    private static ClothingSize parseSize(String size) {
        if (size == null || size.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Розмір не може бути порожнім!");
        }

        try {
            return ClothingSize.valueOf(
                    size.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Невідомий розмір! Доступні: XS, S, M, L, XL, XXL.");
        }
    }

    /**
     * Створює копію іншого об'єкта.
     *
     * @param other об'єкт для копіювання
     */
    public Clothes(Clothes other) {
        if (other == null) {
            throw new IllegalArgumentException(
                    "Об'єкт для копіювання не може бути null!");
        }

        this.name = other.name;
        this.size = other.size;
        this.price = other.price;
        this.brand = other.brand;
        this.quantity = other.quantity;
        objectCount++;
    }

    /**
     * Повертає кількість створених об'єктів.
     *
     * @return кількість об'єктів
     */
    public static int getObjectCount() {
        return objectCount;
    }

    /**
     * Перевіряє текстове значення.
     *
     * @param value значення для перевірки
     * @param field назва поля
     */
    private void validateText(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    field + " не може бути порожнім!");
        }
    }

    /**
     * Повертає назву одягу.
     *
     * @return назва одягу
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює назву одягу.
     *
     * @param name назва одягу
     */
    public void setName(String name) {
        validateText(name, "Назва");
        this.name = name.trim();
    }

    /**
     * Повертає розмір одягу у форматі тексту.
     *
     * @return позначення розміру
     */
    public String getSize() {
        return size.name();
    }

    /**
     * Повертає розмір одягу як значення enum.
     *
     * @return перерахування ClothingSize
     */
    public ClothingSize getClothingSize() {
        return size;
    }

    /**
     * Встановлює розмір одягу.
     *
     * @param size розмір одягу
     */
    public void setSize(ClothingSize size) {
        if (size == null) {
            throw new IllegalArgumentException(
                    "Розмір не може бути null!");
        }
        this.size = size;
    }

    /**
     * Встановлює розмір одягу з текстового значення.
     *
     * @param size текстове позначення розміру
     */
    public void setSize(String size) {
        this.size = parseSize(size);
    }

    /**
     * Повертає ціну одягу.
     *
     * @return ціна
     */
    public double getPrice() {
        return price;
    }

    /**
     * Встановлює ціну одягу.
     *
     * @param price ціна
     */
    public void setPrice(double price) {
        if (!Double.isFinite(price) || price <= 0) {
            throw new IllegalArgumentException(
                    "Ціна повинна бути більшою за 0!");
        }
        this.price = price;
    }

    /**
     * Повертає бренд одягу.
     *
     * @return бренд
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Встановлює бренд одягу.
     *
     * @param brand бренд
     */
    public void setBrand(String brand) {
        validateText(brand, "Бренд");
        this.brand = brand.trim();
    }

    /**
     * Повертає кількість одиниць одягу.
     *
     * @return кількість
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Встановлює кількість одиниць одягу.
     *
     * @param quantity кількість
     */
    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Кількість повинна бути більшою за 0!");
        }
        this.quantity = quantity;
    }

    /**
     * Повертає текстове представлення об'єкта.
     *
     * @return інформація про одяг
     */
    @Override
    public String toString() {
        return "Clothes{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    /**
     * Порівнює два об'єкти одягу.
     *
     * @param o об'єкт для порівняння
     * @return true, якщо об'єкти однакові
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clothes clothes = (Clothes) o;

        return Double.compare(clothes.price, price) == 0
                && quantity == clothes.quantity
                && Objects.equals(name, clothes.name)
                && size == clothes.size
                && Objects.equals(brand, clothes.brand);
    }

    /**
     * Повертає хеш-код об'єкта.
     *
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, size, price, brand, quantity);
    }
}
