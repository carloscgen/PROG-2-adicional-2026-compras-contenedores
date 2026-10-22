
public class CondicionCantidadProductos extends Condicion {
  private int cantidad;

  public CondicionCantidadProductos(int cantidad) {
    this.cantidad = cantidad;
  }

  public boolean cumple(Compra compra) {
    return compra.cantidadProductos() > cantidad;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
}
