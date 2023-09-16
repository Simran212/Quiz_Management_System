
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vss72
 */
public class AccountInfo extends javax.swing.JFrame {
     private static String dbURL = "jdbc:derby://localhost:1527/QuizManagement;create=true;user=root;password=pass";
    private static String tableName = "STUDENT";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;    
    MainScreen m;
    MainScreenStudent M;
    String id;
    private static void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
    
    
    private void UpdateStudent(String id,String name,int age,String sex,String batch,String password)
    {
        try
        {
            stmt = conn.createStatement();
             String query = " update student set NAME=?,AGE=?,SEX=?,BATCH=?,PASSWORD=? where ID=?";
             PreparedStatement ps = conn.prepareStatement(query);
         //putting value for all placeholder (?)
         ps.setString(1,name);
         ps.setInt(2,age);
         ps.setString(3, sex);
         ps.setString(4, batch);
         ps.setString(5, password);
         
         ps.setString(6, id);
          ps.execute();
            JOptionPane.showMessageDialog(this,"Data updated Succesfully"  );
      
      
      conn.close();
       }
        catch (SQLException sqlExcept)
        {   
            sqlExcept.printStackTrace();
        }
    }
     private void UpdateTeacher(String id,String name,int age,String sex,String dept,String password)
    {
        try
        {
            stmt = conn.createStatement();
             String query = " update TEACHER set NAME=?,AGE=?,SEX=?,BATCH=?,PASSWORD=? where ID=?";
             PreparedStatement ps = conn.prepareStatement(query);
         //putting value for all placeholder (?)
         ps.setString(1,name);
         ps.setInt(2,age);
         ps.setString(3, sex);
         ps.setString(4, dept);
         ps.setString(5, password);
         
         ps.setString(6, id);
          ps.execute();
            JOptionPane.showMessageDialog(this,"Data updated Succesfully"  );
      
      
      conn.close();
       }
        catch (SQLException sqlExcept)
        {   
            sqlExcept.printStackTrace();
        }
    }
 
    
    
    /**
     * Creates new form AccountInfo
     */
    public AccountInfo() {
        initComponents();
    }
    public void getInfo(String ID,MainScreenStudent m)
    {
        id=ID;
    if(ID.substring(0,3).equals("std"))
    {  
        M=m;
        jLabel4.setText("BATCH");
        DefaultListModel model = new DefaultListModel();
   // Model model= new Model();
         model.addElement("Y19");
         
         model.addElement("Y18");
         
         model.addElement("Y17");
         
         model.addElement("Y16");
         jList2.setModel(model);
    }
    else if(ID.substring(0,3).equals("tch")){
    jLabel4.setText("DEPARTMENT");
        DefaultListModel model = new DefaultListModel();
   // Model model= new Model();
         model.addElement("CSE");
         
         model.addElement("ECE");
         
         model.addElement("CCE");
         
         model.addElement("ME");
         jList2.setModel(model);
    }
    
    
    createConnection();
                    try{
                        String query="select * from STUDENT where id=?";
                          PreparedStatement ps = conn.prepareStatement(query);
                          ps.setString(1,ID);
                          ResultSet results = ps.executeQuery();
                        if(results.next())
                        {
                            jTextField1.setText(results.getString(2));
                            
                            jTextField2.setText(results.getInt(3)+"");
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "There is some problem in Accessing your record please contact administration");
                           }
                        results.close();
                      
                    }
                    catch (SQLException sqlExcept)
                    {
                        sqlExcept.printStackTrace();
                    }

    }
    
    public void getInfo(String ID,MainScreen m)
    {
        id=ID;
    if(ID.substring(0,3).equals("std"))
    {   jLabel4.setText("BATCH");
        DefaultListModel model = new DefaultListModel();
   // Model model= new Model();
         model.addElement("Y19");
         
         model.addElement("Y18");
         
         model.addElement("Y17");
         
         model.addElement("Y16");
         jList2.setModel(model);
    }
    else if(ID.substring(0,3).equals("tch")){
        this.m=m;
    jLabel4.setText("DEPARTMENT");
        DefaultListModel model = new DefaultListModel();
   // Model model= new Model();
         model.addElement("CSE");
         
         model.addElement("ECE");
         
         model.addElement("CCE");
         
         model.addElement("ME");
         jList2.setModel(model);
    }
    
    
    createConnection();
                    try{
                        String query="select * from TEACHER where id=?";
                          PreparedStatement ps = conn.prepareStatement(query);
                          ps.setString(1,ID);
                          ResultSet results = ps.executeQuery();
                        if(results.next())
                        {
                            jTextField1.setText(results.getString(2));
                            
                            jTextField2.setText(results.getInt(3)+"");
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "There is some problem in Accessing your record please contact administration");
                           }
                        results.close();
                      
                    }
                    catch (SQLException sqlExcept)
                    {
                        sqlExcept.printStackTrace();
                    }

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
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("NAME");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("AGE");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("SEX");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("DEPARTMENT");

        jList1.setBackground(new java.awt.Color(0, 0, 0));
        jList1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "MALE", "FEMALE", "OTHERS" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setBackground(new java.awt.Color(0, 0, 0));
        jList2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jList2.setForeground(new java.awt.Color(255, 255, 255));
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 204, 0));
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("PASSWORD");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ACCOUNT");

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("HOME");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(457, 457, 457)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(459, 459, 459))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             if(id.substring(0,3).equals("std"))
             {
                 UpdateStudent(id,jTextField1.getText(),Integer.parseInt( jTextField2.getText()),jList1.getSelectedValue(),jList2.getSelectedValue(),jTextField3.getText());
                 
             }
             else if(id.substring(0,3).equals("tch"))
             {
             UpdateTeacher(id,jTextField1.getText(),Integer.parseInt( jTextField2.getText()),jList1.getSelectedValue(),jList2.getSelectedValue(),jTextField3.getText());
                
             
             }
    }
    {         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            if(id.substring(0,3).equals("std"))
             {  
                 this.setVisible(false);
                 M.setVisible(true);
            }
    else if(id.substring(0,3).equals("tch")){
    
                 this.setVisible(false);
                 m.setVisible(true);
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
