/*P09.java */
package teo00;
import consola.ES;
public class P09 {
    public static int mcd(int []a, int n){
        if(n>0){
            int min = minimo(a, n);
            return mcdAux(a, n, min);
        }
        return 0;
    }
    
    public static int mcdAux(int a[], int n, int pmcd){
        if(pmcd==1){return -1;}
        if(esDivisorDeTodos(a, n, pmcd)){
            return pmcd;
        }
        else{
            return mcdAux(a, n, pmcd-1);
        }
    }
    
    public static int minimo(int a[], int n){
        return minimoAux(a, n, a[n-1]);
    }
    
    public static int minimoAux(int a[], int n, int minAct){
        if(n==0){return minAct;}
        if(minAct>a[n-1]){
            return minimoAux(a, n-1, a[n-1]);
        }
        return minimoAux(a, n-1, minAct);
    }
    
    public static boolean esDivisorDeTodos(int a[], int n, int div){
        if(n==0){return true;}
        if(!(a[n-1]%div==0)){
            return false;
        }
        return esDivisorDeTodos(a, n-1, div);
    }
    
    public static void main(String[] args) {
        final int MAX = 10;
        int []vec = new int[MAX];
        int n;
        //----------------------------------
        n = P01.llenar(vec);
        P01.mostrar(vec, n);
        //----------------------------------
        ES.escribe("\nMCD: " + mcd(vec, n));
    }    
}