package com.zarcero.UF4.Classes.AC03;

public class ZarceroNicolás_AC03 {
    public static void main(String[] args) {
        Dog dog = new Dog("Firulais", 5, Sex.MACHO);
        System.out.println(dog);
        dog.makeSound();

        Cat cat = new Cat("Garfield", 3, Sex.MACHO);
        System.out.println(cat);
        cat.makeSound();
    }
}

interface canMakeSound {
    abstract void makeSound();
}

abstract class Animal implements canMakeSound {
    private final String name;
    private final int age;
    private final Sex sex;

    public Animal(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    @Override
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    public Dog(String name, int age, Sex sex) {
        super(name, age, sex);
    }

    @Override
    public void makeSound() {
        System.out.println("Guau");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                "}";
    }
}

class Cat extends Animal {
    public Cat(String name, int age, Sex sex) {
        super(name, age, sex);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
        "}";
    }

    @Override
    public void makeSound() {
        System.out.println("Miau");
    }
}

enum Sex {
    MACHO, HEMBRA
}