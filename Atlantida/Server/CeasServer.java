import java.util.Timer;
import java.util.TimerTask;

public class CeasServer 
{
	private Timer cronometru;

	public CeasServer(int milisecunde) 
	{
		cronometru = new Timer();
		cronometru.schedule(new CronometruServer(), milisecunde * 1000);
	}
	
	class CronometruServer extends TimerTask 
	{
		public void run() 
		{
			System.out.println("Time's up, mf!");
			Inventar_utilizator inventar_utilizator = new Inventar_utilizator("Inventare");
			inventar_utilizator.creareConexiune();
			inventar_utilizator.actualizareProprietatiDinInventare((float)-5, (float)-5, (float)1);
			inventar_utilizator.inchidereConexiune();
			new CeasServer(30);
		}
	}
}
