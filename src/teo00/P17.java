/*P017.java */
package teo00;
import consola.ES;
public class P17 {
    public static void hanoi(int n, String fuente, String destino, String auxiliar){
        if(n==0){return;}
        hanoi(n-1,fuente,auxiliar,destino);
        ES.escribe("Mover de " + fuente + " a " + destino);
        hanoi(n-1,auxiliar,destino,fuente);
    }
    
    public static void main(String[] args) {
        int n;
        //----------------------------------
        ES.escribe("\n: ");
        n = ES.leeInt();
        ES.escribe("\n");
        //----------------------------------
        hanoi(n,"A","C","B");
    }    
}