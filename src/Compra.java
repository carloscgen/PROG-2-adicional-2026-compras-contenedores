import java.util.ArrayList;
import java.util.List;

public class Compra extends ElementoEnvio {
  private List<String> ids;
  private Destinatario destinatario;
  private boolean entregado;
  private double tiempoEstimadoEntrega;
  private double distancia;

  public Compra(Destinatario des, double tiempoEstimadoEntrega, double distancia) {
    this.destinatario = des;
    this.tiempoEstimadoEntrega = tiempoEstimadoEntrega;
    this.distancia = distancia;
    this.ids = new ArrayList<>();
    this.entregado = false;
  }

  // OPCION 2 NECESITA OTRO CONSTRUCTOR NUEVO
  // public Compra(Compra compraParaCopiar) {
  // this.destinatario = compraParaCopiar.destinatario.getCopia();
  // this.ids = new ArrayList<>(compraParaCopiar.ids);
  // this.entregado = compraParaCopiar.entregado;
  // this.tiempoEstimadoEntrega = compraParaCopiar.tiempoEstimadoEntrega;
  // this.distancia = compraParaCopiar.distancia;
  // }

  public List<String> getCopiaIds() {
    return new ArrayList<>(this.ids);
  }

  public void agregarId(String id) {
    this.ids.add(id);
  }

  public int getCantIds() {
    return this.ids.size();
  }

  public Destinatario getDestinatario() {
    return this.destinatario.getCopia();
  }

  public void marcarEntregado() {
    this.entregado = true;
  }

  public boolean estaEntregado() {
    return this.entregado;
  }

  public double getDistancia() {
    return this.distancia;
  }

  public double getTiempoEstimadoEntrega() {
    return this.tiempoEstimadoEntrega;
  }

  public String getCiudadDestino() {
    return this.destinatario.getCiudad();
  }

  public int contarCompras(Condicion c) {
    if (c.cumple(this)) {
      return 1;
    } else {
      return 0;
    }
  }

  public boolean tieneId(String id) {
    return ids.contains(id);
  }

  // OPCION 1
  public ElementoEnvio getCopia() {
    Compra nuevaCompra = new Compra(getDestinatario(), tiempoEstimadoEntrega,
        distancia);

    // OPCION a
    for (String id : ids) {
      nuevaCompra.agregarId(id);
    }
    if (this.estaEntregado()) {
      nuevaCompra.marcarEntregado();
    }

    // OPCION b
    // nuevaCompra.ids = getCopiaIds();
    // nuevaCompra.entregado = this.estaEntregado();
    return nuevaCompra;
  }

  // OPCION 2
  // public ElementoEnvio getCopia() {
  // return new Compra(this);
  // }

  public ElementoEnvio getCopia(Condicion c) {
    if(c.cumple(this)) {
      return this.getCopia();
    } else {
      return null;
    }
  }
}
