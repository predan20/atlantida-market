import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Dezintegrare extends BazaDeDate
{
	public Dezintegrare(String numeBazaDate)
	{
		super(numeBazaDate);
	}
	
	
	public boolean dezintegrareElementAtomic(String numeUtilizator, int idElement)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			
			comanda = "DELETE FROM " + numeUtilizator + "WHERE ID = " + idElement + ";";
			
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
	
	
	public boolean dezintegrareElementCompus(String numeUtilizator, int idElement)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			ResultSet rezultat;
			int nrElementeSterse = 0, pozElem = 0;
			ArrayList<Integer> listaElementeSterse = new ArrayList<Integer>();
			
			comanda = "SELECT ID, PARINTE FROM " + numeUtilizator + " WHERE PARINTE = " + idElement + ";";
			
			rezultat = decl.executeQuery(comanda);
			rezultat.last();
			nrElementeSterse = (int)Math.ceil( (double)(0.2 * rezultat.getRow()));
			System.out.println("Numar elem de sters: " + nrElementeSterse);
			
			String cmd = "";
			
			while(listaElementeSterse.size() != nrElementeSterse)
			{
				pozElem = (int)Math.round(Math.random() * nrElementeSterse);
				
				if(!listaElementeSterse.contains(pozElem))
				{
					listaElementeSterse.add(pozElem);
					cmd += "OR id = " + pozElem;
				}
			}
			
			cmd = cmd.replaceFirst("OR", "");
			System.out.println(cmd);
			this.stergereElementCompus(numeUtilizator, cmd);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean stergereElementCompus(String numeUtilizator, String cmd)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			ResultSet rezultat;

			while (true)
			{
				comanda = "DELETE FROM " + numeUtilizator + " WHERE " + cmd + ";";
				decl.addBatch(comanda);
				decl.executeBatch();
				
				cmd = cmd.replaceAll("id", "parinte");
				comanda = "SELECT id FROM " + numeUtilizator + " WHERE " + cmd + ";";
				rezultat = decl.executeQuery(comanda);
				
				if(!rezultat.first())
				{
					break;
				}
			
				cmd = "";
				while(rezultat.next())
				{
					cmd += "OR id = " + rezultat.getString(1);
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
	
	public boolean verificareDezintegrare(String numeUtilizator)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			ResultSet rezultat = null;
			ArrayList<Integer> elementeMarcatePentruStergere = new ArrayList<Integer>();
			
			comanda = "SELECT ID, PARINTE from " + numeUtilizator + " WHERE SANATATE = 0 OR RANDAMENT = 0;";
			
			rezultat = decl.executeQuery(comanda);

			while(rezultat.next())
			{
				if(rezultat.getInt(2) == -1)
				{
					this.dezintegrareElementCompus(numeUtilizator, rezultat.getInt(1));
				}
				else if(rezultat.getInt(2) == 0)
				{
					this.dezintegrareElementAtomic(numeUtilizator, rezultat.getInt(1));
				}
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
