package co.edu.konradlorenz.model;

public class TarjetaDebito extends Cuenta {

    public TarjetaDebito(int numeroCuenta, String propietario, double saldo, String numeroTarjeta, String fechaExpiracion, int cvv) {
        super(numeroCuenta, propietario, saldo, numeroTarjeta, fechaExpiracion, cvv);
    }

    public TarjetaDebito() {
        super();
    }

    @Override
    public String consignar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            return "Consignación exitosa por $" + valor + ". Nuevo saldo: $" + getSaldo();
        } else {
            return "Error: El valor a consignar debe ser mayor que cero.";
        }
    }

    @Override
    public String retirar(double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            return "Retiro exitoso por $" + valor + ". Nuevo saldo: $" + getSaldo();
        } else if (valor <= 0) {
            return "Error: El valor a retirar debe ser mayor que cero.";
        } else {
            return "Error: Fondos insuficientes para retirar $" + valor + ".";
        }
    }
}


