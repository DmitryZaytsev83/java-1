package ru.dmitryzaytsev.lesson7;

public class FeedCats {
    public static void main(String[] args) {
        Cat[] cats = new Cat[]{
                new Cat("Барсик", 7),
                new Cat("Мурзик", 10),
                new Cat("Маркиз", 15),
                new Cat("Васька", 9)
        };
        Plate plate = new Plate(35);
        plate.info();
        for (Cat cat : cats) {
            cat.info();
        }
        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }
        plate.info();
        plate.addFood();
        plate.info();
        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }
        plate.info();
    }
}
