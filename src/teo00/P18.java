/*P017.java
Problema de la mochila*/
package teo00;
import consola.ES;
public class P18 {
    public static void mochila(int[] vec, int n, int c){
        if(n==0){return;}
        int[] vecAux = new int[vec.length];
        ES.escribe("MochilaAux1:\n");
        mochilaAux1(vec, n, c, 0, vecAux, 0);
        ES.escribe("MochilaAux2 (sin vector auxiliar):\n");
        mochilaAux2(vec, n, c, 0, "", 0);
    }
    
    private static void mochilaAux2(int[] vec, int n, int capacidad, int i, String sol, int suma){
        if(suma==capacidad){
            ES.escribe(sol + "\n");
            return;
        }
        if(suma>capacidad){return;}
        if(i==n){return;}
        mochilaAux2(vec, n, capacidad, i+1, sol, suma);
        suma += vec[i];
        sol += vec[i] + " ";
        mochilaAux2(vec, n, capacidad, i+1, sol, suma);
    }
    
    private static void mochilaAux1(int[] vec, int n, int capacidad, int i, int[] vecAux, int c){
        if(P01.suma(vecAux, c)==capacidad){
            P01.mostrar(vecAux, c);
            ES.escribe("\n");
            return;
        }
        if(P01.suma(vecAux, c)>capacidad){return;}
        if(i==n){return;}
        vecAux[c] = vec[i];
        mochilaAux1(vec, n, capacidad, i+1, vecAux, c+1);
        mochilaAux1(vec, n, capacidad, i+1, vecAux, c);
    }
    
    public static void main(String[] args) {
        final int MAX = 10;
        int vec[] = new int[MAX];
        int n;
        int capacidad;
        //---------------------------------------
        ES.escribe("Capacidad total de la mochila: ");
        capacidad = ES.leeInt();
        ES.escribe("\nIngrese los pesos de los objetos:\n");
        n = P01.llenar(vec);
        P01.mostrar(vec,n);
        //---------------------------------------
        P03.ordenar(vec, n);
        ES.escribe("\nOrdenados:\n");
        P01.mostrar(vec,n);
        //---------------------------------------
        ES.escribe("\nSoluciones: \n");
        mochila(vec, n, capacidad);
        ES.escribe("\n");
    }
}
