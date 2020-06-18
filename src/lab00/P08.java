/* P08.java
                %
n = n/psfp      n       psfp    ?   qué hace
psfp++          12      2       =0  imprime psfp
                6       2       =0  imprime psfp
                3       2       /=0  
                3       3       =0  imprime psfp
 */
package lab00;
import consola.ES;

public class P08 {
    public static void imprimeProductoFactoresPrimos(int n){
        int psfp = 2;
        while(psfp<=n){
            if(n%psfp==0){
                ES.escribe(psfp+" ");
                n/=psfp;
            }
            else{
                psfp++;
            }
        }
    }
    public static void main(String[] args) {
        int n;
        ES.escribe("n: ");
        n = ES.leeInt();
        imprimeProductoFactoresPrimos(n);
    }    
}