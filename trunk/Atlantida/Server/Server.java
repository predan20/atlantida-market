import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.*;



public class Server extends Thread
{
	private SSLServerSocketFactory sslServerSocketFactory;
	private SSLServerSocket sslServerSocket;
	private int port;
	private List sockets = new LinkedList();
	private List newSockets = new LinkedList();
	private String numeClasa;
	public Server(int port, String numeClasa)
	{
		this.port = port;
		this.numeClasa = numeClasa;
		
		try
		{
			this.sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
	        this.sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
       
	}
	public SSLServerSocket getSSLServerSocket() {
		return sslServerSocket;
	}

	public void adaugaSocket(SSLSocket sslSocket) throws IOException {
	    synchronized(newSockets) 
	    {
	    	try
	    	{
	    		Class[] classParameters = new Class[] {SSLSocket.class};
	    		Object[] objectParamaters = new Object[] {sslSocket};
	    		
			    Class thr = Class.forName(this.numeClasa);
			    Constructor co = thr.getConstructor(classParameters);
			    Object connectionThread = co.newInstance(objectParamaters);
			    
			    newSockets.add(connectionThread);
			    newSockets.notify();
	    	}
	    	catch (Exception e) 
	    	{
				e.printStackTrace();
			}
	    }
	  }
	
	public void run() 
	{
		System.out.println("Suntem in run de la server!!!"+ this.port);
		while(true) {
	        try {
	          synchronized(newSockets) {
	            sockets.addAll(newSockets);
	            newSockets.clear();
	          }
	          Iterator it = sockets.iterator();	         
	          
	          while(it.hasNext()) 
	          {
	         	  System.out.println("Suntem in while din run!!!");
	              ConnectionAbstractThread log = (ConnectionAbstractThread)it.next();
	              log.start();
		          it.remove();
	          }
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	  }
	}
	
	public void listenTo()
	{
		SSLSocket sslSocket;
		try
		{	
			//System.out.println("ListenTo: "+this.port);
			//this.start();
			try
			{
				while(true)
				{
					this.getSSLServerSocket().setSoTimeout(50);
					sslSocket = (SSLSocket)this.getSSLServerSocket().accept();
					this.adaugaSocket(sslSocket);
				}
			}	
			catch(Exception e)
			{
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args)
	{
		SSLSocket sslSocket = null;
		Server server3000 = new Server(3000,"ThreadLogin");
		Server server3001 = new Server(3001,"ThreadLogout");
		Server server3002 = new Server(3002,"ThreadInregistrare");
		Server server3003 = new Server(3003,"ThreadCombinare");
		Server server3004 = new Server(3004,"ThreadAdministrator");
		
		server3000.start();
		server3001.start();
		server3002.start();
		server3003.start();
		server3004.start();
		
		server3000.listenTo();
		server3001.listenTo();
		server3002.listenTo();
		server3003.listenTo();
		server3004.listenTo();
		
		while(true)
		{
			server3000.listenTo();
			server3001.listenTo();
			server3002.listenTo();
			server3003.listenTo();
			server3004.listenTo();
		}
	}
}
