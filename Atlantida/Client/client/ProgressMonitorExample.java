package client;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimerTask;

import administrator.ComunicareClient;

import com.sun.java.swing.plaf.windows.WindowsProgressBarUI;
import javax.swing.*;
import javax.swing.plaf.*;

public class ProgressMonitorExample extends JPanel implements ActionListener {

  static ProgressMonitor pbar;

  private static int time = 0;
  
  private static String numeElement = "";
  
  private static String ID = "";
  static int counter = 0;
  
  private static String host = "10.0.2.56";
  private static int port = 3006;
  
  Timer timer;
  
  public ProgressMonitorExample(String numeELement,String ID, int time) 
  {
	this.ID = ID;
    this.time = time;
    this.numeElement = numeELement;
    
    pbar = new ProgressMonitor(this, "Licitare element",
        "Initializare . . .", 0, 100);
    pbar.setMaximum(time);
    // Fire a timer every once in a while to update the progress.
    timer = new Timer(1000, this);

    timer.start();
  }

  public static void setareAfisaj()
  {	
	  UIManager.put("Panel.background",new ColorUIResource(Joc.colorInternalPanel));
	  UIManager.put("OptionPane.background",new ColorUIResource(Joc.colorInternalPanel));
	  UIManager.put("OptionPane.cancelButtonText", "Retragere");
	  UIManager.put("ProgressBar.background", new ColorUIResource(Joc.colorInternalPanel));
	  UIManager.put("ProgressMonitor.progressText", numeElement);
  }

  public void actionPerformed(ActionEvent e) {
    // Invoked by the timer every half second. Simply place
    // the progress monitor update on the event queue.
	if(pbar.isCanceled() == false)
		if(counter == time + 1)
		{
			int inventarSize = Joc.getInventarSize();
			ComunicareClient comunicareClient = new ComunicareClient(host,3007);
			comunicareClient.conectareLaServer();
			
			ArrayList<String> date = new ArrayList<String>();
			date.add(Joc.username);
			date.add("Bye!");
			comunicareClient.scriereDate(date);
			date = comunicareClient.citireDate();
			
			int length;
			String[] numeColoane;
			String[][] numeLinii;
			
			length = date.get(0).split(" ").length;
			numeColoane = new String[length];
			numeColoane = date.get(0).split(" ");
			
			int size = date.size() - 1;

			numeLinii = new String[size][length];
			
			for (int i=1;i<size;i++)
			{
				numeLinii[i-1] = date.get(i).split(" ");
			}
			
			Joc.setValues(numeLinii);
			
			if(numeLinii.length == inventarSize)
			{
				JOptionPane.showMessageDialog(this,"N-ati castigat licitatia pentru\n elementul " + numeElement, "Info", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Ati castigat licitatia pentru\n elementul " + numeElement, "Info", JOptionPane.INFORMATION_MESSAGE);
			}
			counter++;
		}
		else
		{
			SwingUtilities.invokeLater(new Update());
		}
	else 
	{
		System.out.println("RETRAGERE!");
		ComunicareClient comunicareClient = new ComunicareClient(host,3006);
		comunicareClient.conectareLaServer();
		
		ArrayList<String> date = new ArrayList<String>();
		date.add("retragere");
		date.add(Joc.username);
		date.add(ID);
		date.add("Bye!");
		
		comunicareClient.scriereDate(date);
		
		comunicareClient.inchidereClient();
		timer.stop();
		counter = time + 1;
	}
  }

  class Update implements Runnable {
    public void run() {
      if (pbar.isCanceled()) {
    	  System.out.println("retragere");
        pbar.close();
      }
      pbar.setProgress(counter);
      pbar.setNote("Au mai ramas " + (time - counter) + " secunde");
      counter += 1;
    }
  }
}