/*P012.java */
package teo00;
import consola.ES;
public class P12 {
    public static int insertar(int a[], int n, int e, int p){
        if(p<0||p>n||p==a.length){
            throw new IllegalArgumentException("'p' fuera de rango");
        }
        n = moverR(a, n, p);
        a[p]=e;
        return n;
    }
    
    public static int moverR(int a[], int n, int p){
        n = (n==a.length)? n-1:n;
        moverRAux(a, n, p);
        return n+1;
    }
    
    public static void moverRAux(int a[], int i, int p){
        if(i==p){return;}
        a[i]=a[i-1];
        moverRAux(a, i-1, p);
    }
    
    public static void main(String[] args) {
        final int MAX = 10;
        int []vec = new int[MAX];
        int n;
        //----------------------------------
        n = P01.llenar(vec);
        P01.mostrar(vec, n);
        //----------------------------------
        int e, p;
        ES.escribe("\ne: ");
        e=ES.leeInt();
        ES.escribe("\np: ");
        p=ES.leeInt();
        n = insertar(vec, n, e, p);
        P01.mostrar(vec, n);
    }    
}