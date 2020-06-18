/* IHashSet2.java
 * Autor: profesor Augusto Vega Pinedo
 */

package teo04;

public interface IHashSet2
    extends IHashSet1
{
    /*Agrega todos los elementos de s.
     */
    public boolean union(IHashSet1 s);
    /*Hace que los elementos sean �nicamente los que tiene en com�n con s.
     */
    public boolean intersection(IHashSet1 s);
    /*Elimina todos los elementos que tambi�n contiene s.
     */
    public boolean setDifference(IHashSet1 s);
    /*Hace que los elementos sean los de �ste m�s los de s, pero menos los
     *comunes a ambos.
     */
    public boolean symmetricDifference(IHashSet1 s);
    /*Hace que los elementos sean exactamente los de s.
     */
    public void assign(IHashSet1 s);
}