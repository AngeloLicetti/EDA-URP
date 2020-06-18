/* P12.java
 */
package lab00;

import consola.ES;

public class P12 {
    public static boolean esDivididoPorTodos(int e, int[][] m){
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++){
                if((e% m[i][j])!=0){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int mayor(int [][]m){
        int ma = m[m.length-1][m[m.length-1].length-1];
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++){
                ma = m[i][j] <= ma ? ma : m[i][j];
            }
        }
        return ma;
    }
    
    public static void llenarMatriz(int [][] m){
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++){
                ES.escribe("sig: ");
                m[i][j]= ES.leeInt();
            }
        }
    }

    public static void mostrarMatriz(int [][] m){
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++){
                ES.escribe(m[i][j] + " ");
            }
            ES.escribe("\n");
        }
    }
    
    public static int mcd(int[][] m){
        int pmcm = mayor(m);
        for(; pmcm< Integer.MAX_VALUE; pmcm++){
            if(esDivididoPorTodos(pmcm, m)){
                break;
            }
        }
        return pmcm==Integer.MAX_VALUE? -1: pmcm;
    }
    
    public static void main(String[] args) {
        final int m=2, n=2;
        int [][] matriz = new int [m][n];
        //----------------------------------------------------------------------
        llenarMatriz(matriz);
        mostrarMatriz(matriz);
        //----------------------------------------------------------------------
        ES.escribe("\nMCD: " + mcd(matriz));
    }
}
