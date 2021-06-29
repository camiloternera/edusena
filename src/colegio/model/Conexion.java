package colegio.model;

import java.sql.*;
/**
 *
 * @author Camilo Ternera, Diego Polo & Anderson Rueda
 */
public class Conexion {
    
    // Creo las variables que iran como argumento en el DriverManager();
    private static final String JDBC_DATABSE = "colegio";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/"+JDBC_DATABSE+"?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    
    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }
    
    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }
    
    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
