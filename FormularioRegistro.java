/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formularioregistro;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
/**
 *
 * @author Lenovo
 */
public class FormularioRegistro  extends JFrame implements ActionListener {
 private JLabel lblNombre, lblApellido, lblEdad, lblTitulo, lblResultado; 
    private JTextField tfNombre, tfApellido, tfEdad; 
    private JButton btnRegistrar, btnLimpiar; 
 
    public FormularioRegistro() { 
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
        // Titulo decorativo en la ventana 
        lblTitulo = new JLabel("Formulario de Registro"); 
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16)); 
        lblTitulo.setBounds(100, 15, 280, 30); 
        add(lblTitulo); 
 
        lblNombre = new JLabel("Nombre:"); 
        lblNombre.setBounds(20, 65, 100, 25); 
        add(lblNombre); 
 
        tfNombre = new JTextField(); 
        tfNombre.setBounds(130, 65, 220, 25); 
        add(tfNombre); 
 
        lblApellido = new JLabel("Apellido:"); 
        lblApellido.setBounds(20, 105, 100, 25); 
        add(lblApellido); 
 
        tfApellido = new JTextField(); 
        tfApellido.setBounds(130, 105, 220, 25); 
        add(tfApellido); 
 
        lblEdad = new JLabel("Edad:"); 
        lblEdad.setBounds(20, 145, 100, 25); 
        add(lblEdad); 
 
        tfEdad = new JTextField(); 
        tfEdad.setBounds(130, 145, 80, 25); 
        add(tfEdad); 
 
        btnRegistrar = new JButton("Registrar"); 
        btnRegistrar.setBounds(130, 195, 120, 35); 
        btnRegistrar.addActionListener(this); 
        add(btnRegistrar); 
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(260, 195, 100, 35);
        btnLimpiar.addActionListener(this);
        add(btnLimpiar);
        
        lblResultado = new JLabel("");
        lblResultado.setBounds(20, 240, 350, 25);
        add(lblResultado);
 } 
 
    @Override 
    
     public void actionPerformed(ActionEvent e) { 
        if (e.getSource() == btnRegistrar) { 
            String nombre   = tfNombre.getText().trim(); 
            String apellido = tfApellido.getText().trim(); 
            String edadStr  = tfEdad.getText().trim(); 
 
            // Validacion basica 
            if (nombre.isEmpty() || apellido.isEmpty() || edadStr.isEmpty()) { 
                lblResultado.setText("ERROR: Completa todos los campos"); 
                return; 
            } 
            try { 
                int edad = Integer.parseInt(edadStr); 
                lblResultado.setText(nombre + " " + apellido + " - " + edad + " años"); 
            } catch (NumberFormatException ex) { 
                lblResultado.setText("ERROR: La edad debe ser un numero entero"); 
            } 
        } 
        if (e.getSource() == btnLimpiar) {
            tfNombre.setText("");
            tfApellido.setText("");
            tfEdad.setText("");
            lblResultado.setText("");
    }
 }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FormularioRegistro f = new FormularioRegistro(); 
        f.setBounds(200, 200, 400, 290); 
        f.setVisible(true); 
    }
    
}
