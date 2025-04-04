package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;

public class TarjetaDebito extends Cuenta {

    private List<String> alertas = new ArrayList<>();

    public TarjetaDebito() {
    }

    public TarjetaDebito(int numeroCuenta, String propietario, double saldo, int numeroTarjeta, String fechaExpiracion, int cvv) {
        super(numeroCuenta, propietario, saldo, numeroTarjeta, fechaExpiracion, cvv);
    }

    @Override
    public void consignar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            alertas.add("Depósito en tarjeta débito: " + valor);
        }
    }
 
    @Override
    public void retirar(double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            alertas.add("Retiro en tarjeta débito: " + valor);
        }
    }

    public List<String> getAlertas() {
        return new ArrayList<>(alertas);
    }
}
