/*P08.java
 */
package teo05;
import consola.ES;

public class P08 {
    public static void llenarN(NodoN raiz){
        int h;
        ES.escribe("hijo de " + raiz + ": ");
        h =  ES.leeInt();
        if(h<0){return;}
        raiz.setHij(new NodoN(new Integer(h)));
        llenarN(raiz.getHij());
        llenarHermanos(raiz.getHij());
    }
    
    public static void llenarHermanos(NodoN nodo){
        int h;
        ES.escribe("hermano de " + nodo + ": ");
        h = ES.leeInt();
        if(h<0){return;}
        llenarN(nodo);
        llenarHermanos(nodo);
    }
    
    public static void mostrarN(NodoN raiz){
        if(raiz==null){return;}
        ES.escribe(raiz + " ");
        mostrarN(raiz.getHij());
        mostrarN(raiz.getHer());
    }
    
    public static int valorN(NodoN nodo){
        return ((Integer)nodo.getE()).intValue();
    }
    
    public static void main(String[] args) {
        NodoN raiz;
        ES.escribe("raiz");
        raiz = new NodoN(new Integer(ES.leeInt()));
        llenarN(raiz);
        mostrarN(raiz);
    }
}

