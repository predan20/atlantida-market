import java.util.ArrayList;

import javax.net.ssl.SSLSocket;


public class ThreadVanzare extends ConnectionAbstractThread
{
	public ThreadVanzare(SSLSocket socket)
	{
		this.socket = socket;
		this.server = new ComunicareServer(socket);
	}
	
	protected ArrayList<String> operatie(ArrayList<String> dateUtilizator)
	{
		
		String numeUtilizator = "";
		int idElem = 0;
		float pretVanzare = 0;
		int idNou = 0;
		
		numeUtilizator = dateUtilizator.get(0);
		idElem = Integer.parseInt(dateUtilizator.get(1));
		
		Piata piata = new Piata("Inventare");
		piata.creareConexiune();
		pretVanzare = piata.getValoareElement(numeUtilizator, idElem);
		System.out.println(pretVanzare);
		idNou = piata.mutareElement(numeUtilizator, "Piata", idElem);
		piata.modificareNrPuncte("Piata", idNou, "*");
		piata.inchidereConexiune();
		
		Jucatori_online jucator = new Jucatori_online("Joc");
		jucator.creareConexiune();
		jucator.actualizareCapitalJucator(numeUtilizator, pretVanzare, "+");
		jucator.inchidereConexiune();
		
		return dateUtilizator;
	}

}
