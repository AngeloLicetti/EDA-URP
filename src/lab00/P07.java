/*P07.java */
package lab00;
import consola.ES;
public class P07 {
    public static boolean esPrimo(int i){
        int top = i/2;
        for(int d=2; d<top; d++){
            if(i%d==0){
                return false;
            }
        }
        return true;
    }
    
    public static void imnprimirPrimos(int n){
        for( int i=2; i<=n-1; i++){
            if(esPrimo(i)){
                ES.escribe("\n"+i);
            }
        }
    }
    
    public static void main(String[] args) {
        int n;
        //----------------------------------------------------------------------
        ES.escribe("n: ");
        n= ES.leeInt();
        imnprimirPrimos(n);
    }
}