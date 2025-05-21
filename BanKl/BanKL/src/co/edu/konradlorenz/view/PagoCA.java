package co.edu.konradlorenz.view;

import co.edu.konradlorenz.model.TarjetaDebito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagoCA extends JFrame {

    private JLabel lblSaldoActual;
    private JTextField txtValor;
    private JButton btnAceptar, btnSalir;

    private TarjetaDebito tarjetaDebito; // Referencia a la cuenta

    public PagoCA(TarjetaDebito tarjetaDebito) {
        this.tarjetaDebito = tarjetaDebito;

        setTitle("Consignar a cuenta de ahorros");
        setSize(950, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(220, 214, 207));
        header.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel logoLabel = new JLabel("<html><span style='font-size:28px; font-weight:bold; color:#001f4d;'>Ban</span><span style='font-size:28px; font-weight:bold;'>KL</span><br>Innovación financiera para tu futuro</html>");
        header.add(logoLabel, BorderLayout.WEST);

        JPanel headerRight = new JPanel(new BorderLayout());
        headerRight.setOpaque(false);
        JLabel welcomeLabel = new JLabel("<html><div style='text-align:right;'>Hola,<br>Bienvenido</div></html>", SwingConstants.RIGHT);
        headerRight.add(welcomeLabel, BorderLayout.CENTER);
        btnSalir = new JButton("Salir");
        headerRight.add(btnSalir, BorderLayout.EAST);

        header.add(headerRight, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // Título
        JLabel titulo = new JLabel("Cuentas", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setOpaque(true);
        titulo.setBackground(new Color(100, 149, 237));
        titulo.setForeground(Color.WHITE);
        titulo.setPreferredSize(new Dimension(100, 50));
        add(titulo, BorderLayout.BEFORE_FIRST_LINE);

        // Panel central
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));
        panelCentral.setBackground(Color.WHITE);

        lblSaldoActual = new JLabel("Saldo:\n" + tarjetaDebito.getSaldo() + "$", SwingConstants.CENTER);
        lblSaldoActual.setFont(new Font("Arial", Font.BOLD, 18));
        lblSaldoActual.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblTexto = new JLabel("Ingrese el valor que desea consignar a su cuenta de ahorros", SwingConstants.CENTER);
        lblTexto.setFont(new Font("Arial", Font.BOLD, 14));
        lblTexto.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTexto.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        txtValor = new JTextField(10);
        txtValor.setMaximumSize(new Dimension(200, 30));
        txtValor.setHorizontalAlignment(SwingConstants.CENTER);
        txtValor.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setPreferredSize(new Dimension(120, 40));
        btnAceptar.setBackground(new Color(100, 149, 237));
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAceptar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        panelCentral.add(lblSaldoActual);
        panelCentral.add(lblTexto);
        panelCentral.add(txtValor);
        panelCentral.add(Box.createRigidArea(new Dimension(0, 20)));
        panelCentral.add(btnAceptar);

        add(panelCentral, BorderLayout.CENTER);

        // Footer
        JPanel footer = new JPanel(new GridLayout(1, 3));
        footer.setBackground(new Color(220, 214, 207));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel contacto = new JLabel("<html><b>CONTÁCTANOS</b><br>12314565465<br><br><b>UBICACIÓN</b><br>Calle Falsa 123</html>");
        JLabel trabaja = new JLabel("<html><b>TRABAJA CON NOSOTROS</b><br>Puestos disponibles<br><br><b>RECLAMOS O SUGERENCIAS</b></html>");
        JLabel vigilancia = new JLabel("<html><b>VIGILADOS POR</b><br>LOREM IPSUM DOLOR SIT AMET</html>");

        footer.add(contacto);
        footer.add(trabaja);
        footer.add(vigilancia);

        add(footer, BorderLayout.SOUTH);

        // Listeners
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consignarValor();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana
            }
        });
    }

    private void consignarValor() {
        try {
            double valor = Double.parseDouble(txtValor.getText());
            if (valor <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor positivo mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            tarjetaDebito.consignar(valor);
            actualizarSaldo(tarjetaDebito.getSaldo());
            JOptionPane.showMessageDialog(this, "Consignación exitosa.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            txtValor.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarSaldo(double nuevoSaldo) {
        lblSaldoActual.setText("Saldo:\n" + nuevoSaldo + "$");
    }

}
