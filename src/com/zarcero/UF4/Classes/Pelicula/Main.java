package com.zarcero.UF4.Classes.Pelicula;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cine cine = new Cine();
        cine.name = "Cine";
        cine.address = "Calle";
        cine.movies = new ArrayList<>();
        cine.clients = new ArrayList<>();

        cine.movies.add(new Pelicula("Pelicula 1", "Director 1", "Genero 1", 120, 18, 2020));
        cine.movies.add(new Pelicula("Pelicula 2", "Director 2", "Genero 2", 120, 18, 2020));
        cine.movies.add(new Pelicula("Pelicula 3", "Director 3", "Genero 3", 120, 18, 2020));
        cine.movies.add(new Pelicula("Pelicula 4", "Director 4", "Genero 4", 120, 18, 2020));

        cine.clients.add(new Persona("Persona 1", "Apellido 1", "Apellido 2", 18, "12345678A"));
        cine.clients.add(new Persona("Persona 2", "Apellido 1", "Apellido 2", 18, "12345678A"));
        cine.clients.add(new Persona("Persona 3", "Apellido 1", "Apellido 2", 18, "12345678A"));
        cine.clients.add(new Persona("Persona 4", "Apellido 1", "Apellido 2", 18, "12345678A"));
    }
}
