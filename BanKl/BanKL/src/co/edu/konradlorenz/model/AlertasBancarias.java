package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;

public class AlertasBancarias implements Alertas {

    private List<Alerta> listaAlertas;

    public AlertasBancarias(List<Alerta> listaAlertas) {
        this.listaAlertas = listaAlertas;
    }

    public AlertasBancarias() {
        this.listaAlertas = new ArrayList<>();
    }
 
    public List<Alerta> getListaAlertas() {
        return listaAlertas;
    }

    public void setListaAlertas(List<Alerta> listaAlertas) {
        this.listaAlertas = listaAlertas;
    }

    @Override
    public void registrarAlerta(int id, String tipo, String descripcion) {
        listaAlertas.add(new Alerta(id, tipo, descripcion));
    }

    @Override
    public List<Alerta> revisarAlertas() {
        return new ArrayList<>(listaAlertas);
    }

}
