

public class Rules extends javax.swing.JPanel {
    
    public Rules() {
        initComponents();
    }
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelRules = new javax.swing.JPanel();
        label1Rules = new javax.swing.JLabel();
        label2Rules = new javax.swing.JLabel();
        label3Rules = new javax.swing.JLabel();
        label5Rules = new javax.swing.JLabel();
        label6Rules = new javax.swing.JLabel();
        label7Rules = new javax.swing.JLabel();
        label8Rules = new javax.swing.JLabel();
        label9Rules = new javax.swing.JLabel();
        label10Rules = new javax.swing.JLabel();
        label4Rules = new javax.swing.JLabel();
        LoginButtonRules = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Reguli");

        panelRules.setBackground(new java.awt.Color(255, 255, 204));

        label1Rules.setFont(new java.awt.Font("Georgia", 0, 11));
        label1Rules.setForeground(new java.awt.Color(255, 51, 0));
        label1Rules.setText(" Actiunea se desfasoara in lumea pierduta a Atlantidei.");

        label2Rules.setFont(new java.awt.Font("Georgia", 0, 11));
        label2Rules.setForeground(new java.awt.Color(255, 51, 0));
        label2Rules.setText(" Fiecare jucator joaca rolul unui inventator care combina");

        label3Rules.setFont(new java.awt.Font("Georgia", 0, 11));
        label3Rules.setForeground(new java.awt.Color(255, 51, 0));
        label3Rules.setText("elemente in cautarea tehnologiei supreme. In joc exista");

        label5Rules.setFont(new java.awt.Font("Georgia", 0, 11));
        label5Rules.setForeground(new java.awt.Color(255, 51, 0));
        label5Rules.setText("pentru a obtine artefactul pe care si-l doresc.");

        label6Rules.setFont(new java.awt.Font("Georgia", 0, 11));
        label6Rules.setForeground(new java.awt.Color(255, 51, 0));
        label6Rules.setText("Elementele pot fi achizitionate de la piata de elemente.");

        label7Rules.setFont(new java.awt.Font("Georgia", 0, 11));
        label7Rules.setForeground(new java.awt.Color(255, 51, 0));
        label7Rules.setText("Se pot achizitiona fie elemente vandute de alti jucatori");

        label8Rules.setFont(new java.awt.Font("Georgia", 0, 11));
        label8Rules.setForeground(new java.awt.Color(255, 51, 0));
        label8Rules.setText("la pretul de 1.5 * valoarea vanzarii fie elemente atomice");

        label9Rules.setFont(new java.awt.Font("Georgia", 0, 11));
        label9Rules.setForeground(new java.awt.Color(255, 51, 0));
        label9Rules.setText("cu proprietati generate aleator de sistem (ascunse inainte");

        label10Rules.setFont(new java.awt.Font("Georgia", 0, 11));
        label10Rules.setForeground(new java.awt.Color(255, 51, 0));
        label10Rules.setText("de cumparare).");

        label4Rules.setFont(new java.awt.Font("Georgia", 0, 11));
        label4Rules.setForeground(new java.awt.Color(255, 51, 0));
        label4Rules.setText("elemente pe care jucatorii le pot combina in diferite feluri");

        javax.swing.GroupLayout panelRulesLayout = new javax.swing.GroupLayout(panelRules);
        panelRules.setLayout(panelRulesLayout);
        panelRulesLayout.setHorizontalGroup(
            panelRulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRulesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelRulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4Rules)
                    .addComponent(label10Rules)
                    .addComponent(label9Rules)
                    .addComponent(label8Rules)
                    .addComponent(label7Rules)
                    .addComponent(label6Rules)
                    .addComponent(label5Rules)
                    .addComponent(label3Rules)
                    .addComponent(label2Rules)
                    .addComponent(label1Rules))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRulesLayout.setVerticalGroup(
            panelRulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRulesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1Rules)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label2Rules)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label3Rules)
                .addGap(11, 11, 11)
                .addComponent(label4Rules)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label5Rules)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label6Rules)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label7Rules)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label8Rules)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label9Rules)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label10Rules)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        LoginButtonRules.setText("Login");
        LoginButtonRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonRules(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(LoginButtonRules)
                        .addGap(18, 18, 18)
                        .addComponent(panelRules, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRules, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(LoginButtonRules)))
                .addContainerGap())
        );
    }

    private void loginButtonRules(java.awt.event.ActionEvent evt) {
    }
    
    public javax.swing.JButton getLoginButtonRules() 
    {
		return LoginButtonRules;
	}
    
    private javax.swing.JButton LoginButtonRules;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label10Rules;
    private javax.swing.JLabel label1Rules;
    private javax.swing.JLabel label2Rules;
    private javax.swing.JLabel label3Rules;
    private javax.swing.JLabel label4Rules;
    private javax.swing.JLabel label5Rules;
    private javax.swing.JLabel label6Rules;
    private javax.swing.JLabel label7Rules;
    private javax.swing.JLabel label8Rules;
    private javax.swing.JLabel label9Rules;
    private javax.swing.JPanel panelRules;
    
}
