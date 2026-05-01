/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appconmenu;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
/**
 *
 * @author Lenovo
 */
public class AppConMenu extends JFrame implements ActionListener {
    private JMenuBar menuBar; 
    private JMenu menuVista, menuTamano, menuAyuda; 
    private JMenuItem miRojo, miAzul, miVerde, miBlancoFondo; 
    private JMenuItem mi800, mi1024, miSalir, miAcerca; 
    private JLabel lblInfo; 
    private JMenuItem miMaximizar;
    private JMenu menuHerramientas;
    private JMenuItem miMensaje;
 
    public AppConMenu() { 
        setLayout(null); 
        setTitle("Aplicacion con Menu"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
        // ---- Construccion del menu ---- 
        menuBar = new JMenuBar(); 
        setJMenuBar(menuBar); 
 
        // Menu Vista 
        menuVista = new JMenu("Vista"); 
        menuBar.add(menuVista); 
 
        miRojo        = new JMenuItem("Fondo Rojo"); 
        miRojo.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
        miAzul        = new JMenuItem("Fondo Azul"); 
        miVerde       = new JMenuItem("Fondo Verde"); 
        miBlancoFondo = new JMenuItem("Restaurar fondo"); 
        miRojo.addActionListener(this); 
        miAzul.addActionListener(this); 
        miVerde.addActionListener(this); 
        miBlancoFondo.addActionListener(this); 
        menuVista.add(miRojo); 
        menuVista.add(miAzul); 
        menuVista.add(miVerde); 
        menuVista.addSeparator(); // Linea separadora 
        menuVista.add(miBlancoFondo); 
        
        menuHerramientas = new JMenu("Herramientas");
        miMensaje = new JMenuItem("Mostrar mensaje");
        miMensaje.addActionListener(this);
        menuHerramientas.add(miMensaje);
        menuVista.addSeparator();
        menuVista.add(menuHerramientas);
 
        // Menu Ventana (con submenu) 
        menuTamano = new JMenu("Ventana"); 
        menuBar.add(menuTamano); 
 
        mi800  = new JMenuItem("800 x 600"); 
        mi1024 = new JMenuItem("1024 x 768"); 
        miSalir = new JMenuItem("Salir"); 
        mi800.addActionListener(this); 
        mi1024.addActionListener(this); 
        miSalir.addActionListener(this); 
        menuTamano.add(mi800); 
        menuTamano.add(mi1024); 
        menuTamano.addSeparator(); 
        menuTamano.add(miSalir); 
 
        // Menu Ayuda 
        menuAyuda = new JMenu("Ayuda"); 
        menuBar.add(menuAyuda); 
        miAcerca = new JMenuItem("Acerca de..."); 
        miAcerca.addActionListener(this); 
        menuAyuda.add(miAcerca); 
        
        miMaximizar = new JMenuItem("Maximizar");
        miMaximizar.addActionListener(this);
        menuTamano.add(miMaximizar); // lo ponemos en "Ventana"
 
        // Contenido de la ventana 
        lblInfo = new JLabel("Usa el menu para interactuar"); 
        lblInfo.setBounds(20, 20, 400, 30); 
        add(lblInfo); 
    } 
 
    @Override 
    public void actionPerformed(ActionEvent e) { 
        Object src = e.getSource(); 
        Container fondo = getContentPane(); 
        
        if (src == miRojo)        fondo.setBackground(new Color(220, 80, 80)); 
        else if (src == miAzul)   fondo.setBackground(new Color(70, 130, 200)); 
        else if (src == miVerde)  fondo.setBackground(new Color(80, 200, 120)); 
        else if (src == miBlancoFondo) fondo.setBackground(null); 
        else if (src == mi800)    setSize(800, 600); 
        else if (src == mi1024)   setSize(1024, 768);
        else if (src == miMaximizar) { setExtendedState(JFrame.NORMAL); setExtendedState(JFrame.MAXIMIZED_BOTH); setVisible(true); }
        else if (src == miSalir) { int opcion = JOptionPane.showConfirmDialog( this, "¿Seguro que quieres salir?",  "Confirmación", JOptionPane.YES_NO_OPTION
    );

    if (opcion == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
}
        else if (src == miAcerca) { 
        
            JOptionPane.showMessageDialog(this, 
                "Practica de Menus con Swing\nVersion 1.0", 
                "Acerca de", JOptionPane.INFORMATION_MESSAGE); 
        } 
        else if (src == miMensaje) {
    JOptionPane.showMessageDialog(this, "Opción de herramientas activada");
}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AppConMenu app = new AppConMenu(); 
        app.setBounds(150, 100, 600, 400); 
        app.setVisible(true); 
    }
    
}
