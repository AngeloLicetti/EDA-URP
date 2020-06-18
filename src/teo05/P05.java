/*P05.java
 */
package teo05;

import consola.ES;
import static teo05.P01.llenarB;
import static teo05.P01.mostrarB;
import static teo05.P02.valorB;
import static teo05.P03.esHoja;

public class P05 {
    public static int iesimaTrayectoriaP(NodoB raiz, int indice){
        int[] ret = new int[]{indice, 0, 0};
        iesimaTrayectoriaPAux(raiz, ret);
        return ret[2]==0? -123 : (ret[1]/ret[2]);
    }
    
    public static void iesimaTrayectoriaPAux(NodoB raiz, int[] ret){
        if(raiz==null){return ;}
        if(esHoja(raiz)){
            if(ret[0]==0){
                ret[1]+= valorB(raiz);
                ret[2]++;
            } else{
                ret[0]--;
            }
            return;
        }
        iesimaTrayectoriaPAux(raiz.getI(), ret);
        if(ret[2]==0){
            iesimaTrayectoriaPAux(raiz.getD(), ret);
        }
        if(ret[2]>0){
            ret[1]+=valorB(raiz);
            ret[2]++;
        }
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
        ES.escribe("\nIesima trayectoria: " + iesimaTrayectoriaP(raiz, i)); 
    }
    
}
