public class CombinareElemente
{
	private String[] id = new String[] {};
	private String numeUtilizator = "";
	
	public CombinareElemente(String numeUtilizator, String id)
	{
		this.id = id.split(",");
		this.numeUtilizator = numeUtilizator;		
	}
	
	
	public int creareParinte()
	{
		try
		{
			int idParinte = 0;
			Inventar_utilizator inventarUtilizator = new Inventar_utilizator("Inventare");
			
			inventarUtilizator.creareConexiune();
			inventarUtilizator.inserareInregistrareVida(numeUtilizator);
			idParinte = inventarUtilizator.getUltimulElement(numeUtilizator);
			if(idParinte > 1)
			{
				for(int i = 0; i < id.length; i++)
				{
					inventarUtilizator.setParinte(numeUtilizator, id[i], idParinte);
				}
				
			}
			else
			{
				System.out.println("Eroare la ultimul element!");
			}
			

			inventarUtilizator.calculareProprietati(numeUtilizator, idParinte, id.length);
			inventarUtilizator.inchidereConexiune();
			
			return idParinte;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	
	
	
}
	