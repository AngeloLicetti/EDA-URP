/* P13.java
 */
package lab00;

import consola.ES;

public class P13 {
    public static void swapM(int m[][], int x, int j, int z, int y){
        int temp = m[x][j];
        m[x] [j] = m[z][y];
        m[z] [y] = temp;
    }
    
    public static void invertirMatriz(int[][] m){
        for(int i=0, z=m.length-1; i<z; i++, z--){
            for(int j=0, y=m[i].length-1; j<y; j++){
                swapM(m, i, j, z, y);
            }
        }
    }
    
    public static void main(String[] args) {
        final int m=2, n=2;
        int [][] matriz = new int [m][n];
        //----------------------------------------------------------------------
        P12.llenarMatriz(matriz);
        P12.mostrarMatriz(matriz);
        //----------------------------------------------------------------------
        invertirMatriz(matriz);
        ES.escribe("\nMatriz invertida:\n");
        P12.mostrarMatriz(matriz);
    }
}