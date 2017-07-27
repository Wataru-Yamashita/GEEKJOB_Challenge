<%-- 
    Document   : db10_form
    Created on : 2017/07/27, 10:15:11
    Author     : wataru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力フォーム</title>
    </head>
    <body>
        <h3>入力フォーム</h3>
        
        <form action="./db10_result" method="post">
            <p>
            ID:<input type="text" name="ID">
            </p>
            <input type="submit" name="Submit">
        </form>
    </body>
</html>
