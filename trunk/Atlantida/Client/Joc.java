import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Joc 
{
	private static String username = "";
	private static String parola = "";
	private static String email = "";
	private Login loginPanel;
	private Rules rulesPanel;
	private Credits creditsPanel;
	private Register registerPanel;
	private StartPage startPagePanel;
	private Combination combinationPanel;
	private Buy buyPanel;
	private Sale salePanel;
	private String host = "192.168.1.102";
	private JFrame frame;
	private int width = 600;
	private int height = 450;
	private ComunicareClient comunicareClient;
	private String[] header;
	private String[][] values;

	
	public Joc()
	{
		comunicareClient = new ComunicareClient(host,3000);
		 frame = new JFrame();
		 frame.setTitle("Atlantida");
		 frame.setSize(width, height);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
		 
		 loginPanel = new Login();
		 frame.setContentPane(loginPanel);
		 frame.paint(frame.getContentPane().getGraphics());
		 frame.validate();
		 
		 loginPanel.getLoginButtonLogin().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneLoginButtonLogin();
			}
		 });
		
		 loginPanel.getRegisterButtonLogin().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneRegisterButtonLogin();
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
    	 
	}
	
	
	
	private void actiuneRegisterButtonLogin()
	{
		registerPanel = new Register();
		frame.getContentPane().removeAll();
		
		frame.setContentPane(registerPanel);
		registerPanel.getLoginButtonRegister().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneLoginButtonRegister();
			}
		 });
		 
		registerPanel.getRegisterButtonRegister().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (registerPanel.registerButtonRegisterHandler(e))
				actiuneRegisterButtonRegister();
			}
		 });
		frame.paintAll(frame.getContentPane().getGraphics());
		frame.getContentPane().validate();
	}
	
	private void actiuneLoginButtonLogin()
	{
		ArrayList<String> dateUtilizator = new ArrayList<String>();
		int length;
		
		comunicareClient = new ComunicareClient(host,3000);
		comunicareClient.conectareLaServer();

		username = loginPanel.getUsernameTextFieldLogin().getText();
		parola = new String(loginPanel.getPasswordPasswordFieldLogin().getPassword());
		
		dateUtilizator.add(username);
		dateUtilizator.add(parola);
		dateUtilizator.add("Bye!");

		comunicareClient.scriereDate(dateUtilizator);
		dateUtilizator = comunicareClient.citireDate();
		
		int size = populareTabelaInventar(dateUtilizator);
	
		actiuneStartPageButtonCombination();
		startPagePanel.getPuncteLabelStartPage().setText(dateUtilizator.get(size));

		comunicareClient.inchidereClient();
	}



	private int populareTabelaInventar(ArrayList<String> dateUtilizator) {
		int length;
		length = dateUtilizator.get(0).split(" ").length;
		header = new String[length];
		header = dateUtilizator.get(0).split(" ");
		
		int size = dateUtilizator.size() - 1;

			values = new String[size][length];
			
			for (int i=1;i<size;i++)
			{
				values[i-1] = dateUtilizator.get(i).split(" ");
			}
		return size;
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
					actiuneLoginButtonRegister();//actiuneLoginButtonRules
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
					actiuneLoginButtonRegister();
				}
		 });		
		frame.getContentPane().validate();
		frame.paintAll(frame.getContentPane().getGraphics());

	}
	

	private void actiuneLoginButtonRegister()
	{
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
		
		loginPanel.getRegisterButtonLogin().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneRegisterButtonLogin();
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
	
	
	private void actiuneCombinationButtonStartPage()
	{
		ArrayList<String> dateUtilizator = new ArrayList<String>();
		int[] rowNr;
		String idElementeSelectate = "";
		
		rowNr = startPagePanel.getJTable1().getSelectedRows();
		for (int i=0;i<rowNr.length-1;i++)
		{
			idElementeSelectate = idElementeSelectate.concat(values[rowNr[i]][0]);
			idElementeSelectate = idElementeSelectate.concat(",");
		}
		idElementeSelectate = idElementeSelectate.concat(values[rowNr[rowNr.length-1]][0]);
		
		dateUtilizator.add(username);
		dateUtilizator.add(idElementeSelectate);
		dateUtilizator.add("Bye!");
		
		comunicareClient = new ComunicareClient(host,3003);
		comunicareClient.conectareLaServer();
		
		comunicareClient.scriereDate(dateUtilizator);
		dateUtilizator = comunicareClient.citireDate();
		int size = populareTabelaInventar(dateUtilizator);
		
		actiuneStartPageButtonCombination();
		startPagePanel.getPuncteLabelStartPage().setText(dateUtilizator.get(size));

		
		comunicareClient.inchidereClient();
		
//		combinationPanel = new Combination();
//		frame.getContentPane().removeAll();
//		
//		
//		frame.setContentPane(combinationPanel);
//		combinationPanel.getStartPageButtonCombination().addActionListener(new ActionListener()
//		 {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					actiuneStartPageButtonCombination();
//				}
//		  });
//
//		combinationPanel.getLogoutButtonCombination().addActionListener(new ActionListener()
//		 {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					actiuneLogoutButton();
//				}
//		  });
//		frame.getContentPane().validate();
//		frame.paintAll(frame.getContentPane().getGraphics());

	}

	private void actiuneStartPageButtonCombination()
	{
		startPagePanel = new StartPage(header,values);	
		frame.getContentPane().removeAll();

		frame.setContentPane(startPagePanel);

		frame.paintAll(frame.getContentPane().getGraphics());
		frame.getContentPane().validate();
		

		startPagePanel.getLogoutButtonStartPage().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				 actiuneLogoutButton();
			}
		 });
		 
		startPagePanel.getCombinationButtonStartPage().addActionListener(new ActionListener()
		 {
				@Override
				public void actionPerformed(ActionEvent e) {
					actiuneCombinationButtonStartPage();
				}
		  });
		 
		startPagePanel.getBuyButtonStartPage().addActionListener(new ActionListener()
		 {
				@Override
				public void actionPerformed(ActionEvent e ) {
					actiuneBuyButtonStartPage();
				}
		  });
		 
		startPagePanel.getSaleButtonStartPage().addActionListener(new ActionListener()
		 {
				@Override
				public void actionPerformed(ActionEvent e) {
					actiuneSaleButtonStartPage();
				}
		  });
			

	}

	
	private void actiuneBuyButtonStartPage()
	{
		buyPanel = new Buy();
		frame.getContentPane().removeAll();
		frame.setContentPane(buyPanel);
		
		buyPanel.getLogoutButtonBuy().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneLogoutButton();
			}
	     });
		
		buyPanel.getStartPageButtonBuy().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneStartPageButtonCombination();
			}
	     });
		
		
		frame.getContentPane().validate();
		frame.paintAll(frame.getContentPane().getGraphics());
	}

	private void actiuneSaleButtonStartPage()
	{
		salePanel = new Sale();
		
		frame.getContentPane().removeAll();
		frame.setContentPane(salePanel);
		
		salePanel.getLogoutButtonSale().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneLogoutButton();
			}
	     });
		
		salePanel.getStartPageButtonSale().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneStartPageButtonCombination();
			}
	     });
		
		frame.getContentPane().validate();
		frame.paintAll(frame.getContentPane().getGraphics());
	}

	
	private void actiuneLogoutButton()
	{
		ArrayList<String> dateUtilizator = new ArrayList<String>();
		
		comunicareClient = new ComunicareClient(host,3001);
		comunicareClient.conectareLaServer();
		
		dateUtilizator.add(username);
		dateUtilizator.add(parola);
		dateUtilizator.add("Bye!");

		comunicareClient.scriereDate(dateUtilizator);
		comunicareClient.inchidereClient();
		
		actiuneLoginButtonRegister();
	}
	
	private void actiuneRegisterButtonRegister()
	{
		
		ArrayList<String> dateUtilizator = new ArrayList<String>();
		int length;
		
		comunicareClient = new ComunicareClient(host,3002);
		comunicareClient.conectareLaServer();
		header = null;
		values = null;
		username = registerPanel.getUsernameTextFieldRegister().getText();
		parola = new String(registerPanel.getPasswordPasswordFieldRegister().getPassword());
		email = registerPanel.getMailTextFieldRegister().getText();
//		System.out.println(username+parola+email);
		dateUtilizator.add(username);
		dateUtilizator.add(parola);
		dateUtilizator.add(email);
		dateUtilizator.add("Bye!");

		comunicareClient.scriereDate(dateUtilizator);
		dateUtilizator = comunicareClient.citireDate();
		
//		System.out.println("nr de coloane"+length);
	   
		//startPagePanel.getPuncteLabelStartPage().setText(dateUtilizator.get(size - 1));
		
		actiuneStartPageButtonCombination();
		
		startPagePanel.getPuncteLabelStartPage().setText(dateUtilizator.get(1));

		comunicareClient.inchidereClient();

	}
	public static void main(String[] args) 
	{
		Joc joc = new Joc();
	}

}
