package com.zarcero.UF4.Classes.Persona;

import java.time.LocalDate;
import java.util.ArrayList;

public class Persona {
    private String dni;
    private String name;
    private String surname1;
    private String surname2;
    private float height;
    private float weight;
    private LocalDate birthdate;
    private boolean isBlind;
    private Disabilities disabilities;
    private ArrayList<Persona> friends;

    public Persona(String dni, String name, String surname1, String surname2, float height, float weight, LocalDate birthdate) {
        this.dni = dni;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.height = height;
        this.weight = weight;
        this.birthdate = birthdate;
        this.isBlind = false;
        this.disabilities = Disabilities.VISIBILIDAD_COMPLETA;
        this.friends = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isBlind() {
        return isBlind;
    }

    public void setBlind(boolean blind) {
        isBlind = blind;
    }

    public Disabilities getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(Disabilities disabilities) {
        this.disabilities = disabilities;
    }

    public ArrayList<Persona> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<Persona> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname1='" + surname1 + '\'' +
                ", surname2='" + surname2 + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", birthdate=" + birthdate +
                ", isBlind=" + isBlind +
                ", disabilities=" + disabilities +
                ", friends=" + friends +
                '}';
    }
}
