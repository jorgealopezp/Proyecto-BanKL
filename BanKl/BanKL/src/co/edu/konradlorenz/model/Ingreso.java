package co.edu.konradlorenz.model;

public class Ingreso {
    private Registro registro;

    public Ingreso(Registro registro) {
        this.registro = registro;
    }

    public boolean autenticar(String documento, String clave) {
        ClienteNatural cliente = registro.buscarClientePorDocumento(documento);
        if (cliente != null) {
            return cliente.getContraseña().equals(clave);
        }
        return false;
    }
}
