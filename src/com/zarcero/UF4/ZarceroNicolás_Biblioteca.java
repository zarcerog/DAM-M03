package com.zarcero.UF4;

import java.util.ArrayList;
import java.util.Scanner;

public class ZarceroNicolás_Biblioteca {
    final static String MENU = "Escoge una opción\n\t[1] Consultar libros\n\t[2] Consulta libro\n\t[3] Añadir libro\n\t[4] Eliminar libro\n\t[5] Modificar un libro\n\t[6] Eliminar todos los libros\n\t[7] Salir";

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        ArrayList<String> libros;
        libros = bibliotecaInit();

        int option = 0;

        do {
            System.out.println("------ Biblioteca ------");
            System.out.println(MENU);
            option = isInt("> ", 1, 7);

            switch (option) {
                case 1:
                    imprimirBiblioteca(libros);
                    break;
                case 2:
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Introduce el nombre del libro: ");
                    String libro = scanner.nextLine();
                    boolean existe = consultaLibros(libros, libro);
                    if (existe) {
                        System.out.println("El libro existe");
                    } else {
                        System.out.println("El libro no existe");
                    }
                    break;
                case 3:
                    anadirLibro(libros);
                    break;
                case 4:
                    eliminarLibro(libros);
                    break;
                case 5:
                    modificarLibro(libros);
                    break;
                case 6:
                    libros = reiniciarBiblioteca(libros);
                    break;
                case 7:
                    libros = reiniciarBiblioteca(libros);
                    System.out.println("Saliendo...");
                    break;
            }
        } while (option != 7);
    }

    /**
     * Método que inicializa la biblioteca
     * @return ArrayList<String> con los libros
     */
    private static ArrayList<String> bibliotecaInit() {
        ArrayList<String> biblioteca = new ArrayList<>();
        biblioteca.add("Tirant Lo Blanc");
        biblioteca.add("Solitud");
        biblioteca.add("El Quixot");
        biblioteca.add("Sapiens");
        biblioteca.add("Teo va a l'escola");
        biblioteca.add("Jumanji");
        biblioteca.add("Spiderman: No way home");
        biblioteca.add("Harry Potter i el calze de foc");

        return biblioteca;
    }

    /**
     * Método que reinicia la biblioteca
     * @param libros ArrayList<String> con los libros
     * @return ArrayList<String> con los libros
     */
    private static ArrayList<String> reiniciarBiblioteca(ArrayList<String> libros) {
        libros.clear();
        return libros;
    }

    /**
     * Método que imprime la biblioteca
     * @param libros ArrayList<String> con los libros
     */
    private static void imprimirBiblioteca(ArrayList<String> libros) {
        for (String libro : libros) {
            System.out.println(libro);
        }
    }

    /**
     * Método que añade un libro a la biblioteca
     * @param libros ArrayList<String> con los libros
     * @return ArrayList<String> con los libros
     */
    private static boolean consultaLibros(ArrayList<String> libros, String libro) {
        return libros.contains(libro);
    }

    /**
     * Método que añade un libro a la biblioteca
     * @param libros ArrayList<String> con los libros
     * @return ArrayList<String> con los libros
     */
    private static void anadirLibro(ArrayList<String> libros) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del libro: ");
        String libro = scanner.nextLine();
        libros.add(libro);
        System.out.println("Libro añadido");
    }

    /**
     * Método que elimina un libro de la biblioteca
     * @param libros ArrayList<String> con los libros
     */
    private static void eliminarLibro(ArrayList<String> libros) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del libro a eliminar: ");
        String libro = scanner.nextLine();

        if (consultaLibros(libros, libro)) {
            libros.remove(libro);
            System.out.println("Libro eliminado");
        } else {
            System.out.println("El libro no existe");
        }
    }

    /**
     * Método que modifica un libro de la biblioteca
     * @param libros ArrayList<String> con los libros
     */
    private static void modificarLibro(ArrayList<String> libros) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del libro a modificar: ");
        String libro = scanner.nextLine();

        if (consultaLibros(libros, libro)) {
            System.out.print("Introduce el nuevo nombre del libro: ");
            String nuevoLibro = scanner.nextLine();
            libros.set(libros.indexOf(libro), nuevoLibro);
            System.out.println("Libro modificado");
        } else {
            System.out.println("El libro no existe");
        }
    }

    /**
     * Método que comprueba si un número es entero
     * @param message Mensaje que se muestra al usuario
     * @param min Número mínimo
     * @param max Número máximo
     * @return Número entero
     */
    private static int isInt(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean isInt;

        do {
            System.out.print(message);

            isInt = scanner.hasNextInt();

            if (isInt) {
                num = scanner.nextInt();
                if (num < min || num > max) {
                    System.out.println("El número debe estar entre " + min + " y " + max);
                    isInt = false;
                }
            } else {
                System.out.println("El valor introducido no es un número");
                scanner.next();
            }
        } while (!isInt);

        return num;
    }
}
