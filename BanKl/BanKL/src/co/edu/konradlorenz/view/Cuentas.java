package co.edu.konradlorenz.view;

import co.edu.konradlorenz.model.Registro;

import javax.swing.*;
import java.awt.*;

public class Cuentas extends JFrame {

    public Cuentas(Registro registro) {
        setTitle("Cuentas - BanKL");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Para no cerrar toda la app
        setSize(950, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(220, 214, 207));
        header.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel logoLabel = new JLabel("<html><span style='font-size:28px; font-weight:bold; color:#001f4d;'>Ban</span><span style='font-size:28px; font-weight:bold; color:#000;'>KL</span><br>Innovación financiera para tu futuro</html>");
        header.add(logoLabel, BorderLayout.WEST);

        JLabel welcomeLabel = new JLabel("<html><div style='text-align:right;'>Hola,<br>Bienvenido</div></html>");
        header.add(welcomeLabel, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);

        // Título "Cuentas"
        JLabel cuentasTitulo = new JLabel("Cuentas", SwingConstants.CENTER);
        cuentasTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        cuentasTitulo.setOpaque(true);
        cuentasTitulo.setBackground(new Color(100, 149, 237));
        cuentasTitulo.setForeground(Color.WHITE);
        cuentasTitulo.setPreferredSize(new Dimension(100, 50));
        add(cuentasTitulo, BorderLayout.BEFORE_FIRST_LINE);

        // Panel central de cuentas
        JPanel cuentasPanel = new JPanel(new GridLayout(1, 2, 30, 0));
        cuentasPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        cuentasPanel.setBackground(Color.WHITE);

        // Cuenta de Ahorros
        JPanel ahorroPanel = new JPanel(new BorderLayout());
        ahorroPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ahorroPanel.setBackground(Color.WHITE);

        JLabel ahorroTitulo = new JLabel("Cuenta de ahorros", SwingConstants.CENTER);
        ahorroTitulo.setOpaque(true);
        ahorroTitulo.setBackground(new Color(100, 149, 237));
        ahorroTitulo.setForeground(Color.WHITE);
        ahorroTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        ahorroPanel.add(ahorroTitulo, BorderLayout.NORTH);

        JTextArea ahorroDatos = new JTextArea("Número:\t13214564\nSaldo:\t0.00$\n\nÚltimos 4 dígitos:\t1234\nVencimiento:\t12/24");
        ahorroDatos.setEditable(false);
        ahorroDatos.setFont(new Font("Arial", Font.PLAIN, 14));
        ahorroPanel.add(ahorroDatos, BorderLayout.CENTER);

        JPanel botonesAhorro = new JPanel(new GridLayout(2, 1, 10, 10));
        botonesAhorro.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        JButton btnIngresar = new JButton("Ingresar");
        JButton btnRetirarAhorro = new JButton("Retirar");
        botonesAhorro.add(btnIngresar);
        botonesAhorro.add(btnRetirarAhorro);

        ahorroPanel.add(botonesAhorro, BorderLayout.SOUTH);
        cuentasPanel.add(ahorroPanel);

        // Cuenta de Crédito
        JPanel creditoPanel = new JPanel(new BorderLayout());
        creditoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        creditoPanel.setBackground(Color.WHITE);

        JLabel creditoTitulo = new JLabel("Cuenta de crédito", SwingConstants.CENTER);
        creditoTitulo.setOpaque(true);
        creditoTitulo.setBackground(new Color(100, 149, 237));
        creditoTitulo.setForeground(Color.WHITE);
        creditoTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        creditoPanel.add(creditoTitulo, BorderLayout.NORTH);

        JTextArea creditoDatos = new JTextArea("Número:\t13214564\nDeuda:\t0.00$\nDisponible:\t200.0$\n\nÚltimos 4 dígitos:\t1234\nVencimiento:\t12/24");
        creditoDatos.setEditable(false);
        creditoDatos.setFont(new Font("Arial", Font.PLAIN, 14));
        creditoPanel.add(creditoDatos, BorderLayout.CENTER);

        JPanel botonesCredito = new JPanel(new GridLayout(2, 1, 10, 10));
        botonesCredito.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        JButton btnPagar = new JButton("Pagar");
        JButton btnRetirarCredito = new JButton("Retirar");
        botonesCredito.add(btnPagar);
        botonesCredito.add(btnRetirarCredito);

        creditoPanel.add(botonesCredito, BorderLayout.SOUTH);
        cuentasPanel.add(creditoPanel);

        add(cuentasPanel, BorderLayout.CENTER);

        // Botones inferior: Cambiar tarjeta y Volver
        JButton btnCambiarTarjeta = new JButton("Cambiar tarjeta");
        JButton btnVolver = new JButton("Volver");

        JPanel cambiarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        cambiarPanel.add(btnCambiarTarjeta);
        cambiarPanel.add(btnVolver);

        btnVolver.addActionListener(e -> {
            dispose();
            new IngresoCliente(registro).setVisible(true);
        });

        add(cambiarPanel, BorderLayout.AFTER_LAST_LINE);

        // Footer
        JPanel footer = new JPanel(new GridLayout(1, 3));
        footer.setBackground(new Color(220, 214, 207));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel contacto = new JLabel("<html><b>CONTÁCTANOS</b><br>1234565465<br><br><b>UBICACIÓN</b><br>Calle Falsa 123</html>");
        JLabel trabaja = new JLabel("<html><b>TRABAJA CON NOSOTROS</b><br>Puestos disponibles<br><br><b>RECLAMOS O SUGERENCIAS</b></html>");
        JLabel vigilancia = new JLabel("<html><b>VIGILADOS POR</b><br>LOREM IPSUM DOLOR SIT AMET</html>");

        footer.add(contacto);
        footer.add(trabaja);
        footer.add(vigilancia);

        add(footer, BorderLayout.SOUTH);
    }
}
