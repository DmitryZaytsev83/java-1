package ru.geekbrains.lesson1;

public class FirstHomework {
    public static void main(String[] args) {
        System.out.println("Java rules the Internet!");
        printAssignment2();
        printAssignment3();
        printAssignment4();
        printAssignment5and6();
        printAssignment7();
        printAssignment8();
    }

    public static void printAssignment2() {
        byte byteVar = Byte.MAX_VALUE;
        short shortVar = Short.MAX_VALUE;
        int intVar = Integer.MAX_VALUE;
        long longVar = Long.MAX_VALUE;
        System.out.println("Byte.MAX_VALUE: " + byteVar);
        System.out.println("Short.MAX_VALUE: " + shortVar);
        System.out.println("Integer.MAX_VALUE: " + intVar);
        System.out.println("Long.MAX_VALUE: " + longVar);
    }

    public static void printAssignment3() {
        float a = 2f, b = 3f, c = 4f, d = 5f;
        System.out.println(calculate(a, b, c, d));
    }

    public static float calculate(float a, float b, float c, float d) {
        return (d == 0) ? 0 : a * (b + (c / d));
    }

    public static void printAssignment4() {
        int a = 16, b = 4;
        System.out.println(checkSumInRange10_20Inclusive(a, b) ? a + " + " + b + " in range [10, 20]" : a + " + " + b + " not in range [10, 20]");
    }

    public static boolean checkSumInRange10_20Inclusive(int a, int b) {
        return (a + b >= 10) && (a + b <= 20);
    }

    public static void printAssignment5and6() {
        int a = 0;
        printPositiveNegative(a);
    }

    public static void printPositiveNegative(int a) {
        System.out.println(isNegative(a) ? a + " - negative number" : a + " - positive number");
    }

    private static boolean isNegative(int a) {
        return a < 0;
    }

    public static void printAssignment7() {
        String name = "Dmitry";
        printGreeting(name);
    }

    public static void printGreeting(String name) {
        System.out.println("Hello, " + name + '!');
    }

    public static void printAssignment8() {
        int year = 1500;
        printIsLeapYear(year);
    }

    public static void printIsLeapYear(int year) {
        System.out.println(isLeapYear(year) ? year + " - leap year" : year + " - common year");
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
