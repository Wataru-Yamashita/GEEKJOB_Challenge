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
public class db8_result extends HttpServlet {

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
            ResultSet db_data = null;
            
            //受け取る文字コードの指定
            request.setCharacterEncoding("UTF-8");
            //入力された文字列を取得
            String name = request.getParameter("searchName");
            
            try{
                //接続
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db", "wataru", "ymst0903");
                //入力された名前を一部含んでいるデータを取得
                db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE name LIKE ?");
                db_st.setString(1, "%" + name + "%");
                //実行
                db_data = db_st.executeQuery();
                
                out.println("「" + name + "」で検索した結果<br>");
                //全件読み出し、表示
                while(db_data.next()){
                    out.println("profilesID:" + db_data.getInt("profilesID") + " ");
                    out.println("name:" + db_data.getString("name") + " ");
                    out.println("tell:" + db_data.getString("tell") + " ");
                    out.println("age:" + db_data.getInt("age") + " ");
                    out.println("birthday:" + db_data.getString("birthday") + "<br>");
                }
                
                db_st.close();
                db_con.close();
                db_data.close();
                
            }
            catch(SQLException e_sql){
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
            out.println("<title>検索結果</title>");            
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
