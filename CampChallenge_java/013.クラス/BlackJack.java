/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wataru
 */
public class BlackJack extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            Dealer dealer = new Dealer(); //Dealerクラスのインスタンス生成
            User user = new User();       //Userクラスのインスタンス生成
            
            out.print(dealer.cards + "<br><br>"); //山札の初期状態
            
            //ディーラーが最初の2枚を引く
            dealer.setCard(dealer.deal());
            out.print("ディーラーが最初に引いた2枚は" + dealer.myCards + "<br>");
            out.print(dealer.cards + "<br>");
            out.print("現在の合計は" + dealer.open() + "<br><br>");
            //ユーザーが最初の2枚を引く
            user.setCard(dealer.deal());
            out.print("ユーザーが最初に引いた2枚は" + user.myCards + "<br>");
            out.print(dealer.cards + "<br>");
            out.print("現在の合計は" + user.open() + "<br><br>");
            //ユーザーはバストしない範囲で好きなだけhitする(今回は19以上で打ち止め)
            while(user.checkSum(user.open())){
                user.setCard(dealer.hit());
                out.print("ユーザーの手持ちは" + user.myCards + "<br>");
                out.print(dealer.cards + "<br>");
                out.print("現在の合計は" + user.open() + "<br><br>");
            }
            
            if(user.open() > 21){
                out.print("バスト！ユーザーの負けです！<br><br>");
            }else{
            //ディーラーは手が17以上になるまでhitしなければならない
                while(dealer.checkSum(dealer.open())){
                    dealer.setCard(dealer.hit());
                    out.print("ディーラーの手持ちは" + dealer.myCards + "<br>");
                    out.print(dealer.cards + "<br>");
                    out.print("現在の合計は" + dealer.open() + "<br><br>");
                }

                if(dealer.open() > 21){
                    out.print("バスト！ディーラーの負けです！<br><br>");
                }else{
                    if(dealer.open() > user.open()){
                        out.print("ディーラーの勝ちです！");
                    }else if(dealer.open() == user.open()){
                        out.print("引き分けです！");
                    }else{
                        out.print("ユーザーの勝ちです！");
                    }
                }
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
