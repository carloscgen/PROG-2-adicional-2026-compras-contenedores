
public class ContenedorExpress extends Contenedor {

	private int restaTiempo;
	private int minimo;
	// PARA QUE SEAN STATIC DEBERIA DECIR ALGO DEL ESTILO
	// para todos los contenedores express se usa el mismo valor
	// si cambia cambia para todos

	public int getTiempoEstimado() {
		int aux = super.getTiempoEstimado() - restaTiempo;
		if (aux >= minimo) {
			return aux;
		} else
			return minimo;
	}

	public ContenedorExpress(int restaTiempo, int minimo) {
		super();
		this.restaTiempo = restaTiempo;
		this.minimo = minimo;
	}

	public int getRestaTiempo() {
		return restaTiempo;
	}

	public void setRestaTiempo(int restaTiempo) {
		this.restaTiempo = restaTiempo;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public Contenedor getCopiaVacia() {
		return new ContenedorExpress(restaTiempo, minimo);
	}

}
