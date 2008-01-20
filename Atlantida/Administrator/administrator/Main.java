package administrator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main {

	private static String username = "";
	private static String parola = "";
	private Admin adminPanel;
	private Login loginPanel;
	private Rules rulesPanel;
	private Credits creditsPanel;
	private JFrame frame;
	private String host = "10.0.2.56";
	private ComunicareClient comunicareClient;
	private CalculatorFrame calculator;
	
	public static String formula = "";
	public Main()
	{
		frame = new JFrame("Administrator");
		frame.setBounds(200, 100, 600, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginPanel = new Login();
		frame.setContentPane(loginPanel);
		loginPanel.getLoginButtonLogin().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneLoginButtonLogin();
			}
		 });
		loginPanel.getRulesButtonLogin().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneRulesButtonLogin();
			}
		 });

		loginPanel.getCreditsButtonLogin().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneCreditsButtonLogin();
			}
		 });

		frame.getContentPane().validate();
		frame.paintAll(frame.getContentPane().getGraphics());
		
	}
	
	private void actiuneLoginButtonLogin()
	{
		ArrayList<String> dateUtilizator = new ArrayList<String>();

		adminPanel = new Admin();
	
		comunicareClient = new ComunicareClient(host,3000);
		comunicareClient.conectareLaServer();

		username = loginPanel.getUsernameTextFieldLogin().getText();
		parola = new String(loginPanel.getPasswordPasswordFieldLogin().getPassword());

		dateUtilizator.add("administrator");
		dateUtilizator.add(username);
		dateUtilizator.add(parola);
		dateUtilizator.add("Bye!");

		comunicareClient.scriereDate(dateUtilizator);
		dateUtilizator = comunicareClient.citireDate();

		frame.getContentPane().removeAll();
		frame.setContentPane(adminPanel);

		adminPanel.textField1Admin.setText(dateUtilizator.get(0));
		adminPanel.textField2Admin.setText(dateUtilizator.get(1));
		adminPanel.textField3Admin.setText(dateUtilizator.get(2));
		adminPanel.textField4Admin.setText(dateUtilizator.get(3));
		adminPanel.textField5Admin.setText(dateUtilizator.get(4));
		adminPanel.textField6Admin.setText(dateUtilizator.get(5));
		adminPanel.textField8Admin.setText(dateUtilizator.get(6));
	
		
		adminPanel.getLogoutButtonAdmin().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneLogoutButtonAdmin();
			}
		 });
		adminPanel.getTrimiteDateButtonAdmin().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneTrimiteDateButtonAdmin();
			}
		 });
		adminPanel.getFormulaButtonAdmin().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneFormulaButtonAdmin();
			}
		 });
		
		
		frame.getContentPane().validate();
		frame.paintAll(frame.getContentPane().getGraphics());
		comunicareClient.inchidereClient();
		
	}
	
	
	private void actiuneRulesButtonLogin()
	{
		rulesPanel = new Rules();
		frame.getContentPane().removeAll();
		
		
		frame.setContentPane(rulesPanel);
		rulesPanel.getLoginButtonRules().addActionListener(new ActionListener()
		 {
				@Override
				public void actionPerformed(ActionEvent e) {
					actiuneLogoutButtonAdmin();//actiuneLoginButtonRules
				}
		 });
		frame.getContentPane().validate();
		frame.paintAll(frame.getContentPane().getGraphics());
		
		
	}
	
	private void actiuneCreditsButtonLogin()
	{
		creditsPanel = new Credits();
		frame.getContentPane().removeAll();
		
		
		frame.setContentPane(creditsPanel);
		creditsPanel.getLoginButtonCredits().addActionListener(new ActionListener()
		 {
				@Override
				public void actionPerformed(ActionEvent e) {
					actiuneLogoutButtonAdmin();
				}
		 });		
		frame.getContentPane().validate();
		frame.paintAll(frame.getContentPane().getGraphics());

	}
	
	private void actiuneLogoutButtonAdmin()
	{
    	ArrayList<String> dateUtilizator = new ArrayList<String>();
		
		comunicareClient = new ComunicareClient(host,3001);
		comunicareClient.conectareLaServer();
		
		dateUtilizator.add(username);
		dateUtilizator.add(parola);
		dateUtilizator.add("Bye!");

		comunicareClient.scriereDate(dateUtilizator);
		comunicareClient.inchidereClient();
		
		loginPanel = new Login();
		frame.getContentPane().removeAll();
		frame.setContentPane(loginPanel);
		
		loginPanel.getLoginButtonLogin().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneLoginButtonLogin();
			}
		 });
		loginPanel.getRulesButtonLogin().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneRulesButtonLogin();
			}
		 });

		loginPanel.getCreditsButtonLogin().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneCreditsButtonLogin();
			}
		 });

		frame.getContentPane().validate();
		frame.paintAll(frame.getContentPane().getGraphics());
	}
	private void actiuneTrimiteDateButtonAdmin()
	{
		ArrayList<String> dateUtilizator = new ArrayList<String>();
		
	
		
		if (   valoareCorecta(adminPanel.textField1Admin.getText())
			&& nrFloatPoz(adminPanel.textField2Admin.getText())
		    && nrFloatNeg(adminPanel.textField3Admin.getText())
			&& nrFloatNeg(adminPanel.textField4Admin.getText())
			&& nrFloatNeg(adminPanel.textField5Admin.getText())
			&& valoareCorecta(adminPanel.textField6Admin.getText())
			&& valoareCorecta(adminPanel.textField8Admin.getText()))
			if (formula.equals(""))
			{
				if (   adminPanel.getJTextField1().getText().equals("")
					&& adminPanel.getTextField7Admin().getText().equals("")
					&& adminPanel.getTextField9Admin().getText().equals("")
					&& adminPanel.getTextField10Admin().getText().equals(""))
					{
						comunicareClient = new ComunicareClient(host,3004);
						comunicareClient.conectareLaServer();
						dateUtilizator = seteazaDateUtilizator();
						comunicareClient.scriereDate(dateUtilizator);
						dateUtilizator = comunicareClient.citireDate();
						if (dateUtilizator.get(0).equalsIgnoreCase("insucces"))
							JOptionPane.showMessageDialog(this.adminPanel,"Eroare la adaugare!", "Error", JOptionPane.ERROR_MESSAGE);							
						comunicareClient.inchidereClient();

					}
				else
				{
					JOptionPane.showMessageDialog(this.adminPanel,"1Ati gresit! Incercati inca o data.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				if (   valoareCorecta(adminPanel.getTextField9Admin().getText())
					&& valoareCorecta(adminPanel.getTextField10Admin().getText()))
					{
						comunicareClient = new ComunicareClient(host,3004);
						comunicareClient.conectareLaServer();
						dateUtilizator = seteazaDateUtilizator();
						comunicareClient.scriereDate(dateUtilizator);
						dateUtilizator = comunicareClient.citireDate();
						if (dateUtilizator.get(0).equalsIgnoreCase("insucces"))
							JOptionPane.showMessageDialog(this.adminPanel,"Eroare la adaugare!", "Error", JOptionPane.ERROR_MESSAGE);							
						comunicareClient.inchidereClient();
	
					}
				else
				{
					JOptionPane.showMessageDialog(this.adminPanel,"2Ati gresit! Incercati inca o data.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		else
		{
			JOptionPane.showMessageDialog(this.adminPanel,"3Ati gresit! Incercati inca o data.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private ArrayList<String> seteazaDateUtilizator()
	{
    	ArrayList<String> dateUtilizator = new ArrayList<String>();

		dateUtilizator.add(adminPanel.textField1Admin.getText());
		dateUtilizator.add(adminPanel.textField2Admin.getText());
		dateUtilizator.add(adminPanel.textField3Admin.getText());
		dateUtilizator.add(adminPanel.textField4Admin.getText());
		dateUtilizator.add(adminPanel.textField5Admin.getText());
		dateUtilizator.add(adminPanel.textField6Admin.getText());
		dateUtilizator.add(adminPanel.textField8Admin.getText());
		dateUtilizator.add(adminPanel.getJTextField1().getText());
		dateUtilizator.add(adminPanel.getTextField7Admin().getText());
		dateUtilizator.add(formula);
		dateUtilizator.add(adminPanel.getTextField9Admin().getText());
		dateUtilizator.add(adminPanel.getTextField10Admin().getText());
		dateUtilizator.add("Bye!");
		return dateUtilizator;
	}
	
	private boolean valoareCorecta(String cuvant)
	{
		Pattern p = Pattern.compile("[^0-9 ]+");
		Pattern p1 = Pattern.compile("[0-9]");
		Matcher m = p.matcher(cuvant);
		Matcher m1 = p1.matcher(cuvant);
		
		if (m.find())
			return false;
		else
		{
			if (m1.find())
				return true;
			else
				return false;
		}
	}
	
	private boolean nrFloatNeg(String cuv)
	{
		Pattern p = Pattern.compile("[^0-9\\. -]+");
		Pattern p1 = Pattern.compile("[\\-]?[0-9]+[\\.]?[0-9]+");
		Matcher m = p.matcher(cuv);
		Matcher m1 = p1.matcher(cuv);
		
		if (m.find())
			return false;
		else
		{
			if (m1.find())
				return true;
			else
				return false;
		}
	}
	
	private boolean nrFloatPoz(String cuv)
	{
		Pattern p = Pattern.compile("[^0-9\\. ]+");
		Pattern p1 = Pattern.compile("[0-9]+[\\.]?[0-9]+");
		Matcher m = p.matcher(cuv);
		Matcher m1 = p1.matcher(cuv);
		
		if (m.find())
			return false;
		else
		{
			if (m1.find())
				return true;
			else
				return false;
		}
	}
	private void actiuneFormulaButtonAdmin()
	{
		Pattern p = Pattern.compile(".");
		Matcher mNumeElem = p.matcher(adminPanel.getJTextField1().getText());
		Matcher mProp = p.matcher(adminPanel.getTextField7Admin().getText());
		if (mNumeElem.find())
		{
			if (mProp.find())
			{
				calculator = new CalculatorFrame(adminPanel.getTextField7Admin().getText());
		    	calculator.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(this.adminPanel,"Introduceti numele proprietatii speciale!!!...", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(this.adminPanel,"Introduceti numele elementului!!!...", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
	}

}
