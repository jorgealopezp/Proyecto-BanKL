package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.model.Cuenta;
import co.edu.konradlorenz.model.TarjetaCredito;
import co.edu.konradlorenz.model.TarjetaDebito;
import co.edu.konradlorenz.view.Ventana;

public class Control {
    Cuenta objC = new Cuenta();
    TarjetaDebito objTD = new TarjetaDebito();
    TarjetaCredito objTC = new TarjetaCredito();
    Ventana objV = new Ventana();

    public void run() {
        objV.mostrarMensaje("Bienvenido al sistema BanKL");
        objV.pedirEntero("Presione 1 para continuar...");
        int opcion;
        do {
            objV.mostrarMensaje("\nMenú Principal");
            objV.mostrarMensaje("1. Información de la cuenta");
            objV.mostrarMensaje("2. Información de tarjetas");
            objV.mostrarMensaje("3. Cambio de divisas");
            objV.mostrarMensaje("4. Protección de valores");
            objV.mostrarMensaje("5. Ver alertas");
            objV.mostrarMensaje("6. Salir");
            opcion = objV.pedirEntero("Seleccione una opción: ");

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
                    objV.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    objV.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private void mostrarInformacionCuenta() {
        objV.mostrarMensaje("\nInformación de la Cuenta");
        objV.mostrarMensaje("Saldo actual: " + objC.getSaldo());
    }

    private void administrarTarjetas() {
        int opcion;
        do {
            objV.mostrarMensaje("\nAdministrar Tarjetas");
            objV.mostrarMensaje("1. Tarjeta Débito");
            objV.mostrarMensaje("2. Tarjeta Crédito");
            objV.mostrarMensaje("3. Volver");
            opcion = objV.pedirEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    gestionarTarjetaDebito();
                    break;
                case 2:
                    gestionarTarjetaCredito();
                    break;
                case 3:
                    return;
                default:
                    objV.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    private void gestionarTarjetaDebito() {
        int opcion;
        do {
            objV.mostrarMensaje("\nGestión de Tarjeta Débito");
            objV.mostrarMensaje("Saldo: " + objTD.getSaldo());
            objV.mostrarMensaje("1. Depositar");
            objV.mostrarMensaje("2. Retirar");
            objV.mostrarMensaje("3. Volver");
            opcion = objV.pedirEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                double montoDeposito = objV.pedirDouble("Ingrese el monto a depositar: ");
                objTD.consignar(montoDeposito);
                objV.mostrarMensaje("Depósito realizado.");
                    break;
                case 2:
                    double montoRetiro = objV.pedirDouble("Ingrese el monto a retirar: ");
                    objTD.retirar(montoRetiro);
                    objV.mostrarMensaje("Retiro realizado.");
                    break;
                case 3:
                    return;
                default:
                    objV.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    private void gestionarTarjetaCredito() {
        int opcion;
        do {
            objV.mostrarMensaje("\nGestión de Tarjeta Crédito");
            objV.mostrarMensaje("Cupo disponible: " + objTC.getSaldo());
            objV.mostrarMensaje("1. Pagar");
            objV.mostrarMensaje("2. Retirar");
            objV.mostrarMensaje("3. Volver");
            opcion = objV.pedirEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    double montoPago = objV.pedirDouble("Ingrese el monto a pagar: ");
                    objTC.consignar(montoPago);
                    objV.mostrarMensaje("Pago realizado.");
                    break;
                case 2:
                    double montoRetiro = objV.pedirDouble("Ingrese el monto a retirar: ");
                    objTC.retirar(montoRetiro);
                    objV.mostrarMensaje("Retiro realizado.");
                    break;
                case 3:
                    return;
                default:
                    objV.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    private void realizarCambioDivisas() {
        objV.mostrarMensaje("\nCambio de Divisas - Funcionalidad en desarrollo");
    }

    private void protegerValores() {
        objV.mostrarMensaje("\nProtección de Valores - Funcionalidad en desarrollo");
    }

    private void verAlertas() {
        objV.mostrarMensaje("\nAlertas - Funcionalidad en desarrollo");
    }
}

