public class ContenedorExpress extends Contenedor {

    private final static double tiempoResta = 5;
    private final static double tiempoMinimo = 1;

    public double getTiempoEstimadoEntrega() {
        double tiempoEstimadoContenedor = super.getTiempoEstimadoEntrega();
        double tiempoEntregaFinal = tiempoEstimadoContenedor - tiempoResta;

        if (tiempoEntregaFinal > tiempoMinimo) {
            return tiempoEntregaFinal;
        }

        return tiempoMinimo;
    }

    public Contenedor crearCopiaVacia() {
        return new ContenedorExpress();
    }

}
