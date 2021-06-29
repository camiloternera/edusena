package colegio.model;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Camilo Ternera, Diego Polo & Anderson Rueda
 */
public class EstudiantesDAO {
    
    private static final String SQL_SELECT = "SELECT identificacion, nombre_estudiantes, apellido_estudiantes, nombre_acudiente, direccion_estudiantes, telefono_acudiente, nombre_cursos FROM estudiantes";
    private static final String SQL_INSERT = "INSERT INTO estudiantes(identificacion, nombre_estudiantes, apellido_estudiantes, nombre_acudiente, direccion_estudiantes, telefono_acudiente, nombre_cursos) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE estudiantes SET nombre_estudiantes = ?, apellido_estudiantes = ?, nombre_acudiente = ?, direccion_estudiantes = ?, telefono_acudiente = ?, nombre_cursos = ? WHERE identificacion = ?";
    private static final String SQL_DELETE = "DELETE FROM estudiantes WHERE identificacion = ?";

    public List<Estudiantes> seleccionar() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        // Instancio la entidad Estudiantes.
        Estudiantes estudiante = null;

        List<Estudiantes> estudiantes = new ArrayList<>();

        try {
            //Llamamos el método getConnection() que realiza la conexión a la base de datos.
            conn = Conexion.getConnection();
            //Mandamos con el método prepareStatement(sql) 
            pstm = conn.prepareStatement(SQL_SELECT);
            // Ejecuta la consulta
            rs = pstm.executeQuery();

            while ( rs.next() ) {
                int identificacion = rs.getInt("identificacion");
                String nombreEstudiante = rs.getString("nombre_estudiantes");
                String apellidoEstudiante = rs.getString("apellido_estudiantes");
                String nombreAcudiente = rs.getString("nombre_acudiente");
                String direccionEstudiante = rs.getString("direccion_estudiantes");
                int telefonoAcudiente = rs.getInt("telefono_acudiente");
                String nombreCurso = rs.getString("nombre_cursos");

                //Llamamos al constructor Estudiantes de la entidad
                estudiante = new Estudiantes(identificacion, nombreEstudiante, apellidoEstudiante, nombreAcudiente, direccionEstudiante, telefonoAcudiente, nombreCurso);

                //Agrego la entidad (un estudiante) a un ArrayList<>();
                estudiantes.add(estudiante);
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
        return estudiantes;
    }
    
    public int insertar(Estudiantes estudiante){
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_INSERT);

            pstm.setInt(1, estudiante.getIdentificacion());
            pstm.setString(2, estudiante.getNombre());
            pstm.setString(3, estudiante.getApellido());
            pstm.setString(4, estudiante.getNombreAcudiente());
            pstm.setString(5, estudiante.getDireccion());
            pstm.setInt(6, estudiante.getTelefonoAcudiente());
            pstm.setString(7, estudiante.getCursos());

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

    public int actualizar(Estudiantes estudiante){
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_UPDATE);

            pstm.setString(1, estudiante.getNombre());
            pstm.setString(2, estudiante.getApellido());
            pstm.setString(3, estudiante.getNombreAcudiente());
            pstm.setString(4, estudiante.getDireccion());
            pstm.setInt(5, estudiante.getTelefonoAcudiente());
            pstm.setString(6, estudiante.getCursos());
            pstm.setInt(7, estudiante.getIdentificacion());

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

    public int eliminar(Estudiantes estudiante){
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_DELETE);

            pstm.setInt(1, estudiante.getIdentificacion());

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
