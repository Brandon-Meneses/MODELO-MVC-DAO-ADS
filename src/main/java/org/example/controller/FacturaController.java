package org.example.controller;

import org.example.dao.FacturaDAO;
import org.example.dao.FacturaDAOImpl;
import org.example.model.Factura;

import java.util.List;

public class FacturaController {
    private FacturaDAO facturaDAO;

    public FacturaController() {
        this.facturaDAO = new FacturaDAOImpl();
    }

    public void addFactura(Factura factura) {
        facturaDAO.create(factura);
    }

    public Factura getFactura(int id) {
        return facturaDAO.read(id);
    }

    public void updateFactura(Factura factura) {
        facturaDAO.update(factura);
    }

    public void deleteFactura(int id) {
        facturaDAO.delete(id);
    }

    public List<Factura> getAllFacturas() {
        return facturaDAO.getAll();
    }
}
