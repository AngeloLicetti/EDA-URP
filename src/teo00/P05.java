/*P05.java*/
package teo00;
import consola.ES;
public class P05 {
    public static void imprimePrimos(int n){
        imprimePrimosAux(n, 2);
    }
    
    private static void imprimePrimosAux(int n, int sig){
        if(sig==n){return;}
        if(esPrimo(sig)){
            ES.escribe(sig+" ");
        }
        imprimePrimosAux(n, sig+1);
    }
    
    public static boolean esPrimo(int p){
        return esPrimoAux(p, 2);
    }
    
    private static boolean esPrimoAux(int p, int d){
        if(d>(p/2)){return true;}
        if(p%d==0){return false;}
        return esPrimoAux(p, d+1);
    }
    
    public static void main(String[] args) {
        int n;
        //----------------------------------------
        ES.escribe("n: ");
        n = ES. leeInt();
        //-----------------------------------------
        ES.escribe("\n");
        imprimePrimos(n);
        
    }
}