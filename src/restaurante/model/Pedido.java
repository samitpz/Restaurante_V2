package restaurante.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private Empleado mesero;
    private List<DetallePedido> detalles;
    private double total;

    public Pedido(int id, Cliente cliente, Empleado mesero) {
        this.id = id;
        this.cliente = cliente;
        this.mesero = mesero;
        this.detalles = new ArrayList<>();
    }

    public void agregarPlato(Plato plato, int cantidad) {
        detalles.add(new DetallePedido(plato, cantidad));
        calcularTotal();
    }

    public void calcularTotal() {
        total = detalles.stream().mapToDouble(DetallePedido::getSubtotal).sum();
    }

    public double getTotal() { return total; }

    public void mostrarPedido() {
        System.out.println("Pedido #" + id + " - Cliente: " + cliente.getNombre());
        detalles.forEach(System.out::println);
        System.out.println("Total a pagar: $" + total);
    }
}
