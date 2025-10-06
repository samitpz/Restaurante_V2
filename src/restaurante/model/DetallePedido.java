package restaurante.model;

public class DetallePedido {
    private Plato plato;
    private int cantidad;

    public DetallePedido(Plato plato, int cantidad) {
        this.plato = plato;
        this.cantidad = cantidad;
    }

    public Plato getPlato() { return plato; }
    public int getCantidad() { return cantidad; }
    public double getSubtotal() { return plato.getPrecio() * cantidad; }

    @Override
    public String toString() {
        return plato.getNombre() + " x" + cantidad + " = $" + getSubtotal();
    }
}
