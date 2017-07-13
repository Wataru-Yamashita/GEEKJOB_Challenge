/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.util.ArrayList;

/**
 *
 * @author wataru
 */
public class User extends Human {

    @Override
    public int open() {
        //myCardsの中身の合計値を計算
        int sum = 0;
        for(int i = 0; i < myCards.size(); i++){
            sum += myCards.get(i);
        }
        return sum; //myCardsの中身の合計値を返す
    }

    @Override
    public void setCard(ArrayList<Integer> set) {
        //setの中にdeal,hitの値が入っている
        //setの中身を1つずつmyCardsに入れる
        for(int i = 0; i < set.size(); i++){
            myCards.add(set.get(i));
        }
    }

    @Override
    public boolean checkSum(int sum) {
        return sum < 19; ////myCardsの合計(open)の値が19より小さければtrue
    }
    
}
