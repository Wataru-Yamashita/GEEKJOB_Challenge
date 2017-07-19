/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author wataru
 */
public class File3 {
    public static void main(String[] args) throws IOException{
        File fp = new File("log.txt");
        FileWriter fw = new FileWriter(fp);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        //現在時刻の取得
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Mathクラスの定義
        double a = 2;
        double b = 6;
        double c = Math.pow(a, b);
        //ファイルへの書き込み
        pw.println(sdf.format(now) + "開始");
        pw.println(a + "の" + b + "乗は" + c + "です");
        pw.println(sdf.format(now) + "終了");
        pw.close();
        //FileReader作成
        FileReader fr = new FileReader(fp);
        //BufferedReader作成
        BufferedReader br = new BufferedReader(fr);
        //1行読み出し
        String str;
        while((str = br.readLine()) != null){
            System.out.println(str);
        }
        
        //クローズ
        br.close();
    }
    
}
