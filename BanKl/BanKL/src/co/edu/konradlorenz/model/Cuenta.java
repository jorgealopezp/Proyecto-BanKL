package co.edu.konradlorenz.model;

public class Cuenta {
    private int numeroCuenta;
    private String propietario;
    private double saldo;
    private String numeroTarjeta;
    private String fechaExpiracion;
    private int cvv;

    public Cuenta() {}

    public Cuenta(int numeroCuenta, String propietario, double saldo, String numeroTarjeta, String fechaExpiracion, int cvv) {
        this.numeroCuenta = numeroCuenta;
        this.propietario = propietario;
        this.saldo = saldo;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    // Ahora retorna String para ser compatible con TarjetaCredito
    public String consignar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return "Consignación exitosa por $" + valor + ". Nuevo saldo: $" + saldo;
        } else {
            return "Error: El valor a consignar debe ser mayor que cero.";
        }
    }

    // Ahora retorna String para ser compatible con TarjetaCredito
    public String retirar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return "Retiro exitoso por $" + valor + ". Nuevo saldo: $" + saldo;
        } else if (valor <= 0) {
            return "Error: El valor a retirar debe ser mayor que cero.";
        } else {
            return "Error: Fondos insuficientes para retirar $" + valor + ".";
        }
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta=" + numeroCuenta +
                ", propietario='" + propietario + '\'' +
                ", saldo=" + saldo +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", fechaExpiracion='" + fechaExpiracion + '\'' +
                ", cvv=" + cvv +
                '}';
    }
}