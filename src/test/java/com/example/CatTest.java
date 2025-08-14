package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    Feline feline = new Feline();

    Cat cat;
    @BeforeEach
    public void setup() {
        cat = new Cat(feline);
    }

    @Test
    @DisplayName("getSound: Коты говорят Мяу")
    void getSound() {
        String actualSound = cat.getSound();
        assertEquals("Мяу", actualSound, "Коты должны говорить Мяу");
    }

    @Test
    @DisplayName("getFood: Еда для котов")
    void getFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood, "Список еды должен соответствовать рациону Хищник");
    }

}