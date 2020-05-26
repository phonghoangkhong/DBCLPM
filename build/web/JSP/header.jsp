<%-- 
    Document   : header
    Created on : Feb 27, 2020, 10:59:54 AM
    Author     : SA Nice
--%>

<%@page import="Models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>JSP Page</title>
        <link href="CSS/header.css?v=57" rel="stylesheet" type="text/css"/>

    </head>
    <body>
    <head>
        <div class="header">
            <img class="logo" src="Images/Icons/logo_BHXH.svg"/>
            <h1 class="title">BẢO HIỂM Y TẾ</h1>
            <%
                if(session.getAttribute("user") != null){
                User user = (User) session.getAttribute("user");
            %>
            
            <div class="empty-div">
                    
            </div>
            <div class="container-avatar">
                <img src="Images/img_avatar2.png" alt="Avatar"> <%out.print( user.getUsername());%>
             
            </div>
                
                
                
            <div class="user-logout">
                <form action="userServlet" method="post">
                    <button class="button-logout" type="submit" name="submit" value="logout">
                        <img src="Images/logout.png" alt="Avatar" class="avatar-icon">
                    </button>
                </form>
            </div>
                        
                
            <%
                }
                else{
            %>
                <button class="button-header button-login" onclick="document.getElementById('modalLogin').style.display='block'">Login</button>
                <button class="button-header button-register" onclick="document.getElementById('modalRegister').style.display='block'">Register</button>
            <%
                }
            %>
        </div>
        <div style id="modalLogin" class="modal">
            <form class="modal-content animate" action="userServlet" method="post">
              <div class="imgcontainer">
                <span onclick="{
                        document.getElementById('modalLogin').style.display='none';
                        document.getElementsByClassName('message-login')[0].innerText = '';
                        document.getElementsByClassName('message-login')[1].innerText = '';
                    }" class="close" title="Close Modal">&times;</span>
                <img src="Images/img_avatar2.png" alt="Avatar" class="avatar">
              </div>

              <div class="container">
                <label for="username"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required>

                <label for="password"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" required>

                <div  class="message-login" style="color: green">
                    <%
                        if(session.getAttribute("message") != null){
                            out.print(session.getAttribute("message"));
                        }
                    %>
                </div>
                
                <div  class="message-login" style="color: red">
                    <%
                        if(session.getAttribute("errorLogin") != null){
                            out.print(session.getAttribute("errorLogin"));
                        }
                    %>
                </div>
                
                <button class="button-modal" type="submit" name="submit" value="login">Login</button>
              </div>

              <div class="container" style="background-color:#f1f1f1">
                <button type="button" 
                    onclick="{
                        document.getElementById('modalLogin').style.display='none';
                        document.getElementsByClassName('message-login')[0].innerText = '';
                        document.getElementsByClassName('message-login')[1].innerText = '';
                    }" 
                    class="button-modal cancelbtn">Cancel</button>
              </div>
            </form>
        </div>
        <%
            if(session.getAttribute("errorLogin") != null || session.getAttribute("message") != null){
            %>
                <script>
                    document.getElementById('modalLogin').style.display='block';
                </script>
            <%
                session.setAttribute("errorLogin", null);
                session.setAttribute("message", null);
            }
        %>
        
        <div id="modalRegister" class="modal">
            <form class="modal-content animate" action="userServlet" method="post">
                <div class="imgcontainer">
                  <span onclick="{
                            document.getElementById('modalRegister').style.display='none';
                            document.getElementsByClassName('message-register')[0].innerText = '';
                        }" class="close" title="Close Modal">&times;</span>
                  <h1>Register</h1>
                </div>
                <hr/>
                <div class="container">
                  <label for="username"><b>Username</b></label>
                  <input type="text" placeholder="Enter Username" name="username" required>

                  <label for="password"><b>Password</b></label>
                  <input type="password" placeholder="Enter Password" name="password" required>
                  
                  <label for="repassword"><b>Repeat Password</b></label>
                  <input type="password" placeholder="Repeat Password" name="repassword" required>
                  
                  <div  class="message-register" style="color: red">
                    <%
                        if(session.getAttribute("errorRegister") != null){
                            out.print(session.getAttribute("errorRegister"));
                        }
                    %>
                </div>
                </div>
                <div class="container" style="background-color:#f1f1f1; display: flex">
                  <button style="width: 49%; margin-right: 1%" type="button" 
                        onclick="{
                            document.getElementById('modalRegister').style.display='none';
                            document.getElementsByClassName('message-register')[0].innerText = '';
                        }" class="button-modal cancelbtn">Cancel</button>
                  <button style="width: 49%; margin-left: 1%" class="button-modal" type="submit" name="submit" value="register">Register</button>
                </div>
            </form>
        </div>
        <%
            if(session.getAttribute("errorRegister") != null){
            %>
                <script>
                    document.getElementById('modalRegister').style.display='block';
                </script>
            <%
                session.setAttribute("errorRegister", null);
            }
        %>

        <script>
            // Get the modal
            var modalLogin = document.getElementById('modalLogin');
            var modalRegister = document.getElementById('modalRegister');
            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event) {
                if (event.target === modalLogin) {
                    modalLogin.style.display = "none";
                    document.getElementsByClassName('message-login')[0].innerText = '';
                    document.getElementsByClassName('message-login')[1].innerText = '';
                }
                if (event.target === modalRegister) {
                    modalRegister.style.display = "none";
                    document.getElementsByClassName('message-register')[0].innerText = '';
                }
            }
        </script>
    </body>
</html>