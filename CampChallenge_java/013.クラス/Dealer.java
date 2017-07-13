/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author wataru
 */
public class Dealer extends Human{
    
    
    ArrayList<Integer> cards = new ArrayList<Integer> ();
    Random rand = new Random();
        
    public Dealer(){    
        //1~13のカードを順に格納する処理を4回繰り返す
        for(int i = 0; i < 4; i++){
            //1から13のカードを順に格納、ジャック以上なら10を格納
            for(int j = 1; j <= 13; j++){
                if(j < 11){
                    cards.add(j);
                }else{
                    cards.add(10);
                }
            }
        }
    }
    
    public ArrayList<Integer> deal(){
        ArrayList<Integer> dealcards = new ArrayList<Integer> ();
        //cardsからランダムに2枚引いてdealcardsに格納
        for(int i = 0; i < 2; i++){
            int index = rand.nextInt(cards.size());
            dealcards.add(cards.get(index));
            cards.remove(index);
        }
        return dealcards;
    }
    
    public ArrayList<Integer> hit(){
        ArrayList<Integer> hitcard = new ArrayList<Integer> ();
            int index = rand.nextInt(cards.size());
            hitcard.add(cards.get(index));
            cards.remove(index);
        return hitcard;
    }

    @Override
    public int open(){
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
    public boolean checkSum(int sum){
        return sum < 17; //myCardsの合計(open)の値が17より小さければtrueを返す
    }
    
    
    


}
