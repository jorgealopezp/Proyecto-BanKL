package co.edu.konradlorenz.view;

import co.edu.konradlorenz.model.ClienteNatural;
import co.edu.konradlorenz.model.Registro;
import co.edu.konradlorenz.model.TarjetaCredito;

import javax.swing.*;
import java.awt.*;

public class RetirarCC extends JFrame {
    private TarjetaCredito tarjeta;

    public RetirarCC(Registro registro) {
        ClienteNatural cliente = registro.buscarClientePorDocumento();
        if (cliente != null && cliente.getTarjetaCredito() != null) {
            this.tarjeta = cliente.getTarjetaCredito();
        } else {
            JOptionPane.showMessageDialog(this, "Cliente o tarjeta de crédito no encontrada.");
            dispose();
            return;
        }

        setTitle("Cuenta de crédito");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JLabel title = new JLabel("Cuenta de crédito", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel lblCupo = new JLabel("Su disponible es :");
        JLabel montoDisponible = new JLabel(String.format("%.1f$", tarjeta.getCupo()), SwingConstants.CENTER);
        montoDisponible.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel lblIngreso = new JLabel("Ingrese el valor que desea retirar:", SwingConstants.CENTER);
        JTextField txtMonto = new JTextField();

        JButton btnRetirar = new JButton("Retirar");

        panel.add(title);
        panel.add(lblCupo);
        panel.add(montoDisponible);
        panel.add(lblIngreso);
        panel.add(txtMonto);
        panel.add(btnRetirar);

        btnRetirar.addActionListener(e -> {
            try {
                double monto = Double.parseDouble(txtMonto.getText());
                if (tarjeta.retirar(monto)) {
                    JOptionPane.showMessageDialog(this, "Retiro exitoso. Nuevo disponible: $" + tarjeta.getCupo());
                } else {
                    JOptionPane.showMessageDialog(this, "Fondos insuficientes.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un monto válido.");
            }
        });

        add(panel);
        setVisible(true);
    }
}
