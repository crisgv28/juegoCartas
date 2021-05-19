import java.util.Random;
/**
 * Esta clase construyela carta.
 * 
 * @author Cristopher Gomez Valverde B32927 
 * @version (11/05/2021)
 */
public class cartaletranumero
{
    char letra;
    int numero;
    
    public cartaletranumero(){
        Random r = new Random();
        int i = r.nextInt(26)+65;
        letra = (char)(i);
        numero = r.nextInt(10)+1;
    }
    
    public char darLetra(){
        return letra;
    }
    
    public int darNumero(){
        return numero;
    }

    
 
}
