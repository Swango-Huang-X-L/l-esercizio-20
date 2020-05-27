
package codice;

/**
 *
 * @author HUANG, DUARTE
 */

public class QualitaAria {
    private int valoreMedioGiornaliero ;
    private String Province;
    
    QualitaAria(int valoreMedioGiornaliero, String Province)
    {
        this.valoreMedioGiornaliero = valoreMedioGiornaliero;
        this.Province = Province;
    }
    
    
    public int getValoreMedio()
    {
        return valoreMedioGiornaliero;            //ritorna il valore
    }
}
