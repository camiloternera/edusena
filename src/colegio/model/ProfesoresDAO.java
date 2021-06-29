package colegio.model;

import java.sql.*;
import java.util.*;

public class ProfesoresDAO {

    private static final String SQL_SELECT = "SELECT cedula_profesor, nombre_profesor, apellido_profesor, sexo_profesor, telefono_profesor, direccion_profesor, nombre_cursos FROM profesores";
    private static final String SQL_INSERT = "INSERT INTO profesore, sexo_profesor, telefono_profesor, direccion_profesor, nombre_cursos) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE profesores SET nombre_profesor = ?, apellido_profesor = ?, sexo_profesor = ?, telefono_profesor = ?, direccion_profesor = ?, nombre_cursos = ? WHERE cedula_profesor = ?";
    private static final String SQL_DELETE = "DELETE FROM profesores WHERE cedula_profesor = ?";
    
    public List<Profesores> seleccionar() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        Profesores profesor = null;

        List<Profesores> profesores = new ArrayList<>();

        try {
            // Llamamos el método getConnection() que realiza la conexión a la base de datos.
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_SELECT);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                int cedulaProfesor = rs.getInt("cedula_profesor");
                String nombreProfesor = rs.getString("nombre_profesor");
                String apellidoProfesor = rs.getString("apellido_profesor");
                String sexoProfesor = rs.getString("sexo_profesor");
                int telefonoProfesor = rs.getInt("telefono_profesor");
                String direccionProfesor = rs.getString("direccion_profesor");
                String nombreCursos = rs.getString("nombre_cursos");

                //Llamamos al constructor Profesores de la entidad
                profesor = new Profesores(cedulaProfesor, nombreProfesor, apellidoProfesor, sexoProfesor, telefonoProfesor, direccionProfesor, nombreCursos);

                //Agrego la entidad (un Profesor) a un ArrayList<>();
                profesores.add(profesor);
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
        return profesores;
    }
    
    public int insertar(Profesores profesor){
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_INSERT);

            pstm.setInt(1, profesor.getCedulaProfesor());
            pstm.setString(2, profesor.getNombreProfesor());
            pstm.setString(3, profesor.getApellidoProfesor());
            pstm.setString(4, profesor.getSexoProfesor());
            pstm.setInt(6, profesor.getTelefonoProfesor());
            pstm.setString(5, profesor.getDireccionProfesor());
            pstm.setString(7, profesor.getNombreCursos());

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

    public int actualizar(Profesores profesor){
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_UPDATE);

            pstm.setString(1, profesor.getNombreProfesor());
            pstm.setString(2, profesor.getApellidoProfesor());
            pstm.setString(3, profesor.getSexoProfesor());
            pstm.setInt(5, profesor.getTelefonoProfesor());
            pstm.setString(4, profesor.getDireccionProfesor());
            pstm.setString(6, profesor.getNombreCursos());
            pstm.setInt(7, profesor.getCedulaProfesor());

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

    public int eliminar(Profesores profesor){
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_DELETE);

            pstm.setInt(1, profesor.getCedulaProfesor());

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