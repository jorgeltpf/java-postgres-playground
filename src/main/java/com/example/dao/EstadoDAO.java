package com.example.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Estado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstadoDAO extends DAO{
    public EstadoDAO(Connection conn) {
        super(conn);
    }

    public List<Estado> listar() throws SQLException {
        List<Estado> lista = new LinkedList<>();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("select * from estado");
        while (result.next()) {
            var estado = new Estado();
            estado.setId(result.getLong("id"));
            estado.setNome(result.getString("nome"));
            estado.setUf(result.getString("uf"));
            lista.add(estado);
            // System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
        }
        return lista;
    }

    public void localizar(String uf) {
        try {
            String sql = "select * from estado where uf = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, uf);
            
            //ResultSet result = statement.executeQuery("select * from estado where uf = '" + uf + "'");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }
        } catch (SQLException e) {
            System.err.println("Não foi possível consultar o banco de dados: " + e.getMessage());
        }

    }
}
