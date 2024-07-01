package org.example.controller;

import org.example.dao.ClienteDAO;
import org.example.dao.ClienteDAOImpl;
import org.example.model.Cliente;

import java.util.List;

public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAOImpl();
    }

    public void addCliente(Cliente cliente) {
        clienteDAO.create(cliente);
    }

    public Cliente getCliente(int id) {
        return clienteDAO.read(id);
    }

    public void updateCliente(Cliente cliente) {
        clienteDAO.update(cliente);
    }

    public void deleteCliente(int id) {
        clienteDAO.delete(id);
    }

    public List<Cliente> getAllClientes() {
        return clienteDAO.getAll();
    }
}
