import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Licitatie extends BazaDeDate
{
	public Licitatie(String numeBazaDate)
	{
		super(numeBazaDate);
	}
	
	public boolean inserareJucatorLicitatie(int idElem, String numeUtilizator, float oferta)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			
			
			comanda = "INSERT INTO Licitatii () VALUES(" + idElem + ",'" + numeUtilizator + "'," + oferta + ",'" + this.getTimpStart(idElem) + "');";
			
			System.out.println("Insrare jucator in licitatie: " + comanda);
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
	
	public String getTimpStart(int idElem)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			ResultSet rezultat;
			String comanda = "";
			
			comanda = "SELECT timp_start FROM Licitatii WHERE id_elem = " + idElem + ";";
			
			rezultat = decl.executeQuery(comanda);
			if (rezultat.first())
			{
				return rezultat.getString(1);
			}
			else
			{
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat timp = new SimpleDateFormat("hh:mm:ss");
				System.out.println("\n\nOra exacta: " + timp.format(calendar.getTime()) + "\n\n");
				new CeasLicitatii(30);
				return timp.format(calendar.getTime());
				
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "00:00:00";
		}
	}
	
	public boolean stergereJucatorLicitatie(int idElem)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			
			comanda = "DELETE FROM Licitatii WHERE id_elem = " + idElem + ";";
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
	
	public ArrayList<ElementeAtribuire> determinareCastigator()
	{
		ArrayList<ElementeAtribuire> listaOferte = new ArrayList<ElementeAtribuire>();
		ElementeAtribuire el;
		float max = Float.MIN_VALUE;
		String numeUtilizator = "";
		
		try
		{
			Statement decl = this.conn.createStatement();
			ResultSet rezultat;
			String comanda = "";
			
			comanda = "SELECT min(timp_start) FROM Licitatii;";
			rezultat = decl.executeQuery(comanda);
			
			if (rezultat.first())
			{
				comanda = "SELECT * FROM Licitatii WHERE timp_start = '" + rezultat.getString(1) + "';";
				
				rezultat = decl.executeQuery(comanda);
				
				while (rezultat.next())
				{
					if (max < rezultat.getFloat("OFERTA"))
					{
						numeUtilizator = rezultat.getString("NUME");
						max = rezultat.getFloat("OFERTA");
						el = new ElementeAtribuire(numeUtilizator, String.valueOf(max));
						listaOferte.add(0, el);
					}
					else
					{
						el = new ElementeAtribuire(rezultat.getString("NUME"), rezultat.getString("OFERTA"));
						listaOferte.add(el);
					}
				}
				rezultat.first();
				el = new ElementeAtribuire(rezultat.getString("ID_ELEM"), "");
				listaOferte.add(0, el);
				this.stergereJucatorLicitatie(rezultat.getInt("ID_ELEM"));
				
				return listaOferte;
			}
			
			return null;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
}
