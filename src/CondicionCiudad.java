
public class CondicionCiudad extends Condicion {
  private String ciudad;

  public CondicionCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public boolean cumple(Compra compra) {
    return compra.getCiudad().equals(ciudad);
  }

}
