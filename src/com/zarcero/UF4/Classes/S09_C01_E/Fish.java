package com.zarcero.UF4.Classes.S09_C01_E;

public class Fish extends Animal implements Pet {
    private String name;

    public Fish(String name) {
        super(0);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println("Fish plays");
    }

    public void eat() {
        System.out.println("Fish eats");
    }
}
