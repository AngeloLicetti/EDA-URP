/* HashSet1.java
 * Autor: profesor Augusto Vega Pinedo.
 */

package teo04;

public class HashSet1
    implements IHashSet1
{
    private IHashTable hashTable;
    private static final Object PRESENT = new Object(); 
    
    public HashSet1() {hashTable = new HashTable1();}
    
    public boolean add(Object o) {return hashTable.put(o, PRESENT)==null;}
    
    public void clear() {hashTable.clear();}
    
    public boolean contains(Object o) {return hashTable.containsKey(o);}
    
    public boolean containsAll(IHashSet1 s) {
        Iterator e = s.iterator();
        while(e.hasNext()) {
            if(!contains(e.next())) {
                return false;
            }
        }
        return true;
    }
    
    public boolean equals(Object o) {
        if(o == this) {return true;}
        if(!(o instanceof IHashSet1)) {return false;}
        IHashSet1 c = (IHashSet1) o;
        if(c.size() != size()) {return false;}
        return containsAll(c);
    }
    
    public boolean isEmpty() {return hashTable.isEmpty();}
    
    public boolean remove(Object o) {return hashTable.remove(o)==PRESENT;}
    
    public boolean removeAll(IHashSet1 s) {
        boolean modified = false;
        if(size() > s.size()) {
            for(Iterator i=s.iterator(); i.hasNext(); )
                modified |= remove(i.next());
        } else {
            for(Iterator i=iterator(); i.hasNext(); ) {
                Object key = i.next();
                if(s.contains(key /*i.next()*/)) {
                    //i.remove();
                    remove(key);
                    modified = true;
                }
            }
        }
        return modified;
    }
    
    public boolean retainAll(IHashSet1 s) {
        boolean modified = false;
        Iterator e = iterator();
        while(e.hasNext()) {
            Object key = e.next();
            if(!s.contains(key/*e.next()*/)) {
                //e.remove();
                remove(key);
                modified = true;
            }
        }
        return modified;
    }
    
    public boolean addAll(IHashSet1 s) {
        boolean modified = false;
        Iterator e = s.iterator();
        while(e.hasNext()) {
            if(add(e.next())) {
                modified = true;
            }
        }
        return modified;
    }
    
    public int size( ) {
        return hashTable.size();
    }
    
    public Iterator iterator() {
        return hashTable.keyIterator();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        Iterator i = iterator();
        boolean b = true;
        while(i.hasNext()) {
            if(b) {
                sb.append(i.next());
                b = false;
            } else {
                sb.append("," + i.next());
            }
        }
        sb.append(']');
        return sb.toString();
    }
}