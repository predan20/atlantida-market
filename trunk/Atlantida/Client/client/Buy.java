package client;
import java.awt.Color;

import javax.swing.ListSelectionModel;



public class Buy extends javax.swing.JPanel {
    
    public Buy(String[] header,String[][] values) {
        initComponents(header,values);
    }
      
      private void initComponents( String[] header,String[][] values) {

        titleLabelBuy = new javax.swing.JLabel();
        startPageButtonBuy = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        scrollPaneBuy = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        stocLabelBuy = new javax.swing.JLabel();
        logoutButtonBuy = new javax.swing.JButton();
        buyLabelBuy = new javax.swing.JLabel();
        puncteLabelBuy = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        licitatieLabelBuy = new javax.swing.JLabel();
        licitatieTextFieldBuy = new javax.swing.JTextField();
        buyButtonBuy = new javax.swing.JButton();
        cancelButtonBuy = new javax.swing.JButton();
        actualizareButtonBuy = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        titleLabelBuy.setFont(new java.awt.Font("Tahoma", 1, 18));
        titleLabelBuy.setForeground(new java.awt.Color(255, 51, 0));
        titleLabelBuy.setText("Cumparare elemente");

        startPageButtonBuy.setText("Meniu");
        startPageButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startPageButtonBuyHandler(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        
        jTable1.setAutoCreateRowSorter(true);
        scrollPaneBuy.setViewportView(jTable1);
        scrollPaneBuy.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneBuy.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneBuy.setAutoscrolls(true);
        scrollPaneBuy.setViewportView(jTable1);
        scrollPaneBuy.getViewport().setBackground(new Color(255, 255, 204));
        scrollPaneBuy.getVerticalScrollBar().setBackground(new Color(255, 255, 204));
        scrollPaneBuy.getHorizontalScrollBar().setBackground(new Color(255, 255, 204));
        scrollPaneBuy.getHorizontalScrollBar().setForeground(new Color(255, 255, 204));
        scrollPaneBuy.getVerticalScrollBar().setForeground(new Color(255, 255, 204));
        jTable1.getTableHeader().setBackground(new Color(255, 255, 204));
        jTable1.setBackground(new Color(255, 255, 204));
        scrollPaneBuy.setBackground(new Color(255, 255, 204));
        scrollPaneBuy.getHorizontalScrollBar().getComponent(1).setBackground(new Color(255, 255, 204));
        scrollPaneBuy.getHorizontalScrollBar().getComponent(0).setBackground(new Color(255, 255, 204));
        scrollPaneBuy.getVerticalScrollBar().getComponent(1).setBackground(new Color(255, 255, 204));
        scrollPaneBuy.getVerticalScrollBar().getComponent(0).setBackground(new Color(255, 255, 204));


        
        if (header!=null && values != null)
        {
        	for(int i=0;i < values.length; i++)
        	{
        		for (int j = 0; j <values[i].length; j++ )
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
            jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            scrollPaneBuy.setViewportView(jTable1);
            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            RowEditor rowEditor = new RowEditor(jTable1);
            rowEditor.isEditable(false);
            for(String s : header)
            {
            	jTable1.getColumn(s).setCellEditor(rowEditor);
            }
            jTable1.removeColumn(jTable1.getColumn("ID"));
            jTable1.removeColumn(jTable1.getColumn("PARINTE"));

        }
        scrollPaneBuy.setViewportView(jTable1);

        stocLabelBuy.setFont(new java.awt.Font("Georgia", 1, 14));
        stocLabelBuy.setForeground(new java.awt.Color(255, 51, 0));
        stocLabelBuy.setText("Stocul pietei");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(stocLabelBuy)
                .addContainerGap(179, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(scrollPaneBuy, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stocLabelBuy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneBuy, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        logoutButtonBuy.setText("Logout");
        logoutButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonBuyHandler(evt);
            }
        });

        buyLabelBuy.setFont(new java.awt.Font("Georgia", 1, 14));
        buyLabelBuy.setForeground(new java.awt.Color(255, 51, 0));
        buyLabelBuy.setText("Nr. de puncte:");

        puncteLabelBuy.setFont(new java.awt.Font("Georgia", 1, 14));
        puncteLabelBuy.setForeground(new java.awt.Color(255, 51, 0));
        puncteLabelBuy.setText("4230");

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        licitatieLabelBuy.setFont(new java.awt.Font("Georgia", 1, 12));
        licitatieLabelBuy.setForeground(new java.awt.Color(255, 51, 0));
        licitatieLabelBuy.setText("Introduceti pretul cu care vreti sa licitati:");

        buyButtonBuy.setText("Cumparare");
        buyButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonBuyHandler(evt);
            }
        });

        cancelButtonBuy.setText("Anulare");
        cancelButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonBuyHandler(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(licitatieLabelBuy)
                        .addGap(24, 24, 24)
                        .addComponent(licitatieTextFieldBuy, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(buyButtonBuy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButtonBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(licitatieLabelBuy)
                    .addComponent(licitatieTextFieldBuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyButtonBuy)
                    .addComponent(cancelButtonBuy)))
        );

        actualizareButtonBuy.setText("Actualizare");
        actualizareButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizareButtonBuyHandler(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(titleLabelBuy))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(actualizareButtonBuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logoutButtonBuy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(startPageButtonBuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(buyLabelBuy)
                        .addGap(18, 18, 18)
                        .addComponent(puncteLabelBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabelBuy)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(startPageButtonBuy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoutButtonBuy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualizareButtonBuy)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(puncteLabelBuy)
                    .addComponent(buyLabelBuy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
     }
      
    private void startPageButtonBuyHandler(java.awt.event.ActionEvent evt) {                                           
    }                                          

    private void logoutButtonBuyHandler(java.awt.event.ActionEvent evt) {                                        
    }                                       

    private void buyButtonBuyHandler(java.awt.event.ActionEvent evt) {
    }

    private void cancelButtonBuyHandler(java.awt.event.ActionEvent evt) {
    }
    private void actualizareButtonBuyHandler(java.awt.event.ActionEvent evt) {
    }
    
    public javax.swing.JButton getActualizareButtonBuy() {
		return actualizareButtonBuy;
	}
    
    public javax.swing.JLabel getPuncteLabelBuy() {
		return puncteLabelBuy;
	}
    
    public javax.swing.JTable getJTable1() {
		return jTable1;
	}
    public javax.swing.JButton getLogoutButtonBuy() {
		return logoutButtonBuy;
	}
    public javax.swing.JButton getCancelButtonBuy() {
		return cancelButtonBuy;
	}
    public javax.swing.JButton getStartPageButtonBuy() {
		return startPageButtonBuy;
	}
    public javax.swing.JButton getBuyButtonBuy() {
		return buyButtonBuy;
	}
    public javax.swing.JTextField getLicitatieTextFieldBuy() {
		return licitatieTextFieldBuy;
	}
    
 
    private javax.swing.JButton actualizareButtonBuy;
    private javax.swing.JButton buyButtonBuy;
    private javax.swing.JLabel buyLabelBuy;
    private javax.swing.JButton cancelButtonBuy;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel licitatieLabelBuy;
    private javax.swing.JTextField licitatieTextFieldBuy;
    private javax.swing.JButton logoutButtonBuy;
    private javax.swing.JLabel puncteLabelBuy;
    private javax.swing.JScrollPane scrollPaneBuy;
    private javax.swing.JButton startPageButtonBuy;
    private javax.swing.JLabel stocLabelBuy;
    private javax.swing.JLabel titleLabelBuy;
}
