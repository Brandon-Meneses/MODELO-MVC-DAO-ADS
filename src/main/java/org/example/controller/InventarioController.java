package org.example.controller;

import org.example.dao.InventarioDAO;
import org.example.dao.InventarioDAOImpl;
import org.example.model.Inventario;

import java.util.List;

public class InventarioController {
    private InventarioDAO inventarioDAO;

    public InventarioController() {
        this.inventarioDAO = new InventarioDAOImpl();
    }

    public void addInventario(Inventario inventario) {
        inventarioDAO.create(inventario);
    }

    public Inventario getInventario(int id) {
        return inventarioDAO.read(id);
    }

    public void updateInventario(Inventario inventario) {
        inventarioDAO.update(inventario);
    }

    public void deleteInventario(int id) {
        inventarioDAO.delete(id);
    }

    public List<Inventario> getAllInventarios() {
        return inventarioDAO.getAll();
    }
}