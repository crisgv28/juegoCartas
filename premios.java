import java.util.Random;
/**
 * Esta clase construyela carta premio.
 * 
 * @author Cristopher Gomez Valverde B32927 
 * @version (11/05/2021)
 */
public class premios
{
    String premio;
    int p;
    
    public premios(String prem){
        premio  = prem;
        if(prem=="duplicar"){
            p = 2;
        }else if(prem == "cuadruplicar"){
            p = 4;
        }
        
    }
    
    public String darPremioString(){
        return premio;  
    }
    
    public int darPremioInt(){
        return p;   
    }
}
