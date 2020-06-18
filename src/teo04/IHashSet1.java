/* IHashSet1.java
 * Autor: profesor Augusto Vega Pinedo
 */

package teo04;

public interface IHashSet1 {
    public boolean add(Object o);
    public boolean addAll(IHashSet1 s);
    public void clear();
    public boolean contains(Object o);
    public boolean containsAll(IHashSet1 s);
    public boolean equals(Object o);
    public boolean isEmpty();
    public boolean remove(Object o);
    public boolean removeAll(IHashSet1 s);
    public boolean retainAll(IHashSet1 s);
    public int size();
    public Iterator iterator();
}