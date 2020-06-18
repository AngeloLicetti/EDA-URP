/*P08.java */
package teo00;
import consola.ES;
public class P08 {
    public static int mcm(int a[], int n){
        if(n>0){
            int max = maximo(a, n);
            return mcmAux(a, n, max);
        }
        else return 0;
    }
    
    public static int mcmAux(int a[], int n, int pmcm){
        if(pmcm==Integer.MAX_VALUE){return -1;}
        if(esDivididoPorTodos(pmcm, a, n)){
            return pmcm;
        }
        return mcmAux(a, n, pmcm+1);
    }
    
    public static int maximo(int a[], int n){
        return maximoAux(a, n, a[n-1]);
    }
    
    public static int maximoAux(int a[], int n, int mAct){
        if(n==0){return mAct;}
        if(a[n-1]>mAct){
            return maximoAux(a, n-1, a[n-1]);
        }
        return maximoAux(a, n-1, mAct);
    }
    
    public static boolean esDivididoPorTodos(int d, int a[], int n){
        if(n<0){return true;}
        if(!(d%a[n]==0)){
            return false;
        }
        return esDivididoPorTodos(d, a, n-1);
    }
    
    public static void main(String[] args) {
        final int MAX = 10;
        int n;
        int vec[] = new int[MAX];
        //----------------------------------
        n = P01.llenar(vec);
        P01.mostrar(vec, n);
        //----------------------------------
        ES.escribe("\nMcm: " + mcm(vec, n));
    }
}