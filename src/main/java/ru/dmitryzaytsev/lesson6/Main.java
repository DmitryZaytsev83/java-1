package ru.dmitryzaytsev.lesson6;

import ru.dmitryzaytsev.lesson6.animals.Animal;
import ru.dmitryzaytsev.lesson6.animals.Cat;
import ru.dmitryzaytsev.lesson6.animals.Dog;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat("Барсик");
        cat.swim(1);
        cat.run(300);
        Animal cat1 = new Cat("Мурзик");
        cat1.swim(1);
        cat1.run(20);
        Animal dog = new Dog("Бобик");
        dog.swim(100);
        dog.run(700);
        Animal dog1 = new Dog("Шарик");
        dog1.swim(10);
        dog1.run(400);
        Animal dog2 = new Dog("Полкан");
        dog2.swim(5);
        dog2.run(300);
        Cat.getCount();
        Dog.getCount();
        Animal.getCount();
    }
}
