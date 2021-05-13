import javax.swing.JOptionPane;
/**
 * Esta clase construyela carta.
 * 
 * @author Cristopher Gomez Valverde B32927 
 * @version (11/05/2021)
 */
public class Mazo
{
    int n, k, t; // n: cantidad total de cartas, k: cant de parejas, t: cant de trios
    cartaletranumero mazo[];
    public Mazo(){
        String s1 = JOptionPane.showInputDialog("Digite el numero de parejas deseadas");
        k = Integer.parseInt(s1);
        String s2 = JOptionPane.showInputDialog("Digite el numero de trios deseados");
        t = Integer.parseInt(s2);
        n = 2*k+3*t;
        mazo = new cartaletranumero[n];
        premios p[] = new premios[10];
        
        
        for(int i = 0; i < 2*k; i=i+2){ // llena el mazo con las parejas
            cartaletranumero pareja = new cartaletranumero();
            mazo[i]= pareja;
            mazo[i+1]=pareja;
        }
        
        for(int j = 2*k; j<n-2;j=j+3){ // llena el mazo con los trios
            cartaletranumero trio = new cartaletranumero();
            mazo[j]= trio;
            mazo[j+1]=trio;
            mazo[j+2]=trio;
        }
        
    }
    
}
