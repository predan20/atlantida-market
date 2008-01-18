import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;


public class ComunicareServer
{
	private SSLServerSocketFactory sslServerSocketFactory;
	private SSLServerSocket sslServerSocket;
	private SSLSocket sslSocket = null;
	//private int port;
	private BufferedReader buferCitire;
	private BufferedWriter buferScriere;
	
	public ComunicareServer(SSLSocket sslSocket)
	{
		this.sslSocket = sslSocket;
	}
	
	public boolean conectareServer()
	{
		try
		{
		//this.sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        //this.sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(this.port);
        //this.sslSocket = (SSLSocket) sslServerSocket.accept();
            
		this.buferScriere = new BufferedWriter(new OutputStreamWriter(this.sslSocket.getOutputStream()));
		this.buferCitire = new BufferedReader(new InputStreamReader(this.sslSocket.getInputStream()));
			
        return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<String> citireDate()
	{
		ArrayList<String> randuriCitite = new ArrayList<String>();
		
		try
		{
			String randCurent = "";
			
			while((randCurent = this.buferCitire.readLine()) != null)
			{
				randuriCitite.add(randCurent);
				System.out.println(randCurent);
				if(randCurent.equals("Bye!"))
				{
					System.out.println("Break!");
					break;
				}
			}
			return randuriCitite;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean scriereDate(ArrayList<String> colectieScriere)
	{
		
		try 
		{
			for (int i = 0; i < colectieScriere.size(); i++)
			{
				System.out.println(colectieScriere.get(i));
				buferScriere.write(colectieScriere.get(i) + "\n");
			}
			
			buferScriere.flush();
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean inchidereServer()
	{
		try
		{
			this.buferScriere.close();
			this.buferCitire.close();	
			this.sslSocket.close();
			//this.sslServerSocket.close();
			
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
}
