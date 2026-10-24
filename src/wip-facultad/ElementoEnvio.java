public abstract class ElementoEnvio implements Comparable<ElementoEnvio> {
  public abstract String getCiudad();

  public abstract boolean entregado();

  public abstract int getTiempoEstimado();

  public int compareTo(ElementoEnvio otro) {
    // opcion 1
    return this.getTiempoEstimado() - otro.getTiempoEstimado();
    // opcion 2
    // return Integer.compare(this.getTiempoEstimado(), otro.getTiempoEstimado());
  }

  public abstract int contarCompras(Condicion cc);

  public abstract ElementoEnvio getCopia();

  public abstract ElementoEnvio getCopia(Condicion cc);
}
