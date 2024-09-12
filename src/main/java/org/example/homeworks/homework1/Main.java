package org.example.homeworks.homework1;

import org.example.homeworks.homework1.json.JsonConverter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.example.homeworks.homework1.ConstantsTypes.*;

/*
1 Создайте класс с 10 методами и 4 приватными полями.
Геттеры и сеттеры добавлять не нужно. Создайте объект Вашего класса.
Выведите в консоль информацию об объекте.

Затем пользователь вводит имя поля или метода.
Программа определяет, имя какого члена класса было введено.
Если введено имя метода, то этот метод немедленно вызывается.
Если введено имя поля, то программа запрашивает у пользователя новое значение и устанавливает его новым значением этого поля.
 */
public class Main {
    public static void main(String[] args) {

        Person person = new Person("Ivan", "Ivanov", 35, false, new Cat("Barsik", 5));
        System.out.println(person);

        // Получение всех методов
        Class<?> cls = Person.class;
        List<Method> methodsList = List.of(cls.getDeclaredMethods());
        List<String> actualMethodsList = methodsList.stream().map(m -> m.getName()).toList();
        System.out.println("Methods:" + actualMethodsList);

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("\nEnter field or method name or 'end' to finish: ");
            input = scanner.nextLine();

            //Проверяем, если существует такое поле
            try {
                Field changeField = person.getClass().getDeclaredField(input);
                System.out.println("Field '" + input + "' exists. Set new value ");

                // Получение нового значения поля
                String newValue = scanner.nextLine();

                // Установка значения поля

                changeField.setAccessible(true); // делаем поле неприватным

                //устанавливаем новое значение согласно введенным параметрам и типу данных
                try {
                    String fieldType = changeField.getType().getSimpleName();
                    switch (fieldType) {
                        case STRING_TYPE:
                            changeField.set(person, newValue);
                            break;
                        case INTEGER_TYPE, INT_TYPE:
                            changeField.set(person, Integer.parseInt(newValue));
                            break;
                        case BOOLEAN_TYPE, BOOL_TYPE:
                            changeField.set(person, Boolean.parseBoolean(newValue));
                            break;
                        case DOUBLE_TYPE, DOUB_TYPE:
                            changeField.set(person, Double.parseDouble(newValue));
                            break;
                        default:
                            System.out.println("Value is not correct");
                    }

                    changeField.setAccessible(false); // делаем поле приватным
                    System.out.println("New person: " + person);

                } catch (IllegalAccessException e) {
                    System.out.println("Cannot change a value of field '" + changeField.getName() + "'");
                }
            } catch (NoSuchFieldException e) {
                try {
                    Method runMethod = person.getClass().getDeclaredMethod(input);

                    if (runMethod.getReturnType().toString().equals("void"))
                        runMethod.invoke(person);
                    else System.out.println(runMethod.invoke(person));

                } catch (NoSuchMethodException en) {
                    System.out.println("Fields or methods with name '" + input + "' does not exist");
                } catch (InvocationTargetException ex) {
                    throw new RuntimeException(ex);
                } catch (IllegalAccessException exc) {
                    throw new RuntimeException(exc);
                }
            }
        } while (!input.equals("end"));


        JsonConverter jc = new JsonConverter();
        System.out.println("\nJSON of " + person.getClass().getName());
        System.out.println(JsonConverter.toJson(person));


    }

    private static List<String> getFieldNames(Field[] fields) {
        return Arrays.stream(fields).map(Field::getName).toList();
    }

    public static List<Field> getAllFields(Class<?> type) {
        List<Field> fields = Arrays.stream(type.getDeclaredFields()).collect(Collectors.toList());

        if (type.getSuperclass() != null) {
            fields.addAll(getAllFields(type.getSuperclass())); // получить предка данного типа
        }
        return fields;
    }

//public static boolean checkFields(Field[] fields, String name){}
}