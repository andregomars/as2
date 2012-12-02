//$Header: /cvsroot-fuse/mec-as2/39/mendelson/comm/as2/client/AS2StatusBar.java,v 1.1 2012/04/18 14:10:23 heller Exp $
package de.mendelson.comm.as2.client;

import de.mendelson.comm.as2.AS2ServerVersion;
import de.mendelson.util.MecResourceBundle;
import de.mendelson.util.ProgressPanel;
import java.awt.GridBagConstraints;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.swing.JPanel;

/*
 * Copyright (C) mendelson-e-commerce GmbH Berlin Germany
 *
 * This software is subject to the license agreement set forth in the license.
 * Please read and agree to all terms before using this software.
 * Other product and brand names are trademarks of their respective owners.
 */
/**
 * Status bar for the AS2 GUI
 * @author S.Heller
 * @version $Revision: 1.1 $
 */
public class AS2StatusBar extends JPanel {

    private MecResourceBundle rb;

    /** Creates new form AS2StatusBar */
    public AS2StatusBar() {
        //load resource bundle
        try {
            this.rb = (MecResourceBundle) ResourceBundle.getBundle(
                    ResourceBundleAS2StatusBar.class.getName());
        } catch (MissingResourceException e) {
            throw new RuntimeException("Oops..resource bundle " + e.getClassName() + " not found.");
        }
        initComponents();
    }

    public void setTransactionCount(int countAll, int countOk, int countPending, int countFailed, int countSelected) {
        this.jLabelTransactionsAll.setText(String.valueOf(countAll));
        this.jLabelTransactionsOk.setText(String.valueOf(countOk));
        this.jLabelTransactionsPending.setText(String.valueOf(countPending));
        this.jLabelTransactionsFailure.setText(String.valueOf(countFailed));
        this.jLabelTransactionsSelected.setText(String.valueOf(countSelected));
    }

    public void setConnectedHost(String host) {
        this.jLabelHost.setText(AS2ServerVersion.getProductName() + "@" + host);
    }

    public void setSelectedTransactionCount(int countSelected) {
        this.jLabelTransactionsSelected.setText(String.valueOf(countSelected));
    }

    public void startProgressIndeterminate(String progressDetails, String uniqueId) {
        this.progressPanel.startProgressIndeterminate(progressDetails, uniqueId);
    }
    
    public void stopProgressIfExists(String uniqueId) {
        this.progressPanel.stopProgressIfExists(uniqueId);
    }

    public ProgressPanel getProgressPanel(){
        return( this.progressPanel );
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelTransactionCount = new javax.swing.JPanel();
        jLabelTransactionsAll = new javax.swing.JLabel();
        jLabelTransactionsOk = new javax.swing.JLabel();
        jLabelTransactionsPending = new javax.swing.JLabel();
        jLabelTransactionsFailure = new javax.swing.JLabel();
        jLabelTransactionsSelected = new javax.swing.JLabel();
        jPanelEmpty = new javax.swing.JPanel();
        jLabelHost = new javax.swing.JLabel();
        progressPanel = new de.mendelson.util.ProgressPanel();

        setLayout(new java.awt.GridBagLayout());

        jPanelTransactionCount.setLayout(new java.awt.GridBagLayout());

        jLabelTransactionsAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/mendelson/comm/as2/client/state_all16x16.gif"))); // NOI18N
        jLabelTransactionsAll.setText("0");
        jLabelTransactionsAll.setToolTipText(this.rb.getResourceString( "count.all"));
        jLabelTransactionsAll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelTransactionCount.add(jLabelTransactionsAll, gridBagConstraints);

        jLabelTransactionsOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/mendelson/comm/as2/client/state_finished16x16.gif"))); // NOI18N
        jLabelTransactionsOk.setText("0");
        jLabelTransactionsOk.setToolTipText(this.rb.getResourceString( "count.ok"));
        jLabelTransactionsOk.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelTransactionCount.add(jLabelTransactionsOk, gridBagConstraints);

        jLabelTransactionsPending.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/mendelson/comm/as2/client/state_pending16x16.gif"))); // NOI18N
        jLabelTransactionsPending.setText("0");
        jLabelTransactionsPending.setToolTipText(this.rb.getResourceString( "count.pending"));
        jLabelTransactionsPending.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelTransactionCount.add(jLabelTransactionsPending, gridBagConstraints);

        jLabelTransactionsFailure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/mendelson/comm/as2/client/state_stopped16x16.gif"))); // NOI18N
        jLabelTransactionsFailure.setText("0");
        jLabelTransactionsFailure.setToolTipText(this.rb.getResourceString( "count.failure"));
        jLabelTransactionsFailure.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelTransactionCount.add(jLabelTransactionsFailure, gridBagConstraints);

        jLabelTransactionsSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/mendelson/comm/as2/client/state_allselected16x16.gif"))); // NOI18N
        jLabelTransactionsSelected.setText("0");
        jLabelTransactionsSelected.setToolTipText(this.rb.getResourceString( "count.selected"));
        jLabelTransactionsSelected.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelTransactionCount.add(jLabelTransactionsSelected, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        add(jPanelTransactionCount, gridBagConstraints);

        jPanelEmpty.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanelEmpty.setPreferredSize(new java.awt.Dimension(125, 20));
        jPanelEmpty.setLayout(new java.awt.GridBagLayout());

        jLabelHost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/mendelson/comm/as2/client/state_empty16x16.gif"))); // NOI18N
        jLabelHost.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabelHost.setMaximumSize(new java.awt.Dimension(1000, 16));
        jLabelHost.setMinimumSize(new java.awt.Dimension(100, 16));
        jLabelHost.setPreferredSize(new java.awt.Dimension(200, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanelEmpty.add(jLabelHost, gridBagConstraints);

        progressPanel.setMaximumSize(new java.awt.Dimension(2147483647, 16));
        progressPanel.setMinimumSize(new java.awt.Dimension(200, 12));
        progressPanel.setPreferredSize(new java.awt.Dimension(200, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanelEmpty.add(progressPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanelEmpty, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelHost;
    private javax.swing.JLabel jLabelTransactionsAll;
    private javax.swing.JLabel jLabelTransactionsFailure;
    private javax.swing.JLabel jLabelTransactionsOk;
    private javax.swing.JLabel jLabelTransactionsPending;
    private javax.swing.JLabel jLabelTransactionsSelected;
    private javax.swing.JPanel jPanelEmpty;
    private javax.swing.JPanel jPanelTransactionCount;
    private de.mendelson.util.ProgressPanel progressPanel;
    // End of variables declaration//GEN-END:variables
}
