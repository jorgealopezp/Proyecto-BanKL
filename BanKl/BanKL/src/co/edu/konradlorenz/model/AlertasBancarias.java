package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;

public class AlertasBancarias {
    private List<Alerta> listaAlertas = new ArrayList<>();

    public void registrarAlerta(int id, String tipo, String descripcion) {
        Alerta alerta = new Alerta(id, tipo, descripcion);
        listaAlertas.add(alerta);
    }

    public List<Alerta> revisarAlertas() {
        return listaAlertas;
    }
}
