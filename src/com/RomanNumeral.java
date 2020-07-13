package com;

import static com.RomanNumeral.values;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author Frolov Sergey
 * Класс типа перечислений enum в котором описывается соответсве римский и арабских цифр
 */
enum RomanNumeral {
    //создаем константы римских цифр и их эквивалент в арабских цифрах
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);
    
    //Создаем переменную для хранения эквивалента арабских цифр
    private int value;
    
    //Создаем контсруктор
    RomanNumeral(int value) {
        this.value = value;
    }
    
    //создаем метод получения значения переменной римской цифры
    public int getValue() {
        return value;
    }

    // метод выстраивает римские цифры в порядке убывания значения и возращает их в формате ArrayList
    public static ArrayList<RomanNumeral> getReverseSortedValues() {
        return (ArrayList<RomanNumeral>) Arrays.stream(values())
            .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
            .collect(Collectors.toList());
    }
}


