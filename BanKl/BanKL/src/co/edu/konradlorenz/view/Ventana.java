package co.edu.konradlorenz.view;

import java.util.Scanner;

public class Ventana {

    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static String pedirString(String info) {
        System.out.println(info);
        return scanner.nextLine();
    }

    public static int pedirEntero(String mensaje) {
        System.out.println(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor ingrese un numero valido.");
            scanner.next();
        }
        int valorInt = scanner.nextInt();
        return valorInt;
    }

    public static double pedirDouble(String mensaje) {
        System.out.println(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor ingrese un numero valido.");
            scanner.next();
        }
        double valorDouble = scanner.nextDouble();
        return valorDouble;
    }

} 