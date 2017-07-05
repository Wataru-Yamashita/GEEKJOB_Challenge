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
class Human{    
    //パブリックな2つの変数
    public String name;
    public int age;    
    //2つの変数に値を設定するパブリックなメソッド
    public void setHuman(String n, int a){
        this.name = n;
        this.age = a;
    }    
    //2つの変数の中身をプリントするパブリックなメソッド
    public void print(){
        System.out.println(this.name);
        System.out.println(this.age);
    }    
}

public class Class1 {

    public static void main(String[] args){        
        //Humanクラスのインスタンス生成
        Human hito = new Human();
        //hitoインスタンスのsetHumanメソッドを利用
        hito.setHuman("山下航", 26);
        //hitoインスタンスのprintメソッドを利用
        hito.print();
    }
    
}
