package colegio.model;

/**
 *
 * @author Camilo Ternera, Diego Polo & Anderson Rueda
 */
public class Estudiantes {
    private int identificacion;
    private String nombre;
    private String apellido;
    private String nombreAcudiente;
    private String direccion;
    private int telefonoAcudiente;
    private String cursos;

    public Estudiantes() {
    }
    
    public Estudiantes(int identificacion, String nombre, String apellido, String nombreAcudiente, String direccion, int telefonoAcudiente, String cursos) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreAcudiente = nombreAcudiente;
        this.direccion = direccion;
        this.telefonoAcudiente = telefonoAcudiente;
        this.cursos = cursos;
    }

    public Estudiantes(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefonoAcudiente() {
        return telefonoAcudiente;
    }

    public void setTelefonoAcudiente(int telefonoAcudiente) {
        this.telefonoAcudiente = telefonoAcudiente;
    }

    public String getCursos() {
        return cursos;
    }

    public void setCursos(String cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Estudiantes{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", apellido=" + apellido + ", nombreAcudiente=" + nombreAcudiente + ", direccion=" + direccion + ", telefonoAcudiente=" + telefonoAcudiente + ", cursos=" + cursos + '}';
    }
    
}
