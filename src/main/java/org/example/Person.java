package org.example;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String sity;
    public Person(String name,String surname){
        this.name=name;
        this.surname=surname;
    }
    public Person(String name,String surname,int age){
        this.name=name;
        this.surname=surname;
        this.age=age;
    }
    private Person(PersonBuilder personBuilder) {
        name = personBuilder.name;
        surname = personBuilder.surname;
        age = personBuilder.age;
        sity = personBuilder.sity;

    }
    boolean hasAge(){
        if (age>0){
            return true;
        }
        return false;
    }
    boolean hasAdress(){
        if (sity!=null){
            return true;
        }
        return false;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAdress() {
        return sity;
    }

    public void setAdress(String adress) {
        this.sity = adress;
    }

    public void happyBirthday(){
        if (age>0) {
            age++;
        }
    }
    public PersonBuilder newChildBuilder(){
        PersonBuilder child=new Person.PersonBuilder()
                .setSurname(this.surname)
                .setAdress(this.sity);
        return child;
    }
    @Override
    public String toString() {
      return  "Имя: "+name+", Фамилия: "+surname+", Возраст: "+age+", Город: "+sity;
    }

    public static class PersonBuilder {
        private String name;
        private String surname;
        private int age=0;
        private String sity;

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder setAge(int age) {
            if (age > 0) {
                this.age = age;
            } else {
                throw new IllegalArgumentException("Нельзя ввести возраст  меньше чем 0, или  0");
            }
            return this;
        }

        public PersonBuilder setAdress(String sity) {
            this.sity=sity;
            return this;
        }

        public Person build() {
            if (this.name == null ||this.surname == null) {
                throw new IllegalStateException("Необходимо ввести имя и фамилию!!!");
            }
            return new Person(this);
        }
    }
}
