package ru.dmitryzaytsev.lesson5;

public class PersonManager {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("Ivanov Ivan", "manager", "ivanoff@mail.ru", "89991234567", 40000, 41);
        persons[1] = new Person("Vasechkin Vasya", "manager", "vasechkin@mail.ru", "89991236767", 30000, 27);
        persons[2] = new Person("Petrov Petr", "clean manager", "petrov@mail.ru", "89991234545", 60000, 50);
        persons[3] = new Person("Dmitriev Dmitry", "ceo", "dmitriev@mail.ru", "89991234444", 25000, 64);
        persons[4] = new Person("Nikolaev Nikolay", "programmer", "nikolaev@mail.ru", "8999123333", 50000, 35);
        for (Person person : persons) {
            if (person.getAge() > 40) {
                person.info();
            }
        }
    }
}
