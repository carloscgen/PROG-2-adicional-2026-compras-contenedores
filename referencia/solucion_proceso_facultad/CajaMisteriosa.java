
public class CajaMisteriosa extends Compra {

	public CajaMisteriosa(Destinatario destino, int tiempoEstimado, double distancia) {
		super(destino, tiempoEstimado, distancia);
		
	}

	public boolean contieneId(String id) {
		return true;
	}
	
	
	public Compra getCompraVacia() {
		return new CajaMisteriosa(getDestino(), getTiempoEstimado(), getDistancia());
	}
}
