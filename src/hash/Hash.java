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
    //Ancienne version du constructeur
      /*  int tryOne = taille & (taille - 1);
        if (tryOne == 0 && taille > 0) {
            // System.out.println("vrai");
            t = new String[taille];
        } else {
            throw new IllegalArgumentException("Value not valid");
        }*/
    
    //Nouvelle version du constructeur
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
    
    public boolean contains(String newChain) {
        int i = newChain.hashCode() % t.length;
        while (t[i] != newChain) {
            i = (i + 1) % t.length;
            if (i == newChain.hashCode() % t.length) {
                throw new IllegalStateException("Chain Not Found");
            }
            
        }
        
        return true;
    }
    
    private int testElement(String newChain) {
        int i;
        int startPoint;
        if (newChain != null) {
            i = newChain.hashCode() % t.length;
            startPoint = newChain.hashCode() % t.length;
        } else {
            i = 0;
            startPoint = 0;
        }
        while (t[i] != newChain) {
            i = (i + 1) % t.length;
            if (i == startPoint) {
                return -1;
            }
            
        }
        
        return i;
    }
    
    public boolean contains2(String newChain) {
        
        if (testElement(newChain) == -1) {
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
