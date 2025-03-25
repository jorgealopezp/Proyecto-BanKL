package co.edu.konradlorenz.model;

import co.edu.konradlorenz.view.*;

public class TarjetaDebito extends Cuenta {

    public TarjetaDebito() {
    }

    public TarjetaDebito(int numeroCuenta, String propietario, double saldo, int numeroTarjeta, String fechaExpiracion, int cvv) {
        super(numeroCuenta, propietario, saldo, numeroTarjeta, fechaExpiracion, cvv);
    }

    @Override
    public void consignar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            Ventana.mostrarMensaje("Consignación exitosa. Saldo actual: " + getSaldo());
        } else {
            Ventana.mostrarMensaje("El valor a consignar debe ser mayor que cero.");
        }
    }
 
    @Override
    public void retirar(double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            Ventana.mostrarMensaje("Retiro exitoso. Saldo actual: " + getSaldo());
        } else if (valor <= 0) {
            Ventana.mostrarMensaje("El valor a retirar debe ser mayor que cero.");
        } else {
            Ventana.mostrarMensaje("No hay suficiente saldo para realizar la operación.");
        }
    }

}
