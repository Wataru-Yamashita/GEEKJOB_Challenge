<%-- 
    Document   : db9_form
    Created on : 2017/07/26, 16:02:15
    Author     : wataru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力フォーム</title>
        
        <style>
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
            div{
                font-size:1.3em;
            }
            input#submit{
                width:4em;
                font-size:1em;
            }
        </style>
        
    </head>
    <body>
        <form action="./db9_result" method="post">
            <h3>新規データ登録フォーム</h3>
            
            <div>
            <p>
            <ul>
                <li><span>ID:</span><input type="text" name="ID"></li>
                <li><span>name:</span><input type="text" name="Name"></li>
                <li><span>tell:</span><input type="text" name="Tell"></li>
                <li><span>age:</span><input type="text" name="Age"></li>
                <li><span>birthday:</span><input type="text" name="Birthday"></li>
            </ul>
            </p>
            </div>
                <input type="submit" id="submit" name="Submit" value="登録">
        </form>
    </body>
</html>
