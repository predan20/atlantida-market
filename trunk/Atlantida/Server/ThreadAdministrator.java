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
		
		Administrator admin = new Administrator("89.43.103.108", "3306", "Joc", "root", "xxx123yyy");
		admin.creareConexiune();
		String propSpeciala = dateUtilizator.get(0);
		
		admin.actualizareInventarUtilizator(propSpeciala);
		admin.inchidereConexiune();
		
		return dateUtilizator;
	}

}
