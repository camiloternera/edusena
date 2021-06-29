package colegio.model;

public class Profesores {
    
    private int cedulaProfesor;
    private String nombreProfesor;
    private String apellidoProfesor;
    private String sexoProfesor;
    private int telefonoProfesor;
    private String direccionProfesor;
    private String nombreCursos;

    /**
     * Sobre carga de constructores.
     * Cuando en una clase existen constructores múltiples, se dice que hay sobrecarga de constructores.
     */
    public Profesores() {
    }

    public Profesores(int cedulaProfesor) {
        this.cedulaProfesor = cedulaProfesor;
    }

    public Profesores(int cedulaProfesor, String nombreProfesor, String apellidoProfesor, String sexoProfesor, int telefonoProfesor, String direccionProfesor, String nombreCursos) {
        this.cedulaProfesor = cedulaProfesor;
        this.nombreProfesor = nombreProfesor;
        this.apellidoProfesor = apellidoProfesor;
        this.sexoProfesor = sexoProfesor;
        this.telefonoProfesor = telefonoProfesor;
        this.direccionProfesor = direccionProfesor;
        this.nombreCursos = nombreCursos;
    }
    
    //Getter and Setter

    public int getCedulaProfesor() {
        return cedulaProfesor;
    }

    public void setCedulaProfesor(int cedulaProfesor) {
        this.cedulaProfesor = cedulaProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public void setApellidoProfesor(String apellidoProfesor) {
        this.apellidoProfesor = apellidoProfesor;
    }

    public String getSexoProfesor() {
        return sexoProfesor;
    }

    public void setSexoProfesor(String sexoProfesor) {
        this.sexoProfesor = sexoProfesor;
    }

    public int getTelefonoProfesor() {
        return telefonoProfesor;
    }

    public void setTelefonoProfesor(int telefonoProfesor) {
        this.telefonoProfesor = telefonoProfesor;
    }

    public String getDireccionProfesor() {
        return direccionProfesor;
    }

    public void setDireccionProfesor(String direccionProfesor) {
        this.direccionProfesor = direccionProfesor;
    }

    public String getNombreCursos() {
        return nombreCursos;
    }

    public void setNombreCursos(String nombreCursos) {
        this.nombreCursos = nombreCursos;
    }

}
