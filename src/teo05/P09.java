/*P09.java
 */
package teo05;
import consola.ES;
import static teo05.P08.llenarN;
import static teo05.P08.mostrarN;
import static teo05.P08.valorN;

public class P09 {
    public static int promedioNP(NodoN raiz){
        int[] ret = new int[]{0,0};
        promedioNPAux(raiz, ret);
        return (ret[1]==0)? -1 : ret[0]/ret[1];
    }
    
    public static void promedioNPAux(NodoN raiz, int[] ret){
        if(raiz==null){return;}
        if(esPar(valorN(raiz))){
            ret[0] += valorN(raiz);
            ret[1]++;
        }
        promedioNPAux(raiz.getHij(), ret);
        promedioNPAux(raiz.getHer(), ret);
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
        ES.escribe("\nPromedio pares: " + promedioNP(raiz));
    }
}
