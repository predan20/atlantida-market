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
	
	public String inserareJucatorLicitatie(int idElem, String numeUtilizator, float oferta)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			String timpStart = this.getTimpStart(idElem);
			
			comanda = "INSERT INTO Licitatii (ID_ELEM ,NUME ,OFERTA ,TIMP_START) VALUES(" 
					  + idElem + ",'" + numeUtilizator + "'," + oferta + ",'" + timpStart + "');";

			decl.addBatch(comanda);
			decl.executeBatch();
			return timpStart;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "";
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
				SimpleDateFormat timp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				new CeasLicitatii(Server.timpLicitatie);
				
				return timp.format(calendar.getTime());
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "0000-00-00 00:00:00";
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
	
	public long getSecundeRamaseDinLicitatie(String timpStartLicitatie)
	{
		String timpFinal = "";
		String[] data = timpStartLicitatie.split(" ");
		String[] anLunaZi = data[0].split("-");
		String[] oraMinSec = data[1].split(":");
		int an = Integer.parseInt(anLunaZi[0]);
		int luna = Integer.parseInt(anLunaZi[1]);
		int zi = Integer.parseInt(anLunaZi[2]);
		int ora = Integer.parseInt(oraMinSec[0]);
		int minut = Integer.parseInt(oraMinSec[1]);
		int secunda = Math.round(Float.parseFloat(oraMinSec[2]));
		
		Date dataStart = new Date(an, luna, zi, ora, minut, secunda);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat timp = new SimpleDateFormat("yyyy:MM:dd:hh:mm:ss");
		timpFinal = timp.format(cal.getTime());
		data = timpFinal.split(":");
		an = Integer.parseInt(data[0]);
		luna = Integer.parseInt(data[1]);
		zi = Integer.parseInt(data[2]);
		ora = Integer.parseInt(data[3]);
		minut = Integer.parseInt(data[4]);
		secunda = Math.round(Integer.parseInt(data[5]));
		
		Date dataFinal = new Date(an, luna, zi, ora, minut, secunda);
		
		
		long sec = (dataFinal.getTime() - dataStart.getTime()) / 1000;
		sec = (long)Server.timpLicitatie - sec;
		
		return sec;
	}
}
