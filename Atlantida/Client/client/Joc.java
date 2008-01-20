package client;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;


import client.ComunicareClient;
import client.Credits;
import client.Login;
import client.Rules;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Joc 
{
	protected static String username = "";
	private static String parola = "";
	private static String email = "";
	private Login loginPanel;
	private Rules rulesPanel;
	private Credits creditsPanel;
	private Register registerPanel;
	private StartPage startPagePanel;
	private Buy buyPanel;
	private Sale salePanel;
	private String host = "10.0.2.56";
	private JFrame frame;
	private ComunicareClient comunicareClient;
	private String[] header;
	private static String[][] values;
	private String puncte = "";
	private String[] piataHeader;
	private String[][] piataValues;
	static Color colorPanel = new Color(255, 204, 204);
	static Color colorInternalPanel = new Color(255, 255, 204);
	private static int inventarSize = 0;


	
	public Joc()
	{
		 comunicareClient = new ComunicareClient(host,3000);
		 frame = new JFrame();
		 frame.setTitle("Atlantida");
		 frame.setBounds(200, 100, 550, 450);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
		 
		 ProgressMonitorExample.setareAfisaj();
		 
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
		
		comunicareClient = new ComunicareClient(host,3000);
		comunicareClient.conectareLaServer();

		username = loginPanel.getUsernameTextFieldLogin().getText();
		parola = new String(loginPanel.getPasswordPasswordFieldLogin().getPassword());
		
		dateUtilizator.add(username);
		dateUtilizator.add(parola);
		dateUtilizator.add("Bye!");

		comunicareClient.scriereDate(dateUtilizator);
		dateUtilizator = comunicareClient.citireDate();
		
		if (dateUtilizator.get(0).equals("insucces"))
			 JOptionPane.showMessageDialog(this.loginPanel, "Username sau parola incorecte!", "Login Error", JOptionPane.ERROR_MESSAGE);
		else
		{
			int size = populareTabelaInventar(dateUtilizator,true);
			
			puncte = dateUtilizator.get(size);
			actiuneStartPageButton();
		}
		comunicareClient.inchidereClient();
		
	}



	private int populareTabelaInventar(ArrayList<String> dateUtilizator,boolean flag ) {
		int length;
		String[] numeColoane;
		String[][] numeLinii;
		
		length = dateUtilizator.get(0).split(" ").length;
		numeColoane = new String[length];
		numeColoane = dateUtilizator.get(0).split(" ");
		
		dateUtilizator.remove(0);
		int size = dateUtilizator.size() - 1;

			numeLinii = new String[size][length];
			
			for (int i=0;i<size;i++)
			{
				numeLinii[i] = dateUtilizator.get(i).split(" ");
			}
		if (flag)
		{
			header = numeColoane;
			values = numeLinii;
			inventarSize = values.length;
		}
		else
		{
			piataHeader = numeColoane;
			piataValues = numeLinii;
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
					actiuneLoginButtonRegister();
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
		
		if (rowNr.length == 0 || rowNr.length == 1)
			JOptionPane.showMessageDialog(this.startPagePanel,"Selectati elemenTELE pe care doriti sa le combinaTI.", "Error", JOptionPane.ERROR_MESSAGE);
		else
		{
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
			int size = populareTabelaInventar(dateUtilizator,true);
			
			puncte = dateUtilizator.get(size);
			actiuneStartPageButton();
	
			
			comunicareClient.inchidereClient();
		}

	}

	private void actiuneStartPageButton()
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
		startPagePanel.getActualizareButtonStartPage().addActionListener(new ActionListener()
		 {
				@Override
				public void actionPerformed(ActionEvent e) {
					actiuneActualizareInventar();
				}
		  });
		startPagePanel.getPuncteLabelStartPage().setText(puncte);
	}

	private void actiuneBuyButtonStartPage()
	{
		ArrayList<String> dateUtilizator = new ArrayList<String>();

		comunicareClient = new ComunicareClient(host,3007);
		comunicareClient.conectareLaServer();
				
		dateUtilizator.add("piata");
		dateUtilizator.add(username);
		dateUtilizator.add("Bye!");
	
		comunicareClient.scriereDate(dateUtilizator);
		dateUtilizator = comunicareClient.citireDate();

		comunicareClient.inchidereClient();
		
		int size = populareTabelaInventar(dateUtilizator, false);
		puncte = dateUtilizator.get(size);
		
		buyPanel = new Buy(piataHeader,piataValues);
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
				actiuneStartPageButtonBuy();
			}
	     });
		buyPanel.getBuyButtonBuy().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneBuyButton();
			}
	     });
		buyPanel.getActualizareButtonBuy().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneBuyButtonStartPage();
			}
	     });
		
		buyPanel.getPuncteLabelBuy().setText(puncte);
		
		frame.getContentPane().validate();
		frame.paintAll(frame.getContentPane().getGraphics());
	}

	private void actiuneSaleButtonStartPage()
	{
		salePanel = new Sale(header,values);
	
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
				actiuneStartPageButton();
			}
	     });
		
		salePanel.getSaleButtonSale().addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				actiuneSaleButton();
			}
	     });
		salePanel.getPuncteLabelSale().setText(puncte);
	
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
				
		comunicareClient = new ComunicareClient(host,3002);
		comunicareClient.conectareLaServer();
		header = null;
		values = null;
		username = registerPanel.getUsernameTextFieldRegister().getText();
		parola = new String(registerPanel.getPasswordPasswordFieldRegister().getPassword());
		email = registerPanel.getMailTextFieldRegister().getText();
		dateUtilizator.add(username);
		dateUtilizator.add(parola);
		dateUtilizator.add(email);
		dateUtilizator.add("Bye!");

		comunicareClient.scriereDate(dateUtilizator);
		dateUtilizator = comunicareClient.citireDate();
		
		puncte = dateUtilizator.get(1);
		actiuneStartPageButton();
		
		comunicareClient.inchidereClient();

	}
	
	
	private void actiuneSaleButton()
	{
		ArrayList<String> dateUtilizator = new ArrayList<String>();
		
		int nrLine = salePanel.getJTable1().getSelectedRow();
		
		if (nrLine == -1)
			JOptionPane.showMessageDialog(this.salePanel,"Selectati elementul pe care doriti sa-l vindeti.", "Error", JOptionPane.ERROR_MESSAGE);
		else
		{
			comunicareClient = new ComunicareClient(host,3005);
			comunicareClient.conectareLaServer();
					
			dateUtilizator.add(username);
			dateUtilizator.add(values[nrLine][0]);
			dateUtilizator.add("Bye!");
		
			comunicareClient.scriereDate(dateUtilizator);
			dateUtilizator = comunicareClient.citireDate();
			int size = populareTabelaInventar(dateUtilizator,true);
			
			puncte = dateUtilizator.get(size);
			actiuneSaleButtonStartPage();
			
			comunicareClient.inchidereClient();
		}
	}
	
	private void actiuneBuyButton()
	{
		
		ArrayList<String> dateUtilizator = new ArrayList<String>();
		String sumaFaraSpatii = buyPanel.getLicitatieTextFieldBuy().getText().trim();
		Pattern sl = Pattern.compile("[^\\d]+"); 
		
		int nrLine = buyPanel.getJTable1().getSelectedRow();
		if (nrLine == -1)
			JOptionPane.showMessageDialog(this.buyPanel,"Selectati elementul pe care doriti sa-l cumparati.", "Error", JOptionPane.ERROR_MESSAGE);
		else
		{
			System.out.println("Parintele"+piataValues[nrLine][2]);
			if (piataValues[nrLine][2].equals("-1"))
			{
				if (sumaFaraSpatii.equals(""))
					JOptionPane.showMessageDialog(this.buyPanel,"Introduceti o suma pt. a putea participa la licitatie.", "Error", JOptionPane.ERROR_MESSAGE);
				else
				{
					Matcher m = sl.matcher(sumaFaraSpatii);
					
					if (m.find())
					{
						JOptionPane.showMessageDialog(this.buyPanel,"Suma introdusa trebuie sa fie formata strict din CIFRE!!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						float sumaLicitata = Float.parseFloat(sumaFaraSpatii);
						float pretElem = Float.parseFloat(piataValues[nrLine][3].trim());
						
						if (Float.parseFloat(puncte) < sumaLicitata)
							JOptionPane.showMessageDialog(this.buyPanel,"Nu aveti suficienti bani.Licitai mai putin.", "Error", JOptionPane.ERROR_MESSAGE);
						else
						{
							if (sumaLicitata < pretElem)
						    {
								JOptionPane.showMessageDialog(this.buyPanel,"Introduceti o suma mai mare decat valoarea elementului.", "Error", JOptionPane.ERROR_MESSAGE);
								buyPanel.getLicitatieTextFieldBuy().setText("");
						    }
							else
							{
								comunicareClient = new ComunicareClient(host,3006);
								comunicareClient.conectareLaServer();
									
								dateUtilizator.add(username);
								dateUtilizator.add(piataValues[nrLine][0]);
								dateUtilizator.add(buyPanel.getLicitatieTextFieldBuy().getText());
								dateUtilizator.add("Bye!");
							
								comunicareClient.scriereDate(dateUtilizator);
								dateUtilizator = comunicareClient.citireDate();
								
								long secRamase = Long.parseLong(dateUtilizator.get(0));
								if (secRamase != -1)
								{
									ProgressMonitorExample.setareAfisaj();
									ProgressMonitorExample pr = new ProgressMonitorExample(piataValues[nrLine][1], piataValues[nrLine][0], (int)secRamase);
									pr.setVisible(true);
									System.out.println("Licitatie" + secRamase);
								}
								else
									JOptionPane.showMessageDialog(this.buyPanel,"Ne pare rau.Nu ati putut participa la licitatie.Actualizati stocul pietei si incercati din nou!", "Error", JOptionPane.ERROR_MESSAGE);
								comunicareClient.inchidereClient();
							}
						}
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this.buyPanel,"Ati cumparat un element atomic.", "Info", JOptionPane.ERROR_MESSAGE);
				comunicareClient = new ComunicareClient(host,3006);
				comunicareClient.conectareLaServer();
					
				dateUtilizator.add(username);
				dateUtilizator.add(piataValues[nrLine][0]);
				dateUtilizator.add(piataValues[nrLine][3]);
				dateUtilizator.add("Bye!");
			
				comunicareClient.scriereDate(dateUtilizator);
				dateUtilizator = comunicareClient.citireDate();
				
				puncte = dateUtilizator.get(1);
				buyPanel.getPuncteLabelBuy().setText(puncte); 
				comunicareClient.inchidereClient();
			}
		}
	}
	
	private void actiuneStartPageButtonBuy()
	{
		ArrayList<String> dateUtilizator = new ArrayList<String>();

		comunicareClient = new ComunicareClient(host,3007);
		comunicareClient.conectareLaServer();

		dateUtilizator.add(username);
		dateUtilizator.add("Bye!");

		comunicareClient.scriereDate(dateUtilizator);
		dateUtilizator = comunicareClient.citireDate();

		int size = populareTabelaInventar(dateUtilizator,true);
		
		puncte = dateUtilizator.get(size);

		comunicareClient.inchidereClient();
		actiuneStartPageButton();
	}
	
	private void actiuneActualizareInventar()
	{
		ArrayList<String> dateUtilizator = new ArrayList<String>();

		comunicareClient = new ComunicareClient(host,3007);
		comunicareClient.conectareLaServer();
	
		dateUtilizator = actualizareNumeElemente();
		dateUtilizator.add(0,username);
		dateUtilizator.add("Bye!");
	
		comunicareClient.scriereDate(dateUtilizator);
		dateUtilizator = comunicareClient.citireDate();
		
		int size = populareTabelaInventar(dateUtilizator,true);
		
		puncte = dateUtilizator.get(size);
		actiuneStartPageButton();
		startPagePanel.getPuncteLabelStartPage().setText(puncte);

		comunicareClient.inchidereClient();
	}

	public static int getInventarSize() {
		return inventarSize;
	}
	public static void setValues(String[][] date) {
		values = date;
	}

  public static void setareAfisaj()
  {	
	  UIManager.put("Panel.background",new ColorUIResource(Joc.colorInternalPanel));
	  UIManager.put("OptionPane.background",new ColorUIResource(Joc.colorInternalPanel));
  }

	public ArrayList<String> actualizareNumeElemente()
	{
		ArrayList<String> elemente;
		elemente = startPagePanel.getRowEditor().getCeluleModificate();
		
		ArrayList<String> modificari = new ArrayList<String>();
		
		int id = 0;
		String[] element = new String[2];
		for(String s : elemente)
		{
			element = s.split(" ");
			modificari.add( element[1] + "\t" + values[Integer.parseInt(element[0])][0]);
		}
		
		
		return modificari;
	}
	  
	public static void main(String[] args) 
	{
		Joc joc = new Joc();
	}

}
