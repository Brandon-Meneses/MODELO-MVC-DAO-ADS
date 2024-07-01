package org.example.dao;

import org.example.model.Inventario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventarioDAOImpl extends GenericDAOImpl<Inventario> implements InventarioDAO {

    @Override
    protected Inventario mapResultSetToEntity(ResultSet rs) throws SQLException {
        Inventario inventario = new Inventario();
        inventario.setIdInventario(rs.getInt("IDInventario"));
        inventario.setFechaActualizacion(rs.getDate("FechaActualizacion"));
        inventario.setIdProducto(rs.getInt("IDProducto"));
        inventario.setCantidad(rs.getInt("Cantidad"));
        return inventario;
    }

    @Override
    protected void setPreparedStatementParameters(PreparedStatement stmt, Inventario inventario) throws SQLException {
        stmt.setInt(1, inventario.getIdInventario());
        stmt.setDate(2, new java.sql.Date(inventario.getFechaActualizacion().getTime()));
        stmt.setInt(3, inventario.getIdProducto());
        stmt.setInt(4, inventario.getCantidad());
    }
}

