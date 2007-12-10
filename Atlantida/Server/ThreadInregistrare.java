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
		Jucator jucator = new Jucator("89.43.103.108", "3306", "Joc", "root", "xxx123yyy");
		
		String numeUtilizator = "";
		String parolaUtilizator = "";
		String emailUtilizator = "";
		
		String numarPuncte = "300";
		
		//Numele si parola vor fi trimise de client, intotdeauna, pe primul si respectiv al doilea rand
		numeUtilizator = dateUtilizator.get(0);
		parolaUtilizator = dateUtilizator.get(1);
		emailUtilizator = dateUtilizator.get(2);
		
		//Creem conexiunea cu baza de date
		jucator.creareConexiune();
		
		//Adaugam date in tabela Jucatori
		jucator.inserareInregistrare(numeUtilizator, parolaUtilizator, emailUtilizator, numarPuncte);
		jucator.inchidereConexiune();
		
		Inventar_utilizator inventar;
		
		inventar = new Inventar_utilizator("89.43.103.108", "3306", "Joc", "root", "xxx123yyy");
		inventar.creareConexiune();
		numeColoane = inventar.getNumeColoane(numeUtilizator);
		inventar.inchidereConexiune();
		
		inventar = new Inventar_utilizator("89.43.103.108", "3306", "Inventare", "root", "xxx123yyy");
		inventar.creareConexiune();
		inventar.creareInventar(numeUtilizator, numeColoane);
		inventar.inchidereConexiune();
		
		//In cazul in care datele sunt valide instantiem un jucator pe care il vom trimite la client
		Jucatori_online jucatorOnline = new Jucatori_online("89.43.103.108", "3306", "Joc", "root", "xxx123yyy");
		jucatorOnline.creareConexiune();
		
		//System.out.println(numarPuncte);
		jucatorOnline.inserareInregistrare(numeUtilizator);
		
		jucatorOnline.inchidereConexiune();
		
		this.server.scriereDate(dateUtilizator);
		System.out.println("Inregistare: " + numeUtilizator + " -> " + parolaUtilizator);


		return dateUtilizator;

	}

}
