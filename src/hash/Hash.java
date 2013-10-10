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
        return i;
    }
    
    public void add(String newChain) {
        if (testElement(newChain)==-1){
            throw new IllegalStateException("The table is full");
        }else{
            t[testElement(newChain)] = newChain;
        }
    }
        
    public boolean contains(String newChain){
        if (testElement(newChain)==-1){
            return false;
        }else{
            if(t[testElement(newChain)]==null){
                return false;
            }else{
                return true;
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int i=0;
        while(i<t.length-1){
            if(t[i]!=null){
                builder.append(t[i]);
                if (t[i + 1] != null) {
                    builder.append(", ");
                }
            }
            i++;
        }
        if(t[i]!=null){
            builder.append(t[t.length-1]);
        }
        builder.append("]");
        return builder.toString();
    }
    
            
     
    public Hash dump() {
        int i = 0;
        while (i < this.t.length) {
            System.out.println(t[i]);
            i++;
        }
        return this;
    }
}
