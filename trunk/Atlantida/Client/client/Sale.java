package client;

import java.awt.Color;

import javax.swing.ListSelectionModel;


public class Sale extends javax.swing.JPanel {
    
    public Sale(String[] header,String[][] values) {
        initComponents(header,values);
    }
  
   
    private void initComponents( String[] header,String[][] values) {

        titleLabelSale = new javax.swing.JLabel();
        startPageButtonSale = new javax.swing.JButton();
        InventarPanelSale = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        logoutButtonSale = new javax.swing.JButton();
        saleButtonSale = new javax.swing.JButton();
        nrPuncteLabelSale = new javax.swing.JLabel();
        puncteLabelSale = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 204));

        titleLabelSale.setFont(new java.awt.Font("Tahoma", 1, 18));
        titleLabelSale.setForeground(new java.awt.Color(255, 51, 0));
        titleLabelSale.setText("Vanzare elemente");

        startPageButtonSale.setText("Meniu");
        startPageButtonSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startPageButtonSaleHandler(evt);
            }
        });

        InventarPanelSale.setBackground(new java.awt.Color(255, 255, 204));

        jTable1.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.getViewport().setBackground(new Color(255, 255, 204));
        jScrollPane1.getVerticalScrollBar().setBackground(new Color(255, 255, 204));
        jScrollPane1.getHorizontalScrollBar().setBackground(new Color(255, 255, 204));
        jScrollPane1.getHorizontalScrollBar().setForeground(new Color(255, 255, 204));
        jScrollPane1.getVerticalScrollBar().setForeground(new Color(255, 255, 204));
        jTable1.getTableHeader().setBackground(new Color(255, 255, 204));
        jTable1.setBackground(new Color(255, 255, 204));
        jScrollPane1.setBackground(new Color(255, 255, 204));
        jScrollPane1.getHorizontalScrollBar().getComponent(1).setBackground(new Color(255, 255, 204));
        jScrollPane1.getHorizontalScrollBar().getComponent(0).setBackground(new Color(255, 255, 204));
        jScrollPane1.getVerticalScrollBar().getComponent(1).setBackground(new Color(255, 255, 204));
        jScrollPane1.getVerticalScrollBar().getComponent(0).setBackground(new Color(255, 255, 204));

        
        if (header!=null && values != null)
        {
        	for(int i=0;i < values.length; i++)
        	{
        		for (int j = 0; j <values[i].length - 1; j++ )
        		{
        			if(values[i][j].equals("null"))
        			{
        				values[i][j] = "";
        			}
        		}
        	}
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    values, header));
            jTable1.setCellSelectionEnabled(false);
            jTable1.setRowSelectionAllowed(true);
            
            RowEditor rowEditor = new RowEditor(jTable1);
            rowEditor.isEditable(false);
            for(String s : header)
            {
            	jTable1.getColumn(s).setCellEditor(rowEditor);
            }
            
            jTable1.removeColumn(jTable1.getColumn("ID"));
            jTable1.removeColumn(jTable1.getColumn("PARINTE"));
            jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            jScrollPane1.setViewportView(jTable1);
            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        }
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 14));
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Inventar");

        javax.swing.GroupLayout InventarPanelSaleLayout = new javax.swing.GroupLayout(InventarPanelSale);
        InventarPanelSale.setLayout(InventarPanelSaleLayout);
        InventarPanelSaleLayout.setHorizontalGroup(
            InventarPanelSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InventarPanelSaleLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGap(73, 73, 73))
            .addGroup(InventarPanelSaleLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1)
                .addContainerGap(174, Short.MAX_VALUE))
        );
        InventarPanelSaleLayout.setVerticalGroup(
            InventarPanelSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventarPanelSaleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );

        logoutButtonSale.setText("Logout");
        logoutButtonSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonSaleHandler(evt);
            }
        });

        saleButtonSale.setText("Vanzare");
        saleButtonSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleButtonSaleHandler(evt);
            }
        });

        nrPuncteLabelSale.setFont(new java.awt.Font("Georgia", 1, 14));
        nrPuncteLabelSale.setForeground(new java.awt.Color(255, 51, 0));
        nrPuncteLabelSale.setText("Nr. de puncte:");

        puncteLabelSale.setFont(new java.awt.Font("Georgia", 1, 14));
        puncteLabelSale.setForeground(new java.awt.Color(255, 51, 0));
        puncteLabelSale.setText("4230");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoutButtonSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startPageButtonSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(InventarPanelSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(titleLabelSale)
                .addContainerGap(192, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nrPuncteLabelSale)
                .addGap(18, 18, 18)
                .addComponent(puncteLabelSale, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(saleButtonSale, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(titleLabelSale)
                        .addGap(18, 18, 18)
                        .addComponent(InventarPanelSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nrPuncteLabelSale)
                            .addComponent(puncteLabelSale)
                            .addComponent(saleButtonSale))
                        .addGap(5, 5, 5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(startPageButtonSale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoutButtonSale)))
                .addGap(14, 14, 14))
        );
    }

    private void startPageButtonSaleHandler(java.awt.event.ActionEvent evt) {                                            
    }                                           

    private void logoutButtonSaleHandler(java.awt.event.ActionEvent evt) {                                         
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
    }
    
    public javax.swing.JButton getSaleButtonSale() {
		return saleButtonSale;
	}
    public javax.swing.JTable getJTable1() {
		return jTable1;
	}
    
    public javax.swing.JLabel getPuncteLabelSale() {
    	return puncteLabelSale;
    }
    
    private javax.swing.JPanel InventarPanelSale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logoutButtonSale;
    private javax.swing.JLabel nrPuncteLabelSale;
    private javax.swing.JLabel puncteLabelSale;
    private javax.swing.JButton saleButtonSale;
    private javax.swing.JButton startPageButtonSale;
    private javax.swing.JLabel titleLabelSale;
    
}
    
