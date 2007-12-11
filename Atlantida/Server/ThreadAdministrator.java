import java.util.ArrayList;

import javax.net.ssl.SSLSocket;


public class ThreadAdministrator extends ConnectionAbstractThread
{
	public ThreadAdministrator(SSLSocket socket)
	{
		this.server = new ComunicareServer(socket);
		this.socket = socket;
	}
	
	@Override
	protected ArrayList<String> operatie(ArrayList<String> dateUtilizator)
	{
		
		Administrator admin = new Administrator("Joc");
		admin.creareConexiune();
		String propSpeciala = dateUtilizator.get(0);
		
		admin.actualizareInventarUtilizator(propSpeciala);
		admin.inchidereConexiune();
		
		return dateUtilizator;
	}

}
