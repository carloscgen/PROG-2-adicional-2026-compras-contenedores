
public class CondicionEntregado extends Condicion {

	@Override
	public boolean cumple(Compra cc) {
		// TODO Auto-generated method stub
		return cc.entregado();
	}

}
