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
//		//expresie formula
//		String expr = "x1=SUM(Masa)\nx2=MIN(PropSp)\nx3=SUM(Randament)\nx4=MULT(Sanatate)\nx5=AVG(Masa)\n2+x1+x2*(x3+x4-x5)";
//		
//		combinareElemente.calculValoareProprSpeciala(expr, idParinte);
		
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
