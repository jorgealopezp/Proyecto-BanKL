package co.edu.konradlorenz.model;

import java.util.List;

public interface Alertas {

    void registrarAlerta(int id, String tipo, String descripcion);

    List<Alerta> revisarAlertas();

    
}
 