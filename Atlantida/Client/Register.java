import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Register extends javax.swing.JPanel {
    
     public Register() {
        initComponents();
    }
    
     private void initComponents() {

        registeLabelRegister = new javax.swing.JLabel();
        loginButtonRegister = new javax.swing.JButton();
        registerPanelRegister = new javax.swing.JPanel();
        usernameLabelRegister = new javax.swing.JLabel();
        passwordLabelRegister = new javax.swing.JLabel();
        confirmPasswordLabelRegister = new javax.swing.JLabel();
        passwordPasswordFieldRegister = new javax.swing.JPasswordField();
        confirmPasswordPasswordFieldRegister = new javax.swing.JPasswordField();
        usernameTextFieldRegister = new javax.swing.JTextField();
        registerButtonRegister = new javax.swing.JButton();
        mailLabelRegister = new javax.swing.JLabel();
        mailTextFieldRegister = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 204, 204));

        registeLabelRegister.setFont(new java.awt.Font("Tahoma", 1, 18));
        registeLabelRegister.setForeground(new java.awt.Color(255, 51, 0));
        registeLabelRegister.setText("Register");

        loginButtonRegister.setText("Login");
        loginButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonRegisterHandler(evt);
            }
        });

        registerPanelRegister.setBackground(new java.awt.Color(255, 255, 204));

        usernameLabelRegister.setFont(new java.awt.Font("Georgia", 1, 12));
        usernameLabelRegister.setForeground(new java.awt.Color(255, 51, 0));
        usernameLabelRegister.setText("Nume utilizator");

        passwordLabelRegister.setFont(new java.awt.Font("Georgia", 1, 12));
        passwordLabelRegister.setForeground(new java.awt.Color(255, 51, 0));
        passwordLabelRegister.setText("Parola");

        confirmPasswordLabelRegister.setFont(new java.awt.Font("Georgia", 1, 12));
        confirmPasswordLabelRegister.setForeground(new java.awt.Color(255, 51, 0));
        confirmPasswordLabelRegister.setText("Confirmare parola");

        registerButtonRegister.setText("Register");
        registerButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonRegisterHandler(evt);
            }
        });

        mailLabelRegister.setFont(new java.awt.Font("Georgia", 1, 12));
        mailLabelRegister.setForeground(new java.awt.Color(255, 51, 0));
        mailLabelRegister.setText("E-mail");

        javax.swing.GroupLayout registerPanelRegisterLayout = new javax.swing.GroupLayout(registerPanelRegister);
        registerPanelRegister.setLayout(registerPanelRegisterLayout);
        registerPanelRegisterLayout.setHorizontalGroup(
            registerPanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelRegisterLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(registerButtonRegister)
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(registerPanelRegisterLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(registerPanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabelRegister)
                    .addComponent(confirmPasswordLabelRegister)
                    .addComponent(usernameLabelRegister)
                    .addComponent(mailLabelRegister))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(registerPanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mailTextFieldRegister)
                    .addComponent(usernameTextFieldRegister)
                    .addComponent(confirmPasswordPasswordFieldRegister)
                    .addComponent(passwordPasswordFieldRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        registerPanelRegisterLayout.setVerticalGroup(
            registerPanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelRegisterLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(registerPanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabelRegister)
                    .addComponent(usernameTextFieldRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registerPanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabelRegister)
                    .addComponent(passwordPasswordFieldRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registerPanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPasswordLabelRegister)
                    .addComponent(confirmPasswordPasswordFieldRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registerPanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mailLabelRegister)
                    .addComponent(mailTextFieldRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(registerButtonRegister)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(loginButtonRegister)
                        .addGap(18, 18, 18)
                        .addComponent(registerPanelRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(registeLabelRegister)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(registeLabelRegister)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(loginButtonRegister))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(registerPanelRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
     
    private void loginButtonRegisterHandler(java.awt.event.ActionEvent evt) 
    {
      
    }

    public boolean registerButtonRegisterHandler(java.awt.event.ActionEvent evt) 
    {
     	String usr = usernameTextFieldRegister.getText();
		String pwd = new String(passwordPasswordFieldRegister.getPassword());
		String cpwd = new String(confirmPasswordPasswordFieldRegister.getPassword());
		String email = mailTextFieldRegister.getText();
		Pattern usrName = Pattern.compile("\\w+");
		Pattern mail = Pattern.compile("\\w+[\\w.]*\\w@\\w[\\w.]+\\.\\w+");
		
		
		Matcher match = usrName.matcher(usr);
		if (match.find())
			if (usr.compareTo(match.group())==0)
			{
				if (usr.equalsIgnoreCase("licitatii") || usr.equalsIgnoreCase("piata") || usr.equalsIgnoreCase("retragere") || usr.equalsIgnoreCase("bye!"))
					 JOptionPane.showMessageDialog(this, "Va rugam sa va alegeti alt nume!!", "Error", JOptionPane.ERROR_MESSAGE);	
				else
				{
					if (pwd.length()<6) JOptionPane.showMessageDialog(this, "Parola trebuie sa contina cel putin 6 caractere!.", "Login Error", JOptionPane.ERROR_MESSAGE);
					else
					{
						if (!pwd.equals(cpwd))
						{
						    JOptionPane.showMessageDialog(this, "Ati gresit parola!Incercati din nou.", "Login Error", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							Matcher m = mail.matcher(email);
							if (m.find())
							{
								if (email.compareTo(m.group())==0)
									return true;
								else
									JOptionPane.showMessageDialog(this, "Adresa de e-mail nu e valida!.", "Login Error", JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								JOptionPane.showMessageDialog(this, "Invalid e-mail adress!.", "Login Error", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
			else
			{
			    JOptionPane.showMessageDialog(this, "Invalid username!.", "Login Error", JOptionPane.ERROR_MESSAGE);
			}
		else
		    JOptionPane.showMessageDialog(this, "Invalid username!.", "Login Error", JOptionPane.ERROR_MESSAGE);
		return false;
    }
    
    public javax.swing.JButton getLoginButtonRegister() 
    {
		return loginButtonRegister;
	}
    
    public javax.swing.JButton getRegisterButtonRegister() 
    {
    	return registerButtonRegister;
    }
       
    public javax.swing.JTextField getUsernameTextFieldRegister() 
    {
    	return usernameTextFieldRegister;
    }
              
    public javax.swing.JPasswordField getPasswordPasswordFieldRegister() 
    {
    	return passwordPasswordFieldRegister;
    }
   
    public javax.swing.JTextField getMailTextFieldRegister() {
		return mailTextFieldRegister;
	}
    
    private javax.swing.JLabel confirmPasswordLabelRegister;
    private javax.swing.JPasswordField confirmPasswordPasswordFieldRegister;
    private javax.swing.JButton loginButtonRegister;
    private javax.swing.JLabel mailLabelRegister;
    private javax.swing.JTextField mailTextFieldRegister;
    private javax.swing.JLabel passwordLabelRegister;
    private javax.swing.JPasswordField passwordPasswordFieldRegister;
    private javax.swing.JLabel registeLabelRegister;
    private javax.swing.JButton registerButtonRegister;
    private javax.swing.JPanel registerPanelRegister;
    private javax.swing.JLabel usernameLabelRegister;
    private javax.swing.JTextField usernameTextFieldRegister;
    
}

