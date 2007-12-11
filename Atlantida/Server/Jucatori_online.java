import java.sql.ResultSet;
import java.sql.Statement;


public class Jucatori_online extends BazaDeDate 
{
	public Jucatori_online(String numeBazaDate)
	{
		super(numeBazaDate);
	}
	
	public int inserareInregistrare(String numeUtilizator)
	{	
		Statement decl = null;
		try
		{
			decl = this.conn.createStatement();
			String comanda = "";
			comanda = "INSERT INTO Jucatori_online (ID, UTILIZATOR, TIP_JUCATOR, NR_PUNCTE) " +
					  "VALUES((SELECT ID FROM Jucatori WHERE UTILIZATOR = '" + numeUtilizator + "')," + 
					  "(SELECT UTILIZATOR FROM Jucatori WHERE UTILIZATOR = '" + numeUtilizator + "')," + 
					  "(SELECT TIP_JUCATOR FROM Jucatori WHERE UTILIZATOR = '" + numeUtilizator + "')," + 
					  "(SELECT NR_PUNCTE FROM Jucatori WHERE UTILIZATOR = '" + numeUtilizator + "'));"; 
			
			decl.addBatch(comanda);
			decl.executeBatch();
		}
		catch (Exception e)
		{	
			e.printStackTrace();
			return 1;
		}
		return 0;
	}
	
	public String getNumarPuncte(String nume)
	{
		Statement decl = null;
		
		try
		{
			ResultSet rezultatUtilizator;
			decl = this.conn.createStatement();
			rezultatUtilizator = decl.executeQuery("SELECT nr_puncte FROM Jucatori_online WHERE utilizator='" + nume +"';");
			
			rezultatUtilizator.first();
			
			return rezultatUtilizator.getString(1);
		}
		catch (Exception e)
		{	
			e.printStackTrace();
			return "";
		}
	}
	
	public boolean stergereInregistrare(String numeUtilizator)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			
			comanda = "DELETE FROM Jucatori_online WHERE utilizator='" + numeUtilizator + "';";
			
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

