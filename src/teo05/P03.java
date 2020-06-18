/*P03.java */
package teo05;

import consola.ES;
import static teo05.P01.llenarB;
import static teo05.P01.mostrarB;
import static teo05.P02.valorB;

public class P03 {
    public static int promedioBH(NodoB raiz){
        int[] ret = new int[]{0,0};
        promedioBHAux(raiz, ret);
        return ret[1]==0?-1:ret[0]/ret[1];
    }
    
    public static void promedioBHAux(NodoB raiz, int[] ret){
        if(raiz==null){return;}
        if(esHoja(raiz)){
            ret[0]+=valorB(raiz);
            ret[1]++;
        }
        promedioBHAux(raiz.getI(), ret);
        promedioBHAux(raiz.getD(), ret);
    }
    
    public static boolean esHoja(NodoB n){
        return n.getI()==null && n.getD()==null;
    }
    
    public static void main(String[] args) {
        NodoB raiz;
        ES.escribe("Raiz: ");
        raiz = new NodoB(new Integer(ES.leeInt()));
        llenarB(raiz);
        mostrarB(raiz);
        //----------------------------------------
        ES.escribe("\nPromedio hojas: " + promedioBH(raiz));
    }
}
