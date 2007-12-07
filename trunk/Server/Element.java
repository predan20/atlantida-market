public class Element 
{
	private int idElement;
	private String numeElement;
	private float masa;
	private float consumEnergetic;
	private float randament;
	private float rataInvechire;
	private float puncteSanatate;
	private int parinte;
	private String numePropSpeciala;
	private float propSpeciala;
	private float numarPuncte;
	private float pret;
	
	public Element(int idElement, String numeElement, int valMaxima) 
	{
		this.idElement = idElement;
		this.numeElement = numeElement;
		this.masa = this.generareProprietate(valMaxima);
		this.consumEnergetic = this.generareProprietate(valMaxima);
		this.randament = (float)Math.random();
		this.rataInvechire = this.generareProprietate(valMaxima);
		this.puncteSanatate = this.generareProprietate(valMaxima);
		this.numarPuncte = this.calculNumarPuncte();
		this.pret = this.calculNumarPuncte();
	}
	
	public Element(int idElement, String numeElement, float masa, float consumEnergetic, float randament, float rataInvechire, float puncteSanatate, int parinte, String numePropSpeciala, float proprSpeciala) 
	{
		this.idElement = idElement;
		this.numeElement = numeElement;
		this.masa = masa;
		this.consumEnergetic = consumEnergetic;
		this.randament = randament;
		this.rataInvechire = rataInvechire;
		this.puncteSanatate = puncteSanatate;
		this.parinte = parinte;
		this.numePropSpeciala = numePropSpeciala;
		this.propSpeciala = proprSpeciala;
	}
	
	
	private float generareProprietate(int valMaxima) {
		return 1 + (float)(Math.random() * valMaxima);
	}
	
	private float calculNumarPuncte() {
		return (puncteSanatate - masa - consumEnergetic) * randament * rataInvechire * 1 * 100; 
	}
	
	public int getIdElement()
	{
		return idElement;
	}
	
	public void setIdElement(int idElement)
	{
		this.idElement = idElement;
	}
	
	public float getMasa()
	{
		return masa;
	}
	
	public void setMasa(float masa)
	{
		this.masa = masa;
	}
	
	public float getConsumEnergetic()
	{
		return consumEnergetic;
	}
	
	public void setConsumEnergetic(float consumEnergetic)
	{
		this.consumEnergetic = consumEnergetic;
	}
	
	public float getRandament()
	{
		return randament;
	}
	
	public void setRandament(float randament)
	{
		this.randament = randament;
	}
	
	public float getRataInvechire()
	{
		return rataInvechire;
	}
	
	public void setRataInvechire(float rataInvechire)
	{
		this.rataInvechire = rataInvechire;
	}
	
	public float getPuncteSanatate()
	{
		return puncteSanatate;
	}
	
	public void setPuncteSanatate(float puncteSanatate)
	{
		this.puncteSanatate = puncteSanatate;
	}
	
	public float getNumarPuncte()
	{
		return numarPuncte;
	}
	
	public void setNumarPuncte(float numarPuncte)
	{
		this.numarPuncte = numarPuncte;
	}
	
	public float getPret()
	{
		return pret;
	}

	public void setPret(int pret)
	{
		this.pret = pret;
	}
	
	public void modificaPret(int valoareNoua) {
		this.pret = valoareNoua;
	}

	public void actualizareParametrii(int valModificaSanatatea, int valModificaRandament, int valModificaConsumEnergetic) {
		this.puncteSanatate = puncteSanatate - valModificaSanatatea;
		this.randament = randament - valModificaRandament;
		this.consumEnergetic = consumEnergetic + valModificaConsumEnergetic;
	}

	public boolean dezintegrareElement() {
		if(puncteSanatate == 0 || randament == 0) return true;
		return false;
	}
	
	public String toString()
	{
		return idElement + " " + numeElement + " " + masa + " " + consumEnergetic + " " + randament + " " + rataInvechire + " " + puncteSanatate + " " + parinte + " " + numePropSpeciala + " " + propSpeciala;
	}
}