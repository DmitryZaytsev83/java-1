package ru.dmitryzaytsev.lesson2;

import java.util.Arrays;

import static java.lang.Math.abs;

public class Homework2 {
    public static void main(String[] args) {
        // Assignment 6**
        int[] oneDimensionalArray = {1, 2, 3, 4, 1, 1, 1, 2, 3, 2};
        System.out.println(Arrays.toString(oneDimensionalArray));
        System.out.println(checkBalance(oneDimensionalArray));

        // Assignment 7****
        int n = -10;
        shiftElements(oneDimensionalArray, n);
        System.out.println(Arrays.toString(oneDimensionalArray));
    }

    private static void shiftElements(int[] arr, int n) {
        if (abs(n) >= arr.length) {
            n = n % arr.length;
        }
        for (int i = 0; i < abs(n); i++) {
            if (n > 0) {
                shiftRight(arr);
            } else {
                shiftLeft(arr);
            }
        }

    }

    private static void shiftLeft(int[] arr) {
        int lastElement = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = lastElement;
    }

    private static void shiftRight(int[] arr) {
        int firstElement = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = firstElement;
    }

    private static boolean checkBalance(int[] arr) {
        int leftPartSum = 0;
        for (int i = 0; i < arr.length; i++) {
            leftPartSum += arr[i];
            int rightPartSum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                rightPartSum += arr[j];
            }
            if (leftPartSum == rightPartSum) {
                System.out.println("balance found between elements of array at indexes - " + i + " and " + (i + 1));
                return true;
            }
        }
        return false;
    }
}
