package co.edu.konradlorenz.view;

import java.awt.*;
import javax.swing.*;

public class Registro extends JFrame {
    public Registro() {
        setTitle("BanKL - Registro");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(220, 215, 210));
        JLabel logo = new JLabel("<html><div style='font-family:sans-serif;'>"
                + "<span style='font-size:30px;'>"
                + "<b style='color:#001F4E;'>Ban</b><b style='color:#FFFFFF;'>KL</b>"
                + "</span><br>"
                + "<span style='font-size:12px;'>Innovación financiera para tu futuro</span></div></html>");
        logo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
        header.add(logo, BorderLayout.WEST);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(60, 300, 60, 300));

        formPanel.add(createInput("Nombres*"));
        formPanel.add(createInput("Numero de documento*"));
        formPanel.add(createInput("Clave digital*"));

        JButton registerButton = new JButton("Regístrate");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setPreferredSize(new Dimension(150, 40));
        registerButton.setMaximumSize(new Dimension(150, 40));
        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(registerButton);

        JPanel footer = new JPanel(new GridLayout(1, 3));
        footer.setBackground(new Color(220, 215, 210));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        footer.add(new JLabel("<html><b>Contactanos</b><br>1234565465<br><br><b>Ubicación</b><br>Calle Falsa 123</html>"));
        footer.add(new JLabel("<html><center><b>Trabaja Con Nosotros</b><br>Puestos disponibles<br><br>Reclamos o Sugerencias</center></html>", SwingConstants.CENTER));
        footer.add(new JLabel("<html><center><b>Vigilados por</b><br>Lorem ipsum dolor sit amet</center></html>", SwingConstants.RIGHT));

        add(header, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }

    private JPanel createInput(String labelText) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        panel.add(label, BorderLayout.NORTH);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }
}