package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineTest {

    Feline feline;

    @BeforeEach
    public void setup() {
        feline = new Feline();
    }

    @Test
    @DisplayName("eatMeat: Еда для хищника")
    void eatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood, "Список еды должен соответствовать рациону Хищник");
    }

    @Test
    @DisplayName("getFamily: Семейство Кошачьи")
    void getFamily() {
        assertEquals("Кошачьи",feline.getFamily(), "Должен быть Кошачьи");
    }

    @Test
    @DisplayName("getKittens: Без параметра возвращает 1")
    void getKittensWithoutParams() {
        assertEquals(1, feline.getKittens(), "Количество котят должно быть 1");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10})
    @DisplayName("Проверка метода getKittens с параметром возвращает переданное значение")
    void getKittensWithParameterReturnsSameValue(int kittensCount) {
        assertEquals(kittensCount, feline.getKittens(kittensCount), "Количество котят должно быть " + kittensCount);
    }
}