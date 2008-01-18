import java.util.ArrayList;

import javax.net.ssl.SSLSocket;


public class ThreadInventar extends ConnectionAbstractThread
{

	public ThreadInventar(SSLSocket socket)
	{
		this.socket = socket;
		this.server = new ComunicareServer(socket);
	}
	
	@Override
	protected ArrayList<String> operatie(ArrayList<String> dateUtilizator)
	{
		ArrayList<String> numeColoane = new ArrayList<String>();
		String numeUtilizator = "";
		String coloane = "";
		String capitalUtilizator = "";
		
		if(dateUtilizator.get(0).equalsIgnoreCase("Piata"))
		{
			//interogare inventar piata, filtrare dupa capital(numeUtilizator)
			numeUtilizator = dateUtilizator.get(1);
			
			Jucatori_online jucatori = new Jucatori_online("Joc");
			jucatori.creareConexiune();
			capitalUtilizator = jucatori.getNumarPuncte(numeUtilizator);
			jucatori.inchidereConexiune();
			
			Inventar_utilizator inventar = new Inventar_utilizator("Inventare");
			inventar.creareConexiune();
			numeColoane = inventar.getNumeColoane(numeUtilizator);
			inventar.inchidereConexiune();
			
			Piata piata = new Piata("Inventare");
			piata.creareConexiune();
			dateUtilizator = piata.filtrareElemente(capitalUtilizator);
			piata.inchidereConexiune();
			
			for(String nume : numeColoane)
			{
				coloane += nume + " ";
			}
			
			dateUtilizator.add(0, coloane);
			dateUtilizator.add(capitalUtilizator);
		}
		else
		{
			//interogare inventar utilizator
			numeUtilizator = dateUtilizator.get(0);
			
			Jucatori_online jucatori = new Jucatori_online("Joc");
			jucatori.creareConexiune();
			capitalUtilizator = jucatori.getNumarPuncte(numeUtilizator);
			jucatori.inchidereConexiune();
			
			Inventar_utilizator inventar = new Inventar_utilizator("Inventare");
			inventar.creareConexiune();
			inventar.actualizareNume(dateUtilizator);
			numeColoane = inventar.getNumeColoane(numeUtilizator);
			dateUtilizator = inventar.getInventar(numeUtilizator, numeColoane);
			inventar.inchidereConexiune();
			
			for(String nume : numeColoane)
			{
				coloane += nume + " ";
			}
			
			dateUtilizator.add(0, coloane);
			dateUtilizator.add(capitalUtilizator);
		}
		
		return dateUtilizator;
	}

}
