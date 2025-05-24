package co.edu.konradlorenz.view;

import co.edu.konradlorenz.model.*;

import javax.swing.*;
import java.awt.*;

public class PagoCA extends JFrame {

    private TarjetaDebito tarjetaDebito;

    public PagoCA(Registro registro) {
<<<<<<< Updated upstream
        ClienteNatural cliente = registro.getClienteAutenticado();

=======
        ClienteNatural cliente = registro.buscarClientePorDocumento(getName());
>>>>>>> Stashed changes
        if (cliente != null && cliente.getTarjetaDebito() != null) {
            this.tarjetaDebito = cliente.getTarjetaDebito();
        } else {
            JOptionPane.showMessageDialog(this, "Cliente o tarjeta débito no encontrada.");
            dispose();
            return;
        }

        setTitle("Pago con Tarjeta Débito");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Encabezado
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(223, 215, 207));
        header.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel lblLogo = new JLabel("<html><span style='font-weight:bold; font-size:28px; color:#1A1F71;'>Ban<span style='color:#CCC;'>KL</span></span><br><span style='font-size:12px;'>Innovación financiera para tu futuro</span></html>");
        JLabel lblBienvenido = new JLabel("<html><div style='text-align:right;'>Hola,<br>Bienvenido</div></html>");
        JButton btnSalir = new JButton("Salir");
        btnSalir.setPreferredSize(new Dimension(80, 30));
        JPanel right = new JPanel(new BorderLayout());
        right.setOpaque(false);
        right.add(lblBienvenido, BorderLayout.CENTER);
        right.add(btnSalir, BorderLayout.SOUTH);

        header.add(lblLogo, BorderLayout.WEST);
        header.add(right, BorderLayout.EAST);

        // Título sección principal
        JPanel tituloPanel = new JPanel();
        tituloPanel.setBackground(new Color(92, 133, 160));
        JLabel lblTitulo = new JLabel("Cuentas");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        tituloPanel.add(lblTitulo);

        // Panel central de consignación
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        panelCentral.setBackground(Color.WHITE);
        panelCentral.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSaldo = new JLabel("Saldo:");
        lblSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSaldo.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel lblSaldoValor = new JLabel(String.format("%.2f$", tarjetaDebito.getSaldo()));
        lblSaldoValor.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSaldoValor.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel lblTexto = new JLabel("<html><div style='text-align: center;'>Ingrese el valor que desea<br>consignar a su cuenta de ahorros</div></html>");
        lblTexto.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTexto.setFont(new Font("Arial", Font.BOLD, 14));
        lblTexto.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        JTextField txtMonto = new JTextField();
        txtMonto.setMaximumSize(new Dimension(300, 30));
        txtMonto.setHorizontalAlignment(JTextField.CENTER);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setPreferredSize(new Dimension(120, 40));
        btnAceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAceptar.setBackground(new Color(92, 133, 160));
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setFocusPainted(false);
        btnAceptar.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel lblResultado = new JLabel("");
        lblResultado.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblResultado.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        btnAceptar.addActionListener(e -> {
            try {
                double monto = Double.parseDouble(txtMonto.getText());
                if (monto <= 0) {
                    lblResultado.setText("El monto debe ser mayor a cero.");
                    return;
                }

                tarjetaDebito.consignar(monto); 
                lblResultado.setText("Consignación exitosa. Nuevo saldo: $" + tarjetaDebito.getSaldo());
                lblSaldoValor.setText(String.format("%.2f$", tarjetaDebito.getSaldo()));
                txtMonto.setText("");
            } catch (NumberFormatException ex) {
                lblResultado.setText("Ingrese un monto válido.");
            }
        });

        panelCentral.add(lblSaldo);
        panelCentral.add(lblSaldoValor);
        panelCentral.add(lblTexto);
        panelCentral.add(txtMonto);
        panelCentral.add(Box.createRigidArea(new Dimension(0, 15)));
        panelCentral.add(btnAceptar);
        panelCentral.add(lblResultado);

        // Pie de página
        JPanel footer = new JPanel(new GridLayout(1, 3));
        footer.setBackground(new Color(223, 215, 207));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel lblContacto = new JLabel("<html><b>Contactanos</b><br>12314565465<br><br><b>Ubicacion</b><br>Calle Falsa 123</html>");
        JLabel lblTrabajo = new JLabel("<html><b>Trabaja Con Nosotros</b><br>Puestos disponibles<br><br>Reclamos o Sugerencias</html>");
        JLabel lblVigilado = new JLabel("<html><b>Vigilados por</b><br>Lorem ipsum dolor sit amet</html>");

        footer.add(lblContacto);
        footer.add(lblTrabajo);
        footer.add(lblVigilado);

        // Agregar todo al frame
        add(header, BorderLayout.NORTH);
        add(tituloPanel, BorderLayout.CENTER);
        add(panelCentral, BorderLayout.SOUTH);
        add(footer, BorderLayout.PAGE_END);

        setVisible(true);
    }
}
