package com.zarcero.UF4.Classes.EjercicioBiblioteca;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro();
        libro1.titulo = "El señor de los anillos";
        libro1.autor = "J.R.R. Tolkien";
        libro1.tema = "Fantasía";
        libro1.numPaginas = 1000;
        libro1.ISBN = 123456789;

        Libro libro2 = new Libro();
        libro2.titulo = "El principito";
        libro2.autor = "Antoine de Saint-Exupéry";
        libro2.tema = "Infantil";
        libro2.numPaginas = 100;
        libro2.ISBN = 987654321;

        Libro libro3 = new Libro();
        libro3.titulo = "El código Da Vinci";
        libro3.autor = "Dan Brown";
        libro3.tema = "Novela";
        libro3.numPaginas = 500;
        libro3.ISBN = 135792468;

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.catalogo.add(libro1);
        biblioteca.catalogo.add(libro2);
        biblioteca.catalogo.add(libro3);

        biblioteca.direccion = "Calle falsa 123";
    }
}
