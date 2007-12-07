import java.util.ArrayList;

import javax.net.ssl.SSLSocket;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class ThreadCombinare extends ConnectionAbstractThread
{
	public ThreadCombinare(SSLSocket socket)
	{
		this.server = new ComunicareServer(socket);
		this.socket = socket;
	}
	
	@Override
	protected ArrayList<String> operatie(ArrayList<String> dateUtilizator)
	{
		//Pe primul rand numele utilizatorului, iar pe cel de-al doilea un string de id-uri separate prin virgula
		String numeUtilizator = dateUtilizator.get(0);
		String idElemente = dateUtilizator.get(1);
		
		CombinareElemente combinareElemente = new CombinareElemente(numeUtilizator, idElemente);
		combinareElemente.creareParinte();
		
		return dateUtilizator;
	}

}
