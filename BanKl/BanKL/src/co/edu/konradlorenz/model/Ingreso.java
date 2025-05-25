package co.edu.konradlorenz.model;

public class Ingreso {

    public static boolean autenticar(Registro registro, String documento, String clave) {
        ClienteNatural cliente = registro.buscarClientePorDocumento(documento);
        if (cliente != null) {
            return cliente.getContraseña().equals(clave);
        }
        return false;
    }
}
