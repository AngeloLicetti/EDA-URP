/*P06.java
 */
package teo05;

import consola.ES;
import static teo05.P01.llenarB;
import static teo05.P01.mostrarB;
import static teo05.P02.valorB;
import static teo05.P03.esHoja;

public class P06 {
    public static void espejoB(NodoB raiz){
        if(raiz==null){return;}
        NodoB temp = raiz.getI();
        raiz.setI(raiz.getD());
        raiz.setD(temp);
        espejoB(raiz.getI());
        espejoB(raiz.getD());
    }
    
    public static void main(String[] args) {
        NodoB raiz;
        ES.escribe("Raiz: ");
        raiz = new NodoB(new Integer(ES.leeInt()));
        llenarB(raiz);
        mostrarB(raiz);
        //----------------------------------------
        ES.escribe("\nEspejo: \n");
        espejoB(raiz);
        mostrarB(raiz);
    }
    
}
