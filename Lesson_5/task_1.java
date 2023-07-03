package Lesson_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("Меню:");
            System.out.println("1) Добавить контакт");
            System.out.println("2) Вывести всех");
            System.out.println("3) Выход");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите номер телефона: ");
                    String phoneNumber = scanner.nextLine();
                    ArrayList<String> phones = new ArrayList<>();
                    if (phoneBook.containsKey(name)) {
                        phones = phoneBook.get(name);
                        if (!phones.contains(phoneNumber)) {
                            phones.add(phoneNumber);
                        }
                        phoneBook.put(name, phones);
                    } else {
                        phones.add(phoneNumber);
                        phoneBook.put(name, phones);
                    }
                   
                    break;
                case 2:
                    System.out.println("Телефонная книга:");
                    List<Map.Entry<String, ArrayList<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
                    Collections.sort(sortedEntries, (a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));
                    for (Map.Entry<String, ArrayList<String>> entry : sortedEntries) {
                        System.out.println(entry.getKey() + " " + entry.getValue());
                    }
                    break;
                case 3:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }

        scanner.close();
    }

}