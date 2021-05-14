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
    premios p[] = new premios[10];
    
    public Mazo(){
        String s1 = JOptionPane.showInputDialog("Digite el numero de parejas deseadas");
        k = Integer.parseInt(s1);
        String s2 = JOptionPane.showInputDialog("Digite el numero de trios deseados");
        t = Integer.parseInt(s2);
        n = 2*k+3*t;
        mazo = new cartaletranumero[n];
        
        //Creacion del vector con premios
        for (int i = 0; i<5;i++){
            p[i] =  new premios("duplicar");    
        }
        for (int i = 5; i<10;i++){
            p[i] =  new premios("cuadruplicar");    
        }
        
        //Creacion del vector con cartas de juego
        for(int i = 0; i < 2*k; i=i+2){ // llena el mazo con las parejas
            cartaletranumero pareja = new cartaletranumero();
            mazo[i]= pareja;
            mazo[i+1]=pareja;
        }
        for(int i = 2*k; i<n-2;i=i+3){ // llena el mazo con los trios
            cartaletranumero trio = new cartaletranumero();
            mazo[i]= trio;
            mazo[i+1]=trio;
            mazo[i+2]=trio;
        }
        
    }
    
}
