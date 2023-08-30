package main;

import java.util.ArrayList;
import java.util.List;

class Cliente {

    private long id;
    private String nome;
    private String cpf;
    private String endereco;

    // Construtor
    public Cliente(long id, String nome, String cpf, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

public class Clientes {

    private List<Cliente> clientes;

    public Clientes() {
        clientes = new ArrayList<>();
    }

    public void createCliente(String nome, String cpf, String endereco) {
        // Gere um ID único (por exemplo, incrementando um contador)
        long id = generateUniqueId();

        Cliente novoCliente = new Cliente(id, nome, cpf, endereco);
        clientes.add(novoCliente);
    }

    public Cliente searchClienteNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    public Cliente searchClienteCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    public Cliente searchCliente(long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    public List<Cliente> showClientes() {
        return clientes;
    }

    public boolean alterCliente(long id, String novoEndereco) {
        Cliente cliente = searchCliente(id);
        if (cliente != null) {
            cliente.setEndereco(novoEndereco);
            return true;
        }
        return false; // Cliente não encontrado
    }

    public boolean deleteCliente(long id) {
        Cliente cliente = searchCliente(id);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        }
        return false; // Cliente não encontrado
    }

    private long generateUniqueId() {
        // Lógica para gerar IDs únicos (pode ser incremento de contador, timestamp, etc.)
        return System.currentTimeMillis();
    }
}
