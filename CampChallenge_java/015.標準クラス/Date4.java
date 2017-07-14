/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author wataru
 */
public class Date4 {
    public static void main(String[] args){
        Calendar ganjitsu = Calendar.getInstance();
        Calendar oomisoka = Calendar.getInstance();
        
        ganjitsu.set(2015, 0, 1, 0, 0, 0);
        oomisoka.set(2015, 11, 31, 23, 59, 59);
        
        Date g = ganjitsu.getTime();
        Date o = oomisoka.getTime();
        
        long ts_g = g.getTime();
        long ts_o = o.getTime();
        
        System.out.println(g);
        System.out.println(ts_g);
        
        System.out.println(o);
        System.out.println(ts_o);
        
        long hiku = ts_o - ts_g;
        System.out.println("差は" + hiku);
    }
}
