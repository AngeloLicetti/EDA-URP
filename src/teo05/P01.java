/*P01.java */
package teo05;

import consola.ES;

public class P01 {
    public static void llenarB(NodoB raiz){
        int h;
        ES.escribe("Nodo hijo izquierdo de " + raiz + ": ");
        h = ES.leeInt();
        if(h>=0){
            raiz.setI(new NodoB(new Integer(h)));
            llenarB(raiz.getI());
        }
        ES.escribe("Nodo hijo derecho de " + raiz + ": ");
        h = ES.leeInt();
        if(h>=0){
            raiz.setD(new NodoB(new Integer(h)));
            llenarB(raiz.getD());
        }
    }
    
    public static void mostrarB(NodoB raiz){
        if(raiz == null){return;}
        ES.escribe(raiz + "");
        mostrarB(raiz.getI());
        mostrarB(raiz.getD());
    }
    
    public static void main(String[] args) {
        NodoB raiz;
        ES.escribe("Raiz: ");
        raiz = new NodoB(new Integer(ES.leeInt()));
        llenarB(raiz);
        mostrarB(raiz);
    }
}
