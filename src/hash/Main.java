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


        Hash hash = new Hash(2);

        hash.add("Felipe");
        hash.add("Blaise");
        hash.add("Blaise");
        hash.add("Blaise");
       
        hash.dump();


////   Hash hash = new Hash(1024);
////    for(int i=0; i<1024; i++) {
////      hash.add(Integer.toString(i));
////    }
////   
////    hash.dump();




    }
}
