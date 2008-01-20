package client;

import java.awt.Color;




public class StartPage extends javax.swing.JPanel {
    
    public StartPage(String[] header,String[][] values) {
    	
        initComponents(header,values);
    }
        
    private void initComponents(String[] header,String[][] values) {

        titleLabelStartPage = new javax.swing.JLabel();
        logoutButtonStartPage = new javax.swing.JButton();
        combinationButtonStartPage = new javax.swing.JButton();
        buyButtonStarPage = new javax.swing.JButton();
        saleButtonStartPage = new javax.swing.JButton();
        panelStartPage = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        nrPuncteLabelStartPage = new javax.swing.JLabel();
        puncteLabelStartPage = new javax.swing.JLabel();
        actualizareButtonStartPage = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        titleLabelStartPage.setFont(new java.awt.Font("Tahoma", 1, 18));
        titleLabelStartPage.setForeground(new java.awt.Color(255, 51, 0));
        titleLabelStartPage.setText("Atlantida");

        logoutButtonStartPage.setText("Logout");
        logoutButtonStartPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonStartPageHandler(evt);
            }
        });

        combinationButtonStartPage.setText("Combinare");
        combinationButtonStartPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combinationButtonStartPageHandler(evt);
            }
        });

        buyButtonStarPage.setText("Cumparare");
        buyButtonStarPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonStartPageHandler(evt);
            }
        });

        saleButtonStartPage.setText("Vanzare");
        saleButtonStartPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleButtonStartPageHandler(evt);
            }
        });

        panelStartPage.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Inventar");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

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
        		for (int j = 0; j <values[i].length; j++ )
        		{
        			if(values[i][j].equalsIgnoreCase("null"))
        			{
        				values[i][j] = "";
        			}
        		}
        	}
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    values, header));
            jTable1.setCellSelectionEnabled(false);
            jTable1.setRowSelectionAllowed(true);
           rowEditor = new RowEditor(jTable1);
            for(String s : header)
            {
            	jTable1.getColumn(s).setCellEditor(rowEditor);
            }
            jTable1.removeColumn(jTable1.getColumn("ID"));
            jTable1.removeColumn(jTable1.getColumn("PARINTE"));
            jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            jScrollPane1.setViewportView(jTable1);
        }
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setGridColor(new java.awt.Color(153, 153, 153));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout panelStartPageLayout = new javax.swing.GroupLayout(panelStartPage);
        panelStartPage.setLayout(panelStartPageLayout);
        panelStartPageLayout.setHorizontalGroup(
            panelStartPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStartPageLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addGap(38, 38, 38))
            .addGroup(panelStartPageLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel1)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        panelStartPageLayout.setVerticalGroup(
            panelStartPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStartPageLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );

        nrPuncteLabelStartPage.setFont(new java.awt.Font("Georgia", 1, 14));
        nrPuncteLabelStartPage.setForeground(new java.awt.Color(255, 51, 0));
        nrPuncteLabelStartPage.setText("Numarul de puncte:");

        puncteLabelStartPage.setFont(new java.awt.Font("Georgia", 1, 14));
        puncteLabelStartPage.setForeground(new java.awt.Color(255, 51, 0));
        puncteLabelStartPage.setText("4230");

        actualizareButtonStartPage.setText("Actualizare");
        actualizareButtonStartPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizareButtonStartPageHandler(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logoutButtonStartPage, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(saleButtonStartPage, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(buyButtonStarPage, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(actualizareButtonStartPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelStartPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(titleLabelStartPage)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nrPuncteLabelStartPage)
                .addGap(18, 18, 18)
                .addComponent(puncteLabelStartPage, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(combinationButtonStartPage, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabelStartPage)
                        .addGap(11, 11, 11)
                        .addComponent(panelStartPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(logoutButtonStartPage)
                        .addGap(4, 4, 4)
                        .addComponent(saleButtonStartPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buyButtonStarPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualizareButtonStartPage)
                        .addGap(118, 118, 118)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nrPuncteLabelStartPage)
                        .addComponent(puncteLabelStartPage))
                    .addComponent(combinationButtonStartPage))
                .addContainerGap())
        );
    }

  
 
    private void logoutButtonStartPageHandler(java.awt.event.ActionEvent evt) {
    }

    private void combinationButtonStartPageHandler(java.awt.event.ActionEvent evt) {
    }

    private void buyButtonStartPageHandler(java.awt.event.ActionEvent evt) {
    }

    private void saleButtonStartPageHandler(java.awt.event.ActionEvent evt) {
    }

    private void actualizareButtonStartPageHandler(java.awt.event.ActionEvent evt) {
    }
    
    public javax.swing.JButton getLogoutButtonStartPage() 
    {
		return logoutButtonStartPage;
	}
    
    public javax.swing.JButton getCombinationButtonStartPage() 
    {
		return combinationButtonStartPage;
	}
    
    public javax.swing.JButton getBuyButtonStartPage() 
    {
		return buyButtonStarPage;
	}
    
    public javax.swing.JButton getSaleButtonStartPage() 
    {
		return saleButtonStartPage;
	}
    
    public javax.swing.JButton getActualizareButtonStartPage() {
		return actualizareButtonStartPage;
	}
    
    public void setPanelStartPage(javax.swing.JPanel panelStartPage) 
    {
    	this.panelStartPage = panelStartPage;
    }
    
    public javax.swing.JPanel getPanelStartPage() {
		return panelStartPage;
	}
    
    public javax.swing.JLabel getPuncteLabelStartPage() {
		return puncteLabelStartPage;
	}

    public javax.swing.JTable getJTable1() {
		return jTable1;
	}
    
    public RowEditor getRowEditor() {
		return rowEditor;
	}
    
    private javax.swing.JButton actualizareButtonStartPage;
    private javax.swing.JButton buyButtonStarPage;
    private javax.swing.JButton combinationButtonStartPage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logoutButtonStartPage;
    private javax.swing.JLabel nrPuncteLabelStartPage;
    private javax.swing.JPanel panelStartPage;
    private javax.swing.JLabel puncteLabelStartPage;
    private javax.swing.JButton saleButtonStartPage;
    private javax.swing.JLabel titleLabelStartPage;
    private  RowEditor rowEditor;
    
}




