/*P04.java
 */
package teo05;

import consola.ES;
import static teo05.P01.llenarB;
import static teo05.P01.mostrarB;
import static teo05.P02.valorB;
import static teo05.P03.esHoja;

public class P04 {
    public static int isesimaHojaB(NodoB raiz, int indice){
        int[] ret = new int[]{indice};
        return iesimaHojaBAux(raiz, ret);
    }
    
    public static int iesimaHojaBAux(NodoB raiz, int[] ret){
        if(raiz==null){return -1;}
        if(esHoja(raiz)){
            if(ret[0]==0){
                return valorB(raiz);
            }
            ret[0]--;
            return -1;
        }
        int v = iesimaHojaBAux(raiz.getI(), ret);
        return v>=0? v : iesimaHojaBAux(raiz.getD(), ret);
    }
    
    public static void main(String[] args) {
        NodoB raiz;
        ES.escribe("Raiz: ");
        raiz = new NodoB(new Integer(ES.leeInt()));
        llenarB(raiz);
        mostrarB(raiz);
        //----------------------------------------
        int i;
        ES.escribe("Indice: ");
        i = ES.leeInt();
        ES.escribe("Iesima hoja: " + isesimaHojaB(raiz, i)); 
    }
    
}
