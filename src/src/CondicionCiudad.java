
public class CondicionCiudad extends Condicion {

	private String ciudad;//get y set constructor
	
	public boolean cumple(Compra cc) {
		// TODO Auto-generated method stub
		return cc.getCiudad().equals(ciudad);
	}

}
