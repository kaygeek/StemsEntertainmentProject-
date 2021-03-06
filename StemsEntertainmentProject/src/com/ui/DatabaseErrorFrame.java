package com.ui;

import java.awt.Color;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import com.database.DatabaseConfiguration;
import com.window.dialog.PopupPane;
import com.installation.ProgramScheduler;
import com.validator.PatternChecker;
import com.prototypes.Validator;
import com.window.location.FrameEvents;
import files.FileProcessor;
import static com.lookandfeel.LookAndFeel.setLookAndFeel;

/**
 * @author Kgaugelo
 */
public class DatabaseErrorFrame extends JFrame implements Validator 
{ 
    private final FileProcessor fileProcessor;
    private final ResourceBundle resource;
    
    /**
     * Creates new form DatabaseErrorFrame
     */
    @SuppressWarnings("LeakingThisInConstructor")
    public DatabaseErrorFrame()
    {      
        fileProcessor = FileProcessor.createFile("preference");
        fileProcessor.loadFile();
        resource = ResourceBundle.getBundle(fileProcessor.getProperties()
                .getProperty("file"));
        
        initComponents();
        FrameEvents.centerFrame(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();
        closeLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        nameTxt = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        testButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        dbErrorLabel = new javax.swing.JLabel();
        dbStatusLabel = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(232, 70, 49));

        jLabel.setBackground(new java.awt.Color(255, 255, 255));
        jLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel.setForeground(new java.awt.Color(255, 255, 255));
        jLabel.setText("Configure Database");
        jLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        closeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/exit.png"))); // NOI18N
        closeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        nameTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameTxt.setMargin(new java.awt.Insets(2, 6, 2, 2));

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordLabel.setText("Password");

        passwordTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        passwordTxt.setMargin(new java.awt.Insets(2, 6, 2, 2));

        testButton.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        testButton.setText("Test Connection");
        testButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testButtonActionPerformed(evt);
            }
        });

        applyButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        applyButton.setText("Confirm");
        applyButton.setToolTipText("");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        dbErrorLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        dbStatusLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dbErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordLabel)
                            .addComponent(usernameLabel))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(testButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(applyButton))
                                    .addComponent(nameTxt)
                                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(dbStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(dbErrorLabel)
                .addGap(45, 45, 45)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addGap(25, 25, 25)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(testButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(dbStatusLabel)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        String username; 
        String password; 
        ConfirmationFrame confirmFrame = new ConfirmationFrame(1);
        
        if (!isEmpty())
        {         
            username = PatternChecker.getInputValue(nameTxt);
            password = PatternChecker.getInputValue(passwordTxt);
            
            ProgramScheduler.startDatabaseServer(this);
          
            DatabaseConfiguration.getConnection().configConnection(
                    username, password, 1
            );
            
            if (DatabaseConfiguration.isConnected()) 
            {
                verifyFile(username, password);
                resetLabels();
                         
                /* Invoke the Popup frame to begin the connection task */
                confirmFrame.setVisible(true);
                dispose();
            }
            else
            {
                dbErrorLabel.setForeground(Color.RED);
                dbErrorLabel.setText(resource.getString("dberr"));
            }
        }
    }//GEN-LAST:event_applyButtonActionPerformed

    private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed
        
        if (ProgramScheduler.startDatabaseServer(this)) {
            dbStatusLabel.setText("");
            delayTask(1);
        } 
        else {
            dbStatusLabel.setText("");
            delayTask(0);
        }
    }//GEN-LAST:event_testButtonActionPerformed

    private void closeLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMousePressed
        exit();
    }//GEN-LAST:event_closeLabelMousePressed
    
    @Override
    public boolean isEmpty()
    {
        fileProcessor.loadFile();
        final String FILE = fileProcessor.getProperties().get("file").toString();   
        ResourceBundle resources = ResourceBundle.getBundle(FILE); 
        
        if (nameTxt.getText().isEmpty()) {
            PopupPane.emptyDialog(this, resources);
            return true;
        }
        return false;
    }
    
    public void exit()
    {
        String message = resource.getString("dbabort");
        int choice =  JOptionPane.showConfirmDialog(this, message);

        if(choice == JOptionPane.YES_OPTION) {
           DatabaseConfiguration.closeConnection();
           System.exit(0); 
        }
    }

    private void delayTask(int label) 
    {
        final int sec = label;      
        new Timer().schedule(new TimerTask() 
        {
            @Override
            public void run()
            {    
                if (sec > 0) {
                    dbStatusLabel.setForeground(new Color(15, 183, 61));
                    dbStatusLabel.setText(resource.getString("dbrun"));
                }
                else {
                    dbStatusLabel.setForeground(Color.RED);
                    dbStatusLabel.setText(resource.getString("dbfail"));
                }
            }
        }, 900);
    }

    private void resetLabels() {
        dbErrorLabel.setText("");
        dbStatusLabel.setText("");
    }
    
    private void verifyFile(String username, String password)
    {
        fileProcessor.getProperties().setProperty("step", "1");
        fileProcessor.getProperties().setProperty("databaseStatus", "true");
        
        fileProcessor.getProperties().setProperty("dbusername", username);
        fileProcessor.getProperties().setProperty("dbpassword", password);
        
        fileProcessor.saveFile();
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        setLookAndFeel("Windows");
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DatabaseErrorFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JLabel closeLabel;
    private javax.swing.JLabel dbErrorLabel;
    private javax.swing.JLabel dbStatusLabel;
    private javax.swing.JLabel jLabel;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JButton testButton;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
