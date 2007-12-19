import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class CeasLicitatii 
{
	private Timer cronometru;

	public CeasLicitatii(int milisecunde) 
	{
		cronometru = new Timer();
		cronometru.schedule(new CronometruLicitatii(), milisecunde * 1000);
	}
	
	class CronometruLicitatii extends TimerTask 
	{
		public void run() 
		{
			String numeUtilizator = "";
			int idElem = 0;
			ArrayList<ElementeAtribuire> listaOferte;
			
			System.out.println("Time's up, mf!");
			Licitatie licitatie = new Licitatie("Inventare");
			licitatie.creareConexiune();
			listaOferte = licitatie.determinareCastigator();
			licitatie.inchidereConexiune();
			
			idElem = Integer.parseInt(listaOferte.get(0).getLValue());
			numeUtilizator = listaOferte.get(1).getLValue();

			//Pentru castigator vom muta in inventar elementul licitat din piata
			Piata piata = new Piata("Inventare");
			piata.creareConexiune();
			piata.modificareNrPuncte("Piata", idElem, "/");
			piata.mutareElementCompus("Piata", numeUtilizator, idElem, piata.getMaxID(numeUtilizator));
			piata.inchidereConexiune();
			//Pentru restul jucatorilor se vor restitui punctele licitate si vor fi scosi din baza de date Licitatii
			Jucatori_online jucatoriOnline = new Jucatori_online("Joc");
			jucatoriOnline.creareConexiune();
			Jucator jucator = new Jucator("Joc");
			jucator.creareConexiune();
			
			System.out.println("Lista oferte: ");
			for (int i = 2; i < listaOferte.size(); i++)
			{
				if (!jucatoriOnline.actualizareCapitalJucator(listaOferte.get(i).getLValue(), Float.parseFloat(listaOferte.get(i).getRValue()), "+"))
				{
					jucator.actualizareCapitalJucator(listaOferte.get(i).getLValue(), Float.parseFloat(listaOferte.get(i).getRValue()), "+");
				}
				System.out.println(i+ ". " +listaOferte.get(i).getLValue() + " " + listaOferte.get(i).getRValue());
			}
			jucatoriOnline.inchidereConexiune();
			jucator.inchidereConexiune();
			//new CeasLicitatii(30);
		}
	}
}