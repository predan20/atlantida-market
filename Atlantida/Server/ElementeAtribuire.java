public class ElementeAtribuire
{
	private String lValue;
	private String rValue;
	
	public ElementeAtribuire(String lValue, String rValue)
	{
		this.lValue = lValue;
		this.rValue = rValue;
	}
	
	public String getLValue()
	{
		return lValue;
	}
	
	public void setLValue(String value)
	{
		lValue = value;
	}
	
	public String getRValue()
	{
		return rValue;
	}
	
	public void setRValue(String value)
	{
		rValue = value;
	}
}
