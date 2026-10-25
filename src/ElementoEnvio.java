public abstract class ElementoEnvio {
  public abstract boolean estaEntregado();

  public abstract String getCiudadDestino();

  public abstract double getTiempoEstimadoEntrega();

  public abstract int contarCompras(Condicion c);

  public abstract ElementoEnvio getCopia();

  public abstract ElementoEnvio getCopia(Condicion c);
}
