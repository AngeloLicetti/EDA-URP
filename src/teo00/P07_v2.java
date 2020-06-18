/*P07_v2.java */
package teo00;
import consola.ES;
public class P07_v2 {
    public static void imprimeFactoresPrimos2(int n){
        if(n>0){
            imprimeFactoresPrimos2Aux(n, 2, -1, 0);
        }
    }
    
    public static void imprimeFactoresPrimos2Aux(int n, int div, int sw, int c){
        if(n==1){
            ES.escribe("\nNúmero de elementos imprimidos: " + c);
            return;
        }
        if(n%div==0){
            if(sw<0){
                ES.escribe(div+" ");
                c++;
                sw=1;
            }
            n/=div;
        }
        else{
            div++;
            sw=-1;
        }
        imprimeFactoresPrimos2Aux(n, div, sw, c);
    }
    
    public static void main(String[] args) {
        int n;
        //----------------------------------
        ES.escribe("n: ");
        n = ES.leeInt();
        //----------------------------------
        imprimeFactoresPrimos2(n);
    }
}