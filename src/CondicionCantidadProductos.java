public class CondicionCantidadProductos extends Condicion {
    private int cantProd;

    public CondicionCantidadProductos(int cant) {
        this.cantProd = cant;
    }

    public boolean cumple(Compra c) {
        return c.getCantIds() > this.cantProd;
    }
}
