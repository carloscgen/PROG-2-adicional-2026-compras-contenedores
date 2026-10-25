public class CajaMisteriosa extends Compra {

    public CajaMisteriosa(Destinatario des, double tiempoDeEntrega, double distancia) {
        super(des, tiempoDeEntrega, distancia);
    }

    public boolean tieneId(String id) {
        return true;
    }

    // OPCION 1
    public ElementoEnvio getCopia() {
        CajaMisteriosa cm = new CajaMisteriosa(getDestinatario(), getTiempoEstimadoEntrega(), getDistancia());
        for (String id : getCopiaIds()) {
            cm.agregarId(id);
        }
        if (estaEntregado()) {
            cm.marcarEntregado();
        }
        return cm;
    }

    // OPCION 2 USA NUEVO CONSTRUCTOR Y QUEDA OTRO getCopia
    // public CajaMisteriosa(CajaMisteriosa caja) {
    //     super(caja);
    // }

    // public ElementoEnvio getCopia() {
    //     return new CajaMisteriosa(this);
    // }
}
