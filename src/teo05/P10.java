/*P10.java
 */
package teo05;
import consola.ES;
import static teo05.P08.llenarN;
import static teo05.P08.mostrarN;
import static teo05.P08.valorN;

public class P10 {
    public static int promedioHojaN(NodoN raiz){
        int[] ret = new int[]{0,0};
        promedioHojaNAux(raiz, ret);
        return (ret[1]==0)? -1 : ret[0]/ret[1];
    }
    
    public static void promedioHojaNAux(NodoN raiz, int[] ret){
        if(raiz==null){return;}
        if(esHojaN(raiz)){
            ret[0] += valorN(raiz);
            ret[1]++;
            promedioHojaNAux(raiz.getHer(), ret);
        }
        promedioHojaNAux(raiz.getHij(), ret);
        promedioHojaNAux(raiz.getHer(), ret);
    }
    
    public static boolean esHojaN(NodoN raiz){
        return raiz.getHij()==null;
    }
    
    public static boolean esPar(int i){
        return i%2 == 0;
    }
    
    public static void main(String[] args) {
        NodoN raiz;
        ES.escribe("raiz");
        raiz = new NodoN(new Integer(ES.leeInt()));
        llenarN(raiz);
        mostrarN(raiz);
        //-----------------------------------------
        ES.escribe("\nPromedio pares: " + promedioHojaN(raiz));
    }
}