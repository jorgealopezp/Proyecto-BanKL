package co.edu.konradlorenz.controller;

import java.util.List;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.view.Ventana;

public class Control {

    Cuenta objC = new Cuenta();
    TarjetaDebito objTD = new TarjetaDebito();
    TarjetaCredito objTC = new TarjetaCredito();
    AlertasBancarias objAB = new AlertasBancarias();
    SeguridadBancaria objSB = new SeguridadBancaria();

    public void run() {
        Ventana.mostrarMensaje("Bienvenido al sistema BanKL");
        int opcion = 0;
        do {
            Ventana.mostrarMensaje("\nMenú Principal");
            Ventana.mostrarMensaje("1. Información de la cuenta");
            Ventana.mostrarMensaje("2. Información de tarjetas");
            Ventana.mostrarMensaje("3. Cambio de divisas");
            Ventana.mostrarMensaje("4. Protección de valores");
            Ventana.mostrarMensaje("5. Ver alertas");
            Ventana.mostrarMensaje("6. Salir");

            try {
                opcion = Ventana.pedirEntero("Seleccione una opción: ");

                if (opcion < 1 || opcion > 6) {
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
                        protegerValores();
                        break;
                    case 5:
                        verAlertas();
                        break;
                    case 6:
                        Ventana.mostrarMensaje("Saliendo del sistema...");
                        break;
                }
            } catch (Exception e) {
                Ventana.mostrarMensaje("Error: Entrada no válida. Por favor, ingrese un número entre 1 y 6.");
            }
        } while (opcion != 6);
    }

    private void mostrarInformacionCuenta() {
        Ventana.mostrarMensaje("\nInformación de la Cuenta");
        Ventana.mostrarMensaje("Saldo actual: " + objC.getSaldo());
    }

    private void administrarTarjetas() {
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

    private void gestionarTarjetaDebito() {
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
                        Ventana.mostrarMensaje("Monto no válido. Por favor, ingrese un monto positivo.");
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
                        Ventana.mostrarMensaje("Monto no válido. Por favor, ingrese un monto positivo.");
                    } else if (montoRetiro > objTD.getSaldo()) {
                        Ventana.mostrarMensaje("Saldo insuficiente. Por favor, ingrese un monto menor.");
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
                    Ventana.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

    }

    private void gestionarTarjetaCredito() {
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
                        Ventana.mostrarMensaje("Monto no válido. Por favor, ingrese un monto positivo.");
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
                        Ventana.mostrarMensaje("Monto no válido. Por favor, ingrese un monto positivo.");
                    } else if (montoRetiro > objTC.getSaldo()) {
                        Ventana.mostrarMensaje("Cupo disponible insuficiente. Por favor, ingrese un monto menor.");
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
                    Ventana.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    private void realizarCambioDivisas() {
        Ventana.mostrarMensaje("\nCambio de Divisas");
        Ventana.mostrarMensaje("En desarrollo...");
        Ventana.mostrarMensaje("Por favor, consulte más tarde.");
    }

    private void protegerValores() {
        Ventana.mostrarMensaje("\nProtección de Valores");
        Ventana.mostrarMensaje("En desarrollo...");
        Ventana.mostrarMensaje("Por favor, consulte más tarde.");
    }

    private void verAlertas() {
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