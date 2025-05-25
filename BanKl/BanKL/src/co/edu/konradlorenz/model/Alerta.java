package co.edu.konradlorenz.model;

public class Alerta {
    private static int contador = 0;
    private int id;
    private String tipo;
    private String descripcion;

    public Alerta(int id, String tipo, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        contador++;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static int getContador() {
        return contador;
    }
}
