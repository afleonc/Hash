/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author tmpetu05
 */
public class Main {

    public static void main(String[] args) {
        Hash2 hash = new Hash2(1);
        Hash2 hash2 = new Hash2(1);
        for (int i = 0; i < 1024; i += 2) {
            hash.add(Integer.toString(i));
            hash2.add(Integer.toString(i + 1));
        }
        hash.add("hell");
        hash2.add("hell");
        System.out.println(hash2.intersect(hash));
    }
}
