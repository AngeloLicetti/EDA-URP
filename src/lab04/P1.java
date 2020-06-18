/* P1.java
 * Autor: Augusto Vega Pinedo.
 */

package lab04;

public class P1 {
    private static void populate(IHashSet1 s, int n, int inc) {
        for(int i=0; i<n; i++) {
            s.add(new Integer(i + inc));
        }
    }
    
    public static void main(String[] args) {
        IHashSet1 s1 = new HashSet1();
        IHashSet1 s2 = new HashSet1();
        populate(s1, 20, 1);            populate(s2, 30, 10);
        System.out.println(s1.size() + "," + s2.size());
        System.out.println(s1 + "");    System.out.println(s2 + "");
        
        s1.addAll(s2);
        System.out.println(s1.size() + "," + s2.size());
        System.out.println(s1 + "");    System.out.println(s2 + "");
        
        s2.clear();
        System.out.println(s1.size() + "," + s2.size());
        System.out.println(s1 + "");    System.out.println(s2 + "");
        System.out.println(s2.isEmpty() + "");
        
        populate(s1, 20, 1);            populate(s2, 30, 10);
        System.out.println(s1.size() + "," + s2.size());
        System.out.println(s1 + "");    System.out.println(s2 + "");
        System.out.println(s1.containsAll(s2) + "");
        System.out.println(s1.equals(s2) + "");
        
        s1.removeAll(s2);
        System.out.println(s1.size() + "," + s2.size());
        System.out.println(s1 + "");    System.out.println(s2 + "");
        System.out.println(s1.containsAll(s2) + "");
        System.out.println(s1.equals(s2) + "");
        
        s1.addAll(s2);
        s2.addAll(s1);
        System.out.println(s1.size() + "," + s2.size());
        System.out.println(s1 + "");    System.out.println(s2 + "");
        System.out.println(s1.containsAll(s2) + "");
        System.out.println(s1.equals(s2) + "");
    }
}