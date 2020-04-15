<%-- 
    Document   : menu
    Created on : Feb 20, 2020, 9:39:11 PM
    Author     : Le Trong Nghia
 
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/menu.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <% String id  = (String) session.getAttribute("id"); %>
        <div class="icon-bar">
            <a id="home" class="active" href="home" ><i class="fa fa-home"></i></a>
            <a id="table" href="table"><i class="fa fa-table"></i></a>
            <a id="caculation" href="caculation"><i class="fa fa-search"></i></a>
        </div>
        <%
            if(id.equals("home")){
        %>
        <script>
            document.getElementsByClassName('active')[0].classList.remove('active');
            document.getElementById('home').classList.add('active');
        </script>
        <%
            }
        else if(id.equals("table")){
        %>
        <script>
            document.getElementsByClassName('active')[0].classList.remove('active');
            document.getElementById('table').classList.add('active');
        </script>
        <%
        }
        else{
        %>
        <script>
            document.getElementsByClassName('active')[0].classList.remove('active');
            document.getElementById('caculation').classList.add('active');
        </script>
        <%
        }
        %>
    </body>
</html>
