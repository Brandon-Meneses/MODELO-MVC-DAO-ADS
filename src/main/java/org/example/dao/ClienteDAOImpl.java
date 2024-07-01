package org.example.dao;

import org.example.model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente> implements ClienteDAO {

    @Override
    protected Cliente mapResultSetToEntity(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getInt("IDCliente"));
        cliente.setNombre(rs.getString("Nombre"));
        cliente.setCorreo(rs.getString("Correo"));
        cliente.setDireccion(rs.getString("Direccion"));
        cliente.setTelefono(rs.getString("Telefono"));
        return cliente;
    }

    @Override
    protected void setPreparedStatementParameters(PreparedStatement stmt, Cliente cliente) throws SQLException {
        stmt.setInt(1, cliente.getIdCliente());
        stmt.setString(2, cliente.getNombre());
        stmt.setString(3, cliente.getCorreo());
        stmt.setString(4, cliente.getDireccion());
        stmt.setString(5, cliente.getTelefono());
    }
}
