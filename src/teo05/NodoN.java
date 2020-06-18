/*NodoN.java
 */
package teo05;
public class NodoN {
    private Object e;
    private NodoN hij;
    private NodoN her;
    
    public NodoN(Object e){
        setE(e);
    }
    
    public void setE(Object e){
        this.e = e;
    }
    
    public Object getE(){
        return e;
    }
    
    public void setHij(NodoN hij){
        this.hij = hij;
    }
    
    public NodoN getHij(){
        return hij;
    }
    
    public void setHer(NodoN her){
        this.her = her;
    }
    
    public NodoN getHer(){
        return her;
    }
    
    public String toString(){
        return e + "";
    }
}
