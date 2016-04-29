/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Test {
    public static void main(String[]args){
        Sequence sq1 = new Sequence("test","ATGCATCAAAGGG");


        System.out.println(sq1.getContent());
        System.out.println(sq1.getLength());
        System.out.println(sq1.simpleValidate());
        
        
        

    }
}
