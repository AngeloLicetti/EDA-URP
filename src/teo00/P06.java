/*P06.java*/
package teo00;
import consola.ES;
public class P06 {
    public static void imprimeProdFactoresPrimos(int n){
        imprimeProdFactoresPrimosAux(n, 2);
    }
    
    public static void imprimeProdFactoresPrimosAux(int n, int div){
        if(n==1){return;}
        if(n%div==0){
            ES.escribe(div+" ");
            n/=div;
        }
        else{
            div++;
        }
        imprimeProdFactoresPrimosAux(n, div+1);
    }
    
    public static void main(String[] args) {
        int n;
        //----------------------------------
        ES.escribe("n: ");
        n = ES.leeInt();
        //----------------------------------
        imprimeProdFactoresPrimos(n);
    }
}