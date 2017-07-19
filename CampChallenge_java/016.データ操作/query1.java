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
public class query1 extends HttpServlet {

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
            
            //クエリストリングから総額、個数、商品種別を取得
            String total = request.getParameter("total");
            String count = request.getParameter("count");
            String type = request.getParameter("type");
            
            //Stringからint型への型変換
            int t = Integer.parseInt(total);
            int c = Integer.parseInt(count);
            
            out.print("商品種別：");
            switch (type) {
                case "1":
                    out.print("雑貨<br>");
                    break;
                case "2":
                    out.print("生鮮食品<br>");
                    break;
                default:
                    out.print("その他<br>");
                    break;
            }
            out.print("総額：" + t + "円<br>");
            out.print("個数：" + c + "個<br>");
            out.print("1個あたりの値段：" + t/c + "円<br>");
            
            out.print("取得ポイント：");
            if(t >= 5000){
                out.print(t * 0.05);
            }else if(t >= 3000){
                out.print(t * 0.04);
            }else{
                out.print(0);
            }
            out.print("ポイント");
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
