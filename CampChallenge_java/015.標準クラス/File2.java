/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.io.*;

/**
 *
 * @author wataru
 */
public class File2{
    public static void main(String[] args) throws IOException{
        //ファイルオープン
        File fp = new File("profile.txt");
        
        //FileWriter作成
        FileWriter fw = new FileWriter(fp);
        //書き込み
        fw.write("山下航です。福岡出身です。");

        //クローズ
        fw.close();
        
        //FileReader作成
        FileReader fr = new FileReader(fp);
        //BufferedReader作成
        BufferedReader br = new BufferedReader(fr);
        //1行読み出し
        System.out.println(br.readLine());
        
        //クローズ
        br.close();
    }
}
