/*P10.java */
package lab00;
import consola.ES;
public class P10 {
    public static boolean esDivididoPorTodos(int e, int[] a, int n){
        for( ; n>0; n--){
            if((e% a[n-1])!=0){
                return false;
            }
        }
        return true;
    }
    
    public static int mayor(int a[], int n){
        int ma = a[n-1];
        for( ; n>0; n--){
            ma = a[n-1] <= ma ? ma : a[n-1];
        }
        return ma;
    }
    
    public static int mcm(int[] a, int n) {
        int pmcm = mayor(a, n);
        for(; pmcm< Integer.MAX_VALUE; pmcm++){
            if(esDivididoPorTodos(pmcm, a, n)){
                break;
            }
        }
        return pmcm==Integer.MAX_VALUE? -1: pmcm;
    }
    
    public static void main(String[] args) {
        final int MAX=8;
        int[]vec = new int[MAX];
        int n;
        //----------------------------------------------------------------------
        n= P01.llenar(vec);
        P01.mostrar(vec,n);
        //----------------------------------------------------------------------
        ES.escribe("\nMCM: " + mcm(vec,n));
    }
}