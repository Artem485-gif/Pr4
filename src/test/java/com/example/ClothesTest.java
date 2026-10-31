package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тести для перевірки класу Clothes.
 */
class ClothesTest {

    /**
     * Перевіряє виняток при некоректній ціні.
     */
    @Test
    void shouldThrowExceptionWhenInvalidPriceInSetter() {
        Clothes clothes = new Clothes(
                "Футболка", "M", 500, "Adidas", 10);

        assertThrows(IllegalArgumentException.class,
                () -> clothes.setPrice(-100));
    }

    /**
     * Перевіряє виняток при некоректній кількості.
     */
    @Test
    void shouldThrowExceptionWhenInvalidQuantityInSetter() {
        Clothes clothes = new Clothes(
                "Футболка", "M", 500, "Adidas", 10);

        assertThrows(IllegalArgumentException.class,
                () -> clothes.setQuantity(0));
    }

    /**
     * Перевіряє виняток при створенні об'єкта
     * з некоректними параметрами.
     */
    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class,
                () -> new Clothes("", "M", -100, "Adidas", 10));
    }

    /**
     * Перевіряє створення об'єкта з правильними даними.
     */
    @Test
    void shouldCreateClothesWithValidData() {
        Clothes clothes = new Clothes(
                "Футболка", "M", 500, "Adidas", 10);

        assertEquals("Футболка", clothes.getName());
        assertEquals("M", clothes.getSize());
        assertEquals(500, clothes.getPrice());
        assertEquals("Adidas", clothes.getBrand());
        assertEquals(10, clothes.getQuantity());
    }
}