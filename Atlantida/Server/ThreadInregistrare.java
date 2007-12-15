import java.util.ArrayList;

import javax.net.ssl.SSLSocket;

//Metoda getNumeColoane ar trebui mutata din Inventar_jucator in Jucatorul de pe server.... se face acces
//la baza de date Joc nu Inventar


public class ThreadInregistrare extends ConnectionAbstractThread
{

	public ThreadInregistrare(SSLSocket socket)
	{
		this.socket = socket;
		this.server = new ComunicareServer(socket);
	}
	
	@Override
	protected ArrayList<String> operatie(ArrayList<String> dateUtilizator)
	{
		ArrayList<String> numeColoane = new ArrayList<String>();
		
		String numeUtilizator = "";
		String parolaUtilizator = "";
		String emailUtilizator = "";
		
		String numarPuncte = "";
		
		//Numele si parola vor fi trimise de client, intotdeauna, pe primul si respectiv al doilea rand
		numeUtilizator = dateUtilizator.get(0);
		parolaUtilizator = dateUtilizator.get(1);
		emailUtilizator = dateUtilizator.get(2);
		
		//Conectare la baza de date Administrare pentru a lua numarul initial de puncte
		Administrator admin = new Administrator("Joc");
		admin.creareConexiune();
		numarPuncte = admin.getProprietateInitiala("capital_initial");
		admin.inchidereConexiune();
		
		//Adaugam date in tabela Jucatori
		Jucator jucator = new Jucator("Joc");
		jucator.creareConexiune();
		jucator.inserareInregistrare(numeUtilizator, parolaUtilizator, emailUtilizator, numarPuncte);
		jucator.inchidereConexiune();
		
		Inventar_utilizator inventar;
		
		inventar = new Inventar_utilizator("Joc");
		inventar.creareConexiune();
		numeColoane = inventar.getNumeColoane("Inventar_utilizator");
		inventar.inchidereConexiune();
		
		inventar = new Inventar_utilizator("Inventare");
		inventar.creareConexiune();
		inventar.creareInventar(numeUtilizator, numeColoane);
		inventar.inchidereConexiune();
		
		//In cazul in care datele sunt valide instantiem un jucator pe care il vom trimite la client
		Jucatori_online jucatorOnline = new Jucatori_online("Joc");
		jucatorOnline.creareConexiune();
		
		//System.out.println(numarPuncte);
		jucatorOnline.inserareInregistrare(numeUtilizator);
		jucatorOnline.inchidereConexiune();
		
		System.out.println("Inregistare: " + numeUtilizator + " -> " + parolaUtilizator);
		//ADAUGAM in numeColoane, pe ultimul rand si numar de puncte initial al jucatorului

		dateUtilizator = new ArrayList<String>();
		String coloane = "";
		for (int i = 0; i < numeColoane.size(); i++)
		{
			coloane += numeColoane.get(i) + " ";
		}
		
		dateUtilizator.add(coloane);
		dateUtilizator.add(numarPuncte);
		
		return dateUtilizator;

	}

}
