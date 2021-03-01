package ru.dmitryzaytsev.lesson8;

import java.util.Random;

public class Game {
    private int number;
    private int attempts = 0;
    private boolean userWin;
    private boolean endGame;

    public Game() {
        init();
    }

    private void init() {
        attempts = 3;
        userWin = false;
        endGame = false;
        this.number = new Random().nextInt(10) + 1;
        info();
    }

    public int getAttempts() {
        return attempts;
    }

    public int checkNumber(int num) {
        attempts--;
        int res = Integer.compare(num, number);
        if (attempts == 0) endGame = true;
        if (res == 0) userWin = true;
        return res;
    }

    private void info() {
        System.out.println(number);
    }

    public void beginNew() {
        init();
    }

    public boolean isUserWin() {
        return userWin;
    }

    public boolean isEndGame() {
        return endGame;
    }
}
