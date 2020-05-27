
package codice;

/**
 *
 * @author HUANG, DUARTE
 */

public class mainClass {
    public static void main(String args[])
    {
        
        GraficoFrame f = new GraficoFrame();   //creazione oggetto  
     
        f.setSize(500,300);                    //imposta dimensione finestra
        f.setVisible(true);
	f.setLocation(100,100);
	f.setTitle("PM10");
    }
    
      
}
