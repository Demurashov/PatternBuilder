package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Старт программы");
        Person person = new Person.PersonBuilder()
                .setName("Петя")
                .setSurname("Васечкин")
                .setAge(40)
                .setAdress("Санкт-Петербург")
                .build();
        Person child = person.newChildBuilder()
                .setName("Вася")
                .setAge(2)
                .build();

        System.out.println("Возраст отца известен? "+person.hasAge());
        System.out.println("Отец: " + person.toString());
        System.out.println("Ребенок: " + child.toString());
        child.happyBirthday();
        System.out.println("Ребенок: " + child.toString());
        try {
            new Person.PersonBuilder().build();
        } catch (IllegalStateException exception) {
            exception.printStackTrace();
        }
        try {
            new Person.PersonBuilder().setAge(-10).build();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }
}