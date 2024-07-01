package org.example.dao;

import org.example.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {

    @Override
    protected Usuario mapResultSetToEntity(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("IDUsuario"));
        usuario.setNombre(rs.getString("Nombre"));
        usuario.setCorreo(rs.getString("Correo"));
        usuario.setContrasena(rs.getString("Contrasena"));
        usuario.setRol(rs.getString("Rol"));
        return usuario;
    }

    @Override
    protected void setPreparedStatementParameters(PreparedStatement stmt, Usuario usuario) throws SQLException {
        stmt.setInt(1, usuario.getIdUsuario());
        stmt.setString(2, usuario.getNombre());
        stmt.setString(3, usuario.getCorreo());
        stmt.setString(4, usuario.getContrasena());
        stmt.setString(5, usuario.getRol());
    }
}
