/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*; 
import java.util.ArrayList; 
import java.util.List;
/**
 *
 * @author Lenovo
 */
public class UsuarioDAO {
     private Connection conn = ConexionDB.getConexion(); 
 
    // ══════════════════════════════════════════════════ 
    //  CREATE — Insertar nuevo usuario 
    // ══════════════════════════════════════════════════ 
    public boolean insertar(Usuario u) { 

        if (conn == null) {
            System.out.println("No hay conexión a la BD");
            return false;
        }

        String sql = "INSERT INTO usuarios (nombre, apellido, email, usuario, contrasena, foto) VALUES (?,?,?,?,?,?)"; 

        try (PreparedStatement ps = conn.prepareStatement(sql)) { 
            ps.setString(1, u.getNombre()); 
            ps.setString(2, u.getApellido()); 
            ps.setString(3, u.getEmail()); 
            ps.setString(4, u.getUsuario()); 
            ps.setString(5, u.getContrasena()); 

            if (u.getFoto() != null) { 
                ps.setBytes(6, u.getFoto()); 
            } else { 
                ps.setNull(6, Types.BLOB); 
            } 

            return ps.executeUpdate() > 0; 

        } catch (SQLException e) { 
            System.err.println("Error al insertar: " + e.getMessage()); 
            return false; 
        } 
    } 

    // ══════════════════════════════════════════════════ 
    //  READ — Login 
    // ══════════════════════════════════════════════════ 
    public Usuario login(String usuario, String contrasena) { 

        if (conn == null) {
            System.out.println("No hay conexión a la BD");
            return null;
        }

        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?"; 

        try (PreparedStatement ps = conn.prepareStatement(sql)) { 
            ps.setString(1, usuario); 
            ps.setString(2, contrasena); 

            ResultSet rs = ps.executeQuery(); 

            if (rs.next()) { 
                Usuario u = new Usuario(); 
                u.setId(rs.getInt("id")); 
                u.setNombre(rs.getString("nombre")); 
                u.setApellido(rs.getString("apellido")); 
                u.setEmail(rs.getString("email")); 
                u.setUsuario(rs.getString("usuario")); 
                u.setFoto(rs.getBytes("foto")); 
                return u; 
            } 

        } catch (SQLException e) { 
            System.err.println("Error en login: " + e.getMessage()); 
        } 

        return null; 
    } 

    // ══════════════════════════════════════════════════ 
    //  READ — Listar usuarios 
    // ══════════════════════════════════════════════════ 
    public List<Usuario> listarTodos() { 

        List<Usuario> lista = new ArrayList<>(); 

        if (conn == null) {
            System.out.println("No hay conexión a la BD");
            return lista;
        }

        String sql = "SELECT id, nombre, apellido, email, usuario FROM usuarios"; 

        try (Statement st = conn.createStatement(); 
             ResultSet rs = st.executeQuery(sql)) { 

            while (rs.next()) { 
                Usuario u = new Usuario(); 
                u.setId(rs.getInt("id")); 
                u.setNombre(rs.getString("nombre")); 
                u.setApellido(rs.getString("apellido")); 
                u.setEmail(rs.getString("email")); 
                u.setUsuario(rs.getString("usuario")); 
                lista.add(u); 
            } 

        } catch (SQLException e) { 
            System.err.println("Error al listar: " + e.getMessage()); 
        } 

        return lista; 
    } 

    // ══════════════════════════════════════════════════ 
    //  UPDATE 
    // ══════════════════════════════════════════════════ 
    public boolean actualizar(Usuario u) { 

        if (conn == null) {
            System.out.println("No hay conexión a la BD");
            return false;
        }

        String sql = "UPDATE usuarios SET nombre=?, apellido=?, email=?, contrasena=?, foto=? WHERE id=?"; 

        try (PreparedStatement ps = conn.prepareStatement(sql)) { 
            ps.setString(1, u.getNombre()); 
            ps.setString(2, u.getApellido()); 
            ps.setString(3, u.getEmail()); 
            ps.setString(4, u.getContrasena()); 
            ps.setBytes(5, u.getFoto()); 
            ps.setInt(6, u.getId()); 

            return ps.executeUpdate() > 0; 

        } catch (SQLException e) { 
            System.err.println("Error al actualizar: " + e.getMessage()); 
            return false; 
        } 
    } 

    // ══════════════════════════════════════════════════ 
    //  DELETE 
    // ══════════════════════════════════════════════════ 
    public boolean eliminar(int id) { 

        if (conn == null) {
            System.out.println("No hay conexión a la BD");
            return false;
        }

        String sql = "DELETE FROM usuarios WHERE id = ?"; 

        try (PreparedStatement ps = conn.prepareStatement(sql)) { 
            ps.setInt(1, id); 
            return ps.executeUpdate() > 0; 

        } catch (SQLException e) { 
            System.err.println("Error al eliminar: " + e.getMessage()); 
            return false; 
        } 
    } 

    // ══════════════════════════════════════════════════ 
    //  VALIDAR usuario existente 
    // ══════════════════════════════════════════════════ 
    public boolean usuarioExiste(String usuario) { 

        if (conn == null) {
            System.out.println("No hay conexión a la BD");
            return false;
        }

        String sql = "SELECT COUNT(*) FROM usuarios WHERE usuario = ?"; 

        try (PreparedStatement ps = conn.prepareStatement(sql)) { 
            ps.setString(1, usuario); 

            ResultSet rs = ps.executeQuery(); 

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) { 
            System.err.println("Error al validar: " + e.getMessage()); 
        } 

        return false; 
    } 
}