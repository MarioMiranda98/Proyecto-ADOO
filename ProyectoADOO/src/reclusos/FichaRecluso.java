/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclusos;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.regex.*;

/**
 *
 * @author FAROL
 */
public class FichaRecluso extends javax.swing.JFrame {

    /**
     * Creates new form FichaRecluso
     */
    public FichaRecluso(Principal p) {
        initComponents();
        this.p = p;
        setLocationRelativeTo(null);
        nombreReclusos = new ArrayList<>();
        apellidosReclusos = new ArrayList<>();
        curpReclusos = new ArrayList<>();
        delitos = new ArrayList<>();
        iddelitos = new ArrayList<>();
        idcondena = new ArrayList<>();
        descripcion = new ArrayList<>();
        cargarRecluso();
        cargarDelito();
        cargarCondena();
        
        comboIdRecluso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                nombreRecluso.setText(nombreReclusos.get(comboIdRecluso.getSelectedIndex()));
                apellidoRecluso.setText(apellidosReclusos.get(comboIdRecluso.getSelectedIndex()));
            }
        });
        
        comboIdDelito.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent e) {
               campoDelito.setText(delitos.get(comboIdDelito.getSelectedIndex()));
           } 
        });
        
        comboIdCondena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                campoCondena.setText(descripcion.get(comboIdCondena.getSelectedIndex()));
            }
        });
    }

    private void cargarRecluso() {
        try {
            int i = 0;
            Connection miConexion = Conexion.dameConexion();
            ResultSet rs = null;
            Statement sentencia = miConexion.createStatement();
            
            String sqlRecuperaReclusos = "SELECT nombre, apellido, curp FROM recluso";
            rs = sentencia.executeQuery(sqlRecuperaReclusos);
            
            while(rs.next()) {
                nombreReclusos.add(rs.getString("nombre"));
                apellidosReclusos.add(rs.getString("apellido"));
                curpReclusos.add(rs.getString("curp"));
            }           
            
            for(i = 1; i <= curpReclusos.size(); i++)
                comboIdRecluso.addItem("" + i);
            
            rs.close();
            miConexion.close();
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    private void cargarDelito() {
        try {
            Connection miConexion = Conexion.dameConexion();
            ResultSet rs = null;
            Statement sentencia = miConexion.createStatement();
            
            String sqlConsultaDelito = "SELECT iddelito, delitonombre FROM delito";
            rs = sentencia.executeQuery(sqlConsultaDelito);
            
            while(rs.next()) {
                delitos.add(rs.getString("delitonombre"));
                iddelitos.add(rs.getString("iddelito"));
            }
            
            for(int i = 1; i <= iddelitos.size(); i += 1)
                comboIdDelito.addItem(iddelitos.get(i - 1));
            
            rs.close();
            miConexion.close();
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    private void cargarCondena() {
        try {
            Connection miConexion = Conexion.dameConexion();
            ResultSet rs = null;
            Statement sentencia = miConexion.createStatement();
            
            String sqlConsultaCondena = "SELECT idcondenas, descripcion FROM condenas";
            rs = sentencia.executeQuery(sqlConsultaCondena);
            
            while(rs.next()) {
                idcondena.add(rs.getString("idcondenas"));
                descripcion.add(rs.getString("descripcion"));
            }
            
            for(int i = 1; i <= idcondena.size(); i += 1)
                    comboIdCondena.addItem(idcondena.get(i - 1));
            
            rs.close();
            miConexion.close();
        } catch(Exception e) { e.printStackTrace(); }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoIdFicha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboIdRecluso = new javax.swing.JComboBox<>();
        nombreRecluso = new javax.swing.JTextField();
        apellidoRecluso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboIdDelito = new javax.swing.JComboBox<>();
        campoDelito = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboIdCondena = new javax.swing.JComboBox<>();
        campoCondena = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoFianza = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        campoFecha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campoFechaIngreso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fichas.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel2.setText("Crear Ficha");

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel3.setText("Id. Ficha");

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel4.setText("Id. Recluso");

        nombreRecluso.setEditable(false);

        apellidoRecluso.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel5.setText("Id. Delito");

        comboIdDelito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboIdDelitoActionPerformed(evt);
            }
        });

        campoDelito.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel6.setText("Id. Condena");

        campoCondena.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel7.setText("Fianza");

        jButton1.setText("Agregar");
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

        jLabel8.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel8.setText("Fecha De Liberacion");

        jLabel9.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel9.setText("Fecha de Ingreso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(426, 426, 426)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jButton1)
                        .addGap(116, 116, 116)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoIdFicha, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboIdRecluso, 0, 86, Short.MAX_VALUE)
                                .addComponent(comboIdDelito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboIdCondena, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campoFianza)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombreRecluso, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(apellidoRecluso, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
                            .addComponent(campoDelito)
                            .addComponent(campoCondena))))
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campoIdFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboIdRecluso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreRecluso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellidoRecluso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboIdDelito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDelito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(comboIdCondena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCondena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(campoFianza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(campoFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboIdDelitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboIdDelitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboIdDelitoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        borrado();
        FichaRecluso.this.dispose();
        p.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        crearFicha(evt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void crearFicha(java.awt.event.ActionEvent evt) {
        ficha = campoIdFicha.getText().trim();
        fianza = campoFianza.getText().trim();
        fecha = campoFecha.getText().trim();
        fechaIngreso = campoFechaIngreso.getText().trim();
        
        Pattern p = Pattern.compile("[a-z]|[A-Z]");
        Matcher m = p.matcher(fianza);
        
        if(ficha.equals("") || fianza.equals("") || fecha.equals("") || fechaIngreso.equals("") || fecha.length() > 10 || fechaIngreso.length() > 10) {
            //System.out.println("Error");
            borrado();
            FichaRecluso.this.dispose();
            new FichaRegistroInvalida(FichaRecluso.this).show();
        } else if(validarFecha(fecha) || validarFecha(fechaIngreso)){
            borrado();
            FichaRecluso.this.dispose();
            new FichaRegistroInvalida(FichaRecluso.this).show();
        }else if(m.find()) {
            //System.out.println("Error");
            FichaRecluso.this.dispose();
            new FianzaInvalida(FichaRecluso.this).show();
        }else if(Existencias.siExiste("idficha", "ficha", ficha)){
            //System.out.println("Ficha existente");
            FichaRecluso.this.dispose();
            new FichaExistente(FichaRecluso.this, ficha).show();
            borrado();
        }else {
            try {
                Connection miConexion = Conexion.dameConexion();
                Statement sentencia = miConexion.createStatement();
                
                String sqlInsertarFicha = "INSERT INTO ficha VALUES('" + ficha + "', '" + iddelitos.get(comboIdDelito.getSelectedIndex()) + "', '" + curpReclusos.get(comboIdRecluso.getSelectedIndex()) + "', '" + idcondena.get(comboIdCondena.getSelectedIndex()) + "', '" + fianza +"', '" + fecha + "', '" + fechaIngreso + "', 'Curso')";
                sentencia.executeUpdate(sqlInsertarFicha);
                
                String sqlActualizarEstado = "UPDATE recluso set estado = 'Recluso' WHERE curp = '" + curpReclusos.get(comboIdRecluso.getSelectedIndex()) + "'";
                sentencia.executeUpdate(sqlActualizarEstado);
                
                JOptionPane.showMessageDialog(FichaRecluso.this, "Ficha creada", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                borrado();
                miConexion.close();
            } catch(Exception e) { e.printStackTrace(); }
        }
    }
    
    private boolean validarFecha(String fecha) {
        boolean bandera = false;
        
        String dia = fecha.substring(0, 2);
        String mes = fecha.substring(3, 5);
        String año = fecha.substring(6, 10);
        
        if(Integer.parseInt(dia) < 1 || Integer.parseInt(dia) > 31)
            bandera = true;
        else if(Integer.parseInt(mes) < 1|| Integer.parseInt(mes) > 12)
            bandera = true;
        else if(Integer.parseInt(año) < 1)
            bandera = true;
        
        Pattern p = Pattern.compile("[0-9]");
        Matcher m1 = p.matcher(dia);
        Matcher m2 = p.matcher(mes);
        Matcher m3 = p.matcher(año);
       
        if(!m1.find())
            bandera = true;
        else if(!m2.find())
            bandera = true;
        else if(!m3.find())
            bandera = true;
        
        return bandera;
    }
    
    private void borrado() {
        campoIdFicha.setText("");
        campoFianza.setText("");
        nombreRecluso.setText("");
        apellidoRecluso.setText("");
        campoDelito.setText("");
        campoCondena.setText("");
        campoFecha.setText("");
        campoFechaIngreso.setText("");
    }
    
    /**
     * @param args the command line arguments
     */

    private Principal p;
    private String ficha;
    private String fianza;
    private String fecha;
    private String fechaIngreso;
    private ArrayList<String> nombreReclusos;
    private ArrayList<String> apellidosReclusos;
    private ArrayList<String> curpReclusos;
    private ArrayList<String> delitos;
    private ArrayList<String> iddelitos;
    private ArrayList<String> idcondena;
    private ArrayList<String> descripcion;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoRecluso;
    private javax.swing.JTextField campoCondena;
    private javax.swing.JTextField campoDelito;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JTextField campoFechaIngreso;
    private javax.swing.JTextField campoFianza;
    private javax.swing.JTextField campoIdFicha;
    private javax.swing.JComboBox<String> comboIdCondena;
    private javax.swing.JComboBox<String> comboIdDelito;
    private javax.swing.JComboBox<String> comboIdRecluso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nombreRecluso;
    // End of variables declaration//GEN-END:variables
}
