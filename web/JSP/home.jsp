<%-- 
    Document   : home
    Created on : Feb 20, 2020, 9:39:11 PM
    Author     : Le Trong Nghia
    Content: Giao diện khai báo thông tin
--%>

<%@page import="Models.Info"%>
<%@page import="Models.User"%>

<!DOCTYPE html>
<%@ page  pageEncoding="UTF-8"%>


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
        </style>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"></jsp:include>
        <!--Menu-->
        <jsp:include page="menu.jsp"></jsp:include>
        <!--Content-->
        <div style="width: calc(100% - 200px); margin: 20px 100px; border: 1px solid #ccc; border-radius: 5px">
            <h2 style="width: 100%; text-align: center; border-bottom: 1px solid #ccc; font-weight: bold">Thông tin người dùng</h2>
            <form id="infoForm" action="infoServlet" method="post">
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
                        <label for="soDT"><b>Số điện thoai</b></label>
                        <input id="soDT" type="text" placeholder="Nhập số điện thoại" name="soDT" required>
                    </div>
                    <div class="gird-item">
                        <label for="gioiTinh"><b>Giới tính</b></label>
                        <select id="gioiTinh" name="gioiTinh" form="infoForm">
                            <option value="0" selected>Nam</option>
                            <option value="1">Nữ</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="gird-item">
                        <label for="diaChi"><b>Địa chỉ</b></label>
                        <input id="diaChi" type="text" placeholder="Nhập địa chỉ" name="diaChi" required>
                    </div>
                    <div class="gird-item">
                        <label for="maTinh"><b>Mã tỉnh</b></label>
                        <input id="maTinh" type="number" placeholder="Nhập mã tỉnh" name="maTinh" required>
                    </div>
                </div>
                <div class="row">
                    <div class="gird-item">
                        <label for="soCMND"><b>Số CMND</b></label>
                        <input id="soCMND" type="number" placeholder="Nhập số CMND" name="soCMND" required>
                    </div>
                    <div class="gird-item">
                        <label for="mucLuong"><b>Mức lương</b></label>
                        <input id="mucLuong" type="number" placeholder="Nhập mức lương" name="mucLuong" required>
                    </div>
                </div>
                <div class="row">
                    <div class="gird-item">
                        <label for="ngaySinh"><b>Ngày sinh</b></label>
                        <input id="ngaySinh" type="date" placeholder="Nhập ngày sinh" name="ngaySinh" required>
                    </div>
                    <div class="gird-item">
                        <label for="hinhThuc"><b>Hình thức bảo hiểm</b></label>
                        <select id="hinhThuc" name="hinhThuc" form="infoForm">
                            <option value="0" selected>Hộ gia đình</option>
                            <option value="1">Công ty</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <button id="submit" class="button-home" type="submit" name="submit">Lưu</button>
                </div>
            </form>
            
                <%
                    if(((User)session.getAttribute("user")).getTrangThai() == false){
                %>
                    <script>
                        document.getElementById('submit').value = 'add';
                        document.getElementById('maTinh').value = 0;
                        document.getElementById('mucLuong').value = 0;
                    </script>   
                <%
                    }
                else{
                    Info info = (Info) session.getAttribute("info");
                    String ten = info.getTen();
                    String soDT = info.getSoDT();
                    String diaChi = info.getDiaChi();
                    String soCMND = info.getSoCMND();
                    String ngaySinh = info.getNgaySinh();
                    String danToc = info.getDanToc();
                    String gioiTinh = info.getGioiTinh() == true?"0":"1";
                    String maTinh = info.getMaTinh();
                    int mucLuong = info.getMucLuong();
                    String hinhThuc = info.getHinhThuc() == true ? "0" : "1";
                %>
                    <script>
                        document.getElementById('submit').value = 'update';
                        document.getElementById('ten').value = "<%=ten%>";
                        document.getElementById('soDT').value = "<%=soDT%>";
                        document.getElementById('diaChi').value = "<%=diaChi%>";
                        document.getElementById('soCMND').value = "<%=soCMND%>";
                        document.getElementById('ngaySinh').value = "<%=ngaySinh%>";
                        document.getElementById('danToc').value = "<%=danToc%>";
                        document.getElementById('gioiTinh').value = "<%=gioiTinh%>";
                        document.getElementById('maTinh').value = "<%=maTinh%>";
                        document.getElementById('mucLuong').value = "<%=mucLuong%>";
                        document.getElementById('hinhThuc').value = "<%=hinhThuc%>";
                    </script>
                <%
                }
                %>
        </div>
    </body>
</html>
