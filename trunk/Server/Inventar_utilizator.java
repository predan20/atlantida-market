import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class Inventar_utilizator extends BazaDeDate 
{	
	public Inventar_utilizator(String host, String port, String numeBazaDate, String utilizator, String parola)
	{
		super(host, port, numeBazaDate, utilizator, parola);
	}
	
	public void creareInventar(String numeUtilizator, ArrayList<String> numeColoane)
	{
		try
		{
			Statement decl = null;
			try
			{
				decl = this.conn.createStatement();
			}
			catch(Exception e)
			{
				System.out.println("In statement!");
			}
			String comanda = "";
			
			comanda = " CREATE TABLE `" + numeUtilizator + "` (" +
					  "`ID` SMALLINT( 6 ) NOT NULL AUTO_INCREMENT PRIMARY KEY ," + 
					  "`NUME` VARCHAR( 15 ) NULL ," +
					  "`PARINTE` SMALLINT( 6 ) NULL ";
			
			for (int i = 3; i < numeColoane.size(); i++)
			{
				comanda += ",`" + numeColoane.get(i) + "` FLOAT UNSIGNED NULL";
					  
			}
			comanda += ") ENGINE = MYISAM CHARACTER SET latin1 COLLATE latin1_swedish_ci";
			
			
			decl.addBatch(comanda);
			decl.executeBatch();
			System.out.println(comanda);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean inserareInregistrare(String numeUtilizator, String numeElement, String proprietatiElement)
	{	
		Statement decl = null;
		
		try
		{
			decl = this.conn.createStatement();
			String comanda = "";
			// in proprietati element se afla toate proprietatile el in afara de nume, separate prin virgula
			comanda = "INSERT INTO " + numeUtilizator + "(ID, NUME, MASA, CONSUM, RANDAMENT, RATA_INV, SANATATE, PROP_SPEC, PARINTE) " +
						"VALUES(0, '" + numeElement + "'," + proprietatiElement + ");";
				
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
	
	public boolean inserareInregistrareVida(String numeUtilizator)
	{
		Statement decl = null;
		
		try
		{
			decl = this.conn.createStatement();
			String comanda = "";
			comanda = "INSERT INTO " + numeUtilizator + "() VALUES ();";
				
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
	
	public int getUltimulElement(String numeUtilizator)
	{
		Statement decl = null;
		ResultSet rezultat = null;
		try
		{
			decl = this.conn.createStatement();
			String comanda = "";
			
			comanda = "SELECT id FROM " + numeUtilizator + " ORDER BY id DESC LIMIT 1";
			
			rezultat = decl.executeQuery(comanda);
			
			rezultat.first();
			
			return rezultat.getInt(1);
		}
		catch (Exception e)
		{	
			e.printStackTrace();
			return -1;
		}
	}
	
	
	public boolean stergereInregistrare(String numeUtilizator, String numeElement)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			
			comanda = "DELETE FROM " + numeUtilizator + " WHERE nume='" + numeElement + "';";
			
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
	
	public ArrayList<String> getInventar(String numeUtilizator, ArrayList<String> numeColoane)
	{
		ArrayList<String> inventar = new ArrayList<String>();
		ResultSet rezultat = null;
		
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
				
			comanda = "SELECT * FROM " + numeUtilizator + " WHERE parinte = -1;";
			rezultat = decl.executeQuery(comanda);
						
			String element = "";
			while (rezultat.next())
			{
				element = "";
				
				for (int i = 0; i < numeColoane.size(); i++)
				{
					System.out.println(rezultat.getString(i+1));
					element += numeColoane.get(i) + " - " + rezultat.getString(i+1) + " ";
				}
				
				inventar.add(element);
			}
			
			return inventar;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean calculareProprietati(String numeUtilizator, int idParinte)
	{		
		ArrayList<Float> valoareProprietati = new ArrayList<Float>();
		ResultSet rezultatSum = null, rezultatMin = null, rezultatProd = null;
		float masa = 0, consum = 0, randament = 1, rataInvechire = 0, sanatate = 0;
		int parinte = 0;
		
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			
			//Calculare randament
			comanda = "select randament from " + numeUtilizator + " WHERE parinte="  + idParinte +";";
			rezultatProd = decl.executeQuery(comanda);
			float prod = 1;
			while(rezultatProd.next())
			{
				prod *= rezultatProd.getFloat(1);
			}
			//
			
			//Calculare rata invechire
			float min = 0;
			comanda = "select min(rata_inv) from " + numeUtilizator + " WHERE parinte="  + idParinte +";";
			rezultatMin = decl.executeQuery(comanda);
			rezultatMin.first();
			min = rezultatMin.getFloat(1);
			//
			
			//Calculare masa, consum, sanatate, protectie, acceleratie, putere 
			comanda = "select sum(masa), sum(consum), sum(sanatate), sum(protectie), sum(acceleratie), sum(putere) from " + numeUtilizator + " WHERE parinte="  + idParinte +" AND parinte IS NOT NULL;";
			rezultatSum = decl.executeQuery(comanda);
			rezultatSum.first();
			//
			
			//Introducere valori proprietati
			valoareProprietati.add(rezultatSum.getFloat(1));//masa
			valoareProprietati.add((float)(rezultatSum.getFloat(2) * 1.1));//consum
			valoareProprietati.add(prod);//randament
			valoareProprietati.add(min);//rata invechire
			valoareProprietati.add(rezultatSum.getFloat(3));//sanatate
			valoareProprietati.add(rezultatSum.getFloat(4));//protectie
			valoareProprietati.add(rezultatSum.getFloat(5));//acceleratie
			valoareProprietati.add(rezultatSum.getFloat(6));//putere
			//
//			for(int i=0;i<valoareProprietati.size();i++)
//			{
//				System.out.println(valoareProprietati.get(i));
//			}
			
			comanda = "UPDATE " + numeUtilizator + " SET nume = 'elemCompus', parinte = -1, masa = " + valoareProprietati.get(0) + 
					", consum = " + valoareProprietati.get(1) + ", randament = " + valoareProprietati.get(2) + 
					", rata_inv = " + valoareProprietati.get(3) + ", sanatate = " + valoareProprietati.get(4) +
					", protectie = " + valoareProprietati.get(5) + ", acceleratie = " + valoareProprietati.get(6) + 
					", putere = " + valoareProprietati.get(7) + "WHERE id = " + idParinte + ";";
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
	
	public boolean setParinte(String numeUtilizator, String idElement, int parinte)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			
			comanda = "UPDATE " + numeUtilizator + " SET PARINTE=" + parinte + " WHERE id='" + idElement + "';";
			
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
}
