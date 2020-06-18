/*P06.java */
package lab00;
import consola.ES;
public class P06 {
    public static int iSigImpar(int a[], int n, int ii){
        for( ;ii<n; ii++){
            if(!P03.esPar(a[ii])){
                return ii;
            }
        }
        return -1;
    }
    
    public static void reordenar(int a[], int n){
        for( int i=0; i<n-1; i++){
            if(P03.esPar(a[i])){
                int ii = iSigImpar(a, n, i+1);
                if(ii<0){
                    return;
                }
                P04.swap(a, i, ii);
            }
        }
    }
    
    public static void main(String[] args) {
        final int MAX=8;
        int[]vec = new int[MAX];
        int n;
        //----------------------------------------------------------------------
        n= P01.llenar(vec);
        P01.mostrar(vec,n);
        //----------------------------------------------------------------------
        ES.escribe("\n");
        reordenar(vec, n);
        P01.mostrar(vec,n);
    }
}