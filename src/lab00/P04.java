/*P04.java */
package lab00;
import consola.ES;
public class P04 {
    public static void swap(int a[], int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    
    public static void invertir(int a[], int n){
        for( int i=0, d=n-1; i<d; i++, d--){
            swap(a, i, d);
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
        invertir(vec, n);
        P01.mostrar(vec,n);
    }
}