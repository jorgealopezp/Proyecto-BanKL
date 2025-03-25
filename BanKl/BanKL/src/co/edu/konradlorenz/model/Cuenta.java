package co.edu.konradlorenz.model;

public class Cuenta {

    private int numeroCuenta;
    private String propietario;
    private double saldo;
    private int numeroTarjeta;
    private String fechaExpiracion;
    private int cvv;

    public Cuenta() {
    }

    public Cuenta(int numeroCuenta, String propietario, double saldo, int numeroTarjeta, String fechaExpiracion, int cvv) {
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

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
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

    @Override
    public String toString() {

        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", propietario=" + propietario + ", saldo=" + saldo + ", numeroTarjeta=" + numeroTarjeta + ", fechaExpiracion=" + fechaExpiracion + ", cvv=" + cvv + '}';
    }

    public void consignar(double valor) {
        saldo += valor;
    }

    public void retirar(double valor) {
        saldo -= valor;
    }
}
