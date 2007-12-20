import java.sql.BatchUpdateException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Elemente_atomice extends BazaDeDate 
{
	public Elemente_atomice(String numeBazaDate)
	{
		super(numeBazaDate);
	}
	
	public int inserareInregistrare(String numeElement, String propSpeciala, String formulaCalcul, int valMaxima, int pretElement)
	{	
		Statement decl = null;
		ResultSet rezultat = null;
		
		try
		{
			decl = this.conn.createStatement();
			
			try
			{
				String comanda = "";
				comanda = "INSERT INTO Elemente_atomice (ID, NUME, PROP_SPEC, FORMULA, VAL_MAX, PRET) " +
						"VALUES(0, '" + numeElement + "','" + propSpeciala + "','" + formulaCalcul + "',"+ valMaxima + "," + pretElement + ");";
				
				decl.addBatch(comanda);
				decl.executeBatch();
			}
			catch (BatchUpdateException e)
			{	
				e.printStackTrace();
				rezultat = decl.executeQuery("SELECT nume FROM Elemente_atomice WHERE nume='" + numeElement +"';");
				
				if (rezultat.next())
				{
					//Elementul exista
					System.out.println("Elementul exista.");
					return 1;
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
	
	public boolean stergereInregistrare(String numeElement)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			
			comanda = "DELETE FROM Elemente_atomice WHERE nume='" + numeElement + "';";
			
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
	
	
	public ArrayList<String> getFormulePropSpeciale()
	{
		ArrayList<String> formule = new ArrayList<String>();
		
		try
		{
			Statement decl = this.conn.createStatement();
			String comanda = "";
			ResultSet rezultat = null;
			
			comanda = "SELECT formula FROM Elemente_atomice ORDER BY id ASC;";

			rezultat = decl.executeQuery(comanda);
			
			while(rezultat.next())
			{
				formule.add(rezultat.getString(1));
			}
			
			return formule;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}

