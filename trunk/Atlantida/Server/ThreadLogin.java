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
		String coloane  = "";
		String numarPuncte = "";
		
		//Creem conexiunea cu baza de date
		jucator.creareConexiune();
		
		if(dateUtilizator.get(0).equalsIgnoreCase("administrator"))
		{
			//Numele si parola vor fi trimise de client, intotdeauna, pe al doilea si respectiv al treilea rand
			numeUtilizator = dateUtilizator.get(1);
			parolaUtilizator = dateUtilizator.get(2);
			
			//Verificam datele primite
			if(jucator.validareDate(numeUtilizator, parolaUtilizator, true))
			{
				Administrator admin = new Administrator("Joc");
				admin.creareConexiune();
				dateUtilizator = admin.getProprietatiAdministare();
				admin.inchidereConexiune();
				
				//In cazul in care datele sunt valide instantiem un jucator pe care il vom trimite la client
				Jucatori_online jucatorOnline = new Jucatori_online("Joc");
				jucatorOnline.creareConexiune();
				jucatorOnline.inserareInregistrare(numeUtilizator);
				jucatorOnline.inchidereConexiune();
			}
			else
			{
				//In cazul in care login-are administratorului nu s-a facut cu succes
				dateUtilizator = new ArrayList<String>();
				dateUtilizator.add("insucces");
				jucator.inchidereConexiune();
			}
		}
		else
		{
			//Numele si parola vor fi trimise de client, intotdeauna, pe primul si respectiv al doilea rand
			numeUtilizator = dateUtilizator.get(0);
			parolaUtilizator = dateUtilizator.get(1);
			
			//Verificam datele primite
			if(jucator.validareDate(numeUtilizator, parolaUtilizator, false))
			{
				numeColoane = jucator.getNumeColoane(numeUtilizator);
				
				jucator.inchidereConexiune();
				//In cazul in care datele sunt valide instantiem un jucator pe care il vom trimite la client
				Jucatori_online jucatorOnline = new Jucatori_online("Joc");
				jucatorOnline.creareConexiune();
				jucatorOnline.inserareInregistrare(numeUtilizator);
				numarPuncte = jucatorOnline.getNumarPuncte(numeUtilizator);
				jucatorOnline.inchidereConexiune();
	
				Inventar_utilizator inventarUtilizator = new Inventar_utilizator("Inventare");
				inventarUtilizator.creareConexiune();
				
				for(String nume : numeColoane)
				{
					coloane += nume + " ";
				}
				
				dateUtilizator = inventarUtilizator.getInventar(numeUtilizator, numeColoane);
				dateUtilizator.add(numarPuncte);
				dateUtilizator.add(0,coloane);
				inventarUtilizator.inchidereConexiune();
	
			}
			else
			{
				//In cazul in care login-area jucatorului nu s-a facut cu succes
				dateUtilizator = new ArrayList<String>();
				dateUtilizator.add("insucces");
				jucator.inchidereConexiune();
			}
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
