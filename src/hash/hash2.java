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

    private String[] t;
    private int nb_elem;

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

    private int testElement(String newChain) {
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

    public boolean contains(String newChain) {
//Méthode contains réfactorée
        if (testElement(newChain) == -1) {
            return false;
        } else {
            return true;
        }

    }

    public void add(String newChain) {
        int a = testElement(null);
        //On vérifie qu'il y ait de la place
        int b = testElement(newChain);
        //On vérfifie que notre liste ne contient pas l'élément
        if (a != -1 & b == -1) {
            if (nb_elem == this.t.length / 2) {
                this.redim();
            }
            this.t[a] = newChain;
            this.nb_elem++;
        }

    }

////    public void redim() {
////        /*     System.out.println("Redim");
////        System.out.println(t.length << 1);*/
////
////        String[] t_tmp = new String[t.length << 1];
////        //this=new Hash2(t.length+1);
////        int i = 0;
////        while (i < t.length) {
////            t_tmp[i] = t[i];
////            i++;
////        }
////        t = t_tmp;
////
////    }
    public void addAll(Hash2 hash) {
//Version refactorée de addAll
        int i = 0;
        while (i < hash.t.length) {
            this.add(hash.t[i]);
            i++;
        }

    }

  

    public void redim() {
//Version refactorée de redim
        Hash2 newHash = new Hash2(this.t.length + 1);

        newHash.addAll(this);
        
        this.t=newHash.t;


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
