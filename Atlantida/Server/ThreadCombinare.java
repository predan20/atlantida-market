import java.util.ArrayList;

import javax.net.ssl.SSLSocket;

import org.nfunk.jep.function.Str;

public class ThreadCombinare extends ConnectionAbstractThread
{
	public ThreadCombinare(SSLSocket socket)
	{
		this.server = new ComunicareServer(socket);
		this.socket = socket;
	}
	
	@Override
	protected ArrayList<String> operatie(ArrayList<String> dateUtilizator)
	{
		//Pe primul rand numele utilizatorului, iar pe cel de-al doilea un string de id-uri separate prin virgula
		String numeUtilizator = dateUtilizator.get(0);
		String idElemente = dateUtilizator.get(1);
		
		CombinareElemente combinareElemente = new CombinareElemente(numeUtilizator, idElemente);
		int idParinte = combinareElemente.creareParinte();
		
		Jucatori_online jucatorOnline = new Jucatori_online("Joc");
		jucatorOnline.creareConexiune();
		String numarPuncte = jucatorOnline.getNumarPuncte(numeUtilizator);
		jucatorOnline.inchidereConexiune();
		
		Inventar_utilizator inventar = new Inventar_utilizator("Inventare");
		inventar.creareConexiune();
		
		ArrayList<String> numeColoane = inventar.getNumeColoane(numeUtilizator);
		String coloane = "";
		
		for(String s : numeColoane)
		{
			coloane += s + " ";
		}
		dateUtilizator = inventar.getInventar(numeUtilizator, numeColoane);
		inventar.inchidereConexiune();
		
		dateUtilizator.add(0,coloane);
		dateUtilizator.add(numarPuncte);

		
		return dateUtilizator;
	}
}
