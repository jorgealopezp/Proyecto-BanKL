package co.edu.konradlorenz.model;

public class TarjetaCredito extends Cuenta {
    private double cupo;

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

    public double disponible() {
        return cupo + getSaldo(); 
    }

    @Override
    public String consignar(double valor) {
        try {
            validarTransaccion(valor, 3000000);
            setSaldo(getSaldo() + valor);
            cupo += valor;
            return "Pago realizado en tarjeta de crédito: " + valor;
        } catch (IllegalArgumentException e) {
            return "Error en consignación: " + e.getMessage();
        }
    }

    @Override
    public String retirar(double valor) {
        try {
            validarTransaccion(valor, 3000000);
            if (valor > cupo) {
                throw new IllegalArgumentException("El valor excede el cupo disponible.");
            }
            setSaldo(getSaldo() - valor);
            cupo -= valor;
            return "Avance en efectivo de tarjeta de crédito: " + valor;
        } catch (IllegalArgumentException e) {
            return "Error en retiro: " + e.getMessage();
        }
    }

    private void validarTransaccion(double valor, double limiteMaximo) {
        if (Double.isNaN(valor) || Double.isInfinite(valor)) {
            throw new IllegalArgumentException("Entrada inválida: valor no numérico.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("El valor debe ser mayor que cero.");
        }
        if (valor > limiteMaximo) {
            throw new IllegalArgumentException("El valor excede el límite permitido por transacción: " + limiteMaximo);
        }
    }
}