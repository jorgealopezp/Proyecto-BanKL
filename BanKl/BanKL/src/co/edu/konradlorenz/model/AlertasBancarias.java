package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;

public class AlertasBancarias {
    private final List<Alerta> listaAlertas = new ArrayList<>();

    public void registrarAlerta(int id, String tipo, String descripcion) {
        listaAlertas.add(new Alerta(id, tipo, descripcion));
    }

    public List<Alerta> revisarAlertas() {
        // Devuelve una copia para evitar modificaciones externas
        return new ArrayList<>(listaAlertas);
    }
}