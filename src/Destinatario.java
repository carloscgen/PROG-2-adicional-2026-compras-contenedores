public class Destinatario {
  private String nombre;
  private String direccion;
  private String ciudad;
  private String apellido;

  public Destinatario(String nombre, String apellido, String direccion, String ciudad) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.direccion = direccion;
    this.ciudad = ciudad;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public String getDireccion() {
    return direccion;
  }

  public String getCiudad() {
    return ciudad;
  }
}
