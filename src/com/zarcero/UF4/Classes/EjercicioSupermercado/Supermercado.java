package com.zarcero.UF4.Classes.EjercicioSupermercado;

import java.util.ArrayList;

public class Supermercado {
    private String nombre;
    private String direccion;
    private String email;
    private String telefono;
    private ArrayList<Producto> productos;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Cliente> clientes;

    public Supermercado(String nombre,
                        String direccion,
                        String email,
                        String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.productos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void addProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void removeProducto(Producto producto) {
        this.productos.remove(producto);
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void removePedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void removeCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}
