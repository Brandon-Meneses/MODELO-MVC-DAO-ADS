package org.example.dao;

import org.example.model.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAOImpl extends GenericDAOImpl<Producto> implements ProductoDAO {

    @Override
    protected Producto mapResultSetToEntity(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setIdProducto(rs.getInt("IDProducto"));
        producto.setNombre(rs.getString("Nombre"));
        producto.setDescripcion(rs.getString("Descripcion"));
        producto.setPrecio(rs.getFloat("Precio"));
        producto.setStock(rs.getInt("Stock"));
        return producto;
    }

    @Override
    protected void setPreparedStatementParameters(PreparedStatement stmt, Producto producto) throws SQLException {
        stmt.setInt(1, producto.getIdProducto());
        stmt.setString(2, producto.getNombre());
        stmt.setString(3, producto.getDescripcion());
        stmt.setFloat(4, producto.getPrecio());
        stmt.setInt(5, producto.getStock());
    }
}
