/*Nodo */
package teo01;
public class Nodo {
    private Object e;
    private Nodo sig;
    
    public Nodo(Object e){
        setE(e);
    }
    
    public Object getE(){
        return e;
    }
    
    public void setE(Object e){
        this.e = e;
    }
    
    public Nodo getSig(){
        return sig;
    }
    
    public void setSig(Nodo sig){
        this.sig = sig;
    }
    
    public String toString(){
        return e + "";
    }
}