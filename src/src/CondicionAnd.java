
public class CondicionAnd extends Condicion {

  private Condicion c1,c2; //get set y constructor
	public boolean cumple(Compra cc) {
		// TODO Auto-generated method stub
		return c1.cumple(cc) && c2.cumple(cc);
		            // el or es igual pero con ||
	}

}
