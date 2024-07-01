package org.example.dao;

import org.example.model.Pedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAOImpl extends GenericDAOImpl<Pedido> implements PedidoDAO {

    @Override
    protected Pedido mapResultSetToEntity(ResultSet rs) throws SQLException {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(rs.getInt("IDPedido"));
        pedido.setIdCliente(rs.getInt("IDCliente"));
        pedido.setIdProducto(rs.getInt("IDProducto"));
        pedido.setCantidad(rs.getInt("Cantidad"));
        pedido.setFecha(rs.getDate("Fecha"));
        return pedido;
    }

    @Override
    protected void setPreparedStatementParameters(PreparedStatement stmt, Pedido pedido) throws SQLException {
        stmt.setInt(1, pedido.getIdPedido());
        stmt.setInt(2, pedido.getIdCliente());
        stmt.setInt(3, pedido.getIdProducto());
        stmt.setInt(4, pedido.getCantidad());
        stmt.setDate(5, new java.sql.Date(pedido.getFecha().getTime()));
    }
}
