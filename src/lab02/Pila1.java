/*Pila1*/
package lab02;
public class Pila1 extends teo01.ListaSecuencial2 implements InterfazPila{
    public Object peek(){
        if(isEmpty()){
            throw new RuntimeException("Pila vacía");
        }
        return super.get(super.length()-1);
    }
    
    public Object pop(){
        Object ret = peek();
        super.remove(super.length()-1);
        return ret;
    }
    
    public Object push(Object o){
        super.add(super.length(), o);
        return o;
    }
    
    //ANULA:
    
    public void add(int index, Object o){
        throw new java.lang.UnsupportedOperationException();
    }
    
    public void remove(int index){
        throw new java.lang.UnsupportedOperationException();
    }
    
    public int indexOf(Object o){
        throw new java.lang.UnsupportedOperationException();
    }
    
    public Object get(int index){
        throw new java.lang.UnsupportedOperationException();
    }
    
    public int length(){
        throw new java.lang.UnsupportedOperationException();
    }
}
