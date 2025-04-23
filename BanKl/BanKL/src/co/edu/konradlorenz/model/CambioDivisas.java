package co.edu.konradlorenz.model;

import static co.edu.konradlorenz.view.Ventana.mostrarMensaje;
import java.util.*;

public final class CambioDivisas {

    private final Map<String, Map<String, Double>> tasas;

    public CambioDivisas() {
        tasas = new HashMap<>();
        agregarTasa("USD", "EUR", 0.85);
        agregarTasa("EUR", "USD", 1.18);
        agregarTasa("USD", "COP", 4000.0);
        agregarTasa("COP", "USD", 0.00025);
    }

    public void agregarTasa(String origen, String destino, double tasa) {
        tasas.computeIfAbsent(origen, k -> new HashMap<>()).put(destino, tasa);
        tasas.computeIfAbsent(destino, k -> new HashMap<>()).put(origen, 1 / tasa);
    }

    public double consultarTasa(String origen, String destino) {
        if (tasas.containsKey(origen) && tasas.get(origen).containsKey(destino)) {
            return tasas.get(origen).get(destino);
        }
        return 0.0;
    }

    public double realizarCambio(String origen, String destino, double cantidad) {
        double tasa = consultarTasa(origen, destino);
        if (tasa == 0.0) {
            mostrarMensaje("No hay tasa directa disponible entre " + origen + " y " + destino);
            return 0.0;
        }
        return cantidad * tasa;
    }
}
