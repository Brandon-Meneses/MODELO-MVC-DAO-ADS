package org.example.controller;

import org.example.dao.UsuarioDAO;
import org.example.dao.UsuarioDAOImpl;
import org.example.model.Usuario;

import java.util.List;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAOImpl();
    }

    public void addUsuario(Usuario usuario) {
        usuarioDAO.create(usuario);
    }

    public Usuario getUsuario(int id) {
        return usuarioDAO.read(id);
    }

    public void updateUsuario(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    public void deleteUsuario(int id) {
        usuarioDAO.delete(id);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioDAO.getAll();
    }
}