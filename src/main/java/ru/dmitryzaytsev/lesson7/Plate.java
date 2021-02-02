package ru.dmitryzaytsev.lesson7;

public class Plate {
    private static final int maxFood = 100;

    private int food;

    public Plate(int food) {
        this.food = Math.min(food, maxFood);
    }

    public void addFood() {
        food = maxFood;
    }

    public boolean decreaseFood(int amount) {
        int result = food - amount;
        if (result >= 0) food -= amount;
        return result >= 0;
    }

    public void info() {
        System.out.printf("Еды в тарелке: %d%n", food);
    }
}
