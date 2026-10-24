import java.util.ArrayList;
import java.util.List;

public class Contenedor extends ElementoEnvio {
  private List<ElementoEnvio> elementos;

  public Contenedor() {
    this.elementos = new ArrayList<ElementoEnvio>();
  }

  public String getCiudadEnvio() {
    if (elementos.isEmpty()) {
      return null;
    }
    return elementos.get(0).getCiudadEnvio();
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

}
