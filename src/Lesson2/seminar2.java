package Lesson2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

public class seminar2 {
    // Задание 1 (тайминг 10 минут)
    // 1.Необходимо написать один из простых алгоритмов сортировки, имеющий
    // сложность O(n2).
    // 2.Можно выбрать из пузырьковой сортировки, сортировки вставками и сортировки
    // выбором.
    // 3.Следует обратить внимание на сложность данных алгоритмов и указать признаки
    // квадратичной сложности для каждого из них.

    // Пузырьковая сортировка
    public static int[] bubleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else {

                }

            }
        }
        return array;
    }

    // Задание 2 (тайминг 20 минут)
    // 1.Написать алгоритм быстрой сортировки (quicksort).
    public static void quickSort(int[] array, int start, int end) {
        int pivot = array[((start + end) / 2)];
        int leftPosotion = start;
        int rightPosotion = end;
        do {
            while (array[leftPosotion] < pivot) {
                leftPosotion++;
            }
            while (array[rightPosotion] > pivot) {
                rightPosotion--;
            }
            if (leftPosotion <= rightPosotion) {
                if (leftPosotion < rightPosotion) {
                    int temp = array[leftPosotion];
                    array[leftPosotion] = array[rightPosotion];
                    array[rightPosotion] = temp;
                }
                leftPosotion++;
                rightPosotion--;
            }
        } while (leftPosotion <= rightPosotion);
        if (leftPosotion < end) {
            quickSort(array, leftPosotion, end);
        }
        if (rightPosotion > start) {
            quickSort(array, start, rightPosotion);
        }
    }

    public static int binarSearch(int[] array, int min, int max, int value) {
        if (max < min) {
            return -1;
        }
        int midPoint = array[(max - min) / 2 + min];
        if (midPoint < value) {
            return binarSearch(array, (max - min) / 2 + min + 1, max, value);
        } else if (midPoint < value) {
            return binarSearch(array, min, (max - min) / 2 + min - 1, value);
        } else {
            return (max - min) / 2 + min;
        }
    }

    public static void main(String[] args) {
        // Задание 3 (тайминг 15 минут)
        // 1.Пишем тесты для сравнения производительности сортировки больших массивов.
        // 2.Для наглядного результата стоит сравнивать массивы до 100 000 элементов.
        // При таком подходе будет явно видно, какая из сортировок окажется быстрее.
        // for (int i = 1000; i <= 100000; i = i + 1000) {
        // int[] array = new int[i];
        // for (int j = 0; j < array.length; j++) {
        // array[j] = (int) (Math.random() * 1000);
        // }
        // int[] array2 = array;
        // Date startDate = new Date();
        // bubleSort(array);
        // Date endDate = new Date();
        // long bubbleSortDuration = endDate.getTime() - startDate.getTime();

        // startDate = new Date();
        // quickSort(array2, 0, array2.length - 1);
        // endDate = new Date();
        // long quickSortDuration = endDate.getTime() - startDate.getTime();
        // System.out.printf("i: %s, bubble sort duration: %s, quick sort duration:
        // %s%n", i, bubbleSortDuration,
        // quickSortDuration);

        // }
        int[] array = { 4, 5, 2, 11, 26, 17 };
        quickSort(array, 0, array.length - 1);
        System.out.println(binarSearch(array, 0, array.length - 1, 26));
    }
}

// Задание 4 (тайминг 15 минут)
// 1.После успешной сортировки массива на нем можно использовать бинарный
// поиск. Необходимо реализовать алгоритм бинарного поиска по элементам.
// 2.Стоит акцентировать внимание, что т.к. алгоритм использует подход
// «разделяй и властвуй», его удобно писать с помощью рекурсии.
// 3.Так что стоит акцентировать внимание на алгоритмическую сложность данного
// алгоритма, что его выполнение многократно быстрее простого перебора на
// больших массивах
