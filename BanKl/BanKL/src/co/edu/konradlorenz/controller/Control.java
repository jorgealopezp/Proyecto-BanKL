package co.edu.konradlorenz.controller;

import javax.swing.SwingUtilities;

import co.edu.konradlorenz.model.Alerta;
import co.edu.konradlorenz.model.AlertasBancarias;
import co.edu.konradlorenz.model.TarjetaCredito;
import co.edu.konradlorenz.view.*;

public class Control {

    private TarjetaCredito tarjeta;
    private AlertasBancarias alertas;

    // Método principal que arranca el programa y muestra el menú principal
    public void run() {
        SwingUtilities.invokeLater(() -> {
            new HomePage().setVisible(true);
        });
    }

    // Método para consignar y registrar alerta
    public void consignarATarjeta(double valor) {
        String mensaje = tarjeta.consignar(valor);
        alertas.registrarAlerta(
            tarjeta.getNumeroCuenta(), // Usar el identificador correcto
            "Consignación",
            mensaje
        );
    }

    // Método para retirar y registrar alerta
    public void retirarDeTarjeta(double valor) {
        String mensaje = tarjeta.retirar(valor);
        alertas.registrarAlerta(
            tarjeta.getNumeroCuenta(), // Usar el identificador correcto
            "Retiro",
            mensaje
        );
    }
}