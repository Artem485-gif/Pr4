package com.example;

import java.util.Objects;

/**
 * Клас для зберігання інформації про одяг.
 * Підраховує кількість створених об'єктів.
 */
public class Clothes {

    private String name;
    private String size;
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
     * @param size розмір
     * @param price ціна
     * @param brand бренд
     * @param quantity кількість
     */
    public Clothes(String name, String size, double price,
                   String brand, int quantity) {
        setName(name);
        setSize(size);
        setPrice(price);
        setBrand(brand);
        setQuantity(quantity);
        objectCount++;
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

    private void validateText(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    field + " не може бути порожнім!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateText(name, "Назва");
        this.name = name.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        validateText(size, "Розмір");
        this.size = size.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (!Double.isFinite(price) || price <= 0) {
            throw new IllegalArgumentException(
                    "Ціна повинна бути більшою за 0!");
        }
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        validateText(brand, "Бренд");
        this.brand = brand.trim();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Кількість повинна бути більшою за 0!");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clothes clothes = (Clothes) o;

        return Double.compare(clothes.price, price) == 0
                && quantity == clothes.quantity
                && Objects.equals(name, clothes.name)
                && Objects.equals(size, clothes.size)
                && Objects.equals(brand, clothes.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, price, brand, quantity);
    }
}
