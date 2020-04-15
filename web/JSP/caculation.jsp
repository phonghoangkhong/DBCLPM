<%-- 
    Document   : caculation
    Created on : Feb 20, 2020, 9:39:11 PM
    Author     : Le Trong Nghia
    Content: Giao diện tính bảo hiểm y tế và xử lý
    Edit :Khong Hoang Phong
    Date: Mar 14,2020
    Content: Chỉnh sửa giao diện và xử lý khi nộp theo hộ gia đình
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Models.Info"%>
<%@page import="Models.User"%>
<%@page import="Commons.Commons"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .row{
                display: flex;
                width: 100%;
            }
            
            .row-caculation{
                display: flex;
                width: calc(100% - 150px);
                margin: 10px 75px;
            }
            
            .gird-item{
                width: calc(50% - 150px);
                margin: 10px 75px;
                display: flex;
            }
            
            .label-item{
                width: 30%;
                text-align: left;
                font-weight: bold
            }
            
            .content-item{
                width: 70%;
                text-align: left;
            }
            
            .button-caculation{
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
                font-weight: bold;
                font-size: 20px;    
            }
            
            .container-modal-pay{
                position: absolute;
                top: 0;
                bottom: 0;
                right: 0;
                left: 0;
                background-color: rgba(0, 0, 0, 0.6);
                display: none;
            }
            
            .modal-pay{
                position: absolute;
                top: 200px;
                right: 200px;
                left: 200px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: white;
            }
            
            .modal-pay h2{
                width: 100%;
                text-align: center;
                border-bottom: 1px solid #ccc;
                font-weight: bold;
                color: #4CAF50;
            }
            
            .modal-pay-QR{
                position: absolute;
                top: 165px;
                right: 615px;
                left: 615px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: white;
            }
            
            .modal-pay-QR h2{
                width: 100%;
                text-align: center;
                border-bottom: 1px solid #ccc;
                font-weight: bold;
                color: #4CAF50;
            }
            
            .close-button{
                position: absolute;
                right: 25px;
                top: 0;
                width: 40px;
                height: 40px;
                background-color: white;
                border: none;
                outline: none;
            }
            
            .close-icon{
                color: #000;
                font-size: 35px;
                font-weight: bold;
                color: black;
            }
            
            .close-icon:hover{
                cursor: pointer;
                color: red;
            }
            
            .container-modal-item{
                margin: 10px;
                border: none;
                outline: none;
                border: 1px solid transparent;
                border-radius: 5px;
                background-color: white;
                width: 250px;
                padding: 0;
            }
            
            .container-modal-item:hover{
                cursor: pointer;
                border-color: #ccc;
            }
            
            .modal-item-image{
                width: 100%;
            }
            
            .modal-item-title{
                width: 100%;
                text-align: center;
                font-size: 16px
            }
            
            .button-thanh-toan{
                width: 100%;
                color: white;
                background-color: #4CAF50;
                text-align: center;
                margin-left: 100px;
                padding: 8px;
            }
        </style>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"></jsp:include>
        <!--Menu-->
        <jsp:include page="menu.jsp"></jsp:include>
        <%
            if(((User)session.getAttribute("user")).getTrangThai() == true){
                Info info = (Info) session.getAttribute("info");
                String title = "MỨC BẢO HIỂM PHẢI ĐÓNG THEO " + (info.getHinhThuc() == true ? "HỘ GIA ĐÌNH" : "CÔNG TY") + " NĂM" ;
                int luong1=0;
                if(info.getHinhThuc() == false){
                                       
                    luong1 = ((info.getMucLuong() + 1490000) * 15 / 1000) * 12;
                }
        %>
            <div style="width: calc(100% - 200px); margin: 20px 100px; border: 1px solid #ccc; border-radius: 5px">
                <h2 style="width: 100%; text-align: center; border-bottom: 1px solid #ccc; font-weight: bold; color: #4CAF50">
                    <%out.print(title);%>
                </h2>
                <div class="row">
                    <div class="gird-item">
                        <div class="label-item">Họ tên :</div>
                        <div class="content-item"><%out.print(info.getTen());%></div>
                    </div>
                    <div class="gird-item">
                        <div class="label-item">Số điện thoại :</div>
                        <div class="content-item"><%out.print(info.getSoDT());%></div>
                    </div>
                </div>
                <div class="row">
                    <div class="gird-item">
                        <div class="label-item">Địa chỉ :</div>
                        <div class="content-item"><%out.print(info.getDiaChi());%></div>
                    </div>
                    <div class="gird-item">
                        <div class="label-item">Số CMND :</div>
                        <div class="content-item"><%out.print(info.getSoCMND());%></div>
                    </div>
                </div>
                <div class="row">
                    <div class="gird-item">
                        <div class="label-item">Ngày sinh :</div>
                        <div class="content-item"><%out.print(info.getNgaySinh());%></div>
                    </div>
                    <div class="gird-item">
                        <div class="label-item">Dân tộc</div>
                        <div class="content-item"><%out.print(info.getDanToc());%></div>
                    </div>
                </div>
                <div class="row">
                    <div class="gird-item">
                        <div class="label-item">Giới tính :</div>
                        <div class="content-item"><%out.print(info.getGioiTinh() == true ? "Nam" : "Nữ");%></div>
                    </div>
                    <div class="gird-item">
                        <div class="label-item">Mã tỉnh :</div>
                        <div class="content-item"><%out.print(info.getMaTinh());%></div>
                    </div>
                </div>
               
                <%
                     if(info.getHinhThuc() == false){
                   
                %>
                    <div class="row-caculation">
                        <div class="label-item">Mức BHYT cá nhân phải đóng: </div>
                                       
                        <div class="content-item"><% out.print(Commons.numberToString(luong1));%> đồng</div> 
                          </div>
                                     
                          
                <%
                    }
else{
 
  ArrayList<Info> list=new ArrayList<>();
  list=(ArrayList < Info >)session.getAttribute("table");
   int luong2,luong3,luong4,luong5 ;
                    luong1 = (1490000 * 45 / 1000) * 12;
                    luong2 = luong1 * 70 / 100;
                    luong3 = luong1 * 60 / 100;
                    luong4 = luong1 * 50 / 100;
                    luong5 = luong1 * 40 / 100;
int tong=0;
  for(int i=0;i<list.size();i++){
                
                %>
                <% if(i==0){
                    %>
                
                      <div class="row-caculation">
                        <div class="label-item">Mức BHYT người thứ 1: </div>
                                       
                        <div class="content-item"><% out.print(Commons.numberToString(luong1));%> đồng</div>
                      </div>
                          <%  tong+=luong1;} %>
                          <% if(i==1){
                    %>
                
                      <div class="row-caculation">
                        <div class="label-item">Mức BHYT người thứ 2 : </div>
                                       
                        <div class="content-item"><% out.print(Commons.numberToString(luong2));%> đồng</div> 
                        </div>  
                        <% tong+=luong2;} %>
                          <% if(i==2){
                    %>
                
                      <div class="row-caculation">
                        <div class="label-item">Mức BHYT người thứ 3 : </div>
                                       
                        <div class="content-item"><% out.print(Commons.numberToString(luong3));%> đồng</div> 
                          <% tong+=luong3;} %>
                        </div>  
                        <% if(i==3){
                    %>
                
                      <div class="row-caculation">
                        <div class="label-item">Mức BHYT người thứ 4: </div>
                                       
                        <div class="content-item"><% out.print(Commons.numberToString(luong4));%> đồng</div> 
                        </div>  
                        <% tong+=luong4;} %>
                          <% if(i>=4){
                    %>
                
                      <div class="row-caculation">
                          <div class="label-item">Mức BHYT người thứ<%out.print(i+1);%> : </div>
                                       
                        <div class="content-item"><% out.print(Commons.numberToString(luong5));%> đồng</div> 
                        </div>
                        <% tong+=luong5;} %>

<%
    }
%>      
<div class="row-caculation">
  <div class="label-item">Tổng tiền phải đóng: </div>                                     
    <div class="content-item"><% out.print(Commons.numberToString(tong));%> đồng</div> </div> 
  <%                      
}
                %>
                
                
            </div>
            <%
                if(info.getTrangThai()){
                %>
                    <button disabled class="button-caculation" style="width: calc(100% - 200px);margin: 0 100px; background-color: #ccc; color: #4CAF50">
                        ĐÃ HOÀN THÀNH BẢO HIỂM
                    </button>
                <%
                }
                else{
                %>
                    <button onclick="handleOpenModal()" class="button-caculation" style="width: calc(100% - 200px);margin: 0 100px;">
                        THANH TOÁN BẢO HIỂM
                    </button>
            <%
                }
            %>
            <div id="modal" class="container-modal-pay">
                <div class="modal-pay">
                    <h2>LỰA CHỌN NGÂN HÀNG THANH TOÁN</h2>
                    <button class="close-button" onclick="handleCloseModal()">
                        <span class="close-icon">x</span>
                    </button>
                    <div style="width: calc(100% - 20px); padding: 10px; display: flex">
                        <button class="modal-button container-modal-item" onclick="handleOpenModalQR()">
                            <div class="modal-item-image">
                                <img width="100%" src="Images/agribank-logo.png" alt=""/>
                            </div>
                            <div class="modal-item-title">AGRIBANK</div>
                        </button>
                        <button class="modal-button container-modal-item" onclick="handleOpenModalQR()">
                            <div class="modal-item-image" style="padding: 8px; width: calc(100% - 16px)">
                                <img width="100%" src="Images/vpbank-logo.png" alt=""/>
                            </div>
                            <div class="modal-item-title">VPBANK</div>
                        </button>
                        <button class="modal-button container-modal-item" onclick="handleOpenModalQR()">
                            <div class="modal-item-image" style="padding: 8px; width: calc(100% - 16px)">
                                <img width="100%" src="Images/vietcombank-logo.jpg" alt=""/>
                            </div>
                            <div class="modal-item-title">VIETCOMBANK</div>
                        </button>
                        <button class="modal-button container-modal-item" onclick="handleOpenModalQR()">
                            <div class="modal-item-image" style="padding: 8px; width: calc(100% - 16px)">
                                <img width="100%" src="Images/vietinbank-logo.png" alt=""/>
                            </div>
                            <div class="modal-item-title">VIETINBANK</div>
                        </button>
                    </div>
                </div>
            </div>
            
            <div id="modalQR" class="container-modal-pay">
                <div class="modal-pay-QR">
                    <h2>THANH TOÁN</h2>
                    <button class="close-button" onclick="handleCloseModalQR()">
                        <span class="close-icon">x</span>
                    </button>
                    <div style="width: calc(100% - 20px); padding: 10px 10px 0 ">
                        <a class="container-modal-item">
                            <div class="modal-item-image">
                                <img width="100%" src="Images/QR-code.png" alt=""/>
                            </div>
                            <div class="modal-item-title">Mã QR</div>
                        </a>
                    </div>
                    <div style='height: 35px'>
                    <a href="success" class="button-thanh-toan">Thanh Toán</a>
                    </div>
                </div>
            </div>
            
        <%
            }
            else{
        %>
        <div style="width: calc(100% - 40px); text-align: center; padding: 20px; font-size: 30px; font-weight: bold; color: red">
            THÔNG TIN CHƯA ĐƯỢC CẬP NHẬT
        </div>
        <div style="width: 40%; margin: 8px 30%">
            <form style="width: 100%" action="home" method="get">
                <button class="button-caculation" type="submit">Nhập thông tin</button>
            </form>
        </div>
        <%
            }
        %>
    </body>
    <script>
        function handleCloseModal(){
            document.getElementById('modal').style.display = 'none';
        }
        
        function handleOpenModal(){
            document.getElementById('modal').style.display = 'block';
        }
        
        function handleCloseModalQR(){
            document.getElementById('modalQR').style.display = 'none';
        }
        
        function handleOpenModalQR(){
            document.getElementById('modalQR').style.display = 'block';
        }
    </script>
</html>
