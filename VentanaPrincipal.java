/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*; 
/**
 *
 * @author Lenovo
 */
public class VentanaPrincipal extends JFrame {
     public VentanaPrincipal() { 
        setLayout(null); 
        setTitle("Mi Primera Aplicacion Swing"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } 
 
    public static void main(String[] args) { 
        VentanaPrincipal ventana = new VentanaPrincipal(); 
        // Centrar en pantalla: 
        int screenW = 
        java.awt.Toolkit.getDefaultToolkit().getScreenSize().width; 
        int screenH = 
        java.awt.Toolkit.getDefaultToolkit().getScreenSize().height; 
        ventana.setBounds((screenW - 1024) / 2, (screenH - 768) / 2, 1024, 768); 
        ventana.setVisible(true); 
    } 
} 

