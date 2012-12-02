//$Header: /cvsroot-fuse/mec-as2/39/mendelson/comm/as2/message/loggui/JPanelFileDisplay.java,v 1.1 2012/04/18 14:10:30 heller Exp $
package de.mendelson.comm.as2.message.loggui;

import de.mendelson.util.MecResourceBundle;
import de.mendelson.util.clientserver.BaseClient;
import de.mendelson.util.clientserver.clients.datatransfer.DownloadRequestFileLimited;
import de.mendelson.util.clientserver.clients.datatransfer.DownloadResponseFileLimited;
import de.mendelson.util.clientserver.clients.datatransfer.TransferClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.swing.*;

/*
 * Copyright (C) mendelson-e-commerce GmbH Berlin Germany
 *
 * This software is subject to the license agreement set forth in the license.
 * Please read and agree to all terms before using this software.
 * Other product and brand names are trademarks of their respective owners.
 */
/**
 * Panel to display the content of a file
 * @author S.Heller
 * @version $Revision: 1.1 $
 */
public class JPanelFileDisplay extends JPanel {

    /**Max filesize for the display of data in the panel, actual 100kB*/
    private final static long MAX_FILESIZE = (long) (100 * Math.pow(2, 10));
    /**Resourcebundle to localize the GUI*/
    private MecResourceBundle rb = null;
    private BaseClient baseClient;

    /** Creates new form JPanelFunctionGraph */
    public JPanelFileDisplay(BaseClient baseClient) {
        //load resource bundle
        try {
            this.rb = (MecResourceBundle) ResourceBundle.getBundle(
                    ResourceBundleFileDisplay.class.getName());
        } catch (MissingResourceException e) {
            throw new RuntimeException("Oops..resource bundle "
                    + e.getClassName() + " not found.");
        }
        this.baseClient = baseClient;
        this.initComponents();
    }

    /**Loads a file to the editor and displays it
     */
    public void displayFile(String filename) {
        if (filename == null) {
            this.jTextFieldFilename.setText("");
            this.jEditorPane.setText(this.rb.getResourceString("no.file"));
            return;
        }
        TransferClient transferClient = new TransferClient(this.baseClient);
        InputStream inStream = null;
        try {
            DownloadRequestFileLimited request = new DownloadRequestFileLimited();
            request.setMaxSize(MAX_FILESIZE);
            request.setFilename(filename);
            DownloadResponseFileLimited response = (DownloadResponseFileLimited) transferClient.download(request);
            this.jTextFieldFilename.setText(response.getFullFilename());
            if (response.isSizeExceeded()) {
                this.jEditorPane.setText(this.rb.getResourceString("file.tolarge",
                        new Object[]{filename}));
            } else {
                inStream = response.getDataStream();
                this.jEditorPane.read(inStream, null);
            }
        } catch (Throwable e) {
            if (e instanceof FileNotFoundException) {
                this.jEditorPane.setText(this.rb.getResourceString("file.notfound",
                        filename));
            } else {
                this.jEditorPane.setText(e.getMessage());
            }
            return;
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (Exception e) {
                    //nop
                }
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane = new javax.swing.JScrollPane();
        jEditorPane = new javax.swing.JEditorPane();
        jTextFieldFilename = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        jEditorPane.setEditable(false);
        jScrollPane.setViewportView(jEditorPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane, gridBagConstraints);

        jTextFieldFilename.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        jTextFieldFilename.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        add(jTextFieldFilename, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextField jTextFieldFilename;
    // End of variables declaration//GEN-END:variables
}