import javax.swing.JOptionPane;
/**
 * Esta clase construye el jugador.
 * 
 * @author Cristopher Gomez Valverde B32927 
 * @version (13/05/2021)
 */
public class jugador
{
    String nombre;
    int jugadas_hechas = 0;
    
    public jugador(){
        nombre = JOptionPane.showInputDialog("Ingrese su numbre:"); 
    }
    
    public String darNombre(){
        return nombre;
    }
    
    public int darJugadasHechas(){
        return jugadas_hechas;
    }
}
