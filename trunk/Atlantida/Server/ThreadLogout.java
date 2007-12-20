import java.util.ArrayList;

import javax.net.ssl.SSLSocket;


public class ThreadLogout extends ConnectionAbstractThread
{

	public ThreadLogout(SSLSocket socket)
	{
		this.socket = socket;
		this.server = new ComunicareServer(socket);
	}
	
	@Override
	protected ArrayList<String> operatie(ArrayList<String> dateUtilizator)
	{
		Jucator jucator = new Jucator("Joc");
		
		String numeUtilizator = "";
		String parolaUtilizator = "";
		String numarPuncte = "";
		
		//Numele si parola vor fi trimise de client, intotdeauna, pe primul si respectiv al doilea rand
		numeUtilizator = dateUtilizator.get(0);
		parolaUtilizator = dateUtilizator.get(1);
		
		//Creem conexiunea cu baza de date
		jucator.creareConexiune();
		
		//Verificam datele primite
		if(jucator.validareDate(numeUtilizator, parolaUtilizator))
		{
			//In cazul in care datele sunt valide instantiem un jucator pe care il vom trimite la client
			Jucatori_online jucatorOnline = new Jucatori_online("Joc");
			jucatorOnline.creareConexiune();
			
			numarPuncte = jucatorOnline.getNumarPuncte(numeUtilizator);
			jucator.setNumarPuncte(numarPuncte, numeUtilizator);
			jucatorOnline.stergereInregistrare(numeUtilizator);
						
			jucatorOnline.inchidereConexiune();

		}
		else
		{
			//eroare logout
		}
		jucator.inchidereConexiune();
		return dateUtilizator;

	}

}
