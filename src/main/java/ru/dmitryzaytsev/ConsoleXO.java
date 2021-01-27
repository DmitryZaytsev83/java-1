package ru.dmitryzaytsev;

import java.util.Random;
import java.util.Scanner;

public class ConsoleXO {

    static final int SIZE = 3;

    static final char DOT_PLAYER = 'X';
    static final char DOT_AI = 'O';
    static final char DOT_EMPTY = '•';

    static final int LENGTH_TO_WIN = 3;
    static int line = 0;

    static char[][] map = new char[SIZE][SIZE];
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        prepareMap();
        printMap();
        while (true) {
            playerTurn();
            printMap();
            if (checkWin(DOT_PLAYER)) {
                System.out.println("Победил игрок");
                break;
            }
            if (checkMapIsFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_AI)) {
                System.out.println("Победил AI");
                break;
            }
            if (checkMapIsFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра завершена.");
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellEmpty(x, y));
        map[x][y] = DOT_AI;
        System.out.printf("Ход ИИ: [%d, %d]\n", x + 1, y + 1);
    }

    private static void playerTurn() {
        int x, y;
        do {
            System.out.println("Укажите координаты в формате: 'строка' 'столбец'");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(x, y));
        map[x][y] = DOT_PLAYER;
    }

    private static boolean isCellEmpty(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        return map[x][y] == DOT_EMPTY;
    }

    private static boolean checkMapIsFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char dot) {
        for (int i = 0; i < SIZE; i++) {
            if (checkHorizontalLine(i, dot) || checkVerticalLine(i, dot)) return true;
        }
        if (checkDescendingDiagonal(dot) || checkAscendingDiagonal(dot)) return true;
        return false;
    }

    private static boolean checkAscendingDiagonal(char dot) {
        for (int j = 0; j < SIZE; j++) {
            if (map[SIZE - 1 - j][j] == dot) line++;
            else break;
            if (line == LENGTH_TO_WIN) return true;
        }
        line = 0;
        return false;
    }

    private static boolean checkDescendingDiagonal(char dot) {
        for (int j = 0; j < SIZE; j++) {
            if (map[j][j] == dot) line++;
            else break;
            if (line == LENGTH_TO_WIN) return true;
        }
        line = 0;
        return false;
    }

    private static boolean checkHorizontalLine(int i, char dot) {
        for (int j = 0; j < SIZE; j++) {
            if (map[i][j] == dot) line++;
            else break;
            if (line == LENGTH_TO_WIN) return true;
        }
        line = 0;
        return false;
    }

    private static boolean checkVerticalLine(int i, char dot) {
        for (int j = 0; j < SIZE; j++) {
            if (map[j][i] == dot) line++;
            else break;
            if (line == LENGTH_TO_WIN) return true;
        }
        line = 0;
        return false;
    }

    private static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void prepareMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
}
