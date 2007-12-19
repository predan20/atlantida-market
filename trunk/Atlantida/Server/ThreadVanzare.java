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
		String coloane = "";
		int idElem = 0;
		float pretVanzare = 0;
		String numarPuncte = "";
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
		
		Jucatori_online jucatorOnline = new Jucatori_online("Joc");
		jucatorOnline.creareConexiune();
		jucatorOnline.actualizareCapitalJucator(numeUtilizator, pretVanzare, "+");
		numarPuncte = jucatorOnline.getNumarPuncte(numeUtilizator);
		jucatorOnline.inchidereConexiune();
		
		ArrayList<String> numeColoane = new ArrayList<String>();
		Jucator jucator = new Jucator("Joc");
		jucator.creareConexiune();
		numeColoane = jucator.getNumeColoane(numeUtilizator);
		jucator.inchidereConexiune();
		
		for (String nume : numeColoane)
		{
			coloane += nume + " ";
		}
		
		Inventar_utilizator inventar_utilizator = new Inventar_utilizator("Inventare");
		inventar_utilizator.creareConexiune();
		dateUtilizator = inventar_utilizator.getInventar(numeUtilizator, numeColoane);
		dateUtilizator.add(0, coloane);
		dateUtilizator.add(numarPuncte);
		inventar_utilizator.inchidereConexiune();
		
		return dateUtilizator;
	}

}
