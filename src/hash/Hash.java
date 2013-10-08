/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author tmpetu05
 */
public class Hash {

    String[] t;

    public Hash(int taille) {
        int tryOne = taille & (taille - 1);
        if (tryOne == 0 && taille > 0) {
            // System.out.println("vrai");
            t = new String[taille];
        } else {
            throw new IllegalArgumentException("Value not valid");
        }
    }

    public void add(String newChain) {
        int i = newChain.hashCode() % t.length;
        while (t[i] != null&&t[i]!=newChain) {
            i = (i + 1) % t.length;
            if (i == newChain.hashCode() % t.length) {
                throw new IllegalStateException("Table is full");
            }
            
        }
        t[i] = newChain;

    }

    public String[] dump() {
        int i = 0;
        while (i < this.t.length) {
            System.out.println(t[i]);
            i++;
        }
        return t;
    }

    /*   @Override
     public StringBuilder toString() {
     System.out.println(i);
          
     while(i<this.t.length)
     {
            
     }
     return "Hash{" + "t=" + t + '}';
     }*/
}
