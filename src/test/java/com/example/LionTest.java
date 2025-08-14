package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline feline = new Feline();

    @Test
    @DisplayName("haveMane: У самца есть грива")
    public void doesHaveMane() throws Exception {
        Lion maleLion = new Lion(feline, "Самец");
        assertTrue(maleLion.doesHaveMane(), "У самца должна быть грива");
    }

    @Test
    @DisplayName("haveMane: У самки нет гривы")
    public void doesNotHaveMane() throws Exception {
        Lion femaleLion = new Lion(feline, "Самка");
        assertFalse(femaleLion.doesHaveMane(), "У самки не должно быть гривы");
    }

    @Test
    @DisplayName("haveMane: Проверка исключения")
    public void exceptionHaveMane() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(feline ,"Чубака"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

    @Test
    @DisplayName("getKittens: Количество котят")
    public void getKittens() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, "Самка");
        int kittens = lion.getKittens();
        assertEquals(1, kittens, "Количество котят должно совпадать с возвращаемым значением feline");
        verify(feline, times(1)).getKittens(); // Проверка, что метод был вызван только 1 раз.
    }

    @Test
    @DisplayName("getFood: Еда для льва")
    public void getFoodFeline() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion(feline, "Самка");
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood, "Список еды должен соответствовать рациону Хищник");
        verify(feline, times(1)).getFood("Хищник");
    }

}