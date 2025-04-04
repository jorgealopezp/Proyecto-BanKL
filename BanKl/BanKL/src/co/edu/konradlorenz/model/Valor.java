package co.edu.konradlorenz.model;

public class Valor extends Objeto {
    private double monto;

    public Valor(int id, Object objeto, double monto) {
        super(id, objeto);
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }


}