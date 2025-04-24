package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;

public class AlertasBancarias implements Alertas {

    // Lista que almacena las alertas registradas
    private List<Alerta> listaAlertas;

    //CONSTRUCTOR
    public AlertasBancarias(List<Alerta> listaAlertas) {
        this.listaAlertas = listaAlertas;
    }

    
    public AlertasBancarias() {
        this.listaAlertas = new ArrayList<>();
    }
 
    //GETTERS Y SETTERS
    public List<Alerta> getListaAlertas() {
        return listaAlertas;
    }

    
    public void setListaAlertas(List<Alerta> listaAlertas) {
        this.listaAlertas = listaAlertas;
    }

    // Implementación del método para registrar una nueva alerta
    @Override
    public void registrarAlerta(int id, String tipo, String descripcion) {
        listaAlertas.add(new Alerta(id, tipo, descripcion));
    }

    // Implementación del método para revisar y obtener todas las alertas registradas
    @Override
    public List<Alerta> revisarAlertas() {
        return new ArrayList<>(listaAlertas);
    }

}
