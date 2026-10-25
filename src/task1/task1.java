package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Napisać program, który z pliku tab.txt (należy go uprzednio stworzyć) wczytuje do kolekcji
 * liczby całkowite, które są rozdzielone dowolnymi białymi znakami. Wśród zapisanych war-
 * tości należy znaleźć wartość maksymalną oraz wszystkie indeksy kolekcji gdzie taka wartość
 * występuje.
 * Program powinien wypisywać na konsoli:
 * • w pierwszym wierszu - wszystkie liczby, rozdzielone spacjami
 * • w drugim wierszu - wartość maksymalną,
 * • w trzecim wierszu - indeksy pod którymi w kolekcji znajduje się wartość maksymalna
 */
public class task1 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        File file = new File("tab.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku tab.txt! Upewnij się, że plik znajduje się w głównym katalogu projektu.");
            return;
        }

        if (numbers.isEmpty()) {
            System.out.println("Plik jest pusty lub nie zawiera liczb całkowitych.");
            return;
        }

        int maxValue = Collections.max(numbers);

        List<Integer> maxIndices = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(maxValue)) {
                maxIndices.add(i);
            }
        }

        String numbersOutput = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(numbersOutput);

        System.out.println(maxValue);

        String indicesOutput = maxIndices.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(indicesOutput);
    }
}

