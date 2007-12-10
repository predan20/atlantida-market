import java.sql.Statement;


public class Administrator extends BazaDeDate
{
	public Administrator(String host, String port, String numeBazaDate, String utilizator, String parola)
	{
		super(host, port, numeBazaDate, utilizator, parola);
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
			
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
