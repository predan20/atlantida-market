import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Administrator extends BazaDeDate
{
	public Administrator(String numeBazaDate)
	{
		super(numeBazaDate);
	}
	
	public boolean actualizareInventarUtilizator(String numeColoanaNoua)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			
			String comanda = "";
			
			comanda = "ALTER TABLE Inventar_utilizator ADD " + numeColoanaNoua + " FLOAT;";
			
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
	
	public boolean actualizareInventare(String numeColoanaNoua)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			Statement decl_inventare = this.conn.createStatement();
			
			String comanda = "";
			
			ResultSet rezultat;
			comanda = "SHOW TABLES FROM Inventare;";
			rezultat = decl.executeQuery(comanda);
			
			while(rezultat.next())
			{
				if (!rezultat.getString(1).equals("Licitatii"))
				{
					comanda = "ALTER TABLE " + rezultat.getString(1) + " ADD " + numeColoanaNoua + " FLOAT;";
					decl_inventare.addBatch(comanda);
					decl_inventare.executeBatch();
				}
			}
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setareParametriAdministrare(ArrayList<String> valoareParametri)
	{
		ArrayList<String> numeColoane = this.getNumeColoane("Administrare");
		
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "UPDATE Administrare SET ";
			
			int nrColoane = numeColoane.size();
			for (int i = 0; i < nrColoane - 1; i++)
			{
				if (!valoareParametri.get(i).trim().equals(""))
				{
					comanda += numeColoane.get(i) + "=" + valoareParametri.get(i) + ",";
				}
			}
			
			if (!valoareParametri.get(nrColoane - 1).trim().equals(""))
			{
				comanda += numeColoane.get(nrColoane - 1) + "=" + valoareParametri.get(nrColoane - 1) + " LIMIT 1;";
			}
			else
			{
				if (comanda.lastIndexOf(',') == comanda.length() - 1)
				{
					comanda = comanda.substring(0, comanda.length() - 2);
					comanda += " LIMIT 1;";
				}
			}
			
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
	
	public ArrayList<String> getNumeColoane(String numeTabela)
	{
		ArrayList<String> numeColoane = new ArrayList<String>();
		ResultSet rezultat;
		try
		{
			Statement decl = this.conn.createStatement();
			int i = 1;
			rezultat = decl.executeQuery("SHOW COLUMNS FROM " + numeTabela + ";");
			
			while (rezultat.next())
			{
				numeColoane.add(rezultat.getString(1));
				System.out.println(rezultat.getString(1));
				
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
	
	public String getProprietateInitiala(String numeProprietate)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			ResultSet rezultat;
			String comanda = "";
			
			comanda = "SELECT " + numeProprietate + " FROM Administrare;";
			rezultat = decl.executeQuery(comanda);
			
			rezultat.first();
			return rezultat.getString(1);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "";
		}
	}
	
	public ArrayList<String> getProprietatiAdministare()
	{
		ArrayList<String> proprietati = new ArrayList<String>();
		try
		{
			Statement decl = this.conn.createStatement();
			ResultSet rezultat;
			String comanda = "";
			
			comanda = "SELECT * FROM Administrare;";
			rezultat = decl.executeQuery(comanda);
			
			System.out.println("\n\nProp: ");
			rezultat.first();
			for (int i = 1; i <= rezultat.getMetaData().getColumnCount(); i++)
			{
				proprietati.add(rezultat.getString(i));
				System.out.println(proprietati.get(i-1));
			}
			return proprietati;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
}
