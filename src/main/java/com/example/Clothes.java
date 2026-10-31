package com.example;

import java.util.Objects;

/**
 * Клас для зберігання інформації про одяг.
 */
public class Clothes {

    private String name;
    private String size;
    private double price;
    private String brand;
    private int quantity;

    /**
     * Створює об'єкт одягу з перевіркою параметрів.
     *
     * @param name назва одягу
     * @param size розмір одягу
     * @param price ціна одягу
     * @param brand бренд одягу
     * @param quantity кількість одиниць
     */
    public Clothes(String name, String size, double price,
                   String brand, int quantity) {
        setName(name);
        setSize(size);
        setPrice(price);
        setBrand(brand);
        setQuantity(quantity);
    }

    /**
     * Перевіряє текстове значення.
     *
     * @param value текст для перевірки
     * @param field назва поля
     * @throws IllegalArgumentException якщо текст порожній
     */
    private void validateText(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    field + " не може бути порожнім!");
        }
    }

    /** @return назву одягу */
    public String getName() {
        return name;
    }

    /**
     * Встановлює назву одягу.
     * @param name назва одягу
     */
    public void setName(String name) {
        validateText(name, "Назва");
        this.name = name.trim();
    }

    /** @return розмір одягу */
    public String getSize() {
        return size;
    }

    /**
     * Встановлює розмір одягу.
     * @param size розмір одягу
     */
    public void setSize(String size) {
        validateText(size, "Розмір");
        this.size = size.trim();
    }

    /** @return ціну одягу */
    public double getPrice() {
        return price;
    }

    /**
     * Встановлює ціну одягу.
     * @param price ціна одягу
     */
    public void setPrice(double price) {
        if (!Double.isFinite(price) || price <= 0) {
            throw new IllegalArgumentException(
                    "Ціна повинна бути більшою за 0!");
        }
        this.price = price;
    }

    /** @return бренд одягу */
    public String getBrand() {
        return brand;
    }

    /**
     * Встановлює бренд одягу.
     * @param brand бренд одягу
     */
    public void setBrand(String brand) {
        validateText(brand, "Бренд");
        this.brand = brand.trim();
    }

    /** @return кількість одиниць */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Встановлює кількість одиниць.
     * @param quantity кількість одиниць
     */
    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Кількість повинна бути більшою за 0!");
        }
        this.quantity = quantity;
    }

    /** @return текстове представлення об'єкта */
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

    /**
     * Порівнює два об'єкти одягу.
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
                && Objects.equals(size, clothes.size)
                && Objects.equals(brand, clothes.brand);
    }

    /** @return хеш-код об'єкта */
    @Override
    public int hashCode() {
        return Objects.hash(name, size, price, brand, quantity);
    }
}