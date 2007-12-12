import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;


public class Inventar_utilizator extends BazaDeDate 
{	
	public Inventar_utilizator(String numeBazaDate)
	{
		super(numeBazaDate);
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
					  "`PARINTE` SMALLINT( 6 ) NULL " +
					  "`NR_PUNCTE` SMALLINT( 6 ) NULL " +
					  "`NR_COMP` SMALLINT( 6 ) NULL ";
			
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
		ArrayList<String> numeColoane = new ArrayList<String>();
		ArrayList<String> formule = new ArrayList<String>();
		
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
			comanda = "select sum(masa), sum(consum), sum(sanatate) from " + numeUtilizator + " WHERE parinte="  + idParinte +" AND parinte IS NOT NULL;";
			rezultatSum = decl.executeQuery(comanda);
			rezultatSum.first();
			//
			
			//Introducere valori proprietati
			valoareProprietati.add(rezultatSum.getFloat(1));//masa
			valoareProprietati.add((float)(rezultatSum.getFloat(2) * 1.1));//consum
			valoareProprietati.add(prod);//randament
			valoareProprietati.add(min);//rata invechire
			valoareProprietati.add(rezultatSum.getFloat(3));//sanatate
			//
			
			//Calculare valori proprietati speciale
			numeColoane = this.getNumeColoane(numeUtilizator);
			
			//Calculare numar puncte si numar componente si prop speciale
			
			
			
			
//			comanda = "UPDATE " + numeUtilizator + " SET nume = 'elemCompus', parinte = -1, masa = " + valoareProprietati.get(0) + 
//					", consum = " + valoareProprietati.get(1) + ", randament = " + valoareProprietati.get(2) + 
//					", rata_inv = " + valoareProprietati.get(3) + ", sanatate = " + valoareProprietati.get(4) +
//					", protectie = " + valoareProprietati.get(5) + ", acceleratie = " + valoareProprietati.get(6) + 
//					", putere = " + valoareProprietati.get(7) + "WHERE id = " + idParinte + ";";
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
	
	
	public ArrayList<String> calculOperatiiSimple(String numeUtilizator, int idParinte, String operatiiSimple,String proprSpeciala)
	{		
		ArrayList<String> valoareProprietati = new ArrayList<String>();

		ResultSet rezultatSum = null;
		ResultSetMetaData rezultatSumMetaData;
		
		//mai trebuie luat linie cu linie si la produs. in rest pare ok.
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			String str = "";
			
			BufferedReader reader = new BufferedReader(new StringReader(operatiiSimple));
			int i = 1;
			try 
			{
			  while ((str = reader.readLine()) != null) 
			  {
				  if (i == 1) 
				  {
					comanda = "select " + str + " from " + numeUtilizator + " WHERE parinte="  + idParinte +";";
				  }
				  else
				  {
					  comanda = "select " + str + " from " + numeUtilizator + " WHERE parinte="  + idParinte +" AND " + proprSpeciala + " IS NOT NULL;";
				  }
					rezultatSum = decl.executeQuery(comanda);
					rezultatSum.first();
					//
					rezultatSumMetaData = (ResultSetMetaData)rezultatSum.getMetaData();
					
					for(int j=1;i<rezultatSumMetaData.getColumnCount();j++)
					{
						System.out.println(rezultatSum.getString(j));
						valoareProprietati.add(rezultatSum.getString(j));
					}  
			  }
			  return valoareProprietati;
			} 
			catch(IOException exc) 
			{
			  exc.printStackTrace();
			  return null;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}


	public ArrayList<String> calculProdus(String numeUtilizator, int idParinte,
			String campuriProdus,String proprSpeciala) 
	{		
		try
		{
			Statement decl = this.conn.createStatement();
			ResultSet rezultatProd;
			ResultSetMetaData rezultatMD;
			String comanda;
			ArrayList<Float> produs;
			ArrayList<String> rezultat = new ArrayList<String>();
			String str = "";
			
			BufferedReader reader = new BufferedReader(new StringReader(campuriProdus));
			int i = 1;
			try 
			{
			  while ((str = reader.readLine()) != null) 
			  {
				  if (i == 1) 
				  {
					comanda = "select " + str + " from " + numeUtilizator + " WHERE parinte="  + idParinte +";";
				  }
				  else
				  {
					  comanda = "select " + str + " from " + numeUtilizator + " WHERE parinte="  + idParinte +" AND " + proprSpeciala + " IS NOT NULL;";
				  }
				  rezultatProd = decl.executeQuery(comanda);
				  rezultatProd.first();
					//
				  rezultatMD = (ResultSetMetaData)rezultatProd.getMetaData();
					
/*					for(int j=1;i<rezultatMD.getColumnCount();j++)
					{
						System.out.println(rezultatProd.getString(j));
						rezultat.add(rezultatProd.getString(j));
					}  */
				  
					produs = new ArrayList<Float>(rezultatMD.getColumnCount());
					
					for(Float f : produs)
						f = 1f;
					
					while(rezultatProd.next())
					{
						for (i= 1; i < produs.size(); i++)
						{
							produs.set(i,produs.get(i) * rezultatProd.getFloat(i));
						}
					}
					for(Float f : produs)
						rezultat.add(f.toString());
			  }
			  return rezultat;
			}
			catch(IOException exc) 
			{
			  exc.printStackTrace();
			  return null;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
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
	
	public boolean setCamp(String numeUtilizator,int id,String camp,float valoare)
	{
		
		System.out.println(id+": "+ valoare);
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			
			comanda = "UPDATE " + numeUtilizator + " SET " + camp + "=" + valoare + " WHERE id='" + id + "';";
			
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
	
	public boolean calculValoareProprSpeciala(String numeUtilizator, int idParinte, String expresie, String numePropSpec )
	{
		EvaluareExpresie evaluareExpresie;
		ArrayList<String> evalList;
//		Inventar_utilizator inventarUtilizator = new Inventar_utilizator("89.43.103.108", "3306", "Inventare", "root", "xxx123yyy");
//
//		inventarUtilizator.creareConexiune();
		
		
		evaluareExpresie = new EvaluareExpresie(expresie);
		
		String operatiiSimple = evaluareExpresie.getOperatiiSimple();
		String campuriProdus = evaluareExpresie.getCampuriProdus();
		
		evalList = this.calculOperatiiSimple(numeUtilizator, idParinte, operatiiSimple,numePropSpec);
		evaluareExpresie.setValoriElemente(evalList,false);
		
		this.calculProdus(numeUtilizator, idParinte, campuriProdus,numePropSpec);
		evaluareExpresie.setValoriElemente(evalList, true);
		
		float valPropSpeciala;
		valPropSpeciala = evaluareExpresie.calculFormula();
		this.setCamp(numeUtilizator, idParinte, numePropSpec, valPropSpeciala);
		
//		inventarUtilizator.inchidereConexiune();
		
		return true;
	}
	
	public boolean actualizareProprietati(String numeUtilizator,float actualizareSanatate, float actualizareRandament, float actualizareConsum)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			
			comanda = "UPDATE " + numeUtilizator + " SET sanatate = sanatate + FLOOR(rata_inv / 3) * " + actualizareSanatate + 
					  ", randament = randament + FLOOR(rata_inv / 5) * " +actualizareRandament + 
					  ", consum = consum + FLOOR(rata_inv / 4) * " + actualizareConsum + ";";
						
			decl.addBatch(comanda);
			decl.executeBatch();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean actualizareProprietatiDinInventare(float actualizareSanatate, float actualizareRandament, float actualizareConsum)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			ResultSet rezultat = null;
			
			comanda = "SHOW TABLES FROM Inventare;";
			
			rezultat = decl.executeQuery(comanda);
			
			while(rezultat.next())
			{
				this.actualizareProprietati(rezultat.getString(1), actualizareSanatate, actualizareRandament, actualizareConsum);
				this.calculNumarPuncteElem(rezultat.getString(1));
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean calculNumarPuncteElem(String numeUtilizator)
	{
		try
		{
			System.out.println("Calcl numar puncte elem");
			float numarPuncte = 0, sumaPropSpeciale = 0;
			Statement decl = this.conn.createStatement();
			Statement update = this.conn.createStatement(); 
			String comanda = "";
			ResultSet rezultat = null;
			
			comanda = "SELECT * FROM " + numeUtilizator + " WHERE parinte=-1;";
			rezultat = decl.executeQuery(comanda);
			
			while (rezultat.next())
			{
				for (int i = (rezultat.findColumn("SANATATE") + 1); i <= rezultat.getMetaData().getColumnCount(); i++)
				{
					sumaPropSpeciale += rezultat.getFloat(i);
				}
				
				numarPuncte = (rezultat.getFloat("SANATATE") - rezultat.getFloat("MASA") - rezultat.getFloat("CONSUM") + 
						sumaPropSpeciale) * rezultat.getFloat("RANDAMENT") * rezultat.getFloat("RATA_INV") * 
						rezultat.getFloat("NR_COMP") * 100;
				
				System.out.println(rezultat.getFloat("SANATATE")+" "+rezultat.getFloat("MASA")+" "+rezultat.getFloat("CONSUM")+" "+ 
						rezultat.getFloat("RANDAMENT")+" "+rezultat.getFloat("RATA_INV")+" "+ 
						rezultat.getFloat("NR_COMP"));
				
				System.out.println("Numar puncte: " + numarPuncte);
				comanda = "UPDATE " + numeUtilizator + " SET nr_puncte=" + numarPuncte + " WHERE id=" + rezultat.getShort("ID") + ";";
				update.addBatch(comanda);
				update.executeBatch();
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
