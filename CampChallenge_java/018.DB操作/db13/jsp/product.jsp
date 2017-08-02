<%-- 
    Document   : product
    Created on : 2017/07/27, 17:33:00
    Author     : wataru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理ページ</title>
        
        <style>
            input#Submit{
                width:5em;
                font-size:1em;
            }
            ul{
                list-style-type: none;
            }
            li{
                margin-bottom:0.4em;
            }
            span{
                width: 4em; /*幅は4文字分*/
                margin:0px;
                display:block; /*spanはインライン要素なのでブロック化する*/
                float:left; /*左揃え*/
            }
            p.registered{
                color:red;
            }
        </style>
    </head>
    <body>
        <h1>在庫管理ページ</h1>
        
        <h3>・商品一覧表示</h3>
            <form action="product_all.jsp" method="post">
                <input type="submit" id="Submit" name="List" value="一覧表示">
            </form>
        
        <h3>・新規商品登録</h3>
        <p class="registered">
            <%
                HttpSession hs = request.getSession(true);
                
                Object check = hs.getAttribute("sessionRegist");
                
                if(check == "OK"){
                    out.println("新しく商品が追加されました。");
                    hs.setAttribute("sessionRegist", null);
                }
            %>
        </p>
        <p>
        <form action="./product_add" method="post">
        <ul>
            <li><span>商品ID:</span><input type="text" name="newID" required=""></li>
            <li><span>商品名:</span><input type="text" name="newName" required=""></li>
            <li><span>価格:</span><input type="text" name="newPrice" required=""></li>
            <li><span>個数:</span><input type="text" name="newQuantity" required=""></li>
            <li><input type="submit" id="Submit" name="Registration" value="新規登録"></li>
        </ul>
        </form>
        </p>
        
    </body>
    
    <footer>
        <form action="./logout_check" method="post">
        <input type="submit" id="Submit" name="Logout" value="ログアウト">
        </form>
    </footer>
</html>
