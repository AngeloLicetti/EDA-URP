/*P06_v2.java */
package teo00;
import consola.ES;
public class P06_v2 {
    public static void imprimeProdFactoresPrimos2(int n){
        if(n>0){
            imprimeProdFactoresPrimos2Aux(n, 2, 0);
        }
    }
    
    private static void imprimeProdFactoresPrimos2Aux(int n, int div, int c){
        if(n==1){
            ES.escribe("\nNúmero de elementos imprimidos: " + c);
            return;
        }
        if(n%div==0){
            ES.escribe(div + " ");
            n/=div;
            c++;
        }
        else{
            div++;
        }
        imprimeProdFactoresPrimos2Aux(n, div, c);
    }
    
    public static void main(String[] args) {
        int n;
        //----------------------------------
        ES.escribe("n: ");
        n = ES.leeInt();
        //----------------------------------
        imprimeProdFactoresPrimos2(n);
    }    
}