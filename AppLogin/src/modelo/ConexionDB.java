/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
/**
 *
 * @author Lenovo
 */
public class ConexionDB {
     // ── Parámetros de conexión ───────────────────────── 
    private static final String URL      = "jdbc:mysql://localhost:3306/app_login"; 
    private static final String USUARIO  = "root";      // cambia si es necesario 
    private static final String PASSWORD = "monsalvo950590"; // tu contraseña MySQL 
    private static final String DRIVER   = "com.mysql.cj.jdbc.Driver"; 
 
    private static Connection conexion = null; 
 
    // ── Obtener conexión (Singleton) ────────────────── 
    public static Connection getConexion() { 
        try { 
            if (conexion == null || conexion.isClosed()) { 
                Class.forName(DRIVER); 
                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD); 
                System.out.println("Conexión establecida correctamente."); 
            } 
        } catch (ClassNotFoundException e) { 
            System.err.println("Driver JDBC no encontrado: " + e.getMessage()); 
        } catch (SQLException e) { 
            System.err.println("Error al conectar con MySQL: " + e.getMessage()); 
        } 
        return conexion; 
    } 
 
    // ── Cerrar conexión ─────────────────────────────── 
    public static void cerrarConexion() { 
        try { 
            if (conexion != null && !conexion.isClosed()) { 
                conexion.close(); 
                System.out.println("Conexión cerrada."); 
            } 
        } catch (SQLException e) { 
            System.err.println("Error al cerrar: " + e.getMessage()); 
        } 
    } 
}
