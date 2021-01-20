package ru.dmitryzaytsev;

import java.util.Random;
import java.util.Scanner;

public class Homework3 {
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        String hiddenWord = words[(new Random()).nextInt(words.length)];
        Scanner sc = new Scanner(System.in);
        String ans;
        do {
            System.out.println("Try to guess the word!");
            ans = sc.nextLine();
            getGuessedSymbols(ans, hiddenWord);
        } while (!ans.equals(hiddenWord));
        System.out.println("Congratulations!");
    }

    private static void getGuessedSymbols(String answer, String hiddenWord) {
        char[] word = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        int minLength = answer.length() <= hiddenWord.length() ? answer.length() : hiddenWord.length();
        for (int i = 0; i < minLength; i++) {
            word[i] = answer.charAt(i) == hiddenWord.charAt(i) ? answer.charAt(i) : '#';
        }
        for (char c : word) {
            System.out.print(c);
        }
        System.out.println();
    }
}
