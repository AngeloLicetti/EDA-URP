/*P013.java */
package teo00;
import consola.ES;
public class P13 {
    public static int eliminar(int a[], int n, int p){
        if(n==0||p<0||p>=n){
            throw new IllegalArgumentException("'p' fuera de rango");
        }
        moverL(a, n, p);
        return n-1;
    }
    
    public static void moverL(int a[], int n, int p){
        //es suficiente con p==n-1
        if(p==n||(n==a.length&&p==n-1)){return;}
        a[p]=a[p+1];
        moverL(a, n, p+1);
    }
    
    public static void main(String[] args) {
        final int MAX = 10;
        int []vec = new int[MAX];
        int n;
        //----------------------------------
        n = P01.llenar(vec);
        P01.mostrar(vec, n);
        //----------------------------------
        int p;
        ES.escribe("\np: ");
        p=ES.leeInt();
        n = eliminar(vec, n, p);
        P01.mostrar(vec, n);
    }    
}