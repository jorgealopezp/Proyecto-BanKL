package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;

public class TarjetaCredito extends Cuenta {//Hereda de Cuenta
//Atributos
    private double cupo;
    private List<String> alertas = new ArrayList<>();
//Constructores
    public TarjetaCredito(int numeroCuenta, String propietario, int saldo, String numeroTarjeta, String fechaExpiracion, int cvv, double cupo) {
        super(numeroCuenta, propietario, saldo, numeroTarjeta, fechaExpiracion, cvv);
        this.cupo = cupo;
    }

    public TarjetaCredito() {
        super();
    }
//Metodos
    public double getCupo() {
        return cupo;
    }

    public void setCupo(double cupo) {
        this.cupo = cupo;
    }

    @Override
    public void consignar(double valor) {
        try {
            validarTransaccion(valor, 30000000);//Limite de 3M por transaccion.

            setSaldo(getSaldo() + valor);//actualizacion de saldo
            cupo += valor;
            alertas.add("Pago realizado en tarjeta de crédito: " + valor);

        } catch (IllegalArgumentException e) {
            alertas.add("Error en consignación: " + e.getMessage());
        }
    }

    @Override
    public void retirar(double valor) {
        try {
            validarTransaccion(valor, 3000000); 

            if (valor > cupo) {
                throw new IllegalArgumentException("El valor excede el cupo disponible.");
            }

            setSaldo(getSaldo() - valor);
            cupo -= valor;
            alertas.add("Avance en efectivo de tarjeta de crédito: " + valor);

        } catch (IllegalArgumentException e) {
            alertas.add("Error en retiro: " + e.getMessage());
        }
    }

    public List<String> getAlertas() {
        return new ArrayList<>(alertas);
    }

    private void validarTransaccion(double valor, double limiteMaximo) {//Metodo para la validacion de transaccion.
        if (Double.isNaN(valor) || Double.isInfinite(valor)) {//Verifica si es un numero.
            throw new IllegalArgumentException("Entrada inválida: valor no numérico.");
        }
        if (valor <= 0) {//Evita que sea numeros negativos.
            throw new IllegalArgumentException("El valor debe ser mayor que cero.");
        }
        if (valor > limiteMaximo) {//Revisa que no sea mas del limite.
            throw new IllegalArgumentException("El valor excede el límite permitido por transacción: " + limiteMaximo);
        }
    }
}
