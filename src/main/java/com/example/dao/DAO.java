package com.example.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    protected Connection conn;

    public DAO(Connection conn) {
        this.conn = conn;
    }

    public void listar(String tabela) {
        var sql = "select * from " + tabela;
        System.out.println(sql);
        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            var metadata = result.getMetaData();
            int cols = metadata.getColumnCount();

            for (int i = 1; i <= cols; i++) {
                System.out.printf("%-25s | ", metadata.getColumnName(i));
            }
            System.out.println();

            while(result.next()) {
                for (int i = 1; i <= cols; i++) {
                    System.out.printf("%-25s | ", result.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Não possível executar o sql: " + e);
        }
    }
}
