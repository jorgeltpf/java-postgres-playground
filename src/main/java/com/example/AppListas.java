package com.example;

import java.util.List;

import com.example.model.Cliente;

import java.util.ArrayList;

public class AppListas {
    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>();
        var cliente1 = new Cliente();
        cliente1.setNome("Teste");
        listaClientes.add(cliente1);
        var cliente2 = new Cliente();
        cliente2.setNome("Fulano");
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);

        int i = listaClientes.size() - 1;
        listaClientes.remove(i);
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }
}
