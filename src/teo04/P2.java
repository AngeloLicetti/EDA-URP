/* P2.java
 * Autor: profesor Augusto Vega Pinedo.
 */

package teo04;

public class P2 {
    private static void populate(IHashSet1 s, int n, int inc) {
        for(int i=0; i<n; i++) {
            s.add(new Integer(i + inc));
        }
    }
    public static void main(String[] args) {
        IHashSet2 s1 = new HashSet2();
        IHashSet2 s2 = new HashSet2();
        
        populate(s1, 20, 1);            populate(s2, 30, 10);
        System.out.println(s1 + "");    System.out.println(s2 + "");
        s1.union(s2);
        System.out.println(s1 + "");    System.out.println(s2 + "");
        s1.clear();                     s2.clear();

        populate(s1, 20, 1);            populate(s2, 30, 10);
        s1.intersection(s2);
        System.out.println(s1 + "");    System.out.println(s2 + "");
        s1.clear();                     s2.clear();

        populate(s1, 20, 1);            populate(s2, 30, 10);
        s1.setDifference(s2);
        System.out.println(s1 + "");    System.out.println(s2 + "");
        s1.clear();                     s2.clear();

        populate(s1, 20, 1);            populate(s2, 30, 10);
        s1.symmetricDifference(s2);
        System.out.println(s1 + "");    System.out.println(s2 + "");
        s1.clear();                     s2.clear();

        populate(s1, 20, 1);            populate(s2, 30, 10);
        s1.assign(s2);
        System.out.println(s1 + "");    System.out.println(s2 + "");
        s1.clear();                     s2.clear();
    }
}