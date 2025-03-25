package co.edu.konradlorenz.model;

import co.edu.konradlorenz.view.*;

public class TarjetaCredito extends Cuenta {

    private double limiteCredito;
    private double interes;
    private double deuda;

    public TarjetaCredito() {
    }

    public TarjetaCredito(int numeroCuenta, String propietario, double saldo, int numeroTarjeta, String fechaExpiracion, int cvv, double limiteCredito, double interes, double deuda) {
        super(numeroCuenta, propietario, saldo, numeroTarjeta, fechaExpiracion, cvv);
        this.limiteCredito = limiteCredito;
        this.interes = interes;
        this.deuda = deuda;
    }
 
    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" + "limiteCredito=" + limiteCredito + ", interes=" + interes + ", deuda=" + deuda + '}';
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

    public void pagarDeuda(double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            setDeuda(getDeuda() - valor);
            Ventana.mostrarMensaje("Pago de deuda exitoso. Saldo actual: " + getSaldo());
        } else if (valor <= 0) {
            Ventana.mostrarMensaje("El valor a pagar debe ser mayor que cero.");
        } else {
            Ventana.mostrarMensaje("No hay suficiente saldo para realizar la operación.");
        }
    }
}
