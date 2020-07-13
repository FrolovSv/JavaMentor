package com;

import java.util.ArrayList;
/**
 *
 * @author Frolov Sergey
 * Класс выполняющий заданные арифтметические операции над строкой
 */
public class Arifmetic {
    // создаем переменную для хранения введенной строки с консоли
    private String stringLine = ""; 

    // создаем конструктор
    public Arifmetic(String string) { 
        stringLine = string;
    }

    // создаем метод выполнения арифметических операций над числами
    private String twoNumberOperation(Integer num1, String operation, Integer num2) {
        // Ищем совпадения оператора
        switch (operation) {
            // выполняем операцию сложения
            case "+":
                return String.valueOf(num1 + num2);
            // выполняем операцию разности
            case "-":
                return String.valueOf(num1 - num2);
            // выполняем операцию деления
            case "/":
                // если деление производится без остатка возвращаем результат в формате Integer (без остатка)
                if (num1 % num2 == 0) {
                    return String.valueOf(num1 / num2);
                // в противном случае возвращаем результат в формате Double (значение с плавающей запятой
                } else {
                    return String.valueOf(num1 / Double.valueOf(num2));
                }
            // выполняем операцию умножения    
            case "*":
                return String.valueOf(num1 * num2);
            // Если введенная операция не соответсвует описаным выше
            default:
                // выводим сообщение об ошибке
                throw new IllegalArgumentException("Арифметическая операция: " +operation + " - не поддерживается. Доступные операции: `+`,`-`,`*`,`/`");
                //System.out.println("Арифметическая операци не распознана");
                //завершаем выполнение программы
                //System.exit(0);
                //return "";
        }
    }

    //В даном методе происходит определение числа и преобразование его необходимому виду для выполнение арифметических операций, 
    //метод возвращает результат в виде строки
    public String getResult() {
        try {
            //Определяем и инициализируем переменны для хранения введенных чисел
            Integer dig1 = 0, dig2 = 0;
            //разделяем сроку на составные части: первое число, оператор, второе число
            String[] exp = stringLine.split(" ");
            // первое и второе число является арабской цифрой
            if (isDigits(exp[0]) && isDigits(exp[2])) {
                // присваиваем значение к переменным
                dig1 = Integer.valueOf(exp[0]);
                dig2 = Integer.valueOf(exp[2]);
            // если первое и второе число является римской цифрой   
            } else {
                // Операция присваивания и преобразования римской цифры к арабской
                dig1 = romanToArabic(exp[0]);
                dig2 = romanToArabic(exp[2]);
            }
            // устанавливаем органичения согласно условию задачи числа в диапазоне [1-10]
            if (dig1 > 0 && dig2 > 0 && dig1 < 11 && dig2 < 11) {
                //Записываем результат вычислений в переменную
                String result = twoNumberOperation(dig1, exp[1], dig2);
                //Если первое число является арабской цифрой, то
                if (isDigits(exp[0])){  
                    //возращаем результат в виде арабаских цифр
                    return result;
                }
                //если первое число является римской цифрой
                else{ 
                    //если результат вычеслений содержит дробную часть, то
                    if (result.contains(".") && dig1 % dig2 != 0) {
                        //возращаем результат в виде арабаских цифр
                        return result;
                    //Если результат не содержит дробную часть, то
                    }else {
                        //возращаем результат в виде римских цифр
                        return arabicToRoman(Integer.valueOf(result));
                    }
                }
            //Если введенные числа не соответсвуют указанному диапазону
            } else {
                //выводим сообщение об ошибке
                throw new IllegalArgumentException("Числа: " +dig1 + " и/или "+dig2 +" - не соответсвуют диапазону [1-10]");
                //System.out.println("Вводитмые числа не соответсвуют диапазону [1-10]");
                //завершение выполнение приложения
                //System.exit(0);
            }
        //обрабатываем исключение некорректно введенных данных с консоли
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Ошибка ввода. Не указаны числа и/или операция. Пример: арабские цифры: 1 + 1; Римские цифры: I + I");
            //завершение выполнение приложения
            System.exit(0);
        //обрабатываем исключение некорректного ввода значений с консоли    
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            //завершение выполнение приложения
            System.exit(0);
        }
        return null;
    }
    
