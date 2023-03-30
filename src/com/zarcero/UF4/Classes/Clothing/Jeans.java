package com.zarcero.UF4.Classes.Clothing;

public class Jeans extends Clothing {
    private String type;

    public Jeans(String cod, double price, String size, String color, char genre, String type) {
        super(cod, price, size, color, genre);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Jeans{" +
                "type='" + type + '\'' +
                ", cod='" + cod + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", genre=" + genre +
                '}';
    }
}
