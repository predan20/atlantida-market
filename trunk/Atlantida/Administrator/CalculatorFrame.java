
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.regex.*;
import javax.swing.JOptionPane;


class CalculatorPanel extends JPanel implements ActionListener 
{
	static final long serialVersionUID = 0;
	
	  private JTextField display;
	  
	  private String atribuiri = "";
	  
	  private String expresieFinala = "";
	  
	  private String expression = ""; 
	  
	  private  JPanel p;
	  
	  private String numeElemente =  "Restrictie";
	  private String fields = "MasaSanatateRata_invConsumRandament";
	  
	  private String fieldsOp = "SUMAVGMINMAXMULT";
	  
	  private String mathOp = "+-*/";
	  
	  private String paran = "()";
	  
	  private String equal = "";
	  
	  private String digits = ".0123654789";
	  
	  private int fieldOpCounter = 1;
	  
	  private JFrame frmNumeElemente;
	  
	  private String numePropSpec = "";
	   
  public CalculatorPanel(String numePropSpec) 
  {
	this.numePropSpec = numePropSpec;
	fields += this.numePropSpec;
	setLayout(new BorderLayout());

    display = new JTextField("0");
    display.setEditable(false);
    add(display, "North");

    p = new JPanel();
    p.setLayout(new GridLayout(4, 8));;
    
    String buttons = "789/";
    for (int i = 0; i < buttons.length(); i++)
      addButton(p, buttons.substring(i, i + 1));
    addButton(p, "(");
    addButton(p, "MIN");
    addButton(p,"Consum");
    addButton(p,numePropSpec);

    buttons = "456*";
    for (int i = 0; i < buttons.length(); i++)
        addButton(p, buttons.substring(i, i + 1));
    addButton(p, ")");
    addButton(p, "MAX");
    addButton(p, "AVG");
    addButton(p,"Rata_inv");  

    
    buttons = "123-";
    for (int i = 0; i < buttons.length(); i++)
        addButton(p, buttons.substring(i, i + 1));
    addButton(p, "SUM");
    addButton(p, "MIN");
    addButton(p,"Masa");
    addButton(p,"Sanatate");

    
    buttons = "0.=+";
    for (int i = 0; i < buttons.length(); i++)
        addButton(p, buttons.substring(i, i + 1));

    addButton(p, "MULT");
    addButton(p,"Randament");
    
    addButton(p,numeElemente);
    addButton(p, "CE");
    add(p, "Center");
    
    
    frmNumeElemente = new JFrame();
    JComboBox cbNumeElemente = new JComboBox();
    
    
    
    
    
    frmNumeElemente.getContentPane().add(cbNumeElemente);
    setButtons(numeElemente, false);
    setButtons(mathOp, false);
    setButtons(fields, false);
    setButtons(")", false);
  }

  private void addButton(Container c, String s) {
    JButton b = new JButton(s);
    c.add(b);
    b.addActionListener(this);
  }

