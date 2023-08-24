package com.example;

import com.example.dao.ConnectionManager;
import com.example.dao.DAO;
import com.example.dao.EstadoDAO;
import com.example.dao.ProdutoDAO;
import com.example.model.Estado;
import com.example.model.Marca;
import com.example.model.Produto;

import java.sql.SQLException;

public class AppBd {
    public static void main(String[] args) {
        new AppBd();
    }

    public AppBd() {
        try (var conn = ConnectionManager.getConnection()) {
            EstadoDAO estadoDAO = new EstadoDAO(conn);
            var listaEstados = estadoDAO.listar();
            for (Estado estado : listaEstados) {
                System.out.println(estado);
            }
            estadoDAO.localizar("RS");

            ProdutoDAO produtoDAO = new ProdutoDAO(conn);
            Marca marca = new Marca();
            marca.setId(1L);
            Produto produto = new Produto();
            produto.setMarca(marca);
            produto.setNome("Produto teste");
            produto.setValor(3.45);
            // produtoDAO.inserir(produto);
            // produtoDAO.excluir(202);

            produtoDAO.listar();

            produto.setId(201L);
            produto.setNome("Atualizar produto teste");
            produto.setValor(14.45);
            produtoDAO.atualizar(produto);
            DAO dao = new DAO(conn);
            // dao.listar("produto");
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
        }
    }

}
