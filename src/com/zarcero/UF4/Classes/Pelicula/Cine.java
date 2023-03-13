package com.zarcero.UF4.Classes.Pelicula;

import java.util.ArrayList;

public class Cine {
    String name;
    String address;
    ArrayList<Pelicula> movies;
    ArrayList<Persona> clients;

    public Cine() {
        this.name = "";
        this.address = "";
        this.movies = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public Cine(String name, String address, ArrayList<Pelicula> movies, ArrayList<Persona> clients) {
        this.name = name;
        this.address = address;
        this.movies = movies;
        this.clients = clients;
    }
}
