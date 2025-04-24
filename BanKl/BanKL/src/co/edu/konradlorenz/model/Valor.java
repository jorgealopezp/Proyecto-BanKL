package co.edu.konradlorenz.model;

public class Valor {
    //ATRIBUTOS
    private int id;
    private String nombre;
    private double valor;
    //CONSTRUCTOR
    public Valor(int id, String nombre, double valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }
    //GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Valor{" + "id=" + id + ", nombre=" + nombre + ", valor=" + valor + '}';
    }
}