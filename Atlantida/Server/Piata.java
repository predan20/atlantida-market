import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.State;


public class Piata extends BazaDeDate
{
	public Piata(String numeBazaDate)
	{
		super(numeBazaDate);
	}
	
	public int mutareElement(String inventarSursa, String inventarDestinatie, int idElem)
	{
		try
		{
			int max = 0;
			max = this.getMaxID(inventarDestinatie);
			
			Statement decl;
			ResultSet rezultat;
			String comanda = "";
			
			decl = this.conn.createStatement();
			
			comanda = "SELECT * FROM " + inventarSursa + " WHERE id=" + idElem + ";";
			rezultat = decl.executeQuery(comanda);
			
			rezultat.first();
			if (rezultat.getInt("NR_COMP") == 1 && rezultat.getInt("PARINTE") == -1)
			{
				System.out.println("Intra in if-ul din mutareElem");
				//Element atomic, deci copiem doar linia din sursa in dest
				comanda = "INSERT INTO " + inventarDestinatie + " SELECT * FROM " + inventarSursa + 
						" WHERE id=" + idElem + " ON DUPLICATE KEY UPDATE id=" + (max + 1) + ";";
				
				decl.addBatch(comanda);
				decl.executeBatch();
				
				this.stergereInregistrare(idElem, inventarSursa);
			}
			else
			{
				System.out.println("Intra in else-ul din mutareElem");
				//In cazul elementelor compuse, copiem intreaga structura (fii....)
				this.mutareElementCompus(inventarSursa, inventarDestinatie, idElem, max);
			}
			
			return (max+1);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	public int getMaxID(String inventar)
	{
		try
		{
			Statement decl;
			ResultSet rezultat;
			decl = this.conn.createStatement();
			String comanda = "";
			
			comanda = "SELECT MAX(id) FROM " + inventar + ";";
			rezultat =  decl.executeQuery(comanda);
			
			rezultat.first();
			return rezultat.getInt(1);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean mutareElementCompus(String inventarSursa, String inventarDestinatie, int idElem, int idMax)
	{
		ArrayList<Integer> idSursa = new ArrayList<Integer>(); 
		String cmd = "id=" + idElem;
		
		try
		{
			Statement decl = this.conn.createStatement();
			Statement declInsert = this.conn.createStatement();
			String comanda = "";
			ResultSet rezultat;
			int idCurent = 0, parinte = -1;

			while (true)
			{
				comanda = "SELECT * FROM " + inventarSursa + " WHERE " + cmd + ";";
				rezultat = decl.executeQuery(comanda);
				
				while (rezultat.next())
				{
					idCurent = rezultat.getInt("ID");
					idSursa.add(idCurent);
					
					comanda = "INSERT INTO " + inventarDestinatie + " () VALUES (" + (idMax + idSursa.indexOf(idCurent) + 1) + 
							",'" + rezultat.getString("NUME") + "'," + parinte + ",";
					
					for (int i = 3; i < rezultat.getMetaData().getColumnCount(); i++)
					{
						comanda += rezultat.getString(i+1) + ",";
					}
					
					comanda = comanda.substring(0, comanda.length() - 1);
					comanda += ");";
					
					declInsert.addBatch(comanda);
					declInsert.executeBatch();
					
					parinte = idMax + idSursa.indexOf(rezultat.getInt("PARINTE")) + 1;
					
				}
				
				comanda = "DELETE FROM " + inventarSursa + " WHERE " + cmd + ";";
				decl.addBatch(comanda);
				decl.executeBatch();
				
				cmd = cmd.replaceAll("id", "parinte");
				comanda = "SELECT id FROM " + inventarSursa + " WHERE " + cmd + ";";
				rezultat = decl.executeQuery(comanda);
				
				if(!rezultat.first())
				{
					break;
				}
				
				cmd = "";
				
				rezultat.beforeFirst();
				while(rezultat.next())
				{
					cmd += " OR id = " + rezultat.getString(1);
				}
				
				cmd = cmd.replaceFirst("OR","");
			}
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<String> filtrareElemente(String capital)
	{
		ArrayList<String> elementeInventar = new ArrayList<String>();
		
		try
		{
			Statement decl = this.conn.createStatement();
			ResultSet rezultat;
			String comanda = "";
			String element = "";
			
			comanda = "SELECT * FROM Piata  WHERE nr_puncte <= " + capital + " AND parinte < 0;";
			rezultat = decl.executeQuery(comanda);
			
			int coloane = rezultat.getMetaData().getColumnCount();
			while(rezultat.next())
			{
				element = "";
				for (int i = 1; i <= coloane;i++)
				{
					element += rezultat.getString(i) + " ";
				}
				elementeInventar.add(element);
			}
		
			return elementeInventar;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean stergereInregistrare(int idElem, String inventar)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			
			comanda = "DELETE FROM " + inventar + " WHERE id=" + idElem + ";";
			
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
	
	public boolean modificareNrPuncte(String inventarDestinatie, int idElem, String operator)
	{
		try
		{
			Statement decl = this.conn.createStatement(); 
			String comanda = "";
		
			comanda = "UPDATE " + inventarDestinatie + " SET nr_puncte= nr_puncte " + operator + " 1.5 WHERE id=" + idElem+ ";";
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
	
	public int cumparareElementeAtomiceCuPropRandom(String numeUtilizator, int idElem)
	{
		try
		{
			Statement decl = this.conn.createStatement(); 
			String comanda = "";
			ResultSet rezultat;
			String valoriProp = "";
			int max = 0, start = 0, i = 0;
		
			comanda = "SELECT * FROM Piata WHERE id = " + idElem + " AND parinte = -2;";
			
			rezultat = decl.executeQuery(comanda);
			if (rezultat.first() == false)
			{
				return 0;
			}
			else
			{
				ArrayList<Float> propRandom;
				do
				{
					//rezultat.first();
					System.out.println("\n\nCalculare prop random!");
					propRandom = new ArrayList<Float>();
					comanda = "";
					float proprietateRandom = 0f;
					max = this.getMaxID(numeUtilizator);
					start = rezultat.findColumn("MASA");
					
					valoriProp = "(" + (max + 1) + ",'" + rezultat.getString("NUME") + "',-1," + rezultat.getString("NR_PUNCTE") + ",1,";
					
					for(i = start; i <= rezultat.getMetaData().getColumnCount(); i++)
					{
						proprietateRandom = this.valoareRandom(rezultat.getFloat(i));
						valoriProp +=  proprietateRandom + ",";
						propRandom.add(proprietateRandom);
					}
					
					valoriProp =  valoriProp.substring(0, valoriProp.length() - 1) + ");";
					
					comanda = "INSERT INTO " + numeUtilizator + " () VALUES" + valoriProp;
				} while (!this.verificarePuncte(propRandom)); 
				
				decl.addBatch(comanda);
				decl.executeBatch();
				
				return (max+1);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	public boolean verificarePuncte(ArrayList<Float> propRandom)
	{
		float sumaProp = 0f;
		
		sumaProp = propRandom.get(4) - propRandom.get(0) - propRandom.get(1);
		
		for (int i = 5; i < propRandom.size(); i++)
		{
			sumaProp += propRandom.get(i);
		}
		
		if (sumaProp <= 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public float valoareRandom(float valoarePropMaxima)
	{
		return (float)(Math.random() * valoarePropMaxima);
	}
	
	
	
	public boolean actualizareNrPuncte(String numeUtilizator, int idElem)
	{
		try
		{
			float numarPuncte = 0, sumaPropSpeciale = 0;
			Statement decl = this.conn.createStatement();
			Statement update = this.conn.createStatement(); 
			String comanda = "";
			ResultSet rezultat = null;
			
			comanda = "SELECT * FROM " + numeUtilizator + " WHERE id=" + idElem +";";
			rezultat = decl.executeQuery(comanda);
			
			rezultat.first();
			for (int i = (rezultat.findColumn("SANATATE") + 1); i <= rezultat.getMetaData().getColumnCount(); i++)
			{
				sumaPropSpeciale += rezultat.getFloat(i);
			}
			
			numarPuncte = (rezultat.getFloat("SANATATE") - rezultat.getFloat("MASA") - rezultat.getFloat("CONSUM") + 
					sumaPropSpeciale) * rezultat.getFloat("RANDAMENT") * rezultat.getFloat("RATA_INV") * 
					rezultat.getFloat("NR_COMP") * 10;
			System.out.println(numarPuncte);
			comanda = "UPDATE " + numeUtilizator + " SET nr_puncte=" + numarPuncte + " WHERE id=" + idElem + ";";
			update.addBatch(comanda);
			update.executeBatch();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public float getValoareElement(String inventarSursa, int idElem)
	{
		Statement decl = null;
		
		try
		{
			ResultSet rezultatUtilizator;
			decl = this.conn.createStatement();
			rezultatUtilizator = decl.executeQuery("SELECT nr_puncte FROM " + inventarSursa +" WHERE id=" + idElem +";");
			
			rezultatUtilizator.first();
			
			return rezultatUtilizator.getFloat(1);
		}
		catch (Exception e)
		{	
			e.printStackTrace();
			return -1;
		}
	}
	
	public boolean adaugareElementAtomicNou(String numeElement, String numePropSpec, float valMaxPropSpec, float pretElement)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			ResultSet rezultat;
			String comanda = "";
			int elemAleator = 0;
			
			comanda = "SELECT * FROM Piata WHERE parinte = -2;";
			rezultat = decl.executeQuery(comanda);
			
			rezultat.last();
			elemAleator = (int)Math.floor(Math.random() * rezultat.getRow());
			rezultat.absolute(elemAleator);
			
			comanda = "INSERT INTO Piata () VALUES(0, '" + numeElement + "', -2, " + pretElement + ", 1, " + rezultat.getString("MASA") + ", " 
					+ rezultat.getString("CONSUM") + ", " + rezultat.getString("RANDAMENT") + ", " + rezultat.getString("RATA_INV") + ", " 
					+ rezultat.getString("SANATATE") + ", ";
			
			int start = rezultat.findColumn("SANATATE") + 1;
			for (int i = start; i < rezultat.getMetaData().getColumnCount(); i++)
			{
				comanda += "NULL, ";
			}
			
			comanda += valMaxPropSpec + ");";
			
			System.out.println("\n\nComanda de inserare elem atomic nou: " + comanda);
			
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
