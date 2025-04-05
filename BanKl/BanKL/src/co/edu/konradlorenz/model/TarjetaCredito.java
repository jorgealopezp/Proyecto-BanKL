package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;

public class TarjetaCredito extends Cuenta {

    private double cupo;
    private List<String> alertas = new ArrayList<>();

    public TarjetaCredito(int numeroCuenta, String propietario, int saldo, String numeroTarjeta, String fechaExpiracion, int cvv, double cupo) {
        super(numeroCuenta, propietario, saldo, numeroTarjeta, fechaExpiracion, cvv);
        this.cupo = cupo;
    }
    public TarjetaCredito() {
        super();
    }

    public double getCupo() {
        return cupo;
    }

    public void setCupo(double cupo) {
        this.cupo = cupo;
    }

    @Override
    public void consignar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            cupo += valor;
            alertas.add("Pago realizado en tarjeta de crédito: " + valor);
        }
    }

    @Override
    public void retirar(double valor) {
        if (valor > 0 && valor <= cupo) {
            setSaldo(getSaldo() - valor);
            cupo -= valor;
            alertas.add("Avance en efectivo de tarjeta de crédito: " + valor);
        }
    }

    public List<String> getAlertas() {
        return new ArrayList<>(alertas);
    }
}
