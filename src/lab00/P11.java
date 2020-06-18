/*P10.java */
package lab00;
import consola.ES;
public class P11 {
    public static boolean divideA_Todos(int e, int[] a, int n){
        for( ; n>0; n--){
            if((a[n-1]%e)!=0){
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
    
    public static int mcd(int[] a, int n) {
        int pmcd = mayor(a, n);
        for(; pmcd>1; pmcd--){
            if(divideA_Todos(pmcd, a, n)){
                break;
            }
        }
        return pmcd;
    }
    
    public static void main(String[] args) {
        final int MAX=8;
        int[]vec = new int[MAX];
        int n;
        //----------------------------------------------------------------------
        n= P01.llenar(vec);
        P01.mostrar(vec,n);
        //----------------------------------------------------------------------
        ES.escribe("\nMCD: " + mcd(vec,n));
    }
}