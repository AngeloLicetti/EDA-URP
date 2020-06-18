package teo00;
import consola.ES;
public class P01_v2 {
    public static int promedio2P(int a[], int n){
        int [] ret = new int[]{0,0};
        promedio2PAux(a, n, ret);
        return ret[1]==0?-1:ret[0]/ret[1];
    }
    
    private static void promedio2PAux(int a[], int n, int ret[]){
        if(n==0){return;}
        if(P01.esPar(a[n-1])){
            ret[0]+=a[n-1];
            ret[1]++;
        }
        promedio2PAux(a, n-1, ret);
    }
    //----------------------------------------------------------
    public static void main(String[] args) {
        final int MAX = 10;
        int vec[] = new int[MAX];
        int n;
        //---------------------------------------
        n = P01.llenar(vec);
        P01.mostrar(vec,n);
        //---------------------------------------
        ES.escribe("\nPromedio pares: " + promedio2P(vec, n));
    }
}