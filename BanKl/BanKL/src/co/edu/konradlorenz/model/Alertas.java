package co.edu.konradlorenz.model;

import java.util.List;

public interface Alertas {

    /**
     *
     * @param id
     * @param tipo
     * @param descripcion
     */
    void registrarAlerta(int id, String tipo, String descripcion);

    List<Alerta> revisarAlertas();

    void tomarAccion(int idAlerta, String accion);
}
 