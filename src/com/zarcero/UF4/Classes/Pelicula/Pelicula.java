package com.zarcero.UF4.Classes.Pelicula;

public class Pelicula {
    String title;
    String director;
    String genre;
    int duration;
    int minimumAge;
    int releaseDate;

    public Pelicula() {
        this.title = "";
        this.director = "";
        this.genre = "";
        this.duration = 0;
        this.minimumAge = 0;
        this.releaseDate = 0;
    }

    public Pelicula(String title, String director, String genre, int duration, int minimumAge, int releaseDate) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.duration = duration;
        this.minimumAge = minimumAge;
        this.releaseDate = releaseDate;
    }
}
