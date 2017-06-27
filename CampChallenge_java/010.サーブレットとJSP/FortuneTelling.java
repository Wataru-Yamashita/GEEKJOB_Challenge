/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;      //占いの処理に利用
import java.util.Random;    //占いの処理に利用
import javax.servlet.RequestDispatcher;     //JSPを呼び出すため
import org.camp.servlet.ResultData;         //作成したJavaBeans

/**
 *
 * @author wataru
 */
public class FortuneTelling extends HttpServlet {

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
            
            final String result = "/WEB-INF/jsp/FortuneTellingResult.jsp";
            
            String luckList [] = {"大吉", "中吉", "小吉", "吉", "半吉", "末小吉", "凶", "小凶", "半凶", "末凶", "大凶"};
            
            Random rand = new Random();
            
            Integer index = rand.nextInt(luckList.length);
            
            out.print("今日のあなたの運勢は..." + luckList[index] + "です！");
            
            
            //リクエストスコープへ結果を設定
            ResultData data = new ResultData();
            data.setD(new Date());
            data.setLuck(luckList[index]);
            request.setAttribute("DATA", data);

            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request, response);
            
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
