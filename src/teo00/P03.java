package teo00;
import consola.ES;
public class P03 {
    public static void ordenar(int a[], int n){
        if(n>0){tratarI(a, n, 0);}
    }
    
    public static void tratarI(int a[], int n, int i){
        if(i==n-1){return;}
        tratarD(a, n, i, i+1);
        tratarI(a, n, i+1);
    }
    
    public static void tratarD(int []a, int n, int i, int d){
        if(d==n){return;}
        if(a[d]<a[i]){
            P02.swap(a, i, d);
        }
        tratarD(a, n, i, d+1);
    }
    
    public static void main(String[] args) {
        final int MAX = 10;
        int vec[] = new int[MAX];
        int n;
        //---------------------------------------
        n = P01.llenar(vec);
        P01.mostrar(vec,n);
        //---------------------------------------
        ordenar(vec, n);
        ES.escribe("\n");
        P01.mostrar(vec, n);
    }
}