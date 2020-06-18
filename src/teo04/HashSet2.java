/* HashSet2.java
 * Autor: profesor Augusto Vega Pinedo.
 */

package teo04;

public class HashSet2
    extends HashSet1
    implements IHashSet2
{
    /*Agrega todos los elementos de s.
     */
    public boolean union(IHashSet1 s) {
        return addAll(s);
    }
    
    /*Hace que los elementos sean �nicamente los que tiene en com�n con s.
     */
    public boolean intersection(IHashSet1 s) {
       return retainAll(s);
    }
    
    /*Elimina todos los elementos que tambi�n contiene s.
     */
    public boolean setDifference(IHashSet1 s) {
        return removeAll(s);
    }
    
    /*Hace que los elementos sean los de �ste m�s los de s, pero menos los
     *comunes a ambos.
     */
    public boolean symmetricDifference(IHashSet1 s) {
        IHashSet1 intersec = new HashSet1();
        intersec.addAll(this);
        intersec.retainAll(s);                                //la intersecci�n
        //uni�n y quitar intersecci�n
        return addAll(s) | removeAll(intersec);
    }
    
    /*Hace que los elementos sean exactamente los de s.
     */
    public void assign(IHashSet1 s) {
        clear();
        addAll(s);
    }
}