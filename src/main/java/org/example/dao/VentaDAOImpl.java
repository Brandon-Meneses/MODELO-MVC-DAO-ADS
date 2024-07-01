package org.example.dao;

import org.example.model.Venta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaDAOImpl extends GenericDAOImpl<Venta> implements VentaDAO {

    @Override
    protected Venta mapResultSetToEntity(ResultSet rs) throws SQLException {
        Venta venta = new Venta();
        venta.setIdVenta(rs.getInt("IDVenta"));
        venta.setFecha(rs.getDate("Fecha"));
        venta.setTotal(rs.getFloat("Total"));
        venta.setIdUsuario(rs.getInt("IDUsuario"));
        venta.setIdCliente(rs.getInt("IDCliente"));
        return venta;
    }

    @Override
    protected void setPreparedStatementParameters(PreparedStatement stmt, Venta venta) throws SQLException {
        stmt.setInt(1, venta.getIdVenta());
        stmt.setDate(2, new java.sql.Date(venta.getFecha().getTime()));
        stmt.setFloat(3, venta.getTotal());
        stmt.setInt(4, venta.getIdUsuario());
        stmt.setInt(5, venta.getIdCliente());
    }
}
