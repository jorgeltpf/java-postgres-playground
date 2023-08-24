package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Produto;

public class ProdutoDAO extends DAO {
    public ProdutoDAO(Connection conn) {
        super(conn);
    }

    public void listar() {
        var sql = "select *, m.nome as marcanome from produto p inner join marca m on m.id = p.marca_id";
        try {
            var statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql);
            while(result.next()) {
                System.out.printf("Id: %d Nome: %s Marca: %s Valor: %f\n", result.getInt("id"), result.getString("nome"), result.getString("marcanome"), result.getDouble("valor"));
            }
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Não possível executar a consulta ao banco de dados: " + e.getMessage());
        }
    }

    public void inserir(Produto produto) {
        var sql = "insert into produto(nome, marca_id, valor) values (?, ?, ?)";
        try(PreparedStatement statement = conn.prepareStatement(sql);) {
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Não foi possível inserir o produto no banco de dados: " + e.getMessage());
        }
    }

    public void excluir(long id) {
        var sql = "delete from produto where id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, id);
            if (statement.executeUpdate() == 1) {
                System.out.println("Produto excluído");
            } else {
                System.out.println("Produto não localizado");
            }
        } catch (SQLException e) {
            System.err.println("Não foi possível excluir o produto do banco de dados: " + e.getMessage());
        }
    }

    public void atualizar(Produto produto) {
        var sql = "update produto set nome = ?, marca_id = ?, valor = ? where id = ? ";
        try(PreparedStatement statement = conn.prepareStatement(sql);) {
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.setLong(4, produto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Não foi possível atualizar o produto no banco de dados: " + e.getMessage());
        }
    }
}
