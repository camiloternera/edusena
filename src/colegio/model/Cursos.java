package colegio.model;

public class Cursos {

    private int codigoCursos;
    private String nombreCursos;
    private int duracionCursos;
    private int estudiantesCursos;
    private int profesoresCursos;

    public Cursos() {
    }

    public Cursos(int codigoCursos) {
        this.codigoCursos = codigoCursos;
    }

    public Cursos(String nombreCursos, int duracionCursos, int estudiantesCursos, int profesoresCursos) {
        this.nombreCursos = nombreCursos;
        this.duracionCursos = duracionCursos;
        this.estudiantesCursos = estudiantesCursos;
        this.profesoresCursos = profesoresCursos;
    }

    public Cursos(int codigoCursos, String nombreCursos, int duracionCursos, int estudiantesCursos, int profesoresCursos) {
        this.codigoCursos = codigoCursos;
        this.nombreCursos = nombreCursos;
        this.duracionCursos = duracionCursos;
        this.estudiantesCursos = estudiantesCursos;
        this.profesoresCursos = profesoresCursos;
    }

    public int getCodigoCursos() {
        return codigoCursos;
    }

    public void setCodigoCursos(int codigoCursos) {
        this.codigoCursos = codigoCursos;
    }

    public String getNombreCursos() {
        return nombreCursos;
    }

    public void setNombreCursos(String nombreCursos) {
        this.nombreCursos = nombreCursos;
    }

    public int getDuracionCursos() {
        return duracionCursos;
    }

    public void setDuracionCursos(int duracionCursos) {
        this.duracionCursos = duracionCursos;
    }

    public int getEstudiantesCursos() {
        return estudiantesCursos;
    }

    public void setEstudiantesCursos(int estudiantesCursos) {
        this.estudiantesCursos = estudiantesCursos;
    }

    public int getProfesoresCursos() {
        return profesoresCursos;
    }

    public void setProfesoresCursos(int profesoresCursos) {
        this.profesoresCursos = profesoresCursos;
    }

}
