import java.util.*;
import javax.net.ssl.SSLSocket;

public abstract class ConnectionAbstractThread extends Thread 
{
	ComunicareServer server;
	SSLSocket socket;
	
	protected abstract ArrayList<String> operatie(ArrayList<String> dateUtilizator);
	
	public void run()
	{
		ArrayList<String> dateUtilizator; 
		server.conectareServer();
		dateUtilizator = server.citireDate();
		
		dateUtilizator = operatie(dateUtilizator);
		
		dateUtilizator.add("Bye!");
		server.scriereDate(dateUtilizator);
		server.inchidereServer();
	}
	
	public String toString()
	{
		return "ConnectionAbstractThread " + socket.getPort();
	}
}
