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
        int cant_jugadores = Integer.parseInt(s1);
        jugador j[] = new jugador[cant_jugadores];
        for(int i = 0; i<Integer.parseInt(s1);i++){
            JOptionPane.showMessageDialog(null,"Datos del jugador "+(i+1));
            j[i] = new jugador();  
        }
        
        for (int i=1;i<=Mazo1.darN();i++){
            x+="\t"+i;
        }
        
        for(int i = 0; i<Mazo1.darN(); i++){
            y+="\t"+Mazo1.darCarta(i).darLetra();
        }
        y = 1+y;
        
       
        boolean b = true;
        while(b == true){ 
        String opciones = JOptionPane.showInputDialog("1. Seguir jugando \n 2.Mostrar puntajes \n 3. Salir del juego");
        int turno_jugador=0;
        String estad = "";
        
        switch(opciones){
            case "1": //Seguir jugando
                
                int jugadas_totales=0;
                for(int i = 0; i<cant_jugadores;i++){
                    jugadas_totales=jugadas_totales+j[i].darJugadasHechas();
                }
            
                if(jugadas_totales==0){
                    JOptionPane.showMessageDialog(null,"Empieza: " +j[0].darNombre()); 
                }else{
                    JOptionPane.showMessageDialog(null,"Turno de: "+j[jugadas_totales%cant_jugadores].darNombre());
                    turno_jugador = jugadas_totales%cant_jugadores;
                }    
        
                JTextArea jt = new JTextArea(x+"\n"+y);
                JOptionPane.showMessageDialog(null,jt);
                String X1 = "";
                String X2 = "";
                String Y1 = "";
                String Y2 = "";
                String NLA1 = "";
                int x1=-1, x2=-1, y1=-1, y2=-1;
                
                X1 = JOptionPane.showInputDialog("Escriba la coordenada x de su primera carta");
                Y1 = JOptionPane.showInputDialog("Escriba la coordenada y de su primera carta");
                X2 = JOptionPane.showInputDialog("Escriba la coordenada x de su segunda carta");
                Y2 = JOptionPane.showInputDialog("Escriba la coordenada y de su segunda carta");
                
                x1 = Integer.parseInt(X1);
                y1 = Integer.parseInt(Y1);
                x2 = Integer.parseInt(X2);
                y2 = Integer.parseInt(Y2);
                int puntos_ganados = 0;
                if((Mazo1.darCarta(x1)!=null)&&(Mazo1.darCarta(x2)!=null)){
                    puntos_ganados = Mazo1.darCarta(x1).darNumero() + Mazo1.darCarta(x2).darNumero();
                }
                
                
                NLA1 = JOptionPane.showInputDialog("Escriba N, L o A. N significa que las cartas coinciden en numero, \n L que coinciden el letra y A que coinciden en ambas");
                
                switch(NLA1){
                    case "N":
                        if((Mazo1.darCarta(x1)!=null)&&(Mazo1.darCarta(x2)!=null)){
                            if(Mazo1.darCarta(x1).darNumero()==Mazo1.darCarta(x2).darNumero()){
                                JOptionPane.showMessageDialog(null,"Tus cartas son: "+Mazo1.darCarta(x1).darNumero()+Mazo1.darCarta(x1).darLetra()+" y "+Mazo1.darCarta(x2).darNumero()+Mazo1.darCarta(x2).darLetra()+"¡Tus cartas coinciden en numero!");
                                JOptionPane.showMessageDialog(null,"Ganaste "+puntos_ganados+" puntos");
                                j[turno_jugador].setPuntaje(j[turno_jugador].darPuntaje() + puntos_ganados);
                                j[turno_jugador].setJugadasHechas(j[turno_jugador].darJugadasHechas()+1);
                                Mazo1.quitarCarta(x1);
                                Mazo1.quitarCarta(x2);
                            }else{
                                JOptionPane.showMessageDialog(null,"Las cartas no coinciden en numero");
                                j[turno_jugador].setJugadasHechas(j[turno_jugador].darJugadasHechas()+1);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"Las cartas elegidas ya no estan en juego, elija otras");
                            }
                        break;
                    case "L":
                        if((Mazo1.darCarta(x1)!=null)&&(Mazo1.darCarta(x2)!=null)){
                            if(Mazo1.darCarta(x1).darLetra()==Mazo1.darCarta(x2).darLetra()){
                                JOptionPane.showMessageDialog(null,"Tus cartas son: "+Mazo1.darCarta(x1).darNumero()+Mazo1.darCarta(x1).darLetra()+" y "+Mazo1.darCarta(x2).darNumero()+Mazo1.darCarta(x2).darLetra()+"¡Tus cartas coinciden en Letra!");
                                JOptionPane.showMessageDialog(null,"Ganaste "+puntos_ganados+" puntos");
                                j[turno_jugador].setPuntaje(j[turno_jugador].darPuntaje() + puntos_ganados);
                                Mazo1.quitarCarta(x1);
                                Mazo1.quitarCarta(x2);
                            }else{
                                JOptionPane.showMessageDialog(null,"Las cartas no coinciden en letra");
                                j[turno_jugador].setJugadasHechas(j[turno_jugador].darJugadasHechas()+1);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"Las cartas elegidas ya no estan en juego");
                        }
                        break;
                    case "A":
                        if((Mazo1.darCarta(x1)!=null)&&(Mazo1.darCarta(x2)!=null)){
                            if((Mazo1.darCarta(x1).darLetra()==Mazo1.darCarta(x2).darLetra())&&(Mazo1.darCarta(x1).darNumero()==Mazo1.darCarta(x2).darNumero())){
                                b = false;
                            }else{
                                JOptionPane.showMessageDialog(null,"Tus cartas no coinciden en letra y numero");
                                j[turno_jugador].setJugadasHechas(j[turno_jugador].darJugadasHechas()+1);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"Las cartas elegidas ya no estan en juego");
                        }
                        break;
                }
                
                int count = 0;
                for(int i = 0;i<Mazo1.darN();i++){
                    for(int k = i+1;k<Mazo1.darN();k++){
                        if((Mazo1.darCarta(i)!=null)&&(Mazo1.darCarta(k)!=null)&&(Mazo1.darCarta(i).darNumero()!=Mazo1.darCarta(k).darNumero())&&(Mazo1.darCarta(i).darLetra()!=Mazo1.darCarta(k).darLetra())){
                            count = count+1;
                        }
                    }
                }
                
                if(count==(Mazo1.darN()*(Mazo1.darN()-1)/2)){
                    b=false;
                    JOptionPane.showMessageDialog(null,"Fin del juego");
                }
                
                
                
                break;
                
            
                case "2":
                    for(int i = 0;i<Integer.parseInt(s1);i++){
                        estad = estad+j[i].darNombre()+" :"+j[i].darPuntaje()+"pts y "+j[i].darJugadasHechas()+" turnos \n";
                    }
                    JOptionPane.showMessageDialog(null,estad);
                    b = true;           
                break;
                
                case "3":
                    String ganador = "";
                    String perdedor = "";
                    String empate;
                    int contadorganadores=0;
                    String resultadofinal = "";
                    String ganadores = "";
                    int num_ganador = -1, num_perdedor = 0;
                    int numero_ganadores = 0;
                    
                    for(int i = 0;i<cant_jugadores;i++){
                            if(num_ganador!=-1){
                                if(j[i].darPuntaje()>=j[num_ganador].darPuntaje()){
                                    ganador = j[i].darNombre();
                                    num_ganador = i;
                                }
                            }
                            
                            if(ganador==""){
                                resultadofinal = "HAY EMPATE";
                            }else{
                                resultadofinal = "El GANADOR es: "+ganador;
                            }
                    }
                    
                    for(int i = 0;i<cant_jugadores;i++){
                        if(ganador==j[i].darNombre()){
                            numero_ganadores = numero_ganadores+1;
                        }
                    }
                    
                    if(numero_ganadores>1){
                        resultadofinal = "HAY EMPATE";
                    }
                    
                    
                    
                    for(int i = 0;i<Integer.parseInt(s1);i++){
                        estad = estad+j[i].darNombre()+" :"+j[i].darPuntaje()+"pts y "+j[i].darJugadasHechas()+" turnos \n";
                    }
                    JOptionPane.showMessageDialog(null,"Las estadisticas de la partida son: \n"+ estad +"\n RESULTADO: "+resultadofinal);
                    
                    b = false;
                break; //salir del juego
        
        }
        
        }
        
    }
    
    
        public static boolean isNotNumeric(String s){
        boolean b;
        try{
            Integer.parseInt(s);
            b = false;
        }catch(Exception e){
            b = true;
        }
        return b;
        }
        
        public String resultadoDelJuego(){
            String resultadodeljuego = "";
            int contadorganador = 0;
            int max=0, min=0;
            jugador j[] = new jugador[6];
            
            for (int i = 0; i < 10; i++) {
              
            if(j[i].darPuntaje()>max){
            
                max=j[i].darPuntaje();
                contadorganador = i;
                
            }
        
            if(j[i].darPuntaje()<min){
            
                min=j[i].darPuntaje();
                
            }
            
            if(max>min){
                resultadodeljuego = "Felicidades al ganador!"+j[i].darNombre();
            }else if(max==min){
                resultadodeljuego = "EMPATE";
            }
}
            
            return resultadodeljuego;
        }
    

}
