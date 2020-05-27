
package codice;

/**
 *
 * @author HUANG, DUARTE
 */

// classe che permette di gestire gli eventi del frame
import java.awt.event.*;

public class GestoreFinestra implements WindowListener     
{
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowClosing(WindowEvent e){
    
    System.out.println("programma terminato. ");      //chiusura finestra
    System.exit(0);
    }   
    
}