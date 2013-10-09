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

        int startPoint = newChain.hashCode() & (t.length - 1);
        int i = startPoint;
        while (t[i] != null && !t[i].equals(newChain)) {
            i = (i + 1) & (t.length - 1);
            if (i == startPoint) {
                return -1;
            }
        }
        return i;

    }

    public boolean contains(String newChain) {
        if (newChain != null) {
            if (testElement(newChain) == -1) {
                return false;
            } else {
                if (t[testElement(newChain)] == null) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        throw new NullPointerException();

    }

    public void add(String newChain) {
        if (testElement(newChain) == -1) {
            throw new IllegalStateException("The table is full");
        } else {
            if (nb_elem == this.t.length / 2) {
                this.redim();
            }
            t[testElement(newChain)] = newChain;
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
            if (hash.t[i] != null) {
                add(hash.t[i]);
            }
            i++;
        }

    }

    public void redim() {
//Version refactorée de redim
        Hash2 newHash = new Hash2(this.t.length + 1);
        newHash.addAll(this);
        this.t = newHash.t;


    }

    public String dump() {
        int i = 0;
        while (i < this.t.length) {
            System.out.println(t[i]);
            i++;
        }
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int i = 0;
        while (i < t.length - 1) {
            if (t[i] != null) {
                builder.append(t[i]);
                if (t[i + 1] != null) {
                    builder.append(", ");
                }
            }
            i++;
        }
        if (t[i] != null) {
            builder.append(t[t.length - 1]);
        }
        builder.append("]");
        return builder.toString();
    }

    public boolean intersect(Hash2 hash) {
        int i = 0;
        if (this.t.length < hash.t.length) {
            while (i < this.t.length) {
                if (this.t[i] != null) {
                    if (hash.contains(this.t[i])) {
                        return true;
                    }
                }
                i++;
            }
            return false;
        } else {
            while (i < hash.t.length) {
                if (hash.t[i] != null) {
                    if (this.contains(hash.t[i])) {
                        return true;
                    }
                }
                i++;
            }
            return false;
        }
    }
}
