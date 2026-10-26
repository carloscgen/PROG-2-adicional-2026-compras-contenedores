public class ContenedorExpress extends Contenedor {

    private final static double TIEMPO_RESTA = 5;
    private final static double TIEMPO_MINIMO = 1;

    public double getTiempoEstimadoEntrega() {
        double tiempoEstimadoContenedor = super.getTiempoEstimadoEntrega();
        double tiempoEntregaFinal = tiempoEstimadoContenedor - TIEMPO_RESTA;

        if (tiempoEntregaFinal > TIEMPO_MINIMO) {
            return tiempoEntregaFinal;
        }

        return TIEMPO_MINIMO;
    }

    protected Contenedor crearCopiaVacia() {
        return new ContenedorExpress();
    }

}
