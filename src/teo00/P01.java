package teo00;
import consola.ES;
public class P01 {
    public static int llenar(int [] a){
        return llenarAux(a, 0);
    }
    
    private static int llenarAux(int a[], int i){
        if(i==a.length){return i;}
        ES.escribe("sig: ");
        a[i] = ES.leeInt();
        if(a[i] < 0){return i;}
        return llenarAux(a, i + 1);
    }
    
    public static void mostrar(int[] a, int n){
        mostrarAux(a, n, 0);
    }
    
    public static void mostrarAux(int a[], int n, int i){
        if(i==n){return;}
        ES.escribe(a[i] + " ");
        mostrarAux(a, n, i+1);
    }
    //------------------------------------------------------
    public static int promedio1(int[] a, int n){
        return n==0? -747 : promedio1Aux(a, n);
    }
    
    private static int promedio1Aux(int [] a, int n){
        return suma(a, n)/n;
    }
    
    public static int suma(int [] a, int n){
        if(n==0){return 0;}
        return a[n-1] + suma(a, n-1);
    }
    //----------------------------------------------------------
    public static int promedio1P(int a[], int n){
        return n==0? -84 : promedio1PAux(a,n);
    }
    
    private static int promedio1PAux(int a[], int n){
        int ret [] = new int[]{n, 0, 0}; //{n, s, c}
        promedio1PAuxAux(a, ret);
        return ret[2] == 0? -1 : (ret[1] / ret[2]);
    }
    
    private static void promedio1PAuxAux(int a[], int ret[]){
        if(ret[0]==0){return;}
        if(esPar(a[ret[0]-1])){
            ret[1]+=a[ret[0]-1];
            ret[2]++;
        }
        ret[0]--;
        promedio1PAuxAux(a, ret);
    }
    
    public static boolean esPar(int e){
        return(e%2)==0;
    }
    //----------------------------------------------------------
    public static void main(String[] args) {
        final int MAX = 10;
        int vec[] = new int[MAX];
        int n;
        //---------------------------------------
        n = llenar(vec);
        mostrar(vec,n);
        //---------------------------------------
        ES.escribe("\nPromedio: " + promedio1(vec, n));
        //---------------------------------------
        ES.escribe("\nPromedio pares: " + promedio1P(vec, n));
    }
}
