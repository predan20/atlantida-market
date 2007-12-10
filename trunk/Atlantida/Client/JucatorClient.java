import java.util.*;

public class JucatorClient {

	private String utilizator;
	private int utilizatorID;
	private long punctajUtilizator;
	private ArrayList<Element> inventarUtilizator;
	
	
	public JucatorClient(String utilizator, int utilizatorID, long punctajUtilizator, ArrayList<Element> inventarUtilizator)
	{
		this.utilizator = utilizator;
		this.utilizatorID = utilizatorID;
		this.punctajUtilizator = punctajUtilizator;
		this.inventarUtilizator = inventarUtilizator;
	}

	public String getUtilizator() {
		return utilizator;
	}
	
	public void setUtilizator(String utilizator) {
		this.utilizator = utilizator;
	}
	
	public int getUtilizatorID() {
		return utilizatorID;
	}
	
	public void setUtilizatorID(int utilizatorID) {
		this.utilizatorID = utilizatorID;
	}
	
	public long getPunctajUtilizator() {
		return punctajUtilizator;
	}
	
	public void setPunctajUtilizator(long punctajUtilizator) {
		this.punctajUtilizator = punctajUtilizator;
	}
	
	public ArrayList<Element> getInventarUtilizator() {
		return inventarUtilizator;
	}
	
	public void setInventarUtilizator(ArrayList<Element> inventarUtilizator) {
		this.inventarUtilizator = inventarUtilizator;
	}
	
	/*public Element combinareElemente() 
	{
		
	}*/

	public boolean adaugareElementInInventar(Element element) 
	{
		try
		{
			inventarUtilizator.add(element);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void modificaNumarPuncte(float valoareComercializare)
	{
			punctajUtilizator = punctajUtilizator + (long)valoareComercializare;
	}

	public boolean stergereElementDinInventar(int idElement) 
	{
		try
		{
			Iterator<Element> it = inventarUtilizator.iterator();
			while(it.hasNext())
			{
				Element elemIterat = it.next();
				if(elemIterat.getIdElement() == idElement)
				{
					it.remove();
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

}