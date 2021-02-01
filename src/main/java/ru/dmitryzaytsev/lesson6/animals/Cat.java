package ru.dmitryzaytsev.lesson6.animals;

public class Cat extends Animal {
    static int count = 0;

    public Cat(String name) {
        super(name);
        this.maxRunLength = 200;
        this.maxSwimLength = 0;
        count++;
    }

    @Override
    public void swim(int length) {
        System.out.printf("%s не поплыл, потому что забил%n", name);
    }

    public static void printCount() {
        System.out.printf("Количество котов: %d%n", count);
    }
}
