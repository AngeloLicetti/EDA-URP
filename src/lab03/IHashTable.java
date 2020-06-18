package lab03;
public interface IHashTable {
    public void clear();
    public boolean containsValue(Object value);
    public boolean containsKey(Object key);
    public Object get(Object key);
    public boolean isEmpty();
    public Object put(Object key, Object value);
    public void putAll(IHashTable t);
}
