public class CajaMisteriosa extends Compra {

  public CajaMisteriosa(Destinatario destino, int tiempoEstimado, int distancia) {
    super(destino, tiempoEstimado, distancia);
  }

  public boolean contieneId(String id) {
    return true;
  }

  public ElementoEnvio getCopia() {
    CajaMisteriosa copia = this.getCompraVacia();
    for (String id : this.getIds()) {
      copia.addId(id);
    }
    return copia;
  }

  public Compra getCompraVacia() {
    return new CajaMisteriosa(getDestino(), getTiempoEstimado(), getDistancia());
  }

}
