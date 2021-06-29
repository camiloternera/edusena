package colegio.model;

import java.sql.*;
import java.util.*;

public class CursosDAO {
    
    private static final String SQL_SELECT = "SELECT codigo_cursos, nombre_cursos, duracion_cursos, estudiantes_cursos, profesores_cursos FROM cursos";
    private static final String SQL_INSERT = "INSERT INTO cursos(codigo_cursos, nombre_cursos, duracion_cursos, estudiantes_cursos, profesores_cursos) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE cursos SET nombre_cursos = ?, duracion_cursos = ?, estudiantes_cursos = ?, profesores_cursos = ? WHERE codigo_cursos = ?";
    private static final String SQL_DELETE = "DELETE FROM cursos WHERE codigo_cursos = ?";
    
    public List<Cursos> seleccionar() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        Cursos curso = null;

        List<Cursos> cursos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_SELECT);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int codigoCursos = rs.getInt("codigo_cursos");
                String nombreCursos = rs.getString("nombre_cursos");
                int duracionCursos = rs.getInt("duracion_cursos");
                int estudiantesCursos = rs.getInt("estudiantes_cursos");
                int profesoresCursos = rs.getInt("profesores_cursos");

                curso = new Cursos(codigoCursos, nombreCursos, duracionCursos, estudiantesCursos, profesoresCursos);

                cursos.add(curso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                Conexion.close(rs);
                Conexion.close(pstm);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return cursos;
    }

    public int insertar(Cursos curso) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_INSERT);

            pstm.setString(1, curso.getNombreCursos());
            pstm.setInt(2, curso.getDuracionCursos());
            pstm.setInt(3, curso.getEstudiantesCursos());
            pstm.setInt(4, curso.getProfesoresCursos());

            registro = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                Conexion.close(pstm);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registro;
    }

    public int actualizar(Cursos curso) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_UPDATE);

            pstm.setString(1, curso.getNombreCursos());
            pstm.setInt(2, curso.getDuracionCursos());
            pstm.setInt(3, curso.getEstudiantesCursos());
            pstm.setInt(4, curso.getProfesoresCursos());

            registro = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                Conexion.close(pstm);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registro;
    }

    public int eliminar(Cursos curso){
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_DELETE);

            pstm.setInt(1, curso.getCodigoCursos());

            //Nos regresa el numero de registros afectados.
            registro = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                Conexion.close(pstm);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registro;
    }

}
