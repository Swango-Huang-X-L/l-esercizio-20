 
package codice;

/**
 *
 * @author HUANG, DUARTE
 */

import java.awt.*;
import java.awt.image.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class Grafico extends JPanel{                                        //classe in cui vie è la creazione del grafico
    
    private Color nero =  Color.BLACK;
    private Color rosso =  Color.RED;
    private Font font = new Font("TimesRoman",Font.BOLD,16);

    private Coda dati = fileCsv();                                          //Coda contenente oggetti di tipo QualitaAria con al loro interno 
    
    public Grafico()
    {
        
       super();                                                              //costruttore JPanel
        //pulisci();
    }
    
    public void paintComponent(Graphics g) {	
                            
				super.paintComponent(g);                    //disegna
                                
                         
                                g.setColor(nero); 
                                g.setFont(font); 
                                g.drawString("0", 60, 300);
                                g.drawString("20", 60, 260);
                                g.drawString("30", 60, 240);
                                g.drawString("40", 60, 220);
                                g.drawString("Limite 50", 10, 200);
                                g.drawString("60", 60, 180);
                                g.drawString("70", 60, 160);
                                g.drawString("80", 60, 140);
                                g.drawString("Dati giornalieri di particolato PM10 nella Provincia di Torino", 20, 50);
                                g.drawString("PM10 (μg/m3)", 10, 90);   
                                
		                                              
                                g.drawLine(80, 100, 80, 300); 
                                g.drawLine(80, 300, 450, 300); 
                                g.drawLine(78, 260, 450,260);                            
                                g.drawLine(78, 240, 450,240); 
                                g.drawLine(78, 220, 450,220);                                
                                g.drawLine(78, 200, 450,200); 
                                g.drawLine(78, 180, 450,180); 
                                g.drawLine(78, 160, 450,160); 
                                g.drawLine(78, 140, 450,140); 
                                                                                                    
                                g.setColor(rosso); 
                                g.setFont(new Font("TimesRoman",  Font.BOLD, 12)); 
                                g.drawString("C.R", 100, 320);
                                g.drawString("CHIERI", 140, 320);
                                g.drawString("IVREA", 195, 320);
                                g.drawString("PINER.", 245, 320);
                                g.drawString("TO.R", 295, 320);
                                g.drawString("TO.L", 345, 320);
                                g.drawString("Stazione", 420, 320);
                                g.drawString("di misura", 420, 330);
                                g.drawString("C.R = Ceresole Reale - Diga", 100, 350);
                                g.drawString("CHIERI = Chieri - Bersezio ", 100, 370);
                                g.drawString("IVREA = Ivrea - Liberazione", 100, 390);
                                g.drawString("PINER. = Pinerolo -  Alpini", 100, 410);
                                g.drawString("TO.R = Torino - Rebaudengo", 100, 430);
                                g.drawString("TO.L = Torino - Lingotto", 100, 450);
                                
                                
                                QualitaAria Dato = (QualitaAria)dati.togli();
                                g.drawLine(110, 300 -(Dato.getValoreMedio() * 2), 110, 300);      //valore del X equivale [300 - (valore csv * 2)] per disegnarlo correttamente sul grafico
                                Dato = (QualitaAria)dati.togli();
                                g.drawLine(160, 300 -(Dato.getValoreMedio() * 2), 160, 300); 
                                Dato = (QualitaAria)dati.togli();
                                g.drawLine(210, 300 -(Dato.getValoreMedio() * 2), 210, 300); 
                                Dato = (QualitaAria)dati.togli();
                                g.drawLine(260, 300 -(Dato.getValoreMedio() * 2), 260, 300); 
                                Dato = (QualitaAria)dati.togli();
                                g.drawLine(310, 300 -(Dato.getValoreMedio() * 2), 310, 300); 
                                Dato = (QualitaAria)dati.togli();
                                g.drawLine(360, 300 -(Dato.getValoreMedio() * 2), 360, 300); 
			}
    
                        
    public static Coda fileCsv() {                          //metodo statico che ritorna una coda con oggetti QualitaAria

        String csvFile = "dati.csv";                        //nome file
        String line = "";                                   //linea del fine
        String cvsSplitBy = ";";                            //parametro utilizzato nello Split
        String lineCheck = "";                              //Stringa in cui viene immessa la prima cella di ogni riga del file
        int valoreMedioGiornaliero;                         //prende il valore del pm10 medio nell aria
        String province;                                    //prende le provinceS
        Coda insiemeDati = new Coda();                      //coda da returnare
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {   //apertura file

            while ((line = br.readLine()) != null) {                               //finche la riga non è vuota
                lineCheck = line.split(cvsSplitBy)[0];                             //lineCheck prende la stringa della prima cella
                if(lineCheck.equals("PM10 - Beta"))                                // se lineCheck è uguale a PM10 - Beta
                {
                // use comma as separator
                valoreMedioGiornaliero = Integer.parseInt(line.split(cvsSplitBy)[2]);   //trasformazione della striga presente nella 3 cella in int
                province = line.split(cvsSplitBy)[1];                                   //province = seconda cella con all inerno i nomi delle province
                QualitaAria Dati = new QualitaAria(valoreMedioGiornaliero,province);    // creazione oggetto 
                insiemeDati.aggiungi(Dati);                                             //inserimento oggetto nella coda
                
            
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return insiemeDati;                                                         //returna la coda
    }
    
  
}
