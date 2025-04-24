package co.edu.konradlorenz.model;

public class Cuenta {
    //ATRIBUTOS
    private int numeroCuenta;
    private String propietario;
    private double saldo;
    private String numeroTarjeta;
    private String fechaExpiracion;
    private int cvv;
    //CONSTRUCTORES
    public Cuenta() {
    }

    public Cuenta(int numeroCuenta, String propietario, double saldo, String numeroTarjeta, String fechaExpiracion, int cvv) {
        this.numeroCuenta = numeroCuenta;
        this.propietario = propietario;
        this.saldo = saldo;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
    }
    
    //GETTERS Y SETTERS
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

    @Override
    public String toString() {

        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", propietario=" + propietario + ", saldo=" + saldo + ", numeroTarjeta=" + numeroTarjeta + ", fechaExpiracion=" + fechaExpiracion + ", cvv=" + cvv + '}';
    }
    //metodos de consignar y retirar
    public void consignar(double valor) {
        saldo += valor;
    }


    public void retirar(double valor) {
        saldo -= valor;
    }
}
