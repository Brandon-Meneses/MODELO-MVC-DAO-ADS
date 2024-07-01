package org.example.dao;

import org.example.model.Factura;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacturaDAOImpl extends GenericDAOImpl<Factura> implements FacturaDAO {

    @Override
    protected Factura mapResultSetToEntity(ResultSet rs) throws SQLException {
        Factura factura = new Factura();
        factura.setIdFactura(rs.getInt("IDFactura"));
        factura.setFechaEmision(rs.getDate("FechaEmision"));
        factura.setIdVenta(rs.getInt("IDVenta"));
        return factura;
    }

    @Override
    protected void setPreparedStatementParameters(PreparedStatement stmt, Factura factura) throws SQLException {
        stmt.setInt(1, factura.getIdFactura());
        stmt.setDate(2, new java.sql.Date(factura.getFechaEmision().getTime()));
        stmt.setInt(3, factura.getIdVenta());
    }
}
