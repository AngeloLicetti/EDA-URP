/*P015.java */
package teo00;
import consola.ES;
public class P15 {
    public static int insertarMat(int[][] m, int n, int e, int p){
        if(p<0||p>n||p==P14.indiceMaximoMat(m)+1){
            throw new IllegalArgumentException("'p' fuera de rango");
        }
        n = moverRMat(m, n , p);
        int f = P14.fila(m, p);
        int c = P14.columna(m, p);
        m[f][c] = e;
        return n;
    }
    
    public static int moverRMat(int m[][], int n, int p){
        n = (n==P14.indiceMaximoMat(m)+1)?n-1:n;
        moverRMatAux(m, n, p);
        return n+1;
    }
    
    public static void moverRMatAux(int m[][], int i, int p){
        if(i==p){return;}
        int fAnt = P14.fila(m, i-1);
        int cAnt = P14.columna(m, i-1);
        int f = P14.fila(m, i);
        int c = P14.columna(m, i);
        m[f][c] =  m[fAnt][cAnt];
        moverRMatAux(m, i-1, p);
    }
    
    public static void main(String[] args) {
        final int MAX_M = 4;
        final int MAX_N = 3;
        int [][]mat = new int[MAX_M][MAX_N];
        int n;
        //----------------------------------
        n = P14.llenarMat(mat);
        P14.mostrarMat(mat, n);
        //----------------------------------
        int e, p;
        ES.escribe("\ne: ");
        e=ES.leeInt();
        ES.escribe("p: ");
        p=ES.leeInt();
        n = insertarMat(mat, n, e, p);
        P14.mostrarMat(mat, n);
    }    
}