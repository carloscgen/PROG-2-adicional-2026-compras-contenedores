import java.util.ArrayList;
import java.util.List;

public class Contenedor extends ElementoEnvio {
  private List<ElementoEnvio> elementos;

  public Contenedor() {
    this.elementos = new ArrayList<>();
  }

  public String getCiudadDestino() {
    if (elementos.isEmpty()) {
      return null;
    }
    return elementos.get(0).getCiudadDestino();

  }

  public double getTiempoEstimadoEntrega() {
    double tiempoTotal = 0;

    for (ElementoEnvio elementoEnvio : elementos) {
      if (elementoEnvio.getTiempoEstimadoEntrega() > tiempoTotal) {
        tiempoTotal = elementoEnvio.getTiempoEstimadoEntrega();

      }
    }
    return tiempoTotal;
  }

  public boolean estaEntregado() {
    for (ElementoEnvio elementoEnvio : elementos) {
      if (!elementoEnvio.estaEntregado()) {
        return false;
      }
    }
    return true;
  }

  public void agregarElemento(ElementoEnvio el) {
    String ciudadDestinoElemento = el.getCiudadDestino();
    // un elemento sin ciudad (contenedor vacío) no se agrega
    if (ciudadDestinoElemento == null) {
      return;
    }

    String ciudadContenedor = this.getCiudadDestino();

    // se agrega si la ciudad del contenedor no está determinada, o si coincide con
    // la del elemento
    if (ciudadContenedor == null || (ciudadContenedor.equals(ciudadDestinoElemento))) {
      elementos.add(el);
    }
  }

  public int contarCompras(Condicion c) {
    int total = 0;

    for (ElementoEnvio elementoEnvio : elementos) {
      total += elementoEnvio.contarCompras(c);
    }
    return total;
  }

  protected Contenedor crearCopiaVacia() {
    return new Contenedor();
  }

  public ElementoEnvio getCopia() {

    Contenedor cc = crearCopiaVacia();

    for (ElementoEnvio elementoEnvio : elementos) {
      cc.agregarElemento(elementoEnvio.getCopia());
    }
    return cc;
  }

  public ElementoEnvio getCopia(Condicion c) {
    Contenedor con = crearCopiaVacia();
    for (ElementoEnvio el : elementos) {
      ElementoEnvio elementoCopia = el.getCopia(c);
      if (elementoCopia != null) {
        con.agregarElemento(elementoCopia);
      }
    }
    if (!con.elementos.isEmpty()) {
      return con;
    }
    return null;
  }
}