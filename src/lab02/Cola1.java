package lab02;
public class Cola1 extends teo01.ListaSecuencial2 implements InterfazCola{
    public Object add(Object o){
        super.add(super.length(), o);
        return o;
    }
    
    public Object front(){
        if(isEmpty()){
            throw new RuntimeException("Cola vacía");
        }
        return super.get(0);
    }
    
    public Object popTail(){
        Object ret = front();
        super.remove(0);
        return ret;
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
