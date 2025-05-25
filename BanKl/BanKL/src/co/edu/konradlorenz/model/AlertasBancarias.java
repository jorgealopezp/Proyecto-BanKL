package co.edu.konradlorenz.model;


import java.util.ArrayList;
import java.util.List;

public class AlertasBancarias implements Alertas {

    private final List<Alerta> listaAlertas = new ArrayList<>();

    @Override
    public void registrarAlerta(int id, String tipo, String descripcion) {
        listaAlertas.add(new Alerta(id, tipo, descripcion));
    }

    @Override
    public List<Alerta> revisarAlertas() {
        return new ArrayList<>(listaAlertas);
    }
}
