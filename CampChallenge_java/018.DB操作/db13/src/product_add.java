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
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 *
 * @author wataru
 */
public class product_add extends HttpServlet {

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
            //入力フォームから送られてくる情報の文字コードを指定
            request.setCharacterEncoding("UTF-8");
            //入力フォームから送られてきた情報を取得
            int newID = Integer.parseInt(request.getParameter("newID"));
            String newName = request.getParameter("newName");
            int newPrice = Integer.parseInt(request.getParameter("newPrice"));
            int newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
            //セッション開始
            HttpSession hs = request.getSession(true);
            
            Connection db_con = null;
            PreparedStatement db_st;
        try{
            //DBに接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db", "wataru", "ymst0903");
            //入力された情報をproductsテーブルに追加するSQL文を用意
            db_st = db_con.prepareStatement("INSERT INTO products VALUES(?, ?, ?, ?)");
            db_st.setInt(1, newID);
            db_st.setString(2, newName);
            db_st.setInt(3, newPrice);
            db_st.setInt(4, newQuantity);
            //実行
            db_st.executeUpdate();
            
            db_con.close();
            db_st.close();
            
            hs.setAttribute("sessionRegist", "OK");
            
            response.sendRedirect("product.jsp");
            
            }catch(SQLException e_sql){
                log("接続時にエラーが発生しました：" + e_sql.toString());
            }catch(Exception e){
                log("接続時にエラーが発生しました：" + e.toString());
            }finally{
                if(db_con != null){
                    try{
                        db_con.close();
                    }catch(Exception e_con){
                        log(e_con.getMessage());
                    }
                }
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet product_add</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>新規商品登録</h1>");
            out.println("</body>");
            out.println("</html>");
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
