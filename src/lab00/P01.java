/*P01.java
 */
package lab00;
import consola.ES;
public class P01 {
    public static int llenar(int a[]){
        int i=0;
        for( ;i<a.length;i++){
            ES.escribe("sig: ");
            a[i]=ES.leeInt();
            if(a[i]<0){
                break;
            }
        }
        return i;
    }
    
    public static void mostrar(int a[], int n){
        for(int i=0; i<n;i++){
            ES.escribe(a[i]+" ");
        }
    }
    
    public static void main(String[] args) {
        final int MAX=8;
        int[]a = new int[MAX];
        int n = llenar(a);
        mostrar(a,n);
    }
}
