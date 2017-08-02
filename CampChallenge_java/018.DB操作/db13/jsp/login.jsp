<%-- 
    Document   : login
    Created on : 2017/07/27, 17:05:20
    Author     : wataru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン画面</title>
        
        <style>
            ul{
                list-style-type: none;
            }
            li{
                margin-bottom:0.4em;
            }
            span{
                width: 6em; /*幅は4文字分*/
                margin:0px;
                display:block; /*spanはインライン要素なのでブロック化する*/
                float:left; /*左揃え*/
            }
            div{
                font-size:1.3em;
            }
            input#Login{
                width:4em;
                font-size:1em;
            }
            p.error{
                color:red;
            }
        </style>
        
    </head>
    <body>
        <div>
        <h2>ログインページ</h2>

        <p>ユーザー名、パスワードをご入力ください。</p>
        
        <p class="error">
        <%
            HttpSession hs = request.getSession(true);

            //認証失敗から呼び出されたのかどうか
            Object status = hs.getAttribute("status");

            if (status != null){
              out.println("認証に失敗しました。<br>");
              out.println("再度ユーザー名とパスワードを入力して下さい。");

              hs.setAttribute("status", null);
            }
        %>
        </p>
        
        <form action="./login_check" method="post">
        <p>
        <ul>
            <li><span>ユーザー名:</span><input type="text" name="User"></li>
            <li><span>パスワード:</span><input type="text" name="Pass"></li>
        </ul>
        </p>
        </div>
            <input type="submit" id="Login" name="Login" value="ログイン">
        </form>
    </body>
</html>
