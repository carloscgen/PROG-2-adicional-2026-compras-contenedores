
public class CondicionProductos extends Condicion {

	private int valor;//get set y contructor
	
	public boolean cumple(Compra cc) {
		// TODO Auto-generated method stub
		return cc.cantidadProductos() >valor;
	}

}
