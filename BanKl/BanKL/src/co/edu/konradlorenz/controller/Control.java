
package co.edu.konradlorenz.controller;

import java.util.List;
import java.util.Set;

import javax.swing.SwingUtilities;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.view.*;


public class Control {

    // Instancias de las clases del modelo
    Cuenta objC = new Cuenta();
    TarjetaDebito objTD = new TarjetaDebito();
    TarjetaCredito objTC = new TarjetaCredito();
    AlertasBancarias objAB = new AlertasBancarias();
    CambioDivisas objCD = new CambioDivisas();
    Registro registro = new Registro(); 

    // Método principal que arranca el programa y muestra el menú principal
    public void run() {

        Ventana.mostrarMensaje("Bienvenido al sistema BanKL");
        int opcion = 0;

        // Bucle principal del menú
        do {
             SwingUtilities.invokeLater(() -> {
            new HomePage().setVisible(true);
        });




        
            Ventana.mostrarMensaje("\nMenú Principal");
            Ventana.mostrarMensaje("1. Información de la cuenta");
            Ventana.mostrarMensaje("2. Información de tarjetas");
            Ventana.mostrarMensaje("3. Cambio de divisas");
            Ventana.mostrarMensaje("4. Ver alertas");
            Ventana.mostrarMensaje("5. Salir");

            try {
                opcion = Ventana.pedirEntero("Seleccione una opción: ");

                if (opcion < 1 || opcion > 5) {
                    Ventana.mostrarMensaje("Opción no válida. Intente de nuevo.");
                    continue;
                }

                switch (opcion) {
                    case 1:
                        mostrarInformacionCuenta();
                        break;
                    case 2:
                        administrarTarjetas();
                        break;
                    case 3:
                        realizarCambioDivisas();
                        break;
                    case 4:
                        verAlertas();
                        break;
                    case 5:
                        Ventana.mostrarMensaje("Saliendo del sistema...");
                        break;
                }

            } catch (Exception e) {
                Ventana.mostrarMensaje("Error: Entrada no válida. Por favor, ingrese un número entre 1 y 5.");
            }

        } while (opcion != 5);
    }

    private void mostrarInformacionCuenta() {
        Ventana.mostrarMensaje("\nInformación de la Cuenta");
        Ventana.mostrarMensaje("Saldo actual: " + objC.getSaldo());
    }

