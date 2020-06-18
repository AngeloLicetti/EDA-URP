
package teo00;
import consola.ES;
public class P02 {    
    public static void invertir(int[] vec, int n) {
        invertirAux(vec, 0, n-1);
    }
    
    public static void invertirAux(int[] a, int i, int d){
        if(i>=d){return;}
        swap(a, i, d);
        invertirAux(a, i+1, d-1);
        
    }
    
    public static void swap(int [] a, int i, int d){
        int temp = a[i];
        a[i] = a[d];
        a[d] = temp;
    }
    
    public static void main(String[] args) {
        final int MAX = 10;
        int vec[] = new int[MAX];
        int n;
        //---------------------------------------
        n = P01.llenar(vec);
        P01.mostrar(vec,n);
        //---------------------------------------
        invertir(vec, n);
        ES.escribe("\n");
        P01.mostrar(vec, n);
    }
}