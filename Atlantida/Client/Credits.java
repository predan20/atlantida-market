
public class Credits extends javax.swing.JPanel {
    
    public Credits() {
        initComponents();
    }
    
    private void initComponents() {

        titleLabelCredits = new javax.swing.JLabel();
        panelCredits = new javax.swing.JPanel();
        authorsLabelCredits = new javax.swing.JLabel();
        label1Credits = new javax.swing.JLabel();
        label2Credits = new javax.swing.JLabel();
        label3Credits = new javax.swing.JLabel();
        label4Credits = new javax.swing.JLabel();
        label5Credits = new javax.swing.JLabel();
        loginButtonCredits = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        titleLabelCredits.setFont(new java.awt.Font("Tahoma", 1, 18));
        titleLabelCredits.setForeground(new java.awt.Color(255, 51, 0));
        titleLabelCredits.setText("Credits");

        panelCredits.setBackground(new java.awt.Color(255, 255, 204));

        authorsLabelCredits.setFont(new java.awt.Font("Tahoma", 1, 12));
        authorsLabelCredits.setForeground(new java.awt.Color(255, 51, 0));
        authorsLabelCredits.setText("Authors:");

        label1Credits.setFont(new java.awt.Font("Tahoma", 1, 11));
        label1Credits.setForeground(new java.awt.Color(255, 51, 0));
        label1Credits.setText("- Prichici Ionela ");

        label2Credits.setFont(new java.awt.Font("Tahoma", 1, 11));
        label2Credits.setForeground(new java.awt.Color(255, 51, 0));
        label2Credits.setText("- Pop Laura");

        label3Credits.setFont(new java.awt.Font("Tahoma", 1, 11));
        label3Credits.setForeground(new java.awt.Color(255, 51, 0));
        label3Credits.setText("- Besnea Alin");

        label4Credits.setFont(new java.awt.Font("Tahoma", 1, 11));
        label4Credits.setForeground(new java.awt.Color(255, 51, 0));
        label4Credits.setText("- Prichici George");

        label5Credits.setFont(new java.awt.Font("Tahoma", 1, 11));
        label5Credits.setForeground(new java.awt.Color(255, 51, 0));
        label5Credits.setText("\"Universitatea Politehnica Timisoara\"");

        javax.swing.GroupLayout panelCreditsLayout = new javax.swing.GroupLayout(panelCredits);
        panelCredits.setLayout(panelCreditsLayout);
        panelCreditsLayout.setHorizontalGroup(
            panelCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreditsLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(authorsLabelCredits)
                    .addGroup(panelCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label5Credits)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCreditsLayout.createSequentialGroup()
                            .addGroup(panelCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label2Credits)
                                .addComponent(label1Credits))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                            .addGroup(panelCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label3Credits)
                                .addComponent(label4Credits)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        panelCreditsLayout.setVerticalGroup(
            panelCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreditsLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(authorsLabelCredits)
                .addGap(29, 29, 29)
                .addGroup(panelCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1Credits)
                    .addComponent(label3Credits))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2Credits)
                    .addComponent(label4Credits))
                .addGap(34, 34, 34)
                .addComponent(label5Credits)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        loginButtonCredits.setText("Login");
        loginButtonCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonCreditsHandler(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(titleLabelCredits))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(loginButtonCredits)
                        .addGap(18, 18, 18)
                        .addComponent(panelCredits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(titleLabelCredits)
                .addGap(18, 18, 18)
                .addComponent(panelCredits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(loginButtonCredits)
                .addContainerGap(163, Short.MAX_VALUE))
        );
    }
    private void loginButtonCreditsHandler(java.awt.event.ActionEvent evt) {
    }
    
    public javax.swing.JButton getLoginButtonCredits() 
    {
		return loginButtonCredits;
	}
    
    private javax.swing.JLabel authorsLabelCredits;
    private javax.swing.JLabel label1Credits;
    private javax.swing.JLabel label2Credits;
    private javax.swing.JLabel label3Credits;
    private javax.swing.JLabel label4Credits;
    private javax.swing.JLabel label5Credits;
    private javax.swing.JButton loginButtonCredits;
    private javax.swing.JPanel panelCredits;
    private javax.swing.JLabel titleLabelCredits;
    
}
