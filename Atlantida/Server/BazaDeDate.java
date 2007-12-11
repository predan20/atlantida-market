import java.sql.*;

public class BazaDeDate
{
	protected Connection conn = null;
	protected String host = "89.43.103.108";
	protected String port = "3306";
	protected String numeBazaDate = "";
	protected String utilizator = "root";
	protected String parola = "xxx123yyy";

	public BazaDeDate(String numeBazaDate)
	{
		/*this.host = host;
		this.port = port;*/
		this.numeBazaDate = numeBazaDate;
		/*this.utilizator = utilizator;
		this.parola = parola;*/
	}
	
	
	public void creareConexiune()
	{		
		String url = "jdbc:mysql://" + this.host + ":" + this.port + "/";
		String driver = "com.mysql.jdbc.Driver";
		//String driver = "org.gjt.mm.mysql.Driver";

		try 
		{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + this.numeBazaDate, this.utilizator, this.parola);
			
			System.out.println("Connection created!");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void inchidereConexiune()
	{
		try
		{
			conn.close();
			System.out.println("Connection Closed!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}