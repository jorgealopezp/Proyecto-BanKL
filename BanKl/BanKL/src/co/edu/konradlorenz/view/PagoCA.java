package co.edu.konradlorenz.view;

import co.edu.konradlorenz.model.ClienteNatural;
import co.edu.konradlorenz.model.Registro;
import co.edu.konradlorenz.model.TarjetaDebito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagoCA extends JFrame {
    private TarjetaDebito tarjetaDebito;

    public PagoCA(Registro registro) {
        ClienteNatural cliente = registro.buscarClientePorDocumento(getName()):
        if (cliente != null && cliente.getTarjetaDebito() != null) {
            this.tarjetaDebito = cliente.getTarjetaDebito();
        } else {
            JOptionPane.showMessageDialog(this, "Cliente o tarjeta débito no encontrada.");
            dispose();
            return;
        }

        setTitle("Pago con Tarjeta Débito");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblMonto = new JLabel("Monto del pago:");
        JTextField txtMonto = new JTextField();
        JButton btnPagar = new JButton("Pagar");
        JLabel lblResultado = new JLabel("");

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(lblMonto);
        panel.add(txtMonto);
        panel.add(new JLabel());
        panel.add(btnPagar);
        panel.add(new JLabel());
        panel.add(lblResultado);

        btnPagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double monto = Double.parseDouble(txtMonto.getText());
                    if (tarjetaDebito.realizarPago(monto)) {
                        lblResultado.setText("Pago exitoso. Saldo actual: $" + tarjetaDebito.getSaldo());
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
