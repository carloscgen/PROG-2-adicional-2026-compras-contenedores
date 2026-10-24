import java.util.ArrayList;
import java.util.List;

public class Compra extends ElementoEnvio {

  private Destinatario destino;
  protected List<String> ids;
  private int tiempoEstimado;
  private boolean entregado;
  private int distancia;

  public Compra(Destinatario destino, int tiempoEstimado, int distancia) {
    super();
    this.destino = destino;
    this.tiempoEstimado = tiempoEstimado;
    this.distancia = distancia;
    entregado = false;
    this.ids = new ArrayList<String>();
  }

  public int getDistancia() {
    return distancia;
  }

  public Destinatario getDestino() {
    return this.destino;
  }

  public void setTiempoEstimado(int tiempoEstimado) {
    this.tiempoEstimado = tiempoEstimado;
  }

  public int getTiempoEstimado() {
    return tiempoEstimado;
  }

  public void addId(String id) {
    ids.add(id.toUpperCase());
  }

  public boolean contieneId(String id) {
    return ids.contains(id);
  }

  public int contarCompras(Condicion cc) {
    if (cc.cumple(this)) {
      return 1;
    }
    return 0;
  }

  @Override
  public String getCiudad() {
    if (destino == null) {
      return null;
    }
    return destino.getCiudad();
  }

  public int cantidadProductos() {
    return ids.size();
  }

  @Override
  public boolean entregado() {
    return entregado;
  }

  public void setEntregado() {
    entregado = true;
  }

  public ElementoEnvio getCopia() {
    Compra copia = new Compra(destino, tiempoEstimado, distancia);

    // opcion 1
    for (String id : this.ids) {
      copia.addId(id);
    }

    // opcion 2
    // copia.ids = new ArrayList<>(this.ids);
    return copia;
  }

  public Compra getCompraVacia() {
    return new Compra(destino, tiempoEstimado, distancia);
  }

  public ElementoEnvio getCopia(Condicion cc) {
    if (cc.cumple(this)) {
      return this.getCopia();
    }
    return null;

  }

}
