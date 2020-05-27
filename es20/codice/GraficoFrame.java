
package codice;

/**
 *
 * @author HUANG, DUARTE
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraficoFrame extends JFrame implements ActionListener                      //creazione frame iniziale
{   
    private JPanel p1 = new JPanel();                                                   //panel contenente il textfield
    private JPanel p2 = new JPanel();                                                   //panel contenente i bottoni e il textarea
    private JTextField nome = new JTextField(30);
    private JButton aggiungi = new JButton("Invia");                                    //tasto che controlla l'inserimento del file giusto nel textfield
    private JButton disegni = new JButton("Disegna");                                   //crea nuovo frame con all interno il grafico
    private JTextArea textarea = new JTextArea(5,30);
    private boolean fileFlag = false;                                                   //true se è stato inserito il nome del file giusto (dati.csv)
    
    public GraficoFrame()
    {
        super();
                
        addWindowListener(new GestoreFinestra());
          
        p1.add(new JLabel("Inserisci nome file (dati.csv): "));                             //aggiunge un etichetta nel p1
        p1.add(nome);
        //p1.add(new JLabel(" "));          
        textarea.setEditable(false);
        p2.add(aggiungi);
        p2.add(disegni);
        p2.add(textarea);
        disegni.addActionListener(this);

        //aggiungi.setPreferredSize(new Dimension(100, 100));
        setLayout(new GridLayout(3,1,5,10));
        add(p1);
        add(p2);      
        aggiungi.addActionListener(this);
    }
     
    
    
    public void actionPerformed(ActionEvent e)
    {
        String pulsante = e.getActionCommand();                                     //prende il nome del pulsante
               
        if(pulsante.equals("Invia"))                                                //si attiva quando si avvera
        {          
        String stringNome = nome.getText();  
        if(stringNome.equals("dati.csv"))
        {
        textarea.setText("Nome file inviato!");                                     //stampa il testo
        fileFlag = true;
        }
        else
        {
        textarea.setText("il file non esiste");                                      //stampa il testo
        fileFlag = false;
        }
        }
        
        if(pulsante.equals("Disegna"))
        {
            if(fileFlag)
            {
            JFrame frame = new JFrame("GRAFICO PM10");                                  //creazione frame grafico
            frame.setSize(520, 500); 
            frame.setResizable(false);
            frame.setVisible(true); 
		
            Grafico panel = new Grafico();	
            frame.setContentPane(panel);	
            }
            else
            {
                textarea.setText("inserire nome file corretto"); 
            }
        }
            
            
    }
    
}
