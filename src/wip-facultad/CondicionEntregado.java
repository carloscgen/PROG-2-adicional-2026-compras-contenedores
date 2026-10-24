
public class CondicionEntregado extends Condicion {
  public boolean cumple(Compra compra) {
    return compra.entregado();
  }

}
