import java.sql.ResultSet;
import java.sql.Statement;


public class Administrator extends BazaDeDate
{
	public Administrator(String numeBazaDate)
	{
		super(numeBazaDate);
	}
	
	public boolean inserareInregistrare(String numeElement, String propSpeciala, String formula,int valMaxima, int pret)
	{
			try
			{
				Statement decl = this.conn.createStatement();
				
				String comanda ="";
				comanda = "INSERT INTO Elemente_atomice (ID, NUME, PROP_SPEC, FORMULA, VAL_MAX, PRET) " +
						"VALUES(0, '" + numeElement + "','" + propSpeciala + "'," + formula + "'," + valMaxima + "," + pret + ");";
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
	
	public boolean actualizareInventarUtilizator(String numeColoanaNoua)
	{
		try
		{
			Statement decl = this.conn.createStatement();
			
			String comanda = "";
			
			comanda = "ALTER TABLE Inventar_utilizator ADD " + numeColoanaNoua + " FLOAT;";
			
			decl.addBatch(comanda);
			decl.executeBatch();
			
			ResultSet rezultat;
			comanda = "SHOW TABLES FROM Inventare;";
			rezultat = decl.executeQuery(comanda);
			int i = 1;
			while(rezultat.next())
			{
				System.out.println(rezultat.getString(i));
				i++;
			}
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
