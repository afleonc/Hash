/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author azathoth
 */
public class Hash2 {
    
 String[] t;
 
    public Hash2(int taille) {
        if (taille > 0) {
            if (taille != Integer.highestOneBit(taille)) {
                t = new String[Integer.highestOneBit(taille) << 1];
            } else {
                t = new String[Integer.highestOneBit(taille)];
            }
        } else {
            throw new IllegalArgumentException("Value not valid");
        }
    }
    
     private int testElement2(String newChain) {
        //Méthode testElement avec l'opération bit
        int i;
        int startPoint;
        if (newChain != null) {
            i = newChain.hashCode() & (t.length - 1);//newChain.hashCode() % t.length;

            //x % 2n == x & (2n - 1)
            startPoint = newChain.hashCode() & (t.length - 1);
        } else {
            i = 0;
            startPoint = 0;
        }
        while (t[i] != newChain) {
            i = (i + 1) & (t.length - 1);
            if (i == startPoint) {
                return -1;
            }

        }

        return i;
    }

    public boolean contains2(String newChain) {
//Méthode contains réfactorée
        if (testElement2(newChain) == -1) {
            return false;
        } else {
            return true;
        }

    }

    public void add2(String newChain) {
        int a = testElement2(null);
        //On vérifie qu'il y ait de la place
        int b = testElement2(newChain);
        //On vérfifie que notre liste ne contient pas l'élément
        if (a != -1 & b == -1) {
            this.t[a] = newChain;
        }

    }

  public Hash2 dump() {
        int i = 0;
        while (i < this.t.length) {
            System.out.println(t[i]);
            i++;
        }
        return this;
    }
}


