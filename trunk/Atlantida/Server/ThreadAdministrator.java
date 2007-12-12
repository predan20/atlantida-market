import java.util.ArrayList;

import javax.net.ssl.SSLSocket;

//Ar mai trebui adaugata facilitatea de modificare a proprietatilor unei coloane: formula, pretul si valoarea maxima
//a prop speciale
//Trebuie facut la administrator cand trimite valorile pt actualizare sa calculam modificarea: ex sanatatea scade cu 1
//la fiecare RI/3 cicluri

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
		Dezintegrare dezintegrare = new Dezintegrare("Inventare");
		
		String durataCiclu = dateUtilizator.get(0);          //Durata unui ciclu exprimata in minute
		String  capitalInitial = dateUtilizator.get(1);      //Capital initial de puncte
		String actualizareSanatate = dateUtilizator.get(2);  //Valoare in puncte cu care se actualizeaza sanatatea
		String actualizareRandament = dateUtilizator.get(3); //Valoare in puncte cu care se actualizeaza randamentul
		String actualizareConsum = dateUtilizator.get(4);    //Valoare in puncte cu care se actualizeaza consumul
		String durataLicitatieSimpla = dateUtilizator.get(5);//Durata in timp a licitatiei fara alti jucatori
		String durataLicitatieComplexa = dateUtilizator.get(6);//Durata in timp a licitatiei cu alti jucatori
		String numeElement = dateUtilizator.get(7);           //Nume element nou
		String propSpeciala = dateUtilizator.get(8);         //Numele proprietatii speciale 
		String formula = dateUtilizator.get(9);              //Formula de calcul a proprietatii speciale 
		String valMaxima = dateUtilizator.get(10);            //Valoarea maxima a proprietatii speciale 
		String pretElementAtomic = dateUtilizator.get(11);    //Pretul elementului atomic
		
		ArrayList<String> parametriAdministare = new ArrayList<String>(); //Primii 7 parametri
		for (int i = 0; i < 7; i++)
		{
			parametriAdministare.add(dateUtilizator.get(i));
		}
		
		/*Administrator admin = new Administrator("Joc");
		admin.creareConexiune();
		admin.setareParametriAdministrare(parametriAdministare);
		
		if ((!propSpeciala.trim().equals(""))&&(!formula.trim().equals(""))&&(!valMaxima.trim().equals(""))&&(!pretElementAtomic.trim().equals("")))
		{
			System.out.println("Intra!!!!");
			admin.inserareInregistrare(numeElement, propSpeciala, formula, Integer.parseInt(valMaxima), Integer.parseInt(pretElementAtomic));
			admin.actualizareInventarUtilizator(propSpeciala);
			admin.inchidereConexiune();
			
			admin = new Administrator("Inventare");
			admin.creareConexiune();
			
			admin.actualizareInventare(propSpeciala);
			admin.inchidereConexiune();
		}
		else
		{
			admin.inchidereConexiune();
		}
		*/
		dezintegrare.creareConexiune();
		dezintegrare.verificareDezintegrare("ionEla12");
		dezintegrare.inchidereConexiune();
		return dateUtilizator;
	}

}
