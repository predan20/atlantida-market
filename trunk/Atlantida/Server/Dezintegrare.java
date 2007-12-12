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
			
			comanda = "DELETE FROM " + numeUtilizator + " WHERE ID = " + idElement + ";";
			
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
	
	
	public boolean dezintegrareElement(String numeUtilizator, int idElement)
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
			rezultat.first();
			int i = 1;
			while (rezultat.next())
			{
				i++;
			}
			System.out.println("Numar randuri: " + i);
			if (rezultat.last())
			{
				nrElementeSterse = (int)Math.ceil((double)(0.2 * rezultat.getRow()));
				System.out.println("Numar elem de sters: " + nrElementeSterse + " " + rezultat.getRow());
				
				String cmd = "";
				
				while(listaElementeSterse.size() != nrElementeSterse)
				{
					pozElem = 1 + (int)Math.round(Math.random() * (rezultat.getRow() - 1));
					
					if(!listaElementeSterse.contains(pozElem))
					{
						listaElementeSterse.add(pozElem);
						rezultat.absolute(pozElem);
						cmd += " OR id = " + rezultat.getString(1);
					}
				}
				
				cmd = cmd.replaceFirst("OR", "");
				System.out.println(cmd);
				this.stergereElementCompus(numeUtilizator, cmd);
			}
			
			this.dezintegrareElementAtomic(numeUtilizator, idElement);//Se sterge elementul compus
			
			comanda = "UPDATE " + numeUtilizator + " SET parinte=-1 WHERE parinte=" + idElement + ";";
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
				System.out.println("Comanda = " + comanda);
				
				cmd = cmd.replaceAll("id", "parinte");
				comanda = "SELECT id FROM " + numeUtilizator + " WHERE " + cmd + ";";
				rezultat = decl.executeQuery(comanda);
				
				if(!rezultat.first())
				{
					break;
				}
				System.out.println("Comanda = " + comanda);
				cmd = "";
				
				rezultat.beforeFirst();
				while(rezultat.next())
				{
					cmd += " OR id = " + rezultat.getString(1);
				}
				
				cmd = cmd.replaceFirst("OR","");
				System.out.println("Comanda = " + comanda);
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
			
			comanda = "SELECT ID from " + numeUtilizator + " WHERE SANATATE = 0 OR RANDAMENT = 0;";
			
			rezultat = decl.executeQuery(comanda);

			while(rezultat.next())
			{				
				this.dezintegrareElement(numeUtilizator, rezultat.getInt(1));
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
