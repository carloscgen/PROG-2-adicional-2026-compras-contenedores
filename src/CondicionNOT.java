public class CondicionNOT extends Condicion {
    private Condicion condicion;

    public CondicionNOT(Condicion condicion) {
        this.condicion = condicion;
    }

    public boolean cumple(Compra c) {
        return !condicion.cumple(c);
    }

}
