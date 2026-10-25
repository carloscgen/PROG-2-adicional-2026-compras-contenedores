public class CondicionCompraEntregada extends Condicion {

    public boolean cumple(Compra c) {
        return c.estaEntregado();

    }
}
