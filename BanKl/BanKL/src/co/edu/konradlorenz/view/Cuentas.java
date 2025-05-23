package co.edu.konradlorenz.view;
import co.edu.konradlorenz.model.Registro;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Cuentas extends JFrame {

    public Cuentas(Registro registro) {
        setTitle("Cuentas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header superior con logo
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(220, 215, 210));

        JLabel logo = new JLabel("<html><div style='font-family:sans-serif;'>"
                + "<span style='font-size:30px;'>"
                + "<b style='color:#001F4E;'>Ban</b><b style='color:#FFFFFF;'>KL</b>"
                + "</span><br>"
                + "<span style='font-size:12px;'>Innovación financiera para tu futuro</span></div></html>");
        logo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
        header.add(logo, BorderLayout.WEST);
        add(header, BorderLayout.NORTH);

        // Panel central con cuentas
        JPanel centro = new JPanel(new GridLayout(1, 2, 20, 0));
        centro.setBorder(new EmptyBorder(20, 20, 20, 20));
        centro.setBackground(Color.WHITE);

        centro.add(crearPanelCuenta("Cuenta de ahorros", "13214564", "0.00", "", "1234", "12/24", "Ingresar", "Retirar"));
        centro.add(crearPanelCuenta("Cuenta de crédito", "13214564", "0.00", "200.00", "1234", "12/24", "Pagar", "Retirar"));

        add(centro, BorderLayout.CENTER);

        // Panel inferior con botones generales
        JPanel inferior = new JPanel();
        inferior.setBorder(new EmptyBorder(10, 10, 10, 10));
        inferior.setBackground(Color.WHITE);

        JButton cambiarBtn = new JButton("Cambiar tarjeta");
        JButton volverBtn = new JButton("Volver");
        estilizarBoton(cambiarBtn);
        estilizarBoton(volverBtn);

        inferior.add(cambiarBtn);
        inferior.add(volverBtn);
        add(inferior, BorderLayout.SOUTH);
    }

    private JPanel crearPanelCuenta(String titulo, String numero, String saldoODuuda, String disponible, String ult4Digitos, String vencimiento, String boton1, String boton2) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        panel.setBackground(Color.WHITE);

        JLabel tituloLabel = new JLabel(titulo, SwingConstants.CENTER);
        tituloLabel.setOpaque(true);
        tituloLabel.setBackground(new Color(0x4177C5));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tituloLabel.setPreferredSize(new Dimension(panel.getWidth(), 30));
        panel.add(tituloLabel, BorderLayout.NORTH);

        String htmlDatos = "<html><div style='font-size:13px; padding: 10px;'>"
                + "<b>Número:</b> " + numero + "<br>";

        if (titulo.contains("ahorros")) {
            htmlDatos += "<b>Saldo:</b> " + saldoODuuda + "$<br>";
        } else {
            htmlDatos += "<b>Deuda:</b> " + saldoODuuda + "$<br>"
                    + "<b>Disponible:</b> " + disponible + "$<br>";
        }

        htmlDatos += "<br><b>Últimos 4 dígitos:</b> " + ult4Digitos + "<br>"
                + "<b>Vencimiento:</b> " + vencimiento + "</div></html>";

        JLabel datosLabel = new JLabel(htmlDatos);
        datosLabel.setBorder(new EmptyBorder(10, 20, 10, 20));
        panel.add(datosLabel, BorderLayout.CENTER);

        JPanel botones = new JPanel(new GridLayout(2, 1, 10, 10));
        botones.setBackground(Color.WHITE);
        botones.setBorder(new EmptyBorder(10, 50, 20, 50));

        JButton b1 = new JButton(boton1);
        JButton b2 = new JButton(boton2);
        estilizarBoton(b1);
        estilizarBoton(b2);

        botones.add(b1);
        botones.add(b2);

        panel.add(botones, BorderLayout.SOUTH);

        return panel;
    }

    private void estilizarBoton(JButton boton) {
        boton.setBackground(new Color(230, 230, 250));
        boton.setForeground(Color.BLACK);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180)),
                new EmptyBorder(5, 15, 5, 15)));
    }
}
