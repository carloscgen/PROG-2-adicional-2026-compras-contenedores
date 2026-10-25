import java.util.ArrayList;

public class Compra extends ElementoEnvio {

	private Destinatario destino; //get y set

	protected ArrayList<String> ids;// add y contains
	
	private int tiempoEstimado;// get y set
	
	private double distancia;//get y set
	
	
	
	
	
	
	
	
	public Compra(Destinatario destino, int tiempoEstimado, double distancia) {
		super();
		this.destino = destino;
		this.tiempoEstimado = tiempoEstimado;
		this.distancia = distancia;
		entregado = false;
		ids = new ArrayList<String>();
	}
	public Destinatario getDestino() {
		return destino;
	}
	public void setDestino(Destinatario destino) {
		this.destino = destino;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	private boolean entregado;
	
	
	public void entregar() {
		entregado = true;
	}
	public void setEntregado(boolean ee) {
		entregado = ee;
	}
	
	public  boolean entregado() {
		return entregado;
	};
	
	public void setTiempoEstimado(int tt) {
		tiempoEstimado = tt;
	}
	
	public  int getTiempoEstimado() {
		return tiempoEstimado;
	};
	
	public String getCiudad() {
		if (destino!=null)
	    	return destino.getCiudad();
		else
			return null;
	}
	
	
	
	public void addId(String id) {
		ids.add(id.toUpperCase());
	}
	
	public boolean contieneId(String id) {
		return ids.contains(id.toUpperCase());
		// utiliza equals de String
	}
	
	public int cantidadProductos() {
		return ids.size();
	}
	
	public int contarCompras(Condicion cc) {
		if (cc.cumple(this)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	public ElementoEnvio getCopia() {
		
		Compra copia = this.getCompraVacia();
	
	    for(int i = 0; i<ids.size(); i++) {
	    	copia.addId(ids.get(i));
	    	
	    }
	    return copia;
	}
	
	public Compra getCompraVacia() {
		return new Compra(destino, tiempoEstimado, distancia);
	};
	
	
	public ElementoEnvio getCopia(Condicion cc) {
		if (cc.cumple(this)) {
			return this.getCopia();
		} else {
			return null;
		}
	}
}
