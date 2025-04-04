package co.edu.konradlorenz.model;

public class Objeto {
    private int id;
    private Object objeto;

    public Objeto(int id, Object objeto) {
        this.id = id;
        this.objeto = objeto;
    }

    public int getId() {
        return id;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    @Override
    public String toString() {
        return "Objeto{" +"id=" + id + ", objeto=" + objeto +'}';
    }
}