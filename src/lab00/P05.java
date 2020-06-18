/*P05.java */
package lab00;
import consola.ES;
public class P05 {
    public static void ordenar(int a[], int n){
        for( int i=0; i<n-1; i++){
            for(int d=i+1; d<n; d++){
                if(a[d] < a[i]){
                    P04.swap(a, i, d);
                }
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
        ordenar(vec, n);
        P01.mostrar(vec,n);
    }
}