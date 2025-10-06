package restaurante.controller;

import restaurante.model.*;
import restaurante.service.PedidoService;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "Juan López", "3201112233");
        Empleado mesero = new Empleado(1, "Samuel Pérez", "Mesero");

        Plato hamburguesa = new Plato(1, "Hamburguesa", 18000, "Comida Rápida");
        Plato limonada = new Plato(2, "Limonada", 5000, "Bebida");

        Pedido pedido = new Pedido(1, cliente, mesero);
        pedido.agregarPlato(hamburguesa, 2);
        pedido.agregarPlato(limonada, 3);

        PedidoService service = new PedidoService();
        service.registrarPedido(pedido);
    }
}
