import java.util.ArrayList;

import javax.net.ssl.SSLSocket;


public class ThreadCumparare extends ConnectionAbstractThread
{
	public ThreadCumparare(SSLSocket socket)
	{
		this.socket = socket;
		this.server = new ComunicareServer(socket);
	}
	
	@Override
	protected ArrayList<String> operatie(ArrayList<String> dateUtilizator)
	{
		String numeUtilizator = "";
		int idElem = 0, verificare;
		float pretCumparare = 0;
		int idNou = 0;
		
		numeUtilizator = dateUtilizator.get(0);
		idElem = Integer.parseInt(dateUtilizator.get(1));
		
		Piata piata = new Piata("Inventare");
		piata.creareConexiune();
		pretCumparare = piata.getValoareElement("Piata", idElem);
		if((verificare = piata.cumparareElementeAtomiceCuPropRandom(numeUtilizator, idElem)) == 0)
			{
				System.out.println("elem deja vandut" + pretCumparare);
				idNou = piata.mutareElement("Piata", numeUtilizator, idElem);
				piata.modificareNrPuncte(numeUtilizator, idNou, "/");
			}
		else if(verificare != -1)
		{
			System.out.println("elem random" + pretCumparare);
			//Actualizare nr puncte in inventarul utilizatorului
			piata.actualizareNrPuncte(numeUtilizator, verificare);
		}
		piata.inchidereConexiune();
		
		Jucatori_online jucator = new Jucatori_online("Joc");
		jucator.creareConexiune();
		jucator.actualizareCapitalJucator(numeUtilizator, pretCumparare, "-");
		jucator.inchidereConexiune();
		
		return dateUtilizator;
	}

}
