import java.util.regex.Pattern;



public class Login extends javax.swing.JPanel {
    
     public Login() {
        initComponents();
    }
    
     private void initComponents() {

        loginLabelLogin = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        usernameLabelLogin = new javax.swing.JLabel();
        passwordLabelLogin = new javax.swing.JLabel();
        loginButtonLogin = new javax.swing.JButton();
        usernameTextFieldLogin = new javax.swing.JTextField();
        passwordPasswordFieldLogin = new javax.swing.JPasswordField();
        registerButtonLogin = new javax.swing.JButton();
        rulesButtonLogin = new javax.swing.JButton();
        creditsButtonLogin = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        loginLabelLogin.setFont(new java.awt.Font("Tahoma", 1, 18));
        loginLabelLogin.setForeground(new java.awt.Color(255, 51, 0));
        loginLabelLogin.setText("Login");

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        usernameLabelLogin.setFont(new java.awt.Font("Georgia", 1, 12));
        usernameLabelLogin.setForeground(new java.awt.Color(255, 51, 0));
        usernameLabelLogin.setText("Nume utilizator");

        passwordLabelLogin.setFont(new java.awt.Font("Georgia", 1, 12));
        passwordLabelLogin.setForeground(new java.awt.Color(255, 51, 0));
        passwordLabelLogin.setText("Parola");

        loginButtonLogin.setText("Login");
        loginButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonLoginHandler(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabelLogin)
                            .addComponent(passwordLabelLogin))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordPasswordFieldLogin)
                            .addComponent(usernameTextFieldLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(loginButtonLogin)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabelLogin)
                    .addComponent(usernameTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordLabelLogin)
                    .addComponent(passwordPasswordFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(loginButtonLogin)
                .addGap(33, 33, 33))
        );

        registerButtonLogin.setText("Creare cont");
        registerButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonLogin(evt);
            }
        });

        rulesButtonLogin.setText("Reguli");
        rulesButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rulesButtonLoginHandler(evt);
            }
        });

        creditsButtonLogin.setText("Despre noi");
        creditsButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsButtonLoginHandler(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(creditsButtonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerButtonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rulesButtonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(loginLabelLogin)
                .addContainerGap(218, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loginLabelLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(registerButtonLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rulesButtonLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(creditsButtonLogin)))
                .addContainerGap())
        );
    }
     
    private void loginButtonLoginHandler(java.awt.event.ActionEvent evt) 
    {  
		
    }

    private void registerButtonLogin(java.awt.event.ActionEvent evt) 
    {
    	
    }

    private void rulesButtonLoginHandler(java.awt.event.ActionEvent evt) 
    {
       
    }

    private void creditsButtonLoginHandler(java.awt.event.ActionEvent evt) 
    {
        
    }
    
    public javax.swing.JButton getLoginButtonLogin() 
    {
		return loginButtonLogin;
	}
    
    public javax.swing.JButton getRegisterButtonLogin() 
    {
		return registerButtonLogin;
	}
    
    public javax.swing.JTextField getUsernameTextFieldLogin() {
		return usernameTextFieldLogin;
	}
    
    public javax.swing.JPasswordField getPasswordPasswordFieldLogin() {
		return passwordPasswordFieldLogin;
	}
    
    public javax.swing.JButton getRulesButtonLogin() 
    {
		return rulesButtonLogin;
	}
    public javax.swing.JButton getCreditsButtonLogin() 
    {
		return creditsButtonLogin;
	}
    
    private javax.swing.JButton creditsButtonLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButtonLogin;
    private javax.swing.JLabel loginLabelLogin;
    private javax.swing.JLabel passwordLabelLogin;
    private javax.swing.JPasswordField passwordPasswordFieldLogin;
    private javax.swing.JButton registerButtonLogin;
    private javax.swing.JButton rulesButtonLogin;
    private javax.swing.JLabel usernameLabelLogin;
    private javax.swing.JTextField usernameTextFieldLogin;
    
}
