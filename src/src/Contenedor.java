import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Contenedor extends ElementoEnvio {

	protected ArrayList<ElementoEnvio> els;
	Comparator<ElementoEnvio> criterio;//get y set
	
	
	
	public Contenedor() {
		
		els = new ArrayList<ElementoEnvio>();
	}

	
	public String getCiudad() {
	
		//Primer elemento
		
		if (els.size()>0) {
			return els.get(0).getCiudad();
		} else {
			return null;
		}
	    // el elemento en la posicion 0 .....
		// dos lineas mas abajo dice elemento en la posicion 5
		/**if (els.size()>posicion) {
		 
			return els.get(posicion).getCiudad();
		}*/
		//posicion es un atributo de la clase;
	
	}
	
	public void addElemento(ElementoEnvio ee) {
		String miCiudad = this.getCiudad();
		String laOtra = ee.getCiudad();
		
		if ((miCiudad == null)||(miCiudad.equals(laOtra))) {
			els.add(ee);
			//por los ejemplos hablados en clase
			Collections.sort(els,criterio);
		} 
	}

	@Override
	public boolean entregado() {
		for(int i = 0; i<els.size(); i++) {
			ElementoEnvio ee = els.get(i);
			if (!ee.entregado())
				return false;
		}
		return true;
	}

	@Override
	public int getTiempoEstimado() {
		int maximo = -1;
		
		for(int i=0; i< els.size(); i++) {
			ElementoEnvio ee = els.get(i);
			int aux = ee.getTiempoEstimado();
			if (aux > maximo) {
				maximo = aux;
			}
		}
		
		return maximo;
	}

	
	public int contarCompras(Condicion cc) {
		int suma = 0;
		for(int i = 0; i< els.size(); i++) {
			ElementoEnvio ee = els.get(i);
			suma = suma + ee.contarCompras(cc);
		}
		return suma;
		
	}
	
	public ElementoEnvio getCopia() {
		Contenedor copia = this.getCopiaVacia();
		for(int i= 0; i<els.size(); i++) {
			ElementoEnvio ee = els.get(i);
			copia.addElemento(ee.getCopia());
		}
		return copia;
		
	}
	
	public Contenedor getCopiaVacia() {
		return new Contenedor();
	}
	
	public ElementoEnvio getCopia(Condicion cc) {
		Contenedor copia = this.getCopiaVacia();
		boolean agregoAlgo = false;
		for(int i= 0; i<els.size(); i++) {
			ElementoEnvio ee = els.get(i);
			
			ElementoEnvio aux = ee.getCopia(cc);
			if (aux != null) {
				agregoAlgo = true;
				copia.addElemento(aux);
			}
		
		}
		if (agregoAlgo)
	    	return copia;
		else
			return null;
	}
	
}
