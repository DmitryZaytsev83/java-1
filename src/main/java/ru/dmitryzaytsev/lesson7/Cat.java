package ru.dmitryzaytsev.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry;

    public Cat() {
        name = "Barsik";
        appetite = 1;
        hungry = true;
    }

    public Cat(String name, int appetite) {
        this();
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (hungry) hungry = !plate.decreaseFood(appetite);
    }

    public void info() {
        System.out.printf("%s голоден: %s%n", name, hungry ? "Да" : "Нет");
    }
}
