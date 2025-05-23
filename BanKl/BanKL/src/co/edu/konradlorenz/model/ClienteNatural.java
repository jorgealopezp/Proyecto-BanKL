package co.edu.konradlorenz.model;

import co.edu.konradlorenz.view.Ventana;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

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
        TarjetaDebito debito = new TarjetaDebito(
                generarNumeroCuenta(),
                this.nombres + " " + this.apellidos,
                0.0,
                generarNumeroTarjeta(),
                generarFechaExpiracion(),
                generarCVV()
        );

        TarjetaCredito credito = new TarjetaCredito(
                generarNumeroCuenta(),
                this.nombres + " " + this.apellidos,
                0,
                generarNumeroTarjeta(),
                generarFechaExpiracion(),
                generarCVV(),
                2000000 // cupo inicial
        );

        this.cuentas.add(debito);
        this.cuentas.add(credito);

        Ventana.mostrarMensaje("Cliente registrado: " + this.nombres + " " + this.apellidos +
                "\nPIN de seguridad: " + this.pinSeguridad +
                "\nTarjetas creadas:\n- Débito terminada en " + debito.getNumeroTarjeta().substring(debito.getNumeroTarjeta().length() - 4) +
                "\n- Crédito terminada en " + credito.getNumeroTarjeta().substring(credito.getNumeroTarjeta().length() - 4));
    }

    @Override
    public boolean iniciarSesion(String usuario, String contraseña, int pin) {
        return this.usuarioIS.equals(usuario)
                && this.contraseña.equals(contraseña)
                && this.pinSeguridad == pin;
    }

    public TarjetaDebito getTarjetaDebito() {
        for (Cuenta cuenta : this.cuentas) {
            if (cuenta instanceof TarjetaDebito) {
                return (TarjetaDebito) cuenta;
            }
        }
        return null;
    }

    public TarjetaCredito getTarjetaCredito() {
        for (Cuenta cuenta : this.cuentas) {
            if (cuenta instanceof TarjetaCredito) {
                return (TarjetaCredito) cuenta;
            }
        }
        return null;
    }

    private String generarNumeroTarjeta() {
        Random random = new Random();
        StringBuilder numero = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            numero.append(random.nextInt(10));
        }
        return numero.toString();
    }

    private String generarFechaExpiracion() {
        LocalDate hoy = LocalDate.now();
        LocalDate expiracion = hoy.plusYears(5); // La tarjeta expira en 5 años
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        return expiracion.format(formatter);
    }

    private int generarCVV() {
        return new Random().nextInt(900) + 100; // CVV entre 100 y 999
    }

    private int generarNumeroCuenta() {
        return new Random().nextInt(90000000) + 10000000; // Número de cuenta de 8 dígitos
    }
}
