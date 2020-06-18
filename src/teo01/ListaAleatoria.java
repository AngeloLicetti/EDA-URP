/*Lista aleatoria */
package teo01;
public class ListaAleatoria {
    private Object lista[];
    private int size;
    
    public ListaAleatoria(int capacidad){
        lista = new Object[capacidad];
        size = 0;
    }
    
    public ListaAleatoria(){
        this(1024);
    }
    
    //implementacion de operadores:
    
    public void add(int index, Object o){
        if(index<0 || index>size){
            throw new IllegalArgumentException("index<0 || index>size");
        }
        if(isEmpty()){//está vacía
            lista[index] = o;
        } else if(index==0){//insertar al comienzo
            moveR(index);
            lista[index] = o;
        } else if(index==size){//insertar al final
            lista[index] = o;
        } else{//eliminar por el medio
            moveR(index);
            lista[index] = o;
        }
        size++;
    }
    
    public void remove(int index){
        if(index<0 || index>(size-1)){
            throw new IllegalArgumentException("index<0 || index>(size-1)");
        }
        if(index==0){//eliminar al comienzo
            moveL(index);
        } else if(index==size-1){//eliminar al final
            //nada
        } else{//eliminar por el medio
            moveL(index);
        }
        size--;
    }
    
    public int indexOf(Object o){
        int i;
        for(i=0; i<size; i++){
            if(o.toString().equals(lista[i].toString())){
                break;
            }
        }
        return i==size?-1:i;
    }
    
    public Object get(int index){
        if(index<0 || index>(size-1)){
            throw new IllegalArgumentException("index<0 || index>(size-1)");
        }
        return lista[index];
    }
    
    public void clear(){
        size=0;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public int length(){
        return size;
    }
    
    //publicos que no son operadores
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i=0; i<size; i++){
            if(i!=0){
                sb.append("," + lista[i]);
            } else{
                sb.append(lista[i] + "");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    //-----------------------------------
    
    private void moveR(int top){
        for(int i=size; i>top; i--){
            lista[i] = lista[i-1];
        }
    }
    
    private void moveL(int top){
        for(int i=top; i<(size-1); i++){
            lista[i] = lista[i+1];
        }
    }
}
