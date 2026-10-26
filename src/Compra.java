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

  protected Compra crearCopiaInicial() {
    Compra nuevaCompra = new Compra(getDestinatario(), tiempoEstimadoEntrega,
        distancia);
    return nuevaCompra;
  }

  protected void agregarInfo(Compra c) {
    // OPCION a
    for (String id : ids) {
      c.agregarId(id);
    }
    if (this.estaEntregado()) {
      c.marcarEntregado();
    }

    // OPCION b
    // c.ids = getCopiaIds();
    // c.entregado = this.estaEntregado();
  }

  public ElementoEnvio getCopia() {
    Compra nuevaCompra = crearCopiaInicial();
    agregarInfo(nuevaCompra);
    return nuevaCompra;
  }

  public ElementoEnvio getCopia(Condicion c) {
    if (c.cumple(this)) {
      return this.getCopia();
    } else {
      return null;
    }
  }
}
