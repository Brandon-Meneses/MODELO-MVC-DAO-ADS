package org.example.controller;

import org.example.dao.ProductoDAO;
import org.example.dao.ProductoDAOImpl;
import org.example.model.Producto;

import java.util.List;

public class ProductoController {
    private ProductoDAO productoDAO;

    public ProductoController() {
        this.productoDAO = new ProductoDAOImpl();
    }

    public void addProducto(Producto producto) {
        productoDAO.create(producto);
    }

    public Producto getProducto(int id) {
        return productoDAO.read(id);
    }

    public void updateProducto(Producto producto) {
        productoDAO.update(producto);
    }

    public void deleteProducto(int id) {
        productoDAO.delete(id);
    }

    public List<Producto> getAllProductos() {
        return productoDAO.getAll();
    }
}