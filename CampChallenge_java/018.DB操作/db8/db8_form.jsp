<%-- 
    Document   : db8_form
    Created on : 2017/07/26, 14:55:07
    Author     : wataru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索フォーム</title>
    </head>
    <body>
        <p1>名前を入力してください。</p1>
        <form action="./db8_result" method="post">
            <input type="text" name="searchName">
            <input type="submit" name="btnSubmit" value="検索">            
        </form>
    </body>
</html>
