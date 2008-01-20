package client;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class ComunicareClient 
{
	private SSLSocketFactory sslSocketFactory;
	private SSLSocket sslSocket;
	private String host;
	private int port;
	private BufferedReader bufferCitire;
	private BufferedWriter bufferScriere;
	
	public ComunicareClient(String host, int port)
	{
		this.host = host;
		this.port = port;
	}
	
	public boolean conectareLaServer()
	{
		try
		{
			this.sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            this.sslSocket = (SSLSocket) sslSocketFactory.createSocket(this.host, this.port);
	        
            InputStream inputstream = sslSocket.getInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            this.bufferCitire = new BufferedReader(inputstreamreader);

            OutputStream outputstream = sslSocket.getOutputStream();
            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
            this.bufferScriere= new BufferedWriter(outputstreamwriter);

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
			
			while((randCurent = this.bufferCitire.readLine()) != null)
			{
				System.out.println(randCurent);
				if (randCurent.equalsIgnoreCase("Bye!"))
				{
					break;
				}
				randuriCitite.add(randCurent);
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
				bufferScriere.write(colectieScriere.get(i).replaceAll("'", "'") + "\n");
			}
			
			bufferScriere.flush();		
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean inchidereClient()
	{
		try
		{
			this.bufferCitire.close();
			this.bufferScriere.close();
			this.sslSocket.close();

			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
}
