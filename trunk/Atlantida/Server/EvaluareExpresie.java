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
		elemente = getCampuri(elemente);
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
		int i = 1;
	if(produs)
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
	else
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
		
	}
	public ArrayList<ElementeAtribuire> parseFormulaElement(String expresie)
	{
		ArrayList<ElementeAtribuire> ret = new ArrayList<ElementeAtribuire>();
		
		Pattern varSt = Pattern.compile("([a-z0-9]+)=");
		Pattern varDr = Pattern.compile("=([a-zA-Z0-9()]+)");
		
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
			varOpField = mDr.group(1);
			//System.out.println(it.next().getLValue());
			it.next().setRValue(varOpField);
			expresie = expresie.replace(mDr.group(), "");
			//it.next();
		}
		
		formula = expresie;
		for(ElementeAtribuire e : ret)
			System.out.println(e.getLValue() + " " + e.getRValue());
		
		System.out.println("Formula: " + formula);
		return ret;
	}
	
	public ArrayList<ElementeAtribuire> getCampuri(ArrayList<ElementeAtribuire> eleList)
	{
		
		ArrayList<ElementeAtribuire> multList = new ArrayList<ElementeAtribuire>();
		
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
				cmdMySql += ", "+e.getRValue();
			}
			else
			{
				//posMult = i;
				field = e.getRValue().substring(e.getRValue().indexOf('(') + 1,e.getRValue().length() -1);
				campuriProdus += ", " + field;
				multList.add(new ElementeAtribuire(e.getLValue(),field));
				
				it.remove();
			}
		}
		
		//trebuie tinut cont de mult.. la revenire din apel valori rValue ia valorile returnate
		//cmdMySql = cmdMySql.replaceFirst(",", "");
		operatiiSimple = cmdMySql;
		System.out.println(cmdMySql);
		
		
		return eleList;
	}
	
	public float calculFormula()
	{
		ArrayList<ElementeAtribuire> eleList = new ArrayList<ElementeAtribuire>();
		JEP eval = new JEP();
		eval.initSymTab();
		
		eval.addStandardFunctions();
		eval.addStandardConstants();
		eval.setAllowUndeclared(true);
		eval.setAllowAssignment(true);
		
		
		for(ElementeAtribuire e : eleList)
		{
			eval.addVariable(e.getLValue(), Double.parseDouble(e.getRValue()));
			System.out.println(eval.getVar(e.getLValue()));
		}
		eval.parseExpression(this.formula);
		//eval.getValue();
		System.out.println("Result: " + eval.getValue());
		
		return (float)(eval.getValue());
	}

}
