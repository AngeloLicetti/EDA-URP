package lab03;

public class HashTable1 /*implements HashTable1 */{
    private Entry1[] table;
    private int size;
    private final float loadFactor;
    private int threshold;
    private final int DEFAULT_INITIAL_CAPACITY = 16;
    private final float DEFAULT_LOAD_FACTOR=0.75f;
    
    private HashTable1(){
        loadFactor=DEFAULT_LOAD_FACTOR;
        threshold=DEFAULT_INITIAL_CAPACITY;
        table=new Entry1[DEFAULT_INITIAL_CAPACITY];
    }
    
    public HashTable1 (int initialCapacity, float loadFactor) throws java.lang.Exception{
        if(initialCapacity<0){
            throw new Exception("initial capacity < 0");
        }
        if(loadFactor<=0 ){
            throw new Exception("initial capacity < 0");
        }
        int capacity=1;
        while(capacity<initialCapacity){
            capacity<<=1;
        }
        this.loadFactor=loadFactor;
        threshold=(int)(capacity*loadFactor);
        table = new Entry1[capacity];
    }
    
    public HashTable1(int initialCapacity) throws Exception{
        this(initialCapacity, 0.75f);
    }
    
    public void clear(){
        Entry1[] tab=table;
        for(int i=0; i<tab.length; i++){
            tab[i]=null;
        }
        size=0;
    }
    
    public boolean containsKey(Object key){
        Object k=maskNull(key);
        int i = hCode(k, table.length);
        Entry1 e=table[i];
        while(e!=null){
            if(eq(k,maskNull(e.getKey()))){
                return true;
            }
            e=e.getNext();
        }
        return false;
    }
    
    public boolean containsValue(Object value){
        if(value==null){
            return containsNullValue();
        }
        Entry1[] tab=table;
        for(int i=0; i<tab.length; i++){
            for(Entry1 e=table[i]; e!=null; e=e.getNext()){
                if(value.equals(e.getValue())){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    public void putAll(IHashTable t){
        
    }
    
    public Object remove(Object key){
        Entry1 e =removeEntryForKey(key);
        return e==null?e:e.getValue();
    }
    
    public Object get(Object key){
        Object k=maskNull(key);
        int i= hCode(k, table.length);
        Entry1 e=table[i];
        while(true){
            if(e==null){
                return e;
            }
            if(eq(k, maskNull(e.getKey()))){
                return e.getValue();
            }
            e=e.getNext();
        }
    }
    
    public Object put(Object key, Object value){
        Object k=maskNull(key);
        int i=hCode(k, table.length);
        for(Entry1 e=table[i]; e!=null; e=e.getNext()){
            if(eq(k, maskNull(e.getKey()))){
                Object oldValue=e.getValue();
                e.setValue(value);
                return oldValue;
            }
        }
        addEntry(k, value, i);
        return null;
    }
    
    //--------------------------------------------------------------------------
    public String toString(){
        StringBuffer sb = new StringBuffer();
        Entry1[] tab=table;
        for(int i=0; i<tab.length; i++){
            for(Entry1 e=tab[i]; e!=null; e=e.getNext()){
                sb.append(e+" ");
            }
        }
        return sb.toString();
    }
    
    public static final Object NULL_KEY = new Object();
    
    public static Object maskNull(Object key){
        return key==null?NULL_KEY:key;
    }
    
    public static Object unmaskNull(Object key){
        return key==NULL_KEY?null:key;
    }
    
    public int hCode(Object key, int capacity){
        return maskNull(key).hashCode() & (capacity-1);
    }
    
    public boolean containsNullValue(){
        Entry1[] tab=table;
        for(int i=0; i<tab.length; i++){
            for(Entry1 e=tab[i]; e!=null; e=e.getNext()){
                if(e.getValue()==null){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean eq(Object x, Object y){
        return (x==y)||x.equals(y);
    }
    
    public void addEntry(Object key, Object value, int index){
        Entry1 nuevoEntry = new Entry1(key,value);
        nuevoEntry.setNext(table[index]);
        table[index]=nuevoEntry;
        if(size++>=threshold){
            resize(2*table.length);
        }
    }
    
    private void resize(int newCapacity){
        
    }
    
    private Entry1 removeEntryForKey(Object key){
        //Elimina y retorna la entrada asociada copn key en esta tabla
        //Retorna null si la tabla no contiene a key como clave de algun valor
        Object k= maskNull(key);
        int i=hCode(key,table.length);
        Entry1 previous=null;
        for(Entry1 e=table[i]; e!=null; e=e.getNext()){
            if(eq(k, maskNull(e.getKey()))){
                if(e==table[i]){
                    table[i]=e.getNext();
                } else{
                    previous.setNext(e.getNext());
                }
                return e;
            }
            previous=e;
        }
        return null;
    }
}
