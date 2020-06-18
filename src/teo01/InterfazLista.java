package teo01;

public interface InterfazLista {
    public void add(int index, Object o);
    public void remove(int index);
    public int indexOf(Object o);
    public Object get(int index);
    public void clear();
    public boolean isEmpty();
    public int length();
}
