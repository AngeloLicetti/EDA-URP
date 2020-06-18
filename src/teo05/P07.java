/*P07.java
 */
package teo05;

import consola.ES;
import static teo05.P01.llenarB;
import static teo05.P01.mostrarB;
import static teo05.P02.valorB;
import static teo05.P03.esHoja;

public class P07 {
    public static int promedioNivelB(NodoB raiz, int indice){
        int [] ret = new int[] {indice, 0, 0};
        promedioNivelBAux(raiz, ret);
        return (ret[2] == 0)? -123 : (ret[1]/ret[2]);
    }
    
    public static void promedioNivelBAux(NodoB raiz, int[] ret){
        if(raiz==null){return;}
        if(ret[0] == 0){
            ret[1]+=valorB(raiz);
            ret[2]++;
            return;
        }
        ret[0]--;
        int x = ret[0];
        promedioNivelBAux(raiz.getI(), ret);
        ret[0] = x;
        promedioNivelBAux(raiz.getD(), ret);
    }
    
    public static void main(String[] args) {
        NodoB raiz;
        ES.escribe("Raiz: ");
        raiz = new NodoB(new Integer(ES.leeInt()));
        llenarB(raiz);
        mostrarB(raiz);
        //----------------------------------------
        int i;
        ES.escribe("\nIndice: ");
        i = ES.leeInt();
        ES.escribe("\nPromedio del nuvel " + i + ": " + promedioNivelB(raiz, i));
    }
    
}
