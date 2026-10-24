public class ContenedorExpress extends Contenedor {
  private int restaTiempo;
  private int minimo;

  public ContenedorExpress(int restaTiempo, int minimo) {
    super();
    this.restaTiempo = restaTiempo;
    this.minimo = minimo;
  }

  public void setRestaTiempo(int restaTiempo) {
    this.restaTiempo = restaTiempo;
  }

  public void setMinimo(int minimo) {
    this.minimo = minimo;
  }

  public int getRestaTiempo() {
    return restaTiempo;
  }

  public int getMinimo() {
    return minimo;
  }

  public int getTiempoMaximo() {
    int aux = super.getTiempoEstimado() - restaTiempo;
    if (aux > minimo) {
      return aux;
    } else {
      return minimo;
    }
  }

  public ElementoEnvio getCopia() {
    ContenedorExpress copia = new ContenedorExpress(this.restaTiempo, this.minimo);
    for (ElementoEnvio elemento : super.getElementos()) {
      copia.addElemento(elemento.getCopia());
    }
    return copia;
  }

  public Contenedor getCopiaVacia() {
    return new ContenedorExpress(this.restaTiempo, this.minimo);
  }

}
