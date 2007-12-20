import java.sql.*;
import java.util.ArrayList;

public class Jucator extends BazaDeDate
{
	public Jucator(String numeBazaDate)
	{
		super(numeBazaDate);
	}
	
	public boolean setNumarPuncte(String numarPuncte, String numeUtilizator)
	{
		Statement decl = null;
		try
		{
			decl = this.conn.createStatement();
			String comanda = "";
			comanda = "UPDATE Jucatori SET NR_PUNCTE=" + numarPuncte + " WHERE utilizator='" + numeUtilizator + "';"; 
			
			decl.addBatch(comanda);
			decl.executeBatch();
			
			return true;
		}
		catch (Exception e)
		{	
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<String> getNumeColoane(String numeUtilizator)
	{
		ArrayList<String> numeColoane = new ArrayList<String>();
		ResultSet rezultat;
		try
		{
			Statement decl = this.conn.createStatement();
			int i = 1;
			rezultat = decl.executeQuery("SHOW COLUMNS FROM Inventar_utilizator;");
			
			while (rezultat.next())
			{
				numeColoane.add(rezultat.getString(1));				
				i++;
			}
			
			return numeColoane;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	
	public int inserareInregistrare(String numeUtilizator, String parolaUtilizator, String emailUtilizator, String nrPuncte)
	{	
		Statement decl = null;
		ResultSet rezultatUtilizator = null;
		ResultSet rezultatEmail = null;

		try
		{
			decl = this.conn.createStatement();
			
			try
			{
				String comanda = "";
				comanda = "INSERT INTO Jucatori (ID, UTILIZATOR, PAROLA, EMAIL, NR_CICLURI, TIP_JUCATOR, NR_PUNCTE) " +
						"VALUES(0, '" + numeUtilizator + "','" + parolaUtilizator + "','" + emailUtilizator + "', -1, 0, " + nrPuncte + ");";
				
				decl.addBatch(comanda);
				decl.executeBatch();
			}
			catch (BatchUpdateException e)
			{	
				e.printStackTrace();
				rezultatUtilizator = decl.executeQuery("SELECT utilizator FROM Jucatori WHERE utilizator='" + numeUtilizator +"';");
				if (rezultatUtilizator.next())
				{
					//Utilizatorul exista
					System.out.println("Utilizatorul exista.");
					return 1;
				}

				rezultatEmail = decl.executeQuery("SELECT email FROM Jucatori WHERE email='" + emailUtilizator +"';");
				if (rezultatEmail.next())
				{
					//Email-ul exista
					System.out.println("Email-ul exista.");
					return 2;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean stergereInregistrare(String numeUtilizator)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			
			comanda = "DELETE FROM Jucatori WHERE utilizator='" + numeUtilizator + "';";
			
			decl.addBatch(comanda);
			decl.executeBatch();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean validareDate(String numeUtilizator, String parolaUtilizator)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			ResultSet rezultat;
			
			comanda = "SELECT utilizator FROM Jucatori WHERE utilizator='" + numeUtilizator + "' AND parola ='" + parolaUtilizator + "';";
			rezultat = decl.executeQuery(comanda);
			if(rezultat.first())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean actualizareCapitalJucator(String numeUtilizator, float valoareElement, String operator)
	{
		try
		{
			Statement decl = this.conn.createStatement(); 
			String comanda = "";
		
			comanda = "UPDATE Jucatori " + "SET nr_puncte= nr_puncte " + operator + valoareElement + " WHERE utilizator='" + numeUtilizator+ "';";
			decl.addBatch(comanda);
			decl.executeBatch();
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}		
}
