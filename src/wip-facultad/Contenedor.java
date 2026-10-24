import java.util.ArrayList;
import java.util.List;

public class Contenedor extends ElementoEnvio {
  private List<ElementoEnvio> elementos;

  public Contenedor() {
    super();
    elementos = new ArrayList<>();
  }

  public List<ElementoEnvio> getElementos() {
    return elementos;
  }

  @Override
  public String getCiudad() {
    if (elementos.size() > 0) {
      return elementos.get(0).getCiudad();
    }
    return null;
  }

  public void addElemento(ElementoEnvio elemento) {
    String ciudadElemento = elemento.getCiudad();
    String laOtra = this.getCiudad();
    if (ciudadElemento == null) {
      elementos.add(elemento);
    } else { // verificar que sea de la misma ciudad
      if (ciudadElemento.equals(laOtra)) {
        elementos.add(elemento);
      }
    }
  }

  @Override
  public boolean entregado() {
    // verificar si al menos uno esta entregado ya devuelvo true, sino false
    for (ElementoEnvio elemento : elementos) {
      if (!elemento.entregado()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int getTiempoEstimado() {
    int tiempoMaximo = 0;
    for (ElementoEnvio elemento : elementos) {
      if (elemento.getTiempoEstimado() > tiempoMaximo) {
        tiempoMaximo = elemento.getTiempoEstimado();
      }
    }
    return tiempoMaximo;
  }

  public int contarCompras(Condicion cc) {
    int contador = 0;
    for (ElementoEnvio elemento : elementos) {
      contador += elemento.contarCompras(cc);
    }
    return contador;
  }

  public ElementoEnvio getCopia() {
    Contenedor copia = new Contenedor();
    for (ElementoEnvio elemento : elementos) {
      copia.addElemento(elemento.getCopia());
    }
    return copia;
  }

}
