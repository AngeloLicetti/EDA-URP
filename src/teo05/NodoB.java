/*NodoB.java
 */
package teo05;
public class NodoB {
    private Object e;
    private NodoB i, d;
    
    public NodoB(Object e){
        setE(e);
    }
    
    public Object getE(){
        return e;
    }
    
    public void setE(Object e){
        this.e = e;
    }
    
    public NodoB getD(){
        return d;
    }
    
    public void setD(NodoB d){
        this.d = d;
    }
    
    public NodoB getI(){
        return i;
    }
    
    public void setI(NodoB i){
        this.i = i;
    }
    
    public String toString(){
        return e + "";
    }
}
