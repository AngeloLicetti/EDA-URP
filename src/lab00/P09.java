/* P09.java
                %
um          n       psfp    ?   qué hace
-1         12       2       =0  imprime psfp
 1          6       2       =0  NO imprime psfp
1           3       2       =0  
-1          3       3       =0  imprime psfp
 */
package lab00;
import consola.ES;

public class P09 {
    public static void imprimeFactoresPrimos(int n){
        int psfp = 2, um=-1;
        while(psfp<=n){
            if(n%psfp==0){
                if(um<=0){
                    ES.escribe(psfp+" ");
                    um=1;
                }
                n/=psfp;
            }
            else{
                psfp++;
                um=-1;
            }
        }
    }
    
    public static void main(String[] args) {
        int n;
        ES.escribe("n: ");
        n = ES.leeInt();
        imprimeFactoresPrimos(n);
    }    
}