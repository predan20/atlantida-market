import java.io.BufferedOutputStream;
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
	        
            InputStream inputstream = System.in;
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            bufferCitire = new BufferedReader(inputstreamreader);

            OutputStream outputstream = sslSocket.getOutputStream();
            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
            bufferScriere= new BufferedWriter(outputstreamwriter);


            
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
			//this.bufferCitire = new BufferedReader(new InputStreamReader(this.sslSocket.getInputStream()));
			
			String randCurent = "";
			
			while((randCurent = this.bufferCitire.readLine()) != null)
			{
				randuriCitite.add(randCurent);
			}
			//bufferCitire.close();
			
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
			//this.bufferScriere = new BufferedWriter(new OutputStreamWriter(this.sslSocket.getOutputStream()));
			
			for (int i = 0; i < colectieScriere.size(); i++)
			{
				bufferScriere.write(colectieScriere.get(i) + "\n");
			}
			
			bufferScriere.flush();		
			//bufferScriere.close();
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
			this.bufferScriere.close();
			this.bufferCitire.close();

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
