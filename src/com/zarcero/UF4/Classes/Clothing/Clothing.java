package com.zarcero.UF4.Classes.Clothing;

public class Clothing {
    protected String cod;
    protected double price;
    protected String size;
    protected String color;
    protected char genre;

    public Clothing(String cod, double price, String size, String color, char genre) {
        this.cod = cod;
        this.price = price;
        this.size = size;
        this.color = color;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "cod='" + cod + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", genre=" + genre +
                '}';
    }
}
