import org.nfunk.jep.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.*;

public class EvaluareExpresie
{
	
	private String operatiiSimple = "";
	private String campuriProdus = "";
	private String formula = "";
	
	private ArrayList<ElementeAtribuire> elemente = new ArrayList<ElementeAtribuire>();
	
	public EvaluareExpresie(String expresie)
	{
		elemente = parseFormulaElement(expresie);
		getCampuri(elemente);
	}
	
	public String getOperatiiSimple()
	{
		return operatiiSimple;
	}
	
	public String getCampuriProdus()
	{
		return campuriProdus;
	}
	
	
	public ArrayList<ElementeAtribuire> getElemente()
	{
		return elemente;
	}
	
	public void setElemente(ArrayList<ElementeAtribuire> elemente)
	{
		this.elemente = elemente;
	}
	
	
	public void setValoriElemente(ArrayList<String> evalList,boolean produs)
	{
		int i = 0;
		if(produs)
		{

			for(ElementeAtribuire e : elemente)
			{
				if(e.getRValue().contains("MULT"))
				{
					e.setRValue(evalList.get(i));
				}
				i++;
			}
		}
		else
		{

			for(ElementeAtribuire e : elemente)
			{		
				if(e.getRValue().contains("MULT") == false)
				{
					e.setRValue(evalList.get(i));
				}
				i++;
			}
		}
		
	}
	public ArrayList<ElementeAtribuire> parseFormulaElement(String expresie)
	{
		ArrayList<ElementeAtribuire> ret = new ArrayList<ElementeAtribuire>();
		
		Pattern varSt = Pattern.compile("([a-z0-9]+)=");
		Pattern varDr = Pattern.compile("=([a-zA-Z0-9()]+)([a-zA-Z0-9_\\[\\]()]*)([ ]+)");
		
		Matcher mSt = varSt.matcher(expresie);

		String varX = "";
		String varOpField = "";
		ElementeAtribuire elementeAtribuire;
		
		while(mSt.find())
		{
			varX = mSt.group(1);
			elementeAtribuire = new ElementeAtribuire(varX,"");
			expresie = expresie.replaceFirst(varX, "");
			ret.add(elementeAtribuire);
		}
		
		Matcher mDr = varDr.matcher(expresie);
		
		Iterator<ElementeAtribuire> it = ret.iterator();
		
		while(mDr.find() && it.hasNext())
		{
			if(mDr.group(1).contains("Sel"))
			{
				varOpField = mDr.group(1).replace("Sel", "") +  mDr.group(2).replaceAll("[\\[\\])]*", "") + ") SEL";
			}
			else
			{
				varOpField = mDr.group(1);
			}
			it.next().setRValue(varOpField);
			expresie = expresie.replace(mDr.group(), "");
		}
		
		formula = expresie.trim();
		
		return ret;
	}
	
	public void getCampuri(ArrayList<ElementeAtribuire> eleList)
	{
		
		ArrayList<String> restrictiiOperatiiSimple = new ArrayList<String>();
		ArrayList<String> restrictiiProdus = new ArrayList<String>();
		Iterator<ElementeAtribuire> it = eleList.iterator();

		//generare comanda mysql
		String cmdMySql = "";
		int posMult = -1;
		String field = "";
		ElementeAtribuire e = null;
		while(it.hasNext())
		{
			e = it.next();
			if(e.getRValue().contains("MULT") == false)
			{
				if(e.getRValue().contains("SEL"))
				{
					restrictiiOperatiiSimple.add(e.getRValue());
				}
				else
				{
					cmdMySql += ", "+e.getRValue();
				}
			}
			else
			{
				field = e.getRValue().substring(e.getRValue().indexOf('(') + 1,e.getRValue().length() -1);
				if(e.getRValue().contains("SEL"))
				{
					restrictiiProdus.add(field);
				}
				else
				{
					campuriProdus += ", " + field;
				}
			}
		}
		
		cmdMySql += "\n";
		for(String s : restrictiiOperatiiSimple)
		{
			cmdMySql +=  ", " + s;
		}
		
		cmdMySql = cmdMySql.replaceFirst(",", "");
		operatiiSimple = cmdMySql;
		
		campuriProdus += "\n";
		for(String s : restrictiiProdus)
		{
			campuriProdus += ", " + s ;
		}
		
		campuriProdus = campuriProdus.replaceFirst(",", "");
	}
	
	public float calculFormula()
	{
		JEP eval = new JEP();
		eval.initSymTab();
		
		eval.addStandardFunctions();
		eval.addStandardConstants();
		eval.setAllowUndeclared(true);
		eval.setAllowAssignment(true);
		
		
		for(ElementeAtribuire e : elemente)
		{
			eval.addVariable(e.getLValue(), Double.parseDouble(e.getRValue()));
		}
		eval.parseExpression(this.formula);
		
		return (float)(eval.getValue());
	}

}
