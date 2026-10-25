public class Destinatario {
  private String nombre;
  private String apellido;
  private String direccion;
  private String ciudad;

  public Destinatario(String nombre, String apellido, String direccion, String ciudad){
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

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public Destinatario getCopia(){
    return new Destinatario(nombre, apellido, direccion, ciudad);
  }
}
