import javax.swing.JTextArea;
import javax.swing.JOptionPane;
/**
 * Esta clase construye el juego completo al ejecutar el main empieza el juego.
 * 
 * @author Cristopher Gomez Valverde B32927 
 * @version (11/05/2021)
 */
public class grid
{
    public static void main (String a[]){

        JOptionPane.showMessageDialog(null,"Bienvenido al juego memoria, pulsa OK para comenzar");
        Mazo Mazo1 = new Mazo();
        JOptionPane.showMessageDialog(null,"Excelente, en este mazo hay un total de "+Mazo1.darN()+" cartas.");

        String s1 = JOptionPane.showInputDialog("Cuantos jugadores van a participar?");
        int cant_jugadores = Integer.parseInt(s1);
        jugador j[] = new jugador[cant_jugadores];
        for(int i = 0; i<Integer.parseInt(s1);i++){
            JOptionPane.showMessageDialog(null,"Datos del jugador "+(i+1));
            j[i] = new jugador();  
        }
        
        //Creacion del string que tiene el grid
        String grid = "";
        for(int i = 0; i<Mazo1.darCantFilas();i++){
            for(int q = 0;q<Mazo1.darCantColumnas();q++){
                if(Mazo1.darCarta(i,q)!=null){
                    grid += "X"+"\t";
                }else{
                    grid += "Vacio"+"\t";
                }
            }
            grid += "\n";
        }
        System.out.println(grid);
       
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
                
                JTextArea jt = new JTextArea(grid);
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
                if((Mazo1.darCarta(x1,y1)!=null)&&(Mazo1.darCarta(x2,y2)!=null)){
                    puntos_ganados = Mazo1.darCarta(x1,y1).darNumero() + Mazo1.darCarta(x2,y2).darNumero();
                }
                
                NLA1 = JOptionPane.showInputDialog("Escriba N, L o A. \n\tN: significa que las cartas coinciden en numero, \n\tL significa que coinciden el letra \n\tA significa que coinciden en ambas");
                
                switch(NLA1){
                    case "N":
                        if((Mazo1.darCarta(x1,y1)!=null)&&(Mazo1.darCarta(x2,y2)!=null)){
                            if(Mazo1.darCarta(x1,y1).darNumero()==Mazo1.darCarta(x2,y2).darNumero()){
                                JOptionPane.showMessageDialog(null,"Tus cartas son: "+Mazo1.darCarta(x1,y1).darNumero()+Mazo1.darCarta(x1,y1).darLetra()+" y "+Mazo1.darCarta(x2,y2).darNumero()+Mazo1.darCarta(x2,y2).darLetra()+"\n¡Tus cartas coinciden en numero! :D");
                                JOptionPane.showMessageDialog(null,"Ganaste "+puntos_ganados+" puntos");
                                j[turno_jugador].setPuntaje(j[turno_jugador].darPuntaje() + puntos_ganados);
                                j[turno_jugador].setJugadasHechas(j[turno_jugador].darJugadasHechas()+1);
                                Mazo1.quitarCarta(x1,y1);
                                Mazo1.quitarCarta(x2,y2);
                                grid = "";
                                for(int i = 0; i<Mazo1.darCantFilas();i++){
                                    for(int q = 0;q<Mazo1.darCantColumnas();q++){
                                        if(Mazo1.darCarta(i,q)!=null){
                                            grid += "X"+"\t";
                                        }else{
                                            grid += "Vacio"+"\t";
                                        }
                                    }
                                    grid += "\n";
                                }
                                
                            }else{
                                JOptionPane.showMessageDialog(null,"Tus cartas son: "+Mazo1.darCarta(x1,y1).darNumero()+Mazo1.darCarta(x1,y1).darLetra()+" y "+Mazo1.darCarta(x2,y2).darNumero()+Mazo1.darCarta(x2,y2).darLetra()+"\nLas cartas no coinciden en numero :(");
                                j[turno_jugador].setJugadasHechas(j[turno_jugador].darJugadasHechas()+1);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"Las cartas elegidas ya no estan en juego, elija otras");
                            }
                            
                        for(int i = 0;i<Integer.parseInt(s1);i++){
                            estad = estad+j[i].darNombre()+" :"+j[i].darPuntaje()+"pts y "+j[i].darJugadasHechas()+" turnos \n";
                        }
                        JOptionPane.showMessageDialog(null,estad);    
                            
                        break;
                    case "L":
                        if((Mazo1.darCarta(x1,y1)!=null)&&(Mazo1.darCarta(x2,y2)!=null)){
                            if(Mazo1.darCarta(x1,y1).darLetra()==Mazo1.darCarta(x2,y2).darLetra()){
                                JOptionPane.showMessageDialog(null,"Tus cartas son: "+Mazo1.darCarta(x1,y1).darNumero()+Mazo1.darCarta(x1,y1).darLetra()+" y "+Mazo1.darCarta(x2,y2).darNumero()+Mazo1.darCarta(x2,y2).darLetra()+"\n¡Tus cartas coinciden en Letra! :D");
                                JOptionPane.showMessageDialog(null,"Ganaste "+puntos_ganados+" puntos");
                                j[turno_jugador].setPuntaje(j[turno_jugador].darPuntaje() + puntos_ganados);
                                j[turno_jugador].setJugadasHechas(j[turno_jugador].darJugadasHechas()+1);
                                Mazo1.quitarCarta(x1,y1);
                                Mazo1.quitarCarta(x2,y2);
                                
                                grid = "";
                                for(int i = 0; i<Mazo1.darCantFilas();i++){
                                    for(int q = 0;q<Mazo1.darCantColumnas();q++){
                                        if(Mazo1.darCarta(i,q)!=null){
                                            grid += "X"+"\t";
                                        }else{
                                            grid += "Vacio"+"\t";
                                        }
                                    }
                                    grid += "\n";
                                }
                                
                            }else{
                                JOptionPane.showMessageDialog(null,"Tus cartas son: "+Mazo1.darCarta(x1,y1).darNumero()+Mazo1.darCarta(x1,y1).darLetra()+" y "+Mazo1.darCarta(x2,y2).darNumero()+Mazo1.darCarta(x2,y2).darLetra()+"\nLas cartas no coinciden en letra");
                                j[turno_jugador].setJugadasHechas(j[turno_jugador].darJugadasHechas()+1);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"Las cartas elegidas ya no estan en juego");
                        }
                        
                        for(int i = 0;i<Integer.parseInt(s1);i++){
                            estad = estad+j[i].darNombre()+" :"+j[i].darPuntaje()+"pts y "+j[i].darJugadasHechas()+" turnos \n";
                        }
                        JOptionPane.showMessageDialog(null,estad);
                        
                        break;
                    case "A":
                        if((Mazo1.darCarta(x1,y1)!=null)&&(Mazo1.darCarta(x2,y2)!=null)){
                            if((Mazo1.darCarta(x1,y1).darLetra()==Mazo1.darCarta(x2,y2).darLetra())&&(Mazo1.darCarta(x1,y1).darNumero()==Mazo1.darCarta(x2,y2).darNumero())){
                                JOptionPane.showMessageDialog(null,"Tus cartas son: "+Mazo1.darCarta(x1,y1).darNumero()+Mazo1.darCarta(x1,y1).darLetra()+" y "+Mazo1.darCarta(x2,y2).darNumero()+Mazo1.darCarta(x2,y2).darLetra()+"¡Tus cartas coinciden en Letra y Numero! :D");
                                JOptionPane.showMessageDialog(null,"Ganaste "+puntos_ganados+" puntos");
                                j[turno_jugador].setPuntaje(j[turno_jugador].darPuntaje() + puntos_ganados);
                                j[turno_jugador].setJugadasHechas(j[turno_jugador].darJugadasHechas()+1);
                                
                                int contador_trios = 0;
                                for(int i = 0; i<Mazo1.darCantFilas();i++){
                                    for(int q = 0;q<Mazo1.darCantColumnas();q++){
                                        if(Mazo1.darCarta(i,q)!=null){
                                            if((Mazo1.darCarta(x1,y1).darLetra()==Mazo1.darCarta(i,q).darLetra())&&((Mazo1.darCarta(x1,y1).darNumero()==Mazo1.darCarta(i,q).darNumero()))){
                                                contador_trios += 1;
                                            }
                                        }
                                    }
                                }
                                
                                cartaletranumero carta_temp = Mazo1.darCarta(x1,y1);
                                Mazo1.quitarCarta(x1,y1);
                                Mazo1.quitarCarta(x2,y2);
                                
                                grid = "";
                                for(int i = 0; i<Mazo1.darCantFilas();i++){
                                    for(int q = 0;q<Mazo1.darCantColumnas();q++){
                                        if(Mazo1.darCarta(i,q)!=null){
                                            grid += "X"+"\t";
                                        }else{
                                            grid += "Vacio"+"\t";
                                        }
                                    }
                                    grid += "\n";
                                }
                                
                                int contador_premios = 0;
                                if((contador_trios==3)&&(contador_premios<10)){
                                    String X = "";
                                    String Y = "";
                                    JOptionPane.showMessageDialog(null, "BONUS: Hay una tercer carta igual a la que elegiste, \ntienes la oportunidad de duplicar o cuadruplicar tu premio si aciertas la tercera carta.");
                                    JTextArea jt2 = new JTextArea(grid);
                                    JOptionPane.showMessageDialog(null,jt2);
                                    X = JOptionPane.showInputDialog("Escriba la coordenada x de su carta");
                                    Y = JOptionPane.showInputDialog("Escriba la coordenada y de su carta");
                                    int x = Integer.parseInt(X);
                                    int y = Integer.parseInt(Y);
                                    if((Mazo1.darCarta(x,y).darLetra()==carta_temp.darLetra())&&(Mazo1.darCarta(x,y).darLetra()==carta_temp.darNumero())){
                                        JOptionPane.showMessageDialog(null,"Genial! haz ganado el premio de: "+Mazo1.darPremio(contador_premios).darPremioString());
                                        j[turno_jugador].setPuntaje(j[turno_jugador].darPuntaje()*Mazo1.darPremio(contador_premios).darPremioInt());
                                        contador_premios +=1;
                                    }else {
                                        JOptionPane.showMessageDialog(null,"No pegaste la tercera carta :( ");
                                    }
                                    
                                }
                                
                                grid = "";
                                for(int i = 0; i<Mazo1.darCantFilas();i++){
                                    for(int q = 0;q<Mazo1.darCantColumnas();q++){
                                        if(Mazo1.darCarta(i,q)!=null){
                                            grid += "X"+"\t";
                                        }else{
                                            grid += "Vacio"+"\t";
                                        }
                                    }
                                    grid += "\n";
                                }
                                
                                
                                
                            }else{
                                JOptionPane.showMessageDialog(null,"Tus cartas son: "+Mazo1.darCarta(x1,y1).darNumero()+Mazo1.darCarta(x1,y1).darLetra()+" y "+Mazo1.darCarta(x2,y2).darNumero()+Mazo1.darCarta(x2,y2).darLetra()+"\nTus cartas no coinciden en letra y numero :(");
                                j[turno_jugador].setJugadasHechas(j[turno_jugador].darJugadasHechas()+1);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"Las cartas elegidas ya no estan en juego");
                        }
                        
                        for(int i = 0;i<Integer.parseInt(s1);i++){
                            estad = estad+j[i].darNombre()+" :"+j[i].darPuntaje()+"pts y "+j[i].darJugadasHechas()+" turnos \n";
                        }
                        JOptionPane.showMessageDialog(null,estad);
                        
                        break;
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
                    String resultadofinal = "";
                    int contador_ganadores = 0;
                    int mejor_puntaje = 0;
                    
                    for(int i = 0;i<cant_jugadores;i++){
                        if(j[i].darPuntaje()>mejor_puntaje){
                            mejor_puntaje = j[i].darPuntaje();
                        }
                    }
                    
                    for(int i = 0;i<cant_jugadores;i++){
                        if(j[i].darPuntaje()==mejor_puntaje){
                            contador_ganadores += 1;
                        }
                    }
                    
                    if(contador_ganadores>1){
                        resultadofinal = "EMPATE";
                    }else if(contador_ganadores==1){
                        String tmp1 ="";
                        for(int i = 0; i<cant_jugadores;i++){
                            if(mejor_puntaje==j[i].darPuntaje()){
                                tmp1 = j[i].darNombre();
                            }
                        }
                        resultadofinal = "El GANADOR ES: "+tmp1;
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
    
    /*
     * Metodo que comprueba si una hilera es un int
     * @param s = hilera
       */ 
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
        
        
    

}
