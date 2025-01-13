package udla.mcriollo.proyectofinal;

public class Cliente {

    private String nombre;
    private String cedula;
    private String direccion;

    public Cliente(String nombre, String cedula, String direccion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + ", Cédula: " + cedula + ", Dirección: " + direccion;
    }
}