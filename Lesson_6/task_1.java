package Lesson_6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class task_1 {
    public static void main(String[] args) {
        Set<NoteBook> notebooks = new HashSet<>();
        notebooks.add(new NoteBook("Notebook 1", 8, 256, "Windows", "Silver"));
        notebooks.add(new NoteBook("Notebook 2", 16, 512, "MacOS", "Space Gray"));
        notebooks.add(new NoteBook("Notebook 3", 8, 512, "Windows", "Black"));
        notebooks.add(new NoteBook("Notebook 4", 16, 512, "Windows", "Silver"));
        notebooks.add(new NoteBook("Notebook 5", 8, 1, "Linux", "Black"));

        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int filterCriteria;
        String filterValue;

        while (true) {
            filterCriteria = scanner.nextInt();
            scanner.nextLine();

            if (filterCriteria == 0) {
                break;
            }

            System.out.println("Введите минимальное значение для выбранного критерия:");
            filterValue = scanner.nextLine();

            filters.put(filterCriteria, filterValue);

            System.out.println("Введите следующий критерий или введите 0 для завершения:");
        }
        scanner.close();
        Set<NoteBook> filteredNotebooks = filterNotebooks(notebooks, filters);
        if (filteredNotebooks.isEmpty()) {
            System.out.println("Ноутбуки, удовлетворяющие условиям фильтрации, не найдены.");
        } else {
            System.out.println("Подходящие ноутбуки:");
            for (NoteBook notebook : filteredNotebooks) {
                System.out.println(notebook.getModel());
            }
        }
    }

    public static Set<NoteBook> filterNotebooks(Set<NoteBook> notebooks, Map<Integer, String> filters) {
        Set<NoteBook> filteredNotebooks = new HashSet<>();
        for (NoteBook notebook : notebooks) {
            boolean matchesFilter = true;
            for (Map.Entry<Integer, String> entry : filters.entrySet()) {
                int filterCriteria = entry.getKey();
                String filterValue = entry.getValue();
                switch (filterCriteria) {
                    case 1:
                        int ram = notebook.getRam();
                        int minRam = Integer.parseInt(filterValue);
                        if (ram < minRam) {
                            matchesFilter = false;
                        }
                        break;

                    case 2:
                        int storage = notebook.getStorage();
                        int minStorage = Integer.parseInt(filterValue);
                        if (storage < minStorage) {
                            matchesFilter = false;
                        }
                        break;

                    case 3:
                        String os = notebook.getOs();
                        if (!os.equalsIgnoreCase(filterValue)) {
                            matchesFilter = false;
                        }
                        break;

                    case 4:
                        String color = notebook.getColor();
                        if (!color.equalsIgnoreCase(filterValue)) {
                            matchesFilter = false;
                        }
                        break;

                    default:
                        System.out.println("Некорректный критерий фильтрации: " + filterCriteria);
                        return filteredNotebooks;
                }

                if (!matchesFilter) {
                    break;
                }
            }

            if (matchesFilter) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }
}
