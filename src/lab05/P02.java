/*P02.java */
package lab05;

import consola.ES;
import static lab05.P01.llenarB;
import static lab05.P01.mostrarB;

public class P02 {
    public static int promedioBP(NodoB raiz){
        int [] ret = new int[] {0,0};
        promedioBPAux(raiz, ret);
        return ret[1]==0? -1 : ret[0]/ret[1];
    }
    
    public static void promedioBPAux(NodoB raiz, int[] ret){
        if(raiz==null){return;}
        if(esPar(valorB(raiz))){
            ret[0] += valorB(raiz);
            ret[1]++;
        }
        promedioBPAux(raiz.getI(), ret);
        promedioBPAux(raiz.getD(), ret);
    }
    
    public static boolean esPar(int i){
        return i%2==0;
    }
    
    public static int valorB(NodoB n){
        return ((Integer)n.getE()).intValue();
    }
    
    public static void main(String[] args) {
        NodoB raiz;
        ES.escribe("Raiz: ");
        raiz = new NodoB(new Integer(ES.leeInt()));
        llenarB(raiz);
        mostrarB(raiz);
        ES.escribe("\n");
        //-----------------------------------------
        ES.escribe("Promedio pares: " + promedioBP(raiz));
    }
    
}
