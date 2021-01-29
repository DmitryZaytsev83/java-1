package ru.dmitryzaytsev.lesson6.animals;

public abstract class Animal {
    static int count = 0;

    String name;
    int maxRunLength;
    int maxSwimLength;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public abstract void swim(int length);

    public void run(int length) {
        if (length <= maxRunLength) {
            System.out.printf("%s пробежал %d метров%n", name, length);
        } else {
            System.out.printf("%s пробежал %d метров и сдох, не добежав %d метров%n", name, maxRunLength, length - maxRunLength);
        }
    }

    public static void printCount() {
        System.out.printf("Количество животных: %d%n", count);
    }
}
