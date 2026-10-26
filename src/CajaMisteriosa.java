public class CajaMisteriosa extends Compra {

    public CajaMisteriosa(Destinatario des, double tiempoDeEntrega, double distancia) {
        super(des, tiempoDeEntrega, distancia);
    }

    public boolean tieneId(String id) {
        return true;
    }

    protected Compra crearCopiaInicial() {
        CajaMisteriosa cm = new CajaMisteriosa(getDestinatario(), getTiempoEstimadoEntrega(), getDistancia());
        return cm;
    }

}
