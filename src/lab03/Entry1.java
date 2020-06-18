package lab03;
public class Entry1 {
    private Object key;
    private Object value;
    private Entry1 next;
    
    Entry1(Object key, Object value){
        this.key=key;
        this.value=value;
    }
    
    Object getKey(){
        return HashTable1.unmaskNull(key);
    }
    
    Object getValue(){
        return value;
    }
    
    Object setValue(Object newValue){
        Object oldValue=value;
        value=newValue;
        return oldValue;
    }
    
    Entry1 getNext(){
        return next;
    }
    
    void setNext(Entry1 next){
        this.next=next;
    }
    
    public String toString(){
        return getKey() + "=" + getValue();
    }
}
