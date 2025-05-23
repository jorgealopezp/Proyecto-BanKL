package co.edu.konradlorenz.view;

import co.edu.konradlorenz.model.ClienteNatural;
import co.edu.konradlorenz.model.Registro;
import co.edu.konradlorenz.model.TarjetaDebito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetiroCA extends JFrame {
    private TarjetaDebito tarjeta;

    public RetiroCA(Registro registro) {
        ClienteNatural cliente = registro.buscarClientePorDocumento(clienteId);
        if (cliente != null && cliente.getTarjetaDebito() != null) {
            this.tarjeta = cliente.getTarjetaDebito();
        } else {
            JOptionPane.showMessageDialog(this, "Cliente o tarjeta débito no encontrada.");
            dispose();
            return;
        }

        setTitle("Retiro con Tarjeta Débito");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblMonto = new JLabel("Monto a retirar:");
        JTextField txtMonto = new JTextField();
        JButton btnRetirar = new JButton("Retirar");
        JLabel lblResultado = new JLabel("");

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(lblMonto);
        panel.add(txtMonto);
        panel.add(new JLabel()); 
        panel.add(btnRetirar);
        panel.add(new JLabel()); 
        panel.add(lblResultado);

        btnRetirar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double monto = Double.parseDouble(txtMonto.getText());
                    if (tarjeta.retirar(monto)) {
                        lblResultado.setText("Retiro exitoso. Saldo actual: $" + tarjeta.getSaldo());
                    } else {
                        lblResultado.setText("Fondos insuficientes.");
                    }

                } catch (NumberFormatException ex) {
                    lblResultado.setText("Ingrese un monto válido.");
                }
            }
        });

        add(panel);
        setVisible(true);
    }
}
