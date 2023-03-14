package com.zarcero.UF4.Classes.EjercicioSupermercado;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaEntrega;
    private ArrayList<ItemPedido> items;

    public Pedido(Cliente cliente, LocalDateTime fechaAlta, LocalDateTime fechaEntrega) {
        this.cliente = cliente;
        this.fechaAlta = fechaAlta;
        this.fechaEntrega = fechaEntrega;
        this.items = new ArrayList<>();
    }

    public void addItem(ItemPedido item) {
        this.items.add(item);
    }

    public void removeItem(ItemPedido item) {
        this.items.remove(item);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public ArrayList<ItemPedido> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemPedido> items) {
        this.items = items;
    }
}
