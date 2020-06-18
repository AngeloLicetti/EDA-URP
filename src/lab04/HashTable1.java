/* HashTable1.java
 * Autor: profesor Augusto Vega Pinedo
 * Descripci�n: Las claves deben implementar los m�todos: hash, equals.
 */

package lab04;

public class HashTable1
    implements IHashTable
{
    private Entry1 table[];
    private int size;
    private final float loadFactor;
    private int threshold;
    
    private final int DEFAULT_INITIAL_CAPACITY = 16;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    
    public HashTable1() {
        loadFactor = DEFAULT_LOAD_FACTOR;
        threshold = DEFAULT_INITIAL_CAPACITY;
        table = new Entry1[DEFAULT_INITIAL_CAPACITY];
    }
    public HashTable1(int initialCapacity, float loadFactor) {
        if(initialCapacity < 0) {
            throw new IllegalArgumentException(
                    "Illegal initial capacity: " + initialCapacity );
        }
        if(loadFactor <= 0 || loadFactor > 1) {
            throw new IllegalArgumentException(
                    "Illegal load factor: " + loadFactor);
        }
        //Encuentra una potencia de 2 >= initialCapacity
        int capacity = 1;
        while(capacity < initialCapacity) {
            capacity <<= 1;
        }
        this.loadFactor = loadFactor;
        threshold = (int)(capacity * loadFactor);
        table = new Entry1[capacity];
    }
    public HashTable1(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    public void clear() {
        Entry1 tab[] = table;
        for (int i = 0; i < tab.length; i++) {
            tab[i] = null;
        }
        size = 0;
    }
    
    public boolean containsKey(Object key) {
        Object k = maskNull(key);
        int i = hCode(k, table.length);//c�digo hash//<-OjO
        Entry1 e = table[i];
        while(e != null) {
            if(eq(k, maskNull(e.getKey()))) {//<-OjO
                return true;
            }
            e = e.getNext();
        }
        return false;
    }
    
    public boolean containsValue(Object value) {
        if (value == null) {
            return containsNullValue();
        }
        Entry1 tab[] = table;
        for(int i=0; i<tab.length; i++) {
            for(Entry1 e=tab[i]; e!=null; e=e.getNext()) {
                if(value.equals(e.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public Object get(Object key) {
        Object k = maskNull(key);
        int i = hCode(k, table.length);//c�digo hash//<-OjO
        Entry1 e = table[i];
        while(true) {
            if(e == null) {
                return e;
            }
            if(eq(k, maskNull(e.getKey()))) {//<-OjO
                return e.getValue();
            }
            e = e.getNext();
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public Object put(Object key, Object value) {
        Object k = maskNull(key);
        int i = hCode(k, table.length);//c�digo hash
        
        for(Entry1 e=table[i]; e!=null; e=e.getNext()) {
            if(eq(k, maskNull(e.getKey()))) {
                Object oldValue = e.getValue();
                e.setValue(value);
                return oldValue;
            }
        }
        
        addEntry(k, value, i);
        return null;
    }
    
    public void putAll(IHashTable t) {
    }
    
    public Object remove(Object key) {
        Entry1 e = removeEntryForKey(key);
        return (e == null ? e : e.getValue());
    }
    
    public int size() {
        return size;
    }
    
    private Iterator keyIterator;
    public Iterator keyIterator() {
        if(keyIterator != null) {
            keyIterator.reset();
            return keyIterator;
        } else {
            return keyIterator = new Iterator() {
                private int i;
                private Entry1 next;
                private Entry1 previous;
                {   reset();
                }
                /*Retorna true si todav�a hay un siguiente por entregar
                 */
                public boolean hasNext() {
                    return next!=null;
                }
                /*Entrega el siguiente
                */
                public Object next() {
                    previous = next;
                    if(next == null) {
                        return next;
                    }
                    Object key = next.getKey();
                    updateINext();
                    return key;
                }
                
                public void remove() {//quita previous
                    if(next == table[i]) {
                        table[i] = next.getNext();
                    } else {
                        previous.setNext(next.getNext());
                        next = next.getNext();
                    }
                    //rectifica next e i
                    if(next == null) {
                        while(++i<table.length) {
                            next = table[i];
                            if(next != null) {
                                break;
                            }
                        }
                    }

                    size--;
                }
                
                public void reset() {
                    next = null;
                    for(i=0; i<table.length; i++) {
                        next = table[i];
                        if(next != null) {
                            break;
                        }
                    }
                }
                ///////////////////////////////////////////////////////////////
                void updateINext() {
                    if(next.getNext() != null) {
                        next = next.getNext();
                    } else {
                        while(++i<table.length) {
                            next = table[i];
                            if(next != null) {
                                break;
                            }
                        }
                    }
                }
            };
        }
    }
    
    
    private Iterator valueIterator;
    public Iterator valueIterator() {
        return null;//IMPLEMENTARLA DESPU�S
    }
    ////////////////////////////////////////////////////////////////////////////
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Entry1 tab[] = table;
        for(int i=0; i<tab.length; i++) {
            for(Entry1 e=tab[i]; e!=null; e=e.getNext()) {
                sb.append(e + " ");
            }
        }
        return sb.toString();

    }
    
    public static final Object NULL_KEY = new Object();
    
    public static Object maskNull(Object key)  {
        return (key == null ? NULL_KEY : key);
    }
    
    public static Object unmaskNull(Object key) {
        return (key == NULL_KEY ? null : key);
    }
    
    private boolean containsNullValue() {
        Entry1 tab[] = table;
        for(int i=0; i<tab.length; i++) {
            for(Entry1 e=tab[i]; e!=null; e=e.getNext()) {
                if (e.getValue() == null) {
                    return true;
                }
            }
        }
        return false;
    }    
    ////////////////////////////////////////////////////////////////////////////
    
    private int hCode(Object k, int capacity) {
        //System.out.println(maskNull(k).hashCode() & (capacity - 1));
        return maskNull(k).hashCode() & (capacity - 1);
//        return capacity % k.hashCode();
    }
    
    private static boolean eq(Object x, Object y ) {
        return x == y || x.equals(y);
    }
    
    private void addEntry(Object key, Object value, int index) {
        Entry1 newEntry = new Entry1(key, value);
        newEntry.setNext(table[index]);
        table[index] = newEntry;
        if(size++ >= threshold) {
            resize(2 * table.length);
        }
    }
    
    private void resize(int newCapacity) {
        //nuevaCapacidad debe ser una potencia de 2
        Entry1[] oldTable = table;
        int oldCapacity = oldTable.length;
        
        //chequea por si es necesario
        if(size < threshold  ||  oldCapacity > newCapacity) {
            return;
        }
        
        Entry1[] newTable = new Entry1[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }
    
    private void transfer(Entry1[] newTable)  {
        Entry1[] src = table;
        int newCapacity = newTable.length;
        for(int j=0; j<src.length; j++) {
            Entry1 e = src[j];
            if(e != null) {
                src[j] = null;
                do {
                    Entry1 next = e.getNext();
                    int i = hCode(e.getKey(), newCapacity);//c�digo hash
                    e.setNext(newTable[i]);
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }
    
    private Entry1 removeEntryForKey(Object key) {
        //Elimina y retorna la entrada asociada con key en esta tabla.
        //Retorna null si la tabla no contiene a key como clave de alg�n valor
        Object k = maskNull(key);
        int i = hCode(k, table.length);//c�digo hash//<-OjO
        Entry1 previous = null;
        for(Entry1 e=table[i]; e!=null; e=e.getNext()) {
            if(eq(k, maskNull(e.getKey()))) {
                if(e == table[i]) {
                    table[i] = e.getNext();
                } else {
                    previous.setNext(e.getNext());
                }
                size--;
                return e;
            }
            previous = e;
        }
        return null;
    }
}