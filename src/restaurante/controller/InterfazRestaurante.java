package restaurante.controller;

import restaurante.model.*;
import restaurante.service.PedidoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazRestaurante extends JFrame {

    private JComboBox<String> comboEntrada;
    private JComboBox<String> comboPlatoFuerte;
    private JComboBox<String> comboPostre;
    private JComboBox<String> comboBebida;
    private JButton btnPedir;
    private JTextArea areaResultado;

    public InterfazRestaurante() {
        setTitle("🍽 Restaurante Samuel");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        // Componentes
        comboEntrada = new JComboBox<>(new String[]{"Ninguna", "Ensalada", "Sopa del día", "Empanadas"});
        comboPlatoFuerte = new JComboBox<>(new String[]{"Ninguno", "Pasta Alfredo", "Carne Asada", "Pollo a la Plancha"});
        comboPostre = new JComboBox<>(new String[]{"Ninguno", "Flan", "Helado", "Tiramisú"});
        comboBebida = new JComboBox<>(new String[]{"Ninguna", "Limonada", "Coca Cola", "Jugo Natural"});

        btnPedir = new JButton("Realizar Pedido");
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        // Agregar al panel
        panel.add(new JLabel("🍴 Entrada:"));
        panel.add(comboEntrada);
        panel.add(new JLabel("🍝 Plato Fuerte:"));
        panel.add(comboPlatoFuerte);
        panel.add(new JLabel("🍰 Postre:"));
        panel.add(comboPostre);
        panel.add(new JLabel("🥤 Bebida:"));
        panel.add(comboBebida);
        panel.add(btnPedir);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        // Acción del botón
        btnPedir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPedido();
            }
        });
    }

    private void realizarPedido() {
        Cliente cliente = new Cliente(1, "Cliente Restaurante", "3201112233");
        Empleado mesero = new Empleado(1, "Samuel Pérez", "Mesero");
        Pedido pedido = new Pedido(1, cliente, mesero);

        // Entradas
        if (!comboEntrada.getSelectedItem().equals("Ninguna")) {
            pedido.agregarPlato(new Plato(1, comboEntrada.getSelectedItem().toString(), 8000, "Entrada"), 1);
        }

        // Plato fuerte
        if (!comboPlatoFuerte.getSelectedItem().equals("Ninguno")) {
            pedido.agregarPlato(new Plato(2, comboPlatoFuerte.getSelectedItem().toString(), 18000, "Plato Fuerte"), 1);
        }

        // Postre
        if (!comboPostre.getSelectedItem().equals("Ninguno")) {
            pedido.agregarPlato(new Plato(3, comboPostre.getSelectedItem().toString(), 9000, "Postre"), 1);
        }

        // Bebida
        if (!comboBebida.getSelectedItem().equals("Ninguna")) {
    <?xml version="1.0" encoding="UTF-8"?>
                    <web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
            https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
            version="5.0">

                    <display-name>Restaurante Samuel</display-name>

                    <servlet>
                    <servlet-name>PedidoServlet</servlet-name>
                    <servlet-class>restaurante.controller.PedidoServlet</servlet-class>
    </servlet>

                    <servlet-mapping>
                    <servlet-name>PedidoServlet</servlet-name>
                    <url-pattern>/pedido</url-pattern>
                    </servlet-mapping>

                    </web-app>
                    pedido.agregarPlato(new Plato(4, comboBebida.getSelectedItem().toString(), 5000, "Bebida"), 1);
        }

        PedidoService service = new PedidoService();
        service.registrarPedido(pedido);

        areaResultado.setText("✅ Pedido Realizado\n\n");
        areaResultado.append("Cliente: " + cliente.getNombre() + "\n\n");
        pedido.mostrarPedido();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazRestaurante ventana = new InterfazRestaurante();
            ventana.setVisible(true);
        });
    }
}
