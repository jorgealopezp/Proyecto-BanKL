package co.edu.konradlorenz.view;

import co.edu.konradlorenz.model.ClienteNatural;
import co.edu.konradlorenz.model.Registro;

import javax.swing.*;
import java.awt.*;

public class IngresoV extends JFrame {
    private Registro registro;
    private JTextField campoDocumento;
    private JPasswordField campoClave;

    public IngresoV(Registro registro) {
        this.registro = registro;

        setTitle("BanKL - Ingreso");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(220, 215, 210));
        JLabel logo = new JLabel("<html><div style='font-family:sans-serif;'>"
                + "<span style='font-size:30px;'>"
                + "<b style='color:#001F4E;'>Ban</b><b style='color:#FFFFFF;'>KL</b>"
                + "</span><br>"
                + "<span style='font-size:12px;'>Innovación financiera para tu futuro</span></div></html>");
        logo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
        header.add(logo, BorderLayout.WEST);

        // Form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(60, 300, 60, 300));

        campoDocumento = new JTextField();
        campoClave = new JPasswordField();

        addLabeledField(formPanel, "Número de documento*", campoDocumento);
        addLabeledField(formPanel, "Clave digital*", campoClave);

        JButton loginButton = new JButton("Ingresar");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setMaximumSize(new Dimension(150, 40));
        loginButton.addActionListener(e -> validarIngreso());

        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(loginButton);

        // Footer
        JPanel footer = new JPanel(new GridLayout(1, 3));
        footer.setBackground(new Color(220, 215, 210));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        footer.add(new JLabel("<html><b>Contáctanos</b><br>1234565465<br><br><b>Ubicación</b><br>Calle Falsa 123</html>"));
        footer.add(new JLabel("<html><center><b>Trabaja Con Nosotros</b><br>Puestos disponibles<br><br>Reclamos o Sugerencias</center></html>", SwingConstants.CENTER));
        footer.add(new JLabel("<html><center><b>Vigilados por</b><br>Lorem ipsum dolor sit amet</center></html>", SwingConstants.RIGHT));

        add(header, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }

    private void addLabeledField(JPanel panel, String labelText, JComponent field) {
        JLabel label = new JLabel(labelText);
        field.setMaximumSize(new Dimension(250, 30));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(label);
        panel.add(field);
        panel.add(Box.createVerticalStrut(10));
    }

    private void validarIngreso() {
        String documento = campoDocumento.getText().trim();
        String clave = new String(campoClave.getPassword()).trim();

        if (documento.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ClienteNatural cliente = registro.buscarClientePorDocumento(documento);
        if (cliente != null && cliente.getContraseña().equals(clave)) {
            JOptionPane.showMessageDialog(this, "Ingreso exitoso.");
            dispose();
            new HomePage(registro).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Documento o clave incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

