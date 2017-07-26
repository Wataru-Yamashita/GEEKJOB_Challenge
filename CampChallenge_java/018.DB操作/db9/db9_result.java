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

import java.sql.*;

/**
 *
 * @author wataru
 */
public class db9_result extends HttpServlet {

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
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            
            //受け取る文字コードの指定
            request.setCharacterEncoding("UTF-8");
            //入力フォームから送られてきた情報を取得
            int id = Integer.parseInt(request.getParameter("ID")); //ID取得、int型への変換
            String name = request.getParameter("Name"); //name取得
            String tell = request.getParameter("Tell"); //tell取得
            int age = Integer.parseInt(request.getParameter("Age")); //age取得、int型への変換
            String birthday = request.getParameter("Birthday"); //birthday取得

            try{
                //接続
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db", "wataru", "ymst0903");
                
                db_st = db_con.prepareStatement("INSERT INTO profiles VALUES(?, ?, ?, ?, ?)");
                
                db_st.setInt(1, id);
                db_st.setString(2, name);
                db_st.setString(3, tell);
                db_st.setInt(4, age);
                db_st.setString(5, birthday);
                
                db_st.executeUpdate();
                out.println("下記の情報が登録されます。<br>");
                out.println("ID:" + id + "<br>");
                out.println("name:" + name + "<br>");
                out.println("tell:" + tell + "<br>");
                out.println("age:" + age + "<br>");
                out.println("birthday:" + birthday + "<br>");
                
                db_st.close();
                db_con.close();
                
            }catch(SQLException e_sql){
                out.println("接続時にエラーが発生しました：" + e_sql.toString());
            }catch(Exception e){
                out.println("接続時にエラーが発生しました：" + e.toString());
            }finally{
                if(db_con != null){
                    try{
                        db_con.close();
                    }catch(Exception e_con){
                        System.out.println(e_con.getMessage());
                    }
                }
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>登録フォーム</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1></h1>");
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
