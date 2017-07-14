/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author wataru
 */
public class Date3 {
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        //2016/11/04/10:00:00をCalendarに設定
        c.set(2016, 10, 4, 10, 0, 0);
        //CalendarをDateに変換
        Date d = c.getTime();
        System.out.println(d);
        System.out.println(d.getTime());
        //年-月-日 時:分:秒にフォーマット
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d));
    }
}
