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

    private String[] t;

    public Hash(int taille) {
    //Ancienne version du constructeur
        int tryOne = taille & (taille - 1);
        if (tryOne == 0 && taille > 0) {
            // System.out.println("vrai");
            t = new String[taille];
        } else {
            throw new IllegalArgumentException("Value not valid");
        }
    
    //Nouvelle version du constructeur
      /*   if (taille > 0) {
            if (taille != Integer.highestOneBit(taille)) {
                t = new String[Integer.highestOneBit(taille) << 1];
            } else {
                t = new String[Integer.highestOneBit(taille)];
            }
        } else {
            throw new IllegalArgumentException("Value not valid");
        }*/
    }


    public int testElement(String newChain){
       int startPoint = newChain.hashCode() % t.length;
       int i = startPoint;
        while (t[i]!=null && !t[i].equals(newChain)) {
            i = (i + 1) % t.length;
            if (i == startPoint) {
                return -1;
            }
        }
        if(t[i]==null){
            return i + t.length;
        }
        return i;
    }
    
    public void add(String newChain) {
        if (testElement(newChain)==-1){
            throw new IllegalStateException("The table is full");
        }else{
            if(testElement(newChain)>t.length){
                t[testElement(newChain)-t.length] = newChain;
            }else{
                System.out.println(testElement(newChain));
                t[testElement(newChain)] = newChain;
            }
        }
    }
        
    public boolean contains(String newChain){
        if (testElement(newChain)==-1){
            return false;
        }else{
            if(testElement(newChain)>t.length){
                return false;
            }else{
                return true;
            }
        }
    }
    
            /*
    private int testElement(String newChain) {
        //Méthode testElement avec l'opérateur %
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
    }*/
    /*
    public boolean contains2(String newChain) {
        
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
*/
 public Hash dump() {
        int i = 0;
        while (i < this.t.length) {
            System.out.println(t[i]);
            i++;
        }
        return this;
    }

}
