/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

/**
 *
 * @author wataru
 */
public class MOJI3 {
    public static void main(String[] args){
        //置換前
        String word = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        System.out.println(word);
        word = word.replace("U", "う");
        word = word.replace("I", "い");
        //置換後
        System.out.println(word);
    }
}
