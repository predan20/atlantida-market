import java.util.ArrayList;

import javax.net.ssl.SSLSocket;

// NU este facuta actualizarea parametrilor dupa nr de cicluri din Jucatori

public class ThreadLogin extends ConnectionAbstractThread
{
	public ThreadLogin(SSLSocket socket)
	{
		this.server = new ComunicareServer(socket);
		this.socket = socket;
	}
	
	protected ArrayList<String> operatie(ArrayList<String> dateUtilizator)
	{
		ArrayList<String> numeColoane = new ArrayList<String>();
		Jucator jucator = new Jucator("Joc");
		
		String numeUtilizator = "";
		String parolaUtilizator = "";
		
		//Numele si parola vor fi trimise de client, intotdeauna, pe primul si respectiv al doilea rand
		numeUtilizator = dateUtilizator.get(0);
		parolaUtilizator = dateUtilizator.get(1);
		
		//Creem conexiunea cu baza de date
		jucator.creareConexiune();
		
		//Verificam datele primite
		if(jucator.validareDate(numeUtilizator, parolaUtilizator))
		{
			numeColoane = jucator.getNumeColoane(numeUtilizator);
			
			jucator.inchidereConexiune();
			//In cazul in care datele sunt valide instantiem un jucator pe care il vom trimite la client
			Jucatori_online jucatorOnline = new Jucatori_online("Joc");
			jucatorOnline.creareConexiune();
			jucatorOnline.inserareInregistrare(numeUtilizator);
			jucatorOnline.inchidereConexiune();

			Inventar_utilizator inventarUtilizator = new Inventar_utilizator("Inventare");
			inventarUtilizator.creareConexiune();
			
			dateUtilizator = inventarUtilizator.getInventar(numeUtilizator, numeColoane);
			inventarUtilizator.inchidereConexiune();
			
			System.out.println("Login: Autentificare: " + numeUtilizator + " -> " + parolaUtilizator);
		}
		else
		{
			jucator.inchidereConexiune();
			System.out.println("Nu exista "+numeUtilizator + parolaUtilizator);
		}
		
		return dateUtilizator;
	}
	
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "ThreadLogin " + socket.getPort();
	}

}
