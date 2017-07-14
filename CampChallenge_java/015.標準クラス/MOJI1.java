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
public class MOJI1 {
    public static void main(String[] args){
        String name = "山下航";
        System.out.println(name);
        //文字列のバイト数を取得
        System.out.println("バイト数は" + name.getBytes().length);
        //文字列の長さを取得
        System.out.println("文字数は" + name.length());
    }
}
