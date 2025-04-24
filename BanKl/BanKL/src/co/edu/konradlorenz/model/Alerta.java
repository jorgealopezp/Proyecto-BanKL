
package co.edu.konradlorenz.model;

public class Alerta {
    // ATRIBUTOS
    private static int contador = 0; // Contador estático para llevar el registro de la cantidad de alertas
    private int id;
    private String tipo;
    private String descripcion;

    public Alerta() {
    }

    // CONSTRUCTOR
    public Alerta(int id, String tipo, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    // GETTERS Y SETTERS
    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Alerta.contador = contador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Alerta{" + "id=" + id + ", tipo=" + tipo + ", descripcion=" + descripcion + '}';
    }
}