package co.edu.konradlorenz.model;

import co.edu.konradlorenz.view.*;
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

    @Override
    public void tomarAccion(int idAlerta, String accion) {
        for (Alerta alerta : listaAlertas) {
            if (alerta.getId() == idAlerta) {
                Ventana.mostrarMensaje("Acción tomada en la alerta " + idAlerta + ": " + accion);
                return;
            }
        }
        Ventana.mostrarMensaje("No se encontró la alerta con ID " + idAlerta);
    }
}
