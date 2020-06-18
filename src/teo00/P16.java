/*P016.java */
package teo00;
import consola.ES;
public class P16 {
    public static int eliminarMat(int[][] m, int n, int p){
        if(n==0||(p<0||p>=n)){
            throw new IllegalArgumentException("");
        }
        moverLMat(m, n, p);
        return n-1;
    }
    
   public static void moverLMat(int [][]m, int n, int p){
       if(p==n-1){return;}
       int fPos = P14.fila(m, p+1);
       int cPos = P14.columna(m, p+1);
       int f = P14.fila(m, p);
       int c = P14.columna(m, p);
       m[f][c] =  m[fPos][cPos];
       moverLMat(m, n, p+1);
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
        int p;
        ES.escribe("\np: ");
        p=ES.leeInt();
        n = eliminarMat(mat, n, p);
        P14.mostrarMat(mat, n);
    }    
}