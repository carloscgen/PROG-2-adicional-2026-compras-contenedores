
public abstract class ElementoEnvio implements Comparable<ElementoEnvio>{

	
	public abstract String getCiudad();
	public abstract boolean entregado();
	public abstract int getTiempoEstimado();
	
	public abstract int contarCompras(Condicion cc);
	
	public abstract  ElementoEnvio    getCopia();
	public abstract  ElementoEnvio    getCopia(Condicion cc);
	
	public int compareTo(ElementoEnvio ee) {
		int miDist = this.getTiempoEstimado();
		int otro = ee.getTiempoEstimado();
		return miDist - otro;
		
	}
}
