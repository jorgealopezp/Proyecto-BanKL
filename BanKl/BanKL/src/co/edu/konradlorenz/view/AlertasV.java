package co.edu.konradlorenz.view;

import co.edu.konradlorenz.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AlertasV extends JFrame {

    private Registro registro;
    private AlertasBancarias alertas;

    public AlertasV(Registro registro) {
        this.registro = registro;
        this.alertas = registro.getAlertas(); 

        setTitle("Alertas - BanKL");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Encabezado
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(220, 214, 207));
        header.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel logoLabel = new JLabel("<html><span style='font-size:28px; font-weight:bold; color:#001f4d;'>Ban</span><span style='font-size:28px; font-weight:bold;color:#ffffff'>KL</span><br>Innovación financiera para tu futuro</html>");
        header.add(logoLabel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setOpaque(false);

        JLabel welcomeLabel = new JLabel("<html><div style='text-align:right;'>Hola,<br>Bienvenido</div></html>");
        JButton logoutButton = new JButton("Salir");
        logoutButton.addActionListener(e -> {
            dispose();
            new HomePage(registro).setVisible(true);
        });

        rightPanel.add(welcomeLabel, BorderLayout.CENTER);
        rightPanel.add(logoutButton, BorderLayout.EAST);
        header.add(rightPanel, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // Centro - contenido de alertas
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel titulo = new JLabel("Alertas");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        titulo.setForeground(Color.WHITE);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(100, 149, 237));
        titlePanel.setMaximumSize(new Dimension(800, 50));
        titlePanel.add(titulo);
        centerPanel.add(titlePanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel subTitulo = new JLabel("Lista de alertas");
        subTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        subTitulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        centerPanel.add(subTitulo);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextArea areaAlertas = new JTextArea(10, 60);
        areaAlertas.setEditable(false);
        areaAlertas.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaAlertas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JScrollPane scrollPane = new JScrollPane(areaAlertas);
        centerPanel.add(scrollPane);

        cargarAlertas(areaAlertas);

        // Botón para volver
        JButton volverButton = new JButton("Volver");
        volverButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        volverButton.addActionListener(e -> {
            new IngresoCliente(registro).setVisible(true);
            dispose();
        });

        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(volverButton);
        add(centerPanel, BorderLayout.CENTER);

        // Pie de página
        JPanel footer = new JPanel(new GridLayout(1, 3));
        footer.setBackground(new Color(220, 214, 207));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        footer.add(new JLabel("<html><b>CONTÁCTANOS</b><br>1234565465<br><br><b>UBICACIÓN</b><br>Calle Falsa 123</html>"));
        footer.add(new JLabel("<html><b>TRABAJA CON NOSOTROS</b><br>Puestos disponibles<br><br><b>RECLAMOS O SUGERENCIAS</b></html>"));
        footer.add(new JLabel("<html><b>VIGILADOS POR</b><br>LOREM IPSUM DOLOR SIT AMET</html>"));
        add(footer, BorderLayout.SOUTH);
    }

 private void cargarAlertas(JTextArea area) {
    List<Alerta> alertasLista = alertas.revisarAlertas();

    if (alertasLista.isEmpty()) {
        area.setText("No hay alertas registradas.");
        return;
    }

    StringBuilder sb = new StringBuilder();
    for (Alerta alerta : alertasLista) {
        sb.append("ID: ").append(alerta.getId())
          .append(" | Tipo: ").append(alerta.getTipo())
          .append(" | Descripción: ").append(alerta.getDescripcion())
          .append("\n");
    }

    area.setText(sb.toString());
}
}
