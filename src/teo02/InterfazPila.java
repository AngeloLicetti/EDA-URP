package teo02;

public interface InterfazPila extends teo01.InterfazLista {
    public void clear();
    public boolean isEmpty();
    public Object peek();
    public Object pop();
    public Object push(Object o);
}
