package teo00;
import consola.ES;
public class P04 {
    public static void reOrdenar(int a[], int n){
        if(n>0){reordenarAux(a, n, 0);}
    }
    
    public static void reordenarAux(int a[], int n, int i){
        if(i==n-1){return;}
        if(P01.esPar(a[i])){
            int ii = indiceSiguienteImpar(a, n, i+1);
            if(ii<0){return;}
            P02.swap(a, i, ii);
        }
        reordenarAux(a, n, i+1);
    }
    
    public static int indiceSiguienteImpar(int []a, int n, int pisi){
        if(pisi==n){ return -1;}
        if(!P01.esPar(a[pisi])){return pisi;}
        return indiceSiguienteImpar(a, n, pisi+1);
    }
    
    public static void main(String[] args) {
        final int MAX = 10;
        int vec[] = new int[MAX];
        int n;
        //---------------------------------------
        n = P01.llenar(vec);
        P01.mostrar(vec,n);
        //---------------------------------------
        reOrdenar(vec, n);
        ES.escribe("\n");
        P01.mostrar(vec, n);
    }
}