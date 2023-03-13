package com.zarcero.UF4.Classes.Pelicula;

public class Persona {
    String name;
    String surname1;
    String surname2;
    int age;
    String DNI;

    public Persona() {
        this.name = "";
        this.surname1 = "";
        this.surname2 = "";
        this.age = 0;
        this.DNI = "";
    }

    public Persona(String name, String surname1, String surname2, int age, String DNI) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.age = age;
        this.DNI = DNI;
    }
}
