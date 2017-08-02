<%-- 
    Document   : product_all
    Created on : 2017/08/02, 13:41:53
    Author     : wataru
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            input#Submit{
                width:5em;
                font-size:1em;
            }
            
            table, tr, td{
                border: solid 1px;
                border-collapse:collapse;
                padding:8px;
            }
            tr.line1{
                background-color:palegreen;
            }
        </style>
        <title>商品一覧ページ</title>
    </head>
    <body>
        <h1>商品一覧</h1>
        <p>
        <%
            
            Connection db_con = null;
            PreparedStatement db_st;
            ResultSet db_data;
        try{
            //DBに接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db", "wataru", "ymst0903");
            //productsテーブル内のデータを全件表示するSQL文を用意
            db_st = db_con.prepareStatement("SELECT * FROM products");
            //実行
            db_data = db_st.executeQuery();
            out.println("<table>");
            out.println("<tr class = line1><td>ID</td><td>商品名</td><td>価格(円)</td><td>個数</td></tr>");
            while(db_data.next()){
                out.println("<tr><td>" + db_data.getInt("proID") + "</td>");
                out.println("<td>" + db_data.getString("proName") + "</td>");
                out.println("<td>" + db_data.getInt("proPrice") + "</td>");
                out.println("<td>" + db_data.getInt("proQuantity") + "</td></tr>");
            }
            out.println("</table>");
            
            db_con.close();
            db_st.close();
            db_data.close();
            
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
        %>
        </p>
    </body>
    <footer>
        <form action="./logout_check" method="post">
        <input type="submit" id="Submit" name="Logout" value="ログアウト">
        </form>
    </footer>
</html>
