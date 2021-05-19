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
    int puntaje;
    int jugadas_hechas;
    
    public jugador(){
        nombre = JOptionPane.showInputDialog("Ingrese su numbre:"); 
        puntaje = 0;
        jugadas_hechas = 0;
    }
    
    public String darNombre(){
        return nombre;
    }
    
    public int darJugadasHechas(){
        return jugadas_hechas;
    }
    
    public int darPuntaje(){
        return puntaje;
    }
    
    public void setPuntaje(int i){
        puntaje = i;
    }
    
    public void setJugadasHechas(int i){
        jugadas_hechas = i;
    }
    
    
}
