/*P07.java */
package teo00;
import consola.ES;
public class P07 {
    public static void imprimeFactoresPrimos(int n){
        if(n>0){
            imprimeFactoresPrimosAux(n, 2, -1);
        }
    }
    
    public static void imprimeFactoresPrimosAux(int n, int div, int sw){
        if(n==1){return;}
        if(n%div==0){
            if(sw<0){
                ES.escribe(div+" ");
                sw=1;
            }
            n/=div;
        }
        else{
            sw=-1;
            div++;
        }
        imprimeFactoresPrimosAux(n, div, sw);
    }
    
    public static void main(String[] args) {
        int n;
        //----------------------------------
        ES.escribe("n: ");
        n = ES.leeInt();
        //----------------------------------
        ES.escribe("\n");
        imprimeFactoresPrimos(n);
    }
}