/*P017.java
Problema de las n reinas*/
package teo00;
import consola.ES;
public class P19 {
    public static void nReinas(int n){
        if(n<4||n>Integer.MAX_VALUE){
            throw new IllegalArgumentException("n fuera de rango");
        }
        int[][] mat = new int [n][n];
        llenarTablero(mat, n, 0, 0);
    }
    
    public static void llenarTablero(int[][] mat,int n, int i, int r){
        if(i>=P14.indiceMaximoMat(mat)+1){
            if(r==n){
                P14.mostrarMat(mat, i);
            }
            return;
        }
        int f = P14.fila(mat, i);
        int c = P14.columna(mat, i);
        if(r==n){
            mat[f][c]=0;
            llenarTablero(mat, n, i+1, r);
            return;
        }
        llenarTableroAux(mat, n, i, r, f);
    }
    
    private static void llenarTableroAux(int[][] mat,int n, int i, int r, int f){
        if(i==n*f){return;}
        if(esPosicionValida(mat, i)){
            int c = P14.columna(mat, i);
            mat[f][c]=1;
            llenarTablero(mat, n, n*f, r); 
        }
        llenarTableroAux(mat, n, i+1, r, f);
    }
    
    private static boolean esPosicionValida(int[][] mat, int i){
        int c = P14.columna(mat, i);
        return columnaVacia(mat, c) && diagonalesVacias(mat, i);
    }
    
    private static boolean columnaVacia(int[][] mat, int c){
        return columnaVaciaAux(mat, c, mat.length, 0);
    }
    
    private static boolean columnaVaciaAux(int[][] mat, int c, int n, int f){
        if(f==n){return true;}
        if(mat[f][c]==1){return false;}
        return columnaVaciaAux(mat, c, n, f+1);
    }
    
    private static boolean diagonalesVacias(int[][] mat, int i){
        //return diagonalAVacia(mat, i) && diagonalBVacia(mat, i);
        return false;
    }
    
    private static boolean diagonalAVacia(int[][] mat, int i){
        int f = P14.columna(mat, i);
        int c = P14.columna(mat, i);
        return diagonalAVaciaAux(mat, 0, c-f, mat.length);
    }
    
    private static boolean diagonalAVaciaAux(int[][] mat, int f, int c, int n){
        if(f==n||c==n){return true;}
        if(mat[f][c]==1){return false;}
        return diagonalAVaciaAux(mat, f+1, c+1, n);
    }
    
    private static boolean diagonalBVacia(){
        return false;
    }
    
    public static void main(String[] args) {
        int n;
        //----------------------------------
        ES.escribe("\n: ");
        n = ES.leeInt();
        ES.escribe("\n");
        //----------------------------------
        nReinas(n);
    }    
}