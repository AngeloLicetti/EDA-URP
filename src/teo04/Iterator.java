/* Iterator.java
 * Autor: profesor Augusto Vega Pinedo.
 */

package teo04;

public interface Iterator {
    public boolean hasNext();
    public Object next();
    public void remove();
    public void reset();
}