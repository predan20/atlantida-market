
public class Buy extends javax.swing.JPanel {
    
    /** Creates new form Buy */
    public Buy() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        titleLabelBuy = new javax.swing.JLabel();
        startPageButtonBuy = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        logoutButtonBuy = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        titleLabelBuy.setFont(new java.awt.Font("Tahoma", 1, 18));
        titleLabelBuy.setForeground(new java.awt.Color(255, 51, 0));
        titleLabelBuy.setText("Buying elements");

        startPageButtonBuy.setText("Start Page");
        startPageButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startPageButtonBuyHandler(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        logoutButtonBuy.setText("Logout");
        logoutButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonBuyHandler(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoutButtonBuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startPageButtonBuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(titleLabelBuy)
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(titleLabelBuy)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(startPageButtonBuy)
                        .addGap(33, 33, 33)
                        .addComponent(logoutButtonBuy))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void startPageButtonBuyHandler(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void logoutButtonBuyHandler(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       
    
    public javax.swing.JButton getLogoutButtonBuy() {
		return logoutButtonBuy;
	}
    public javax.swing.JButton getStartPageButtonBuy() {
		return startPageButtonBuy;
	}
    
    // Variables declaration - do not modify
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutButtonBuy;
    private javax.swing.JButton startPageButtonBuy;
    private javax.swing.JLabel titleLabelBuy;
    // End of variables declaration
    
}
