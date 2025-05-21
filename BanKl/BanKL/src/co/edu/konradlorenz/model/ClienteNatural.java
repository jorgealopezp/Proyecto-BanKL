package co.edu.konradlorenz.model;

import java.util.List;
import co.edu.konradlorenz.view.Ventana;

public class ClienteNatural extends Cliente {

    public ClienteNatural() {
        super();
    }

    public ClienteNatural(String nombres, String apellidos, String id, String direccion, int telefono,
                          String email, List<Cuenta> cuentas, String usuarioIS, String contraseña) {
        super(nombres, apellidos, id, direccion, telefono, email, cuentas, usuarioIS, contraseña);
    }

    @Override
    public void registrarCliente() {
        // Aquí puedes agregar la lógica para guardar el cliente (BD, archivo, lista, etc)
        Ventana.mostrarMensaje("Cliente registrado: " + this.nombres + " " + this.apellidos
                + "\nPIN de seguridad: " + this.pinSeguridad);
    }

    @Override
    public boolean iniciarSesion(String usuario, String contraseña, int pin) {
        return this.usuarioIS.equals(usuario)
                && this.contraseña.equals(contraseña)
                && this.pinSeguridad == pin;
    }
}
