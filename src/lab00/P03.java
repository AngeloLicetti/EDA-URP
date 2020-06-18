/*P03.java */
package lab00;
import consola.ES;
public class P03 {
    public static boolean esPar(int e){
        return e%2 == 0;
    }
    
    public static int promedio1P(int a[], int n){
        int s=0, c=0;
        for( ; n>0; n--){
            if(esPar(a[n-1])){
                s+=a[n-1];
                c++;
            }
        }
        return c==0 ? -111 : (s/c);
    }
    
    public static void main(String[] args) {
        final int MAX=8;
        int[]vec = new int[MAX];
        int n;
        //----------------------------------------------------------------------
        n= P01.llenar(vec);
        P01.mostrar(vec,n);
        //----------------------------------------------------------------------
        ES.escribe("\npromedio: " + promedio1P(vec,n));
    }
}