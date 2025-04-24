package co.edu.konradlorenz.model;

import java.util.List;

public interface Alertas {

    // Método para registrar una nueva alerta con un id, tipo y descripción
    void registrarAlerta(int id, String tipo, String descripcion);

    // Método para revisar y obtener una lista de todas las alertas registradas
    List<Alerta> revisarAlertas();
    
}
 