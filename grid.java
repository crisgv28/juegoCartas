import javax.swing.JTextArea;
import javax.swing.JOptionPane;
/**
 * Esta clase construye el tablero.
 * 
 * @author Cristopher Gomez Valverde B32927 
 * @version (11/05/2021)
 */
public class grid
{
    public static void main (String a[]){
        String x = "";
        String y = "";
        
        JOptionPane.showMessageDialog(null,"Bienvenido al juego memoria, pulsa ok para comenzar");
        Mazo Mazo1 = new Mazo();
        JOptionPane.showMessageDialog(null,"Excelente, en este mazo hay un total de "+Mazo1.darN()+" cartas.");
        
        String s1 = JOptionPane.showInputDialog("Cuantos jugadores van a participar?");
        jugador j[] = new jugador[Integer.parseInt(s1)];
        for(int i = 0; i<Integer.parseInt(s1);i++){
            JOptionPane.showMessageDialog(null,"Datos del jugador "+(i+1));
            j[i] = new jugador();  
        }
        
        for (int i=1;i<=Mazo1.darN();i++){
            x+="\t"+i;
        }
        
        for(int i = 0; i<Mazo1.darN(); i++){
            y+="\t"+"X";
        }
        y = 1+y;
        
        //int i = 0;
        //int j = 0;
       
        JOptionPane.showMessageDialog(null,"Turno del jugador ");
        
        JTextArea jt = new JTextArea(x+"\n"+y);
        JOptionPane.showMessageDialog(null,jt);
        
        String X1 = JOptionPane.showInputDialog("Escriba la coordenada x de su primera carta");
        String Y1 = JOptionPane.showInputDialog("Escriba la coordenada y de su primera carta");
        
        String X2 = JOptionPane.showInputDialog("Escriba la coordenada x de su segunda carta");
        String Y2 = JOptionPane.showInputDialog("Escriba la coordenada y de su segunda carta");
        
        String NLA1 = JOptionPane.showInputDialog("Escriba N, L o A. N significa que las cartas coinciden en numero, \n L que coinciden el letra y A que coinciden en ambas");
        
        int x1 = Integer.parseInt(X1);
        int y1 = Integer.parseInt(Y1);
        int x2 = Integer.parseInt(X2);
        int y2 = Integer.parseInt(Y2);
        
        
        
        
    }
}
