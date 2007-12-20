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
		float pretCumparare, pretElement = 0;
		long secundeRamase = 0;
		int idNou = 0;
		String timpStartLicitatie = "";
		
		numeUtilizator = dateUtilizator.get(0);
		idElem = Integer.parseInt(dateUtilizator.get(1));
		pretCumparare = Float.parseFloat(dateUtilizator.get(2));
		dateUtilizator = new ArrayList<String>();
		
		Piata piata = new Piata("Inventare");
		piata.creareConexiune();
		pretElement = piata.getValoareElement("Piata", idElem);
		if((verificare = piata.cumparareElementeAtomiceCuPropRandom(numeUtilizator, idElem)) == 0)
		{
			Licitatie licitatie = new Licitatie("Inventare");
			licitatie.creareConexiune();
			timpStartLicitatie = licitatie.inserareJucatorLicitatie(idElem, numeUtilizator, pretCumparare);
			//{
				secundeRamase = licitatie.getSecundeRamaseDinLicitatie(timpStartLicitatie);
				dateUtilizator.add(String.valueOf(secundeRamase));
			//}
			//else
			//{
			//	dateUtilizator.add("-1");
			//}
			licitatie.inchidereConexiune();
			
			System.out.println("elem deja vandut" + pretCumparare);
			//idNou = piata.mutareElement("Piata", numeUtilizator, idElem);
			//piata.modificareNrPuncte(numeUtilizator, idNou, "/");
			
		}
		else if(verificare != -1)
		{
			System.out.println("elem random" + pretCumparare);
			//Actualizare nr puncte in inventarul utilizatorului
			piata.actualizareNrPuncte(numeUtilizator, verificare);
			dateUtilizator.add("-1");
		}
		piata.inchidereConexiune();
		
		Jucatori_online jucator = new Jucatori_online("Joc");
		jucator.creareConexiune();
		System.out.println("Bah. mie imi cam vine sa actualizez ceva!");
		jucator.actualizareCapitalJucator(numeUtilizator, pretCumparare, "-");
		jucator.inchidereConexiune();
		
		for(String id : dateUtilizator)
		System.out.println("Secunde returnate la cumparare: " + id);
		return dateUtilizator;
	}

}