  private void setButtons(String type, boolean active)
  {
	  Component[] components = this.p.getComponents();
	  String name = "";
	  for (int i= 0; i< components.length; i++)
	  {
		  name = ((JButton)components[i]).getText();
		  if(type.contains(name))
		  {
				  ((JButton)components[i]).setEnabled(active);
		  }
	  }
  }
  public void actionPerformed(ActionEvent evt) {
    String s = evt.getActionCommand();
    
    if(s.equals("CE"))
    {
    	expression = "";
    	atribuiri = "";
    	expresieFinala = "";
    	setButtons(digits + fieldsOp + paran,true);
    	setButtons(mathOp + fields + numeElemente + ")", false);
    	fieldOpCounter = 1;
    	display.setText("");
    }
    else
    {
    	
    	//setNumberButtons("digits",true);
    	if(fieldsOp.contains(s))
    	{
    		setButtons(digits + paran + equal + mathOp + fieldsOp, false);
    		setButtons(numeElemente + fields, true);
    		
    		atribuiri += "x" + fieldOpCounter + "=" + s + "(";
    		expresieFinala += "x" + fieldOpCounter; 
    		expression += s + "(";
    		
    		fieldOpCounter++;
    	}
    	else
    	{
    		if(fields.contains(s))
    		{
    			setButtons(fields + fieldsOp + digits + paran + numeElemente, false);
    			setButtons(mathOp + equal + ")", true);
    			
    			if(expression.charAt(expression.length() - 1) == '(')
    			{
    				atribuiri += s + ") ";
    			
    				expression += s +")";
    			}
    			else
    			{
    				atribuiri += s + "]) ";
        			
    				expression += s +"])";
    			}
    		}
    		else
    		{
    			if(mathOp.contains(s))
    			{
        			setButtons(mathOp + equal + fields + paran, false);
        			setButtons(fieldsOp + digits + "(", true);
        			
        			setButtons(numeElemente, false);
        			
        			expression += s;
        			expresieFinala += s;
    			}
    			else
    			{
    				if(digits.contains(s))
    				{
	    				setButtons(fields + fieldsOp + paran + numeElemente, false);
	    				setButtons(mathOp + equal + ")", true);
	    				
	    				expression += s;
	    				expresieFinala += s;
    				}
    				else
    				{
	    					if(paran.contains(s))
	    					{
	    						setButtons(numeElemente + fields, false);
		    					setButtons(mathOp, true);
		    					
		    					if(s.equals("("))
		    					{
			    					setButtons(digits + fieldsOp, true);
			    				
			    					expression += s;
			    					expresieFinala += s;
		    					}
		    					else
		    					{
		    						setButtons(digits + fieldsOp, false);
		    						
		    						expression += s;
		    						expresieFinala += s;
		    					}
	    					}
	    					else
	    					{
	    						if(s.equals(numeElemente))
	    						{
	    							
	    							setButtons(numeElemente, false);
	    							
	    							atribuiri += "Sel[";
	    							expression += "Sel["; 
	    						}
	    						else
	    						{
		    						//equal
		    						
		    						if(matchParan(expression) == false)
		    						{   						
		    							JOptionPane.showMessageDialog(null, "Paranteze inegale","Eroare", JOptionPane.ERROR_MESSAGE );
		    						}
		    						
		    						else
		    						{
		    							atribuiri += expresieFinala;
		    							expresieFinala = atribuiri;
		    							
		    							System.out.println(expresieFinala);
		    						}
	    						}
	    					}
    				}
    			}
    		}
    	}
    	//expression += s;
    	display.setText(expression);
    }
  }

	public String getExpresieFinala()
	{
		return expresieFinala;
	}
  
 
  private boolean matchParan(String s)
  {
	  Pattern patternOpen = Pattern.compile("\\(");
	  Pattern patternClose = Pattern.compile("\\)");
	  
	  Matcher mOpen = patternOpen.matcher(s);
	  Matcher mClose = patternClose.matcher(s);
	  int open = 0,close = 0;
	  while (mOpen.find())
		  open++;
	  while (mClose.find())
		  close++;
	  
	  return (open == close);
  }
}
class CalculatorFrame extends JFrame {
	static final long serialVersionUID = 0;
  public CalculatorFrame(String numePropSpec) {
    setTitle("Calculator");
    setSize(700, 400);

    Container contentPane = getContentPane();
    contentPane.add(new CalculatorPanel(numePropSpec));
  }
  
/*	public static void main(String[] args)
	{
		CalculatorFrame calculatorFrame =  new CalculatorFrame();
		calculatorFrame.show();
		
		calculatorFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		EvaluareExpresie eval = new EvaluareExpresie();
		eval.evalTest("x1=SUM(Masa)\nx2=MIN(PropSp)\nx3=SUM(Randament)\nx4=MULT(Sanatate)\nx5=AVG(Masa)\n2+x1+x2*(x3+x4-x5)");
		
	}*/
}

           
       