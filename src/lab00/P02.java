/*P02.java
 */
package lab00;
import consola.ES;
public class P02 {
    public static int suma(int a[], int n){
        int s=0;
        for( ; n>0; n--){
            s+=a[n-1];
        }
        return s;
    }
    
    public static int promedio (int a[], int n){
        return n==0? -134 : suma(a,n)/n;
    }
    
    public static void main(String[] args) {
        final int MAX=8;
        int[]vec = new int[MAX];
        int n;
        //----------------------------------------------------------------------
        n= P01.llenar(vec);
        P01.mostrar(vec,n);
        //----------------------------------------------------------------------
        ES.escribe("\npromedio: " + promedio(vec,n));
    }
}
