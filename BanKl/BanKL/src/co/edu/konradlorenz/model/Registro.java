package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;

public class Registro {
    private List<ClienteNatural> clientes;

    public Registro() {
        clientes = new ArrayList<>();
    }

    public List<ClienteNatural> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteNatural> clientes) {
        this.clientes = clientes;
    }
    

    public void agregarCliente(ClienteNatural cliente) {
        clientes.add(cliente);
    }

    public ClienteNatural buscarClientePorDocumento(String documento) {
        for (ClienteNatural c : clientes) {
            if (c.getId().equals(documento)) {
                return c;
            }
        }
        return null;
    }
}