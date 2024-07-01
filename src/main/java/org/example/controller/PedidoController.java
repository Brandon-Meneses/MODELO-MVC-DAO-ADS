package org.example.controller;

import org.example.dao.PedidoDAO;
import org.example.dao.PedidoDAOImpl;
import org.example.model.Pedido;

import java.util.List;

public class PedidoController {
    private PedidoDAO pedidoDAO;

    public PedidoController() {
        this.pedidoDAO = new PedidoDAOImpl();
    }

    public void addPedido(Pedido pedido) {
        pedidoDAO.create(pedido);
    }

    public Pedido getPedido(int id) {
        return pedidoDAO.read(id);
    }

    public void updatePedido(Pedido pedido) {
        pedidoDAO.update(pedido);
    }

    public void deletePedido(int id) {
        pedidoDAO.delete(id);
    }

    public List<Pedido> getAllPedidos() {
        return pedidoDAO.getAll();
    }
}