    //метод преобразование римской цицры к арабской
    private int romanToArabic(String input) {
        //преобразуем строку в написание с верхним регистром
        String romanNumeral = input.toUpperCase();
        //создаем и инициализируем переменную для вывода результата преобразования
        int result = 0;
        //Присваем значение коллекции реверсивного значения класса enum RomanNumeral
        ArrayList<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();        
        //создаем и инициализируем переменную для выполенния обхода значений в классе enum RomanNumeral
        int i = 0;
        //Обходим все значения в класса enum RomanNumeral при условии не нулевой строки для преобразования
        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            //Присваиваем переменной symbol константу в классе RomanNumeral i-ой итерации цикла
            RomanNumeral symbol = romanNumerals.get(i);
            //проверяем соотвествует ли первый символ искомой строки значению переменной symbol
            if (romanNumeral.startsWith(symbol.name())) {
                //Прибавляем к переменной result значение найденной константы
                result += symbol.getValue();
                //удаляем из искомой строки первый найденные символы сответсвующие константе в классе RomanNumeral
                romanNumeral = romanNumeral.substring(symbol.name().length());
            //Если значение не равно, переходим к следующей константе в классе RomanNumeral
            } else {
                i++;
            }
        }
        //если в результате пердыдущей операции в искомой строке все еще остались какие-то символы, то выводим сообщение об ошибке
        if (romanNumeral.length() > 0) {
            // Сообщение об ошибке, искомая строка не является корректной последовательностью римских цифр, либо не является римскими цифрами
            throw new IllegalArgumentException("Строка: " + input + " - не может быть преобразована в римские цифры");
        }
        //возращем получивший результат вычеслений
        return result;
    }

    //метод приеобразования арабских цифр в римские
    private String arabicToRoman(int number) {
        //устанавливаем ограничение, римские фифры не могут быть преобразованы из арабских величиной больше 4000 и меньше 0
        if ((number <= 0) || (number > 4000)) {
            // Выводим сообщение об ошибке
            throw new IllegalArgumentException("Число: " +number + " - должно быть в диапазоне (0,4000]");
        }
        //Присваем значение коллекции реверсивного значения класса enum RomanNumeral
        ArrayList<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
        //создаем и инициализируем переменную для выполенния обхода значений в классе enum RomanNumeral
        int i = 0;
        //Создаем и инициализируем переменную для записи результата вычислений
        StringBuilder sb = new StringBuilder();
        //Обходим все значения в класса enum RomanNumeral при условии что число для преобразования больше 0
        while ((number > 0) && (i < romanNumerals.size())) {
            //Присваиваем переменной symbol константу в классе RomanNumeral i-ой итерации цикла
            RomanNumeral currentSymbol = romanNumerals.get(i);
            //Если значение константы меньше или равно числу для преобразования, то 
            if (currentSymbol.getValue() <= number) {
                //Сохраняем имя константы в переменную 
                sb.append(currentSymbol.name());
                //Уменьшаем число на величину значения константы
                number -= currentSymbol.getValue();
            //Если значение больше, переходим к следующей константе в классе RomanNumeral
            } else {
                i++;
            }
        }
        //возращем получивший результат вычеслений
        return sb.toString();
    }

    //метод определяет, соответсвует ли указанная строка цифре (арабские цифры) или буквам (римским цифрам)
    private Boolean isDigits(String num) {
        try {
            //пытаемся приобразовать строку к типу Integer (Арабские цифры)
            int i = Integer.parseInt(num);
            //если преобразование было успешным, значит указанная строка является цислом
            return true;
        //Если преобразование завершиблосб с ошибкой, то значит искомая строка не является числом и может содержать римские цифры
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
