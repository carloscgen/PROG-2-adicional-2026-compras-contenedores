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
    this.ids = new ArrayList<String>();
    this.entregado = false;
  }

  public void agregarId(String id) {
    this.ids.add(id);
  }

  public List<String> getIds() {
    return new ArrayList<String>(this.ids);
  }

  public Destinatario getDestinatario() {
    return this.destinatario;
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

  public String getCiudadEnvio() {
    return this.destinatario.getCiudad();
  }
}
