package ru.dmitryzaytsev.lesson6.animals;

public class Dog extends Animal {
    static int count = 0;

    public Dog(String name) {
        super(name);
        this.maxRunLength = 500;
        this.maxSwimLength = 10;
        count++;
    }

    @Override
    public void swim(int length) {
        if (length <= maxSwimLength) {
            System.out.printf("%s проплыл %d метров%n", name, length);
        } else {
            System.out.printf("%s проплыл %d метров и утонул, не доплыв %d метров%n", name, maxSwimLength, length - maxSwimLength);
        }
    }

    public static void printCount() {
        System.out.printf("Количество собак: %d%n", count);
    }
}
