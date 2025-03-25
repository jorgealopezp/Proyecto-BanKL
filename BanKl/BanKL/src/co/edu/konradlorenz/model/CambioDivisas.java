package co.edu.konradlorenz.model;

import static co.edu.konradlorenz.view.Ventana.mostrarMensaje;

import java.util.ArrayList;
import java.util.List;

class TasaCambio {
    String monedaOrigen;
    String monedaDestino;
    double tasa;

    public TasaCambio(String monedaOrigen, String monedaDestino, double tasa) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tasa = tasa;
    }
} 

public class CambioDivisas {
    private List<TasaCambio> tasasCambio;

    public CambioDivisas() {
        tasasCambio = new ArrayList<>();
       
        tasasCambio.add(new TasaCambio("USD", "EUR", 0.85));
        tasasCambio.add(new TasaCambio("EUR", "USD", 1.18));
        tasasCambio.add(new TasaCambio("USD", "COP", 4000.0));
        tasasCambio.add(new TasaCambio("COP", "USD", 0.00025));
    }

    public double consultarTasa(String monedaOrigen, String monedaDestino) {
        for (TasaCambio tasa : tasasCambio) {
            if (tasa.monedaOrigen.equals(monedaOrigen) && tasa.monedaDestino.equals(monedaDestino)) {
                return tasa.tasa;
            }
        }
        return -1.0; 
    }

    public double realizarCambio(String monedaOrigen, String monedaDestino, double cantidad) {
        double tasa = consultarTasa(monedaOrigen, monedaDestino);
        if (tasa == -1.0) {
            mostrarMensaje("No hay tasa de cambio disponible para " + monedaOrigen + " a " + monedaDestino);
        }
        return cantidad * tasa;
    }


}
