public class CondicionCiudadDestino extends Condicion {

    private String ciudadDestino; //get y set constructor

    public CondicionCiudadDestino(String ciudad) {
        this.ciudadDestino = ciudad;
    }

    public boolean cumple(Compra c) {
        return ciudadDestino.equals(c.getCiudadDestino());
    }

}