    public void administrarTarjetas() {
        int opcion = 0;
        do {
            Ventana.mostrarMensaje("\nAdministrar Tarjetas");
            Ventana.mostrarMensaje("1. Tarjeta Débito");
            Ventana.mostrarMensaje("2. Tarjeta Crédito");
            Ventana.mostrarMensaje("3. Volver");

            try {
                opcion = Ventana.pedirEntero("Seleccione una opción: ");

                if (opcion < 1 || opcion > 3) {
                    Ventana.mostrarMensaje("Opción no válida. Intente de nuevo.");
                    continue;
                }

                switch (opcion) {
                    case 1:
                        gestionarTarjetaDebito();
                        break;
                    case 2:
                        gestionarTarjetaCredito();
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                Ventana.mostrarMensaje("Error: Entrada no válida. Por favor, ingrese un número entre 1 y 3.");
            }
        } while (opcion != 3);
    }

    public void gestionarTarjetaDebito() {
        int opcion;
        do {
            Ventana.mostrarMensaje("\nGestión de Tarjeta Débito");
            Ventana.mostrarMensaje("Saldo: " + objTD.getSaldo());
            Ventana.mostrarMensaje("1. Depositar");
            Ventana.mostrarMensaje("2. Retirar");
            Ventana.mostrarMensaje("3. Volver");
            opcion = Ventana.pedirEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    double montoDeposito = Ventana.pedirDouble("Ingrese el monto a depositar: ");
                    if (montoDeposito < 0) {
                        Ventana.mostrarMensaje("Monto no válido.");
                    } else {
                        objTD.consignar(montoDeposito);
                        objAB.registrarAlerta(Alerta.getContador() + 1, "Depósito",
                                "Depósito de " + montoDeposito + " en tarjeta débito");
                        Ventana.mostrarMensaje("Depósito realizado.");
                    }
                    break;
                case 2:
                    double montoRetiro = Ventana.pedirDouble("Ingrese el monto a retirar: ");
                    if (montoRetiro < 0) {
                        Ventana.mostrarMensaje("Monto no válido.");
                    } else if (montoRetiro > objTD.getSaldo()) {
                        Ventana.mostrarMensaje("Saldo insuficiente.");
                    } else {
                        objTD.retirar(montoRetiro);
                        objAB.registrarAlerta(Alerta.getContador() + 1, "Retiro",
                                "Retiro de " + montoRetiro + " en tarjeta débito");
                        Ventana.mostrarMensaje("Retiro realizado.");
                    }
                    break;
                case 3:
                    return;
                default:
                    Ventana.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 3);
    }

    public void gestionarTarjetaCredito() {
        int opcion;
        do {
            Ventana.mostrarMensaje("\nGestión de Tarjeta Crédito");
            Ventana.mostrarMensaje("Cupo disponible: " + objTC.getSaldo());
            Ventana.mostrarMensaje("1. Pagar");
            Ventana.mostrarMensaje("2. Retirar");
            Ventana.mostrarMensaje("3. Volver");
            opcion = Ventana.pedirEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    double montoPago = Ventana.pedirDouble("Ingrese el monto a pagar: ");
                    if (montoPago < 0) {
                        Ventana.mostrarMensaje("Monto no válido.");
                    } else {
                        objTC.consignar(montoPago);
                        objAB.registrarAlerta(Alerta.getContador() + 1, "Pago",
                                "Pago de " + montoPago + " en tarjeta crédito");
                        Ventana.mostrarMensaje("Pago realizado.");
                    }
                    break;
                case 2:
                    double montoRetiro = Ventana.pedirDouble("Ingrese el monto a retirar: ");
                    if (montoRetiro < 0) {
                        Ventana.mostrarMensaje("Monto no válido.");
                    } else if (montoRetiro > objTC.getSaldo()) {
                        Ventana.mostrarMensaje("Cupo disponible insuficiente.");
                    } else {
                        objTC.retirar(montoRetiro);
                        objAB.registrarAlerta(Alerta.getContador() + 1, "Retiro",
                                "Retiro de " + montoRetiro + " en tarjeta crédito");
                        Ventana.mostrarMensaje("Retiro realizado.");
                    }
                    break;
                case 3:
                    return;
                default:
                    Ventana.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 3);
    }

    public void realizarCambioDivisas() {
        CambioDivisas conversor = new CambioDivisas();
        Set<String> monedasValidas = Set.of("USD", "EUR", "COP");

        try {
            Ventana.mostrarMensaje("\nBienvenido al cambio de divisas.");
            Ventana.mostrarMensaje("Monedas disponibles: USD, EUR, COP");

            String origen = Ventana.pedirString("Moneda de origen: ").toUpperCase().trim();
            if (!monedasValidas.contains(origen)) {
                Ventana.mostrarMensaje("Moneda no válida.");
                return;
            }

            String destino = Ventana.pedirString("Moneda de destino: ").toUpperCase().trim();
            if (!monedasValidas.contains(destino) || destino.equals(origen)) {
                Ventana.mostrarMensaje("Destino no válido.");
                return;
            }

            double cantidad = Ventana.pedirDouble("Cantidad a convertir: ");
            if (cantidad <= 0) {
                Ventana.mostrarMensaje("La cantidad debe ser mayor que cero.");
                return;
            }

            double resultado = conversor.realizarCambio(origen, destino, cantidad);
            if (resultado > 0) {
                Ventana.mostrarMensaje("Resultado: " + cantidad + " " + origen + " = " + resultado + " " + destino);
            } else {
                Ventana.mostrarMensaje("Error al convertir.");
            }

        } catch (Exception e) {
            Ventana.mostrarMensaje("Error inesperado, intente de nuevo.");
        }
    }

    public void verAlertas() {
        List<Alerta> alertas = objAB.revisarAlertas();
        if (alertas.isEmpty()) {
            Ventana.mostrarMensaje("No hay alertas registradas.");
        } else {
            Ventana.mostrarMensaje("Alertas registradas:");
            for (Alerta alerta : alertas) {
                Ventana.mostrarMensaje("ID: " + alerta.getId() + ", Tipo: " + alerta.getTipo() + ", Descripción: "
                        + alerta.getDescripcion());
            }
        }
    }
}
