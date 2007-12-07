import java.sql.Statement;


public class Administrator extends BazaDeDate
{
	public Administrator(String host, String port, String numeBazaDate, String utilizator, String parola)
	{
		super(host, port, numeBazaDate, utilizator, parola);
	}
	
	public boolean inserareInregistrare(String numeElement, String propSpeciala, int valMaxima, int pret)
	{
			try
			{
				Statement decl = this.conn.createStatement();
				
				String comanda ="";
				comanda = "INSERT INTO Elemente_atomice (ID, NUME, PROP_SPEC, VAL_MAX, PRET) " +
						"VALUES(0, '" + numeElement + "','" + propSpeciala + "'," + valMaxima + "," + pret + ");";
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
			
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
