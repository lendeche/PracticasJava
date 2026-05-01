/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package editornotas;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author Lenovo
 */
public class EditorNotas extends JFrame implements ActionListener {
private JTextArea areaNota; 
    private JScrollPane scroll; 
    private JTextField tfBuscar; 
    private JButton btnContar, btnBuscar, btnLimpiar, btnMayusculas; 
    private JLabel lblEstado; 
 
    public EditorNotas() { 
        setLayout(null); 
        setTitle("Editor de Notas"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
        areaNota = new JTextArea(); 
        areaNota.setLineWrap(true); 
        areaNota.setWrapStyleWord(true); 
        areaNota.getDocument().addDocumentListener(new DocumentListener() {

    public void insertUpdate(DocumentEvent e) {
        actualizarContador();
    }

    public void removeUpdate(DocumentEvent e) {
        actualizarContador();
    }

    public void changedUpdate(DocumentEvent e) {
        actualizarContador();
    }
});
        
        
        scroll = new JScrollPane(areaNota); 
        scroll.setBounds(10, 10, 560, 280); 
        add(scroll); 
 
        tfBuscar = new JTextField(); 
        tfBuscar.setBounds(10, 310, 200, 30); 
        add(tfBuscar); 
 
        btnBuscar = new JButton("Buscar"); 
        btnBuscar.setBounds(220, 310, 100, 30); 
        btnBuscar.addActionListener(this); 
        add(btnBuscar); 
        
         btnContar = new JButton("Contar palabras"); 
        btnContar.setBounds(330, 310, 160, 30); 
        btnContar.addActionListener(this); 
        add(btnContar); 
 
        btnLimpiar = new JButton("Limpiar"); 
        btnLimpiar.setBounds(480, 310, 100, 30); 
        btnLimpiar.addActionListener(this); 
        add(btnLimpiar); 
        
        btnMayusculas = new JButton("Mayúsculas");
        btnMayusculas.setBounds(400, 350, 150, 30);
        btnMayusculas.addActionListener(this);
        add(btnMayusculas);
 
        lblEstado = new JLabel("Listo."); 
        lblEstado.setBounds(10, 360, 560, 25); 
        add(lblEstado);
    } 
 
    @Override 
    public void actionPerformed(ActionEvent e) { 
        String texto = areaNota.getText(); 
 
        if (e.getSource() == btnContar) { 
            if (texto.trim().isEmpty()) { 
                lblEstado.setText("El area esta vacia."); 
            } else { 
                String[] palabras = texto.trim().split("\\s+"); 
                lblEstado.setText("Total de palabras: " + palabras.length); 
            } 
        } 
 
        if (e.getSource() == btnBuscar) { 
            String termino = tfBuscar.getText().trim(); 
            if (termino.isEmpty()) { 
                lblEstado.setText("Escribe algo en el campo de busqueda."); 
                return; 
            } 
            if (texto.contains(termino)) { 
                lblEstado.setText("Encontrado: '" + termino + "' en el texto."); 
            } else { 
                lblEstado.setText("No se encontro: '" + termino + "'"); 
            } 
        } 
 
        if (e.getSource() == btnLimpiar) { 
            areaNota.setText(""); 
            tfBuscar.setText(""); 
            lblEstado.setText("Listo."); 
        } 
        
        if (e.getSource() == btnMayusculas) {
    areaNota.setText(areaNota.getText().toUpperCase());
        }
    } 
    
    private void actualizarContador() {
    int caracteres = areaNota.getText().length();
    lblEstado.setText("Caracteres: " + caracteres);
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         EditorNotas editor = new EditorNotas(); 
        editor.setBounds(150, 100, 600, 430); 
        editor.setVisible(true);
    }
    
}
