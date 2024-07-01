package org.example.controller;

import org.example.dao.VentaDAO;
import org.example.dao.VentaDAOImpl;
import org.example.model.Venta;

import java.util.List;

public class VentaController {
    private VentaDAO ventaDAO;

    public VentaController() {
        this.ventaDAO = new VentaDAOImpl();
    }

    public void addVenta(Venta venta) {
        ventaDAO.create(venta);
    }

    public Venta getVenta(int id) {
        return ventaDAO.read(id);
    }

    public void updateVenta(Venta venta) {
        ventaDAO.update(venta);
    }

    public void deleteVenta(int id) {
        ventaDAO.delete(id);
    }

    public List<Venta> getAllVentas() {
        return ventaDAO.getAll();
    }
}