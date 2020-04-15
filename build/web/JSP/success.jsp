<%-- 
    Document   : success
    Created on : Feb 20, 2020, 9:39:11 PM
    Author     : Le Trong Nghia
    Content: Giao diện sau khi nộp thành công
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/checkout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"></jsp:include>
        <!--Menu-->
        <jsp:include page="menu.jsp"></jsp:include>
        <!--Content-->
        <div style="position: relative">
            <div class="background">
            </div>
            <div class="content">
                <div class="checkout">
                    THANH TOÁN THÀNH CÔNG!
                </div>
                <div class="icon-checkout">
                    <img src="Images/Icons/checked.png" width="100%" height="100%"/>
                </div></br></br>

                <div class="continue-shopping">
                    <a href="home" style="font-size: 20px;font-weight: bold;color: green">Back</a>
                </div></br>
            </div>
        </div>
    </body>
</html>
