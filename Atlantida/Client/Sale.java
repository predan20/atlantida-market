
public class Sale extends javax.swing.JPanel {
    
    /** Creates new form Sale */
    public Sale() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        titleLabelSale = new javax.swing.JLabel();
        startPageButtonSale = new javax.swing.JButton();
        InventarPanelSale = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        logoutButtonSale = new javax.swing.JButton();
        saleButtonSale = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        titleLabelSale.setFont(new java.awt.Font("Tahoma", 1, 18));
        titleLabelSale.setForeground(new java.awt.Color(255, 51, 0));
        titleLabelSale.setText("Saling elements");

        startPageButtonSale.setText("Start page");
        startPageButtonSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startPageButtonSaleHandler(evt);
            }
        });

        InventarPanelSale.setBackground(new java.awt.Color(255, 255, 204));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout InventarPanelSaleLayout = new javax.swing.GroupLayout(InventarPanelSale);
        InventarPanelSale.setLayout(InventarPanelSaleLayout);
        InventarPanelSaleLayout.setHorizontalGroup(
            InventarPanelSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InventarPanelSaleLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        InventarPanelSaleLayout.setVerticalGroup(
            InventarPanelSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventarPanelSaleLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        logoutButtonSale.setText("Logout");
        logoutButtonSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonSaleHandler(evt);
            }
        });

        saleButtonSale.setText("Sale");
        saleButtonSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleButtonSaleHandler(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startPageButtonSale)
                    .addComponent(logoutButtonSale, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InventarPanelSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(titleLabelSale)
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addComponent(saleButtonSale, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(titleLabelSale)
                        .addGap(18, 18, 18)
                        .addComponent(InventarPanelSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(startPageButtonSale)
                        .addGap(18, 18, 18)
                        .addComponent(logoutButtonSale)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saleButtonSale)
                .addContainerGap())
        );
    }// </editor-fold>

    private void startPageButtonSaleHandler(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void logoutButtonSaleHandler(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        
    
    public javax.swing.JButton getLogoutButtonSale() 
    {
		return logoutButtonSale;
	}
    
    public javax.swing.JButton getStartPageButtonSale() 
    {
		return startPageButtonSale;
	}
    private void saleButtonSaleHandler(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    
    // Variables declaration - do not modify
    private javax.swing.JPanel InventarPanelSale;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logoutButtonSale;
    private javax.swing.JButton saleButtonSale;
    private javax.swing.JButton startPageButtonSale;
    private javax.swing.JLabel titleLabelSale;
    // End of variables declaration
}
    