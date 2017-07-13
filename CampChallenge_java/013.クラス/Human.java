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
abstract public class Human {
    
    abstract public int open();
    abstract public void setCard(ArrayList<Integer> set);
    abstract public boolean checkSum(int sum1);
    ArrayList<Integer> myCards = new ArrayList<Integer>();
    
}
