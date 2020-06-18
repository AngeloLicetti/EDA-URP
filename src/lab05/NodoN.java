/*NodoN.java
 */
package lab05;
public class NodoN {
    private Object e;
    private NodoN hij, her;
    public NodoN(Object e){
        setE(e);
    }
    
    public void setE(Object e){
        this.e = e;
    }
    
    public Object getE(){
        return e;
    }
    
    public void setHer(NodoN her){
        this.her = her;
    }
    
    public NodoN getHer(){
        return her;
    }
    
    public void setHij(NodoN hij){
        this.hij = hij;
    }
    
    public NodoN getHij(){
        return hij;
    }
}
