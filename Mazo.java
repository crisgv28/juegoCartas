import javax.swing.JOptionPane;
/**
 * Esta clase construyela el mazo de cartas y los premios.
 * 
 * @author Cristopher Gomez Valverde B32927 
 * @version (11/05/2021)
 */
public class Mazo
{
    int n, k, t; // n: cantidad total de cartas, k: cant de parejas, t: cant de trios
    int filas = 4, columnas=4; //cantidad de filas y columnas del grid
    cartaletranumero mazo_ordenado[]; //mazo con las cartas ordenadas en pares o trios, se utiliza para luego desordenarlo
    cartaletranumero mazo[][]; //mazo con cartas en desorden, este es el que se usa para jugar
    premios premios[] = new premios[10]; // vector con premios
    
    /*
     * Metodo constructor del mazo para jugar
       */
    public Mazo(){
        JOptionPane.showMessageDialog(null, "A continuacion debe digitar la cantidad de parejas y trios que desea en el mazo");
        String s1 = JOptionPane.showInputDialog("Cantidad de parejas deseadas");
        k = Integer.parseInt(s1);
        String s2 = JOptionPane.showInputDialog("Cantidad de trios deseados");
        t = Integer.parseInt(s2);
        n = 2*k+3*t;
        
        mazo_ordenado = new cartaletranumero[n];
        
        //Creacion del vector con las cartas
        for(int i = 0; i < 2*k; i=i+2){ // llena el mazo con las parejas
            cartaletranumero pareja = new cartaletranumero();
            mazo_ordenado[i]= pareja;
            mazo_ordenado[i+1]=pareja;
        }
        for(int i = 2*k; i<n-2;i=i+3){ // llena el mazo con los trios
            cartaletranumero trio = new cartaletranumero();
            mazo_ordenado[i]= trio;
            mazo_ordenado[i+1]=trio;
            mazo_ordenado[i+2]=trio;
        }
        
        //Creacion del vector con premios
        //lo que sigue hace un arreglo de 10 numero aleatorios entre 0 y 9;
        int aleatorios[] = new int [n];
        int p2 = 0;
        aleatorios[p2]=(int)(Math.random()*(n));
        for(p2 = 1;p2<n;p2++){
            aleatorios[p2]=(int)(Math.random()*(n)); 
            for(int k=0;k<p2;k++){
                if(aleatorios[p2]==aleatorios[k]){
                    p2--;
                }
            }
        }
                
        for(int i = 0;i<10;i++){
            if(aleatorios[i]%2==0){
                premios[i]= new premios("duplicar");
            }else{
                premios[i] = new premios("cuadruplicar");
            }
        }
                
        for(int k = 0;k<10;k++){
            System.out.println(premios[k]);
        }
        
        //Creacion de la matriz con cartas de juego 
        mazo = new cartaletranumero[filas][columnas];
        //lo que sigue hace un arreglo de n numero aleatorios entre 0 y n;
        int arreglo[] = new int [n];
        int p = 0;
        arreglo[p]=(int)(Math.random()*(n));
        for(p = 1;p<n;p++){
            arreglo[p]=(int)(Math.random()*(n)); 
            for(int k=0;k<p;k++){
                if(arreglo[p]==arreglo[k]){
                    p--;
                }
            }
        }
        int l = 0;
        for(int i =0;i<filas;i++){
            for(int j = 0; j<columnas;j++){
                if(l!=n){
                    mazo[i][j]=mazo_ordenado[arreglo[l]];
                    l++;
                }
                
            }
        
        }
    }
    
    /*
     * Metodo que retorna la cantidad de cartas en el mazo
     * @return cantidad de cartas en el mazo
       */
    public int darN(){
        return n;
    }
    
    /*
     * Metodo que retorna una carta del mazo
     * @param
     * @return carta i,j
       */
    public cartaletranumero darCarta(int i, int j){
        return mazo[i][j];
    }
    
    /*
     * Metodo que retorna la cantidad de cartas en el mazo
     * @param i = coordenada fila
     * @param j = coordenada colum
       */
    public void quitarCarta(int i,int j){
        mazo[i][j]=null;
    }
    
    /*
     * Metodo que retorna la cantidad de filas
     * @return cantidad de filas
       */
    public int darCantFilas(){
        return filas;
    }
    
    
    /*
     * Metodo que retorna la cantidad de columns
     * @return cantidad de filas
       */
    public int darCantColumnas(){
        return columnas;
    }
    
    /*
     * Metodo que retorna un premio
     * @return premio i
       */
    public premios darPremio(int i){
        return premios[i];
    }
    
}
