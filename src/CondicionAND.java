
public class CondicionAND extends Condicion {
  private Condicion c1;
  private Condicion c2;

  public CondicionAND(Condicion c1, Condicion c2) {
    this.c1 = c1;
    this.c2 = c2;
  }

  // PODEMOS ESCRIBIR EN EL EXAMEN QUE EL OR ES IGUAL PERO CON ||
  public boolean cumple(Compra compra) {
    return c1.cumple(compra) && c2.cumple(compra);
  }

  public Condicion getC1() {
    return c1;
  }

  public Condicion getC2() {
    return c2;
  }

  public void setC1(Condicion c1) {
    this.c1 = c1;
  }

  public void setC2(Condicion c2) {
    this.c2 = c2;
  }

}
