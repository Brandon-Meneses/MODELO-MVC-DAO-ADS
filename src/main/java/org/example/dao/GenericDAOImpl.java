package org.example.dao;

import org.example.util.DBConnection;

import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {
    private Class<T> type;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;
    protected abstract void setPreparedStatementParameters(PreparedStatement stmt, T t) throws SQLException;

    @Override
    public void create(T t) {
        String query = "INSERT INTO " + type.getSimpleName() + " VALUES (?, ?, ?, ?, ?)"; // Actualiza según los campos
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            setPreparedStatementParameters(stmt, t);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T read(int id) {
        String query = "SELECT * FROM " + type.getSimpleName() + " WHERE ID" + type.getSimpleName() + " = ?";
        T entity = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                entity = mapResultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public void update(T t) {
        String query = "UPDATE " + type.getSimpleName() + " SET campo1 = ?, campo2 = ? WHERE ID" + type.getSimpleName() + " = ?"; // Actualiza según los campos
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            setPreparedStatementParameters(stmt, t);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM " + type.getSimpleName() + " WHERE ID" + type.getSimpleName() + " = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getAll() {
        List<T> entities = new ArrayList<>();
        String query = "SELECT * FROM " + type.getSimpleName();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                T entity = mapResultSetToEntity(rs);
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }
}
