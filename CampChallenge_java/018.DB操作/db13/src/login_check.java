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
import javax.servlet.http.HttpSession;

/**
 *
 * @author wataru
 */
public class login_check extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected boolean authUser(String user, String pass){
        /* 取りあえずユーザー名とパスワードが入力されていれば認証する */
        if (user == null || user.length() == 0 || pass == null || pass.length() == 0){
            return false;
        }
            Connection db_con = null;
            PreparedStatement db_st;
            ResultSet db_data;
        try{
            //DBに接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db", "wataru", "ymst0903");

            //入力されたユーザー名、パスワードに一致するレコードを取得するSQL文を用意
            db_st = db_con.prepareStatement("SELECT * FROM users WHERE username = ? AND pass = ?");
            db_st.setString(1, user);
            db_st.setString(2, pass);
            //実行
            db_data = db_st.executeQuery();


            if(db_data.next()){
                return true;
            }else{
                return false;
            }
                
            
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
        
            return false;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String target = request.getRequestURI();
            
            HttpSession hs = request.getSession(false);
            
            //セッションが開始されてなかったり、開始していても"login"に情報がない場合はログイン画面を表示
            if(hs == null){
                //まだ認証されていない
                hs = request.getSession(true);
                hs.setAttribute("target", target);
                response.sendRedirect("login.jsp");
            }else{
                Object loginCheck = hs.getAttribute("login");
                if(loginCheck ==null){
                //まだ認証されていない
                hs.setAttribute("target", target);
                response.sendRedirect("login.jsp");
                }
            }
            
            //入力フォームから送られてくる情報の文字コードを指定
            request.setCharacterEncoding("UTF-8");
            //入力フォームから送られてきた情報を取得
            String user = request.getParameter("User");
            String pass = request.getParameter("Pass");
            //user,passを引数にしてauthUserメソッドを利用
            boolean check = authUser(user, pass);
            if (check){
                //認証済みにセット
                hs.setAttribute("login", "OK");
                //本来のアクセス先へ飛ばす
                response.sendRedirect("product.jsp");
            }else{
                //認証に失敗したら、"status"セッションに情報を登録し、ログイン画面に戻す
                hs.setAttribute("status", "Not Auth");
                response.sendRedirect("login.jsp");
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
