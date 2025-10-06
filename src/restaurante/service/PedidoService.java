package restaurante.service;

import restaurante.model.*;

public class PedidoService {
    public void registrarPedido(Pedido pedido) {
        System.out.println("Registrando pedido...");
        pedido.mostrarPedido();
        System.out.println("✅ Pedido guardado correctamente");
    }
}
