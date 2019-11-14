/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclusos;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import java.sql.*;
import javax.swing.table.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author FAROL
 */
public class CartaAntecedentesPenales extends javax.swing.JFrame {

    /**
     * Creates new form CartaAntecedentesPenales
     */
    public CartaAntecedentesPenales(ExpedirCarta ec) {
        initComponents();
        setLocationRelativeTo(null);
        this.ec = ec;
        curp = new ArrayList<>();
        pintaDatos();
        fuente = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL);
        fuenteBold = new Font(Font.FontFamily.COURIER, 22, Font.BOLD);
        fuenteItalica = new Font(Font.FontFamily.COURIER, 10, Font.ITALIC);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCartas = new javax.swing.JTable();
        comboCartas = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel1.setText("Carta De Antecedentes Penales");

        tablaCartas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaCartas);

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboCartas, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(248, 248, 248))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(136, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CartaAntecedentesPenales.this.dispose();
        ec.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        generarCartas(evt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pintaDatos() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[] {"Nombre", "Apellidos", "Estado"});
        
        try {
            Connection miConexion = Conexion.dameConexion();
            ResultSet rs = null;
            Statement sentencia = miConexion.createStatement();
            
            String sqlRecuperaCartas = "SELECT curp, nombre, apellido, estado FROM recluso WHERE estado = 'Libre'";
            rs = sentencia.executeQuery(sqlRecuperaCartas);
            
            comboCartas.removeAllItems();
            
            while(rs.next()) {
                curp.add(rs.getString("curp"));
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellido");
                estado = rs.getString("estado");
                
                modelo.addRow(new Object[] {nombre, apellidos, estado});
                comboCartas.addItem(nombre + " " + apellidos);
            }
            
            rs.close();
            miConexion.close();
        } catch(Exception e) { e.printStackTrace(); }
        
        tablaCartas.setModel(modelo);
    }
    
    private void generarCartas(java.awt.event.ActionEvent evt) {
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.requestFocus();
        int r = jf.showOpenDialog(CartaAntecedentesPenales.this);
        
        if(r == JFileChooser.APPROVE_OPTION) {
            File f = jf.getSelectedFile();
            String ruta = f.getPath();
            
            try {
                Document doc = new Document(PageSize.A4);
                PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/" + curp.get(comboCartas.getSelectedIndex()) + ".pdf"));
                doc.open();
                
                Image imagen = Image.getInstance("./src/imgs/Escudo.jpg");
                imagen.scaleAbsolute(600, 125);
                imagen.setAlignment(Element.ALIGN_CENTER);
                doc.add(imagen);
                doc.add(getCabecera(CABECERA, curp.get(comboCartas.getSelectedIndex())));
                doc.add(getInfo(armarCuerpo(curp.get(comboCartas.getSelectedIndex()))));
                doc.add(getFirmas(colocarFirmas()));
                doc.add(getFooter(FOOTER));
                doc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
 
    private Paragraph getCabecera(String texto, String curp) {
        try {
            Connection miConexion = Conexion.dameConexion();
            ResultSet rs = null;
            Statement sentencia = miConexion.createStatement();
            
            String sqlRecuperaNombre = "SELECT nombre, apellido FROM recluso WHERE curp = '" + curp + "'";
            rs = sentencia.executeQuery(sqlRecuperaNombre);
            
            while(rs.next()) 
                texto += "\n\nC. " + rs.getString("nombre") + " " + rs.getString("apellido") + "\n\n"
                        + "Con el siguiente CURP \n\n" + curp +"\n\n";
            
            rs.close();
            miConexion.close();
        } catch(Exception e) { e.printStackTrace(); }
                
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteBold);
        p.add(c);
        
        return p;
    }
    
      private Paragraph getInfo(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_JUSTIFIED);
        c.append(texto);
        c.setFont(fuente);
        p.add(c);
        
        return p;
    }
      
      private Paragraph getFooter(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_RIGHT);
        c.append(texto);
        c.setFont(fuenteItalica);
        p.add(c);
        
        return p;
    }
    
    private Paragraph getFirmas(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuente);
        p.add(c);
        
        return p;
    }  
      
    private String armarCuerpo(String curp) {
        String cuerpoCarta = ""
                + "\n\nHabiendo Cumplido las siguientes condenas:\n\n"
                + "";
        
        try {
            Connection miConexion = Conexion.dameConexion();
            ResultSet rs = null;
            Statement sentencia = miConexion.createStatement();
            
            String sqlRecuperaFichas = ""
                    + "SELECT ficha.fechaIngreso, delito.delitonombre, delito.tipo, condenas.descripcion "
                    + "FROM ficha, recluso, delito, condenas "
                    + "WHERE ficha.recluso_idrecluso = '" + curp + "' AND recluso.curp = '" + curp + "' AND "
                    + "ficha.delito_iddelito = delito.iddelito AND "
                    + "ficha.condenas_idcondenas = condenas.idcondenas"
                    + "";
            
            rs = sentencia.executeQuery(sqlRecuperaFichas);
            
            while(rs.next()) {
                String fechaIngreso = rs.getString("fechaIngreso");
                String delitoNombre = rs.getString("delitonombre");
                String tipoDelito = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                
                cuerpoCarta += "Condena: " + descripcion + "\n";
                cuerpoCarta += "Delito: " + delitoNombre + "\n";
                cuerpoCarta += "Tipo: " + tipoDelito + "\n";
                cuerpoCarta += "Fecha Ingreso: " + fechaIngreso + "\n\n";
            }
            
        } catch(Exception e) { e.printStackTrace(); }
        
        return cuerpoCarta;
    }
    
    private String colocarFirmas() {
        String formato = "\n\n"
                + "_________________________________________________"
                + "\n\n"
                + "Director General del Reclusorio";
     
        return formato;
    }
    
    private ExpedirCarta ec;
    private ArrayList<String> curp;
    private String nombre;
    private String apellidos;
    private String estado;
    private Font fuenteBold;
    private Font fuente;
    private Font fuenteItalica;
    private String salida = "";
    
    private final String CABECERA = ""
            + "\n\nSe otorga la siguiente Carta de Antecedentes Penales al"
            + "";
    
    private final String FOOTER = ""
            + "Analisis y Diseño Orientado a Objetos, 2CM9, 2019"
            + "";
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCartas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCartas;
    // End of variables declaration//GEN-END:variables
}
