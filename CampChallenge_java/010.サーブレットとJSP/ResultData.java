/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author wataru
 */


public class ResultData implements Serializable {
    
    //フィールドを隠匿(カプセル化)
    private Date d;
    private String luck;
    
    //publicで引数なしのコンストラクタ
    public ResultData() {}
    
    //JSPからゲットする  
    public Date getD() {
        return d;
    }
    
    //サーブレットからセットする
    public void setD(Date d) {
        this.d = d;
    }
    
    public String getLuck() {
        return luck;
    }
    
    public void setLuck(String luck) {
        this.luck = luck;
    }    
    
}