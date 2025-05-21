package co.edu.konradlorenz.view;

import co.edu.konradlorenz.model.Registro;

import javax.swing.*;
import java.awt.*;

public class IngresoCliente extends JFrame {

    private Registro registro;

    public IngresoCliente(Registro registro) {
        this.registro = registro;

        setTitle("Panel del Cliente - BanKL");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Encabezado
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(220, 214, 207));
        header.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel logoLabel = new JLabel("<html><span style='font-size:28px; font-weight:bold; color:#001f4d;'>Ban</span><span style='font-size:28px; font-weight:bold;'>KL</span><br>Innovación financiera para tu futuro</html>");
        header.add(logoLabel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setOpaque(false);

        JLabel welcomeLabel = new JLabel("<html><div style='text-align:right;'>Hola,<br>Bienvenido</div></html>");
        JButton logoutButton = new JButton("Salir");

        logoutButton.addActionListener(e -> {
            dispose();
            new HomePage(registro).setVisible(true); // ← error aquí
        });

        rightPanel.add(welcomeLabel, BorderLayout.CENTER);
        rightPanel.add(logoutButton, BorderLayout.EAST);
        header.add(rightPanel, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // Centro
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        String[] botones = {"Cuentas", "Divisas", "Alertas"};
        for (String txt : botones) {
            JButton btn = new JButton(txt);
            btn.setPreferredSize(new Dimension(100, 40));
            btn.setBackground(new Color(100, 149, 237));
            btn.setForeground(Color.WHITE);
            btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.BLACK, 1),
                    BorderFactory.createEmptyBorder(5, 15, 5, 15)));
            btn.setFocusPainted(false);
            buttonPanel.add(btn);
        }

        ImageIcon iconoOriginal = new ImageIcon("E:/Programacion/tecnicasDeProgramacion/BanKL/Proyecto-BanKL/Imagenes proyecto/app.png");
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(500, 200, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        JLabel imageLabel = new JLabel(iconoEscalado, SwingConstants.CENTER);

        centerPanel.add(buttonPanel, BorderLayout.NORTH);
        centerPanel.add(imageLabel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Footer
        JPanel footer = new JPanel(new GridLayout(1, 3));
        footer.setBackground(new Color(220, 214, 207));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        footer.add(new JLabel("<html><b>CONTÁCTANOS</b><br>1234565465<br><br><b>UBICACIÓN</b><br>Calle Falsa 123</html>"));
        footer.add(new JLabel("<html><b>TRABAJA CON NOSOTROS</b><br>Puestos disponibles<br><br><b>RECLAMOS O SUGERENCIAS</b></html>"));
        footer.add(new JLabel("<html><b>VIGILADOS POR</b><br>LOREM IPSUM DOLOR SIT AMET</html>"));

        add(footer, BorderLayout.SOUTH);
    }
}
