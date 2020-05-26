<%-- 
    Document   : home
    Created on : Feb 28, 2020, 9:23:37 PM
    Author     : SA Nice
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Models.Info"%>
<%@page import="Models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .row{
                display: flex;
            }
            
            .gird-item{
                width: calc(50% - 100px);
                margin: 10px 50px;
                
            }
            select{
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }
            
            input{
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }
            
            .button-home{
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
                margin: 10px 50px;
                font-weight: bold;
                font-size: 20px;    
            }
            
            table{
                border-collapse: collapse;
                width: calc(100% - 20px);
                margin: 10px;
                border: 1px solid #ddd;
                font-size: 16px;
            }
            
            th{
                border: 1px solid #ccc;
                padding: 12px;
                background-color: #4CAF50;
                color: white;
            }
            
            td{
                border: 1px solid #ccc;
                text-align: center;
                padding: 12px;
            }
        </style>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"></jsp:include>
        <!--Menu-->
        <jsp:include page="menu.jsp"></jsp:include>
        <!--Content-->
        <div style="width: calc(100% - 200px); margin: 20px 100px; border: 1px solid #ccc; border-radius: 5px">
            <h2 style="width: 100%; text-align: center; border-bottom: 1px solid #ccc; font-weight: bold">Thêm thông tin gia đình</h2>
            <form id="table2Form" action="table2Servlet" method="post">
                <div class="row">
                    <h3 style="width: 100%; color: red; text-align: center">
                        <%
                            if(session.getAttribute("error") != null){
                                out.print(session.getAttribute("error"));
                                session.setAttribute("error", null);
                            }
                        %>
                    </h3>
                </div>
                <div class="row">
                    <div class="gird-item">
                        <label for="ten"><b>Họ tên</b></label>
                        <input id="ten" type="text" placeholder="Nhập họ tên" name="ten" required>
                    </div>
                    <div class="gird-item">
                        <label for="danToc"><b>Dân tộc</b></label>
                        <input id="danToc" type="text" placeholder="Nhập dân tộc" name="danToc" required>
                    </div>
                </div>
                <div class="row">
                    <div class="gird-item">
                        <label for="gioiTinh"><b>Giới tính</b></label>  
                        <select id="gioiTinh" name="gioiTinh" form="table2Form">
                            <option value="0" selected>Nam</option>
                            <option value="1">Nữ</option>
                        </select>
                    </div>
                    <div class="gird-item">
                        <label for="soCMND"><b>Số CMND</b></label>
                        <input id="soCMND" type="number" placeholder="Nhập số CMND" name="soCMND" required>
                    </div>
                </div>
                <div class="row">
                    <div class="gird-item">
                        <label for="ngaySinh"><b>Ngày sinh</b></label>
                        <input id="ngaySinh" type="date" placeholder="Nhập ngày sinh" name="ngaySinh" required>
                    </div>
                </div>
                <div class="row">
                    <button id="submit" class="button-home" type="submit" name="submit">Thêm thông tin</button>
      </div>
            </form>
                    
                    
                    
        </div>  

                                    
                    <%
                       ArrayList<Info> info=new ArrayList<>();
                        info = (ArrayList<Info>) session.getAttribute("table");
                        Info info2=(Info)session.getAttribute("info");
                        %>
        <div style="width: calc(100% - 200px); margin: 40px 100px; border: 1px solid #ccc; border-radius: 5px">
            <h2 style="width: 100%; text-align: center; border-bottom: 1px solid #ccc; font-weight: bold">Thông tin gia đình</h2>
            <table>
                <thead>
                <th>STT</th>
                <th>Họ tên</th>
                <th>Dân tộc</th>
                <th>Giới tính</th>
                <th>Số CMTND</th>
                <th>Ngày sinh</th>
                </thead>
                <tbody>
                    <% for(int i=0;i<info.size();i++){ %>
                    <tr>
                        <td><%out.print(i+1);%></td>
                        <td><%out.print(info.get(i).getTen());%></td>
                        <td><%out.print(info.get(i).getDanToc());%></td>
                        <td><%out.print(info.get(i).getGioiTinh() == true ? "Nam" : "Nữ");%></td>
                        <td><%out.print(info.get(i).getSoCMND());%></td>
                        <td><%out.print(info.get(i).getNgaySinh());%></td>
                    </tr>
                  
                           <% } %>
                    
                </tbody>
            </table>
                           <form id="table3Form" action="table3Servlet" method="post">
                                <div class="row">
                    <button id="submit2" class="button-home" type="submit" name="submit2">Tính BHYT</button>
          
                </div>
                           </form>
                           
        </div>
    </body>
</html>
