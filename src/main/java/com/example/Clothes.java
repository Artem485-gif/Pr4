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
     * Створює об'єкт одягу.
     */
    public Clothes(String name, String size, double price,
                   String brand, int quantity) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.brand = brand;
        this.quantity = quantity;
    }

    /** @return назву одягу */
    public String getName() {
        return name;
    }

    /** @param name назва одягу */
    public void setName(String name) {
        this.name = name;
    }

    /** @return розмір одягу */
    public String getSize() {
        return size;
    }

    /** @param size розмір одягу */
    public void setSize(String size) {
        this.size = size;
    }

    /** @return ціну одягу */
    public double getPrice() {
        return price;
    }

    /** @param price ціна одягу */
    public void setPrice(double price) {
        this.price = price;
    }

    /** @return бренд одягу */
    public String getBrand() {
        return brand;
    }

    /** @param brand бренд одягу */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /** @return кількість одиниць */
    public int getQuantity() {
        return quantity;
    }

    /** @param quantity кількість одиниць */
    public void setQuantity(int quantity) {
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

    /** Порівнює два об'єкти одягу. */
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