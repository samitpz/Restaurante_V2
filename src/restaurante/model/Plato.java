package restaurante.model;

public class Plato {
    private int id;
    private String nombre;
    private double precio;
    private String categoria;

    public Plato(int id, String nombre, double precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}
