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
        for (int i=1;i<=10;i++){
            x+="\t"+i;
            y+=i+"\t"+"X"+"\n";
        }
        
        JTextArea jt = new JTextArea(x+"\n"+y);
        JOptionPane.showMessageDialog(null,jt);
        
        //System.out.println();
        //String y = "";
        //for(int i =1;i<10;i++){
        //    y+="\n"+i;
        //}
        //JTextArea jt2 = new JTextArea(y);
        //JOptionPane.showMessageDialog(null,jt2);
        
    }
}
