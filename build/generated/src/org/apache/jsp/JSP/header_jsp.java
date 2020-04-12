package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"../CSS/header.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <img class=\"logo\" src=\"../Images/Icons/logo_BHXH.svg\"/>\n");
      out.write("            <h1 class=\"title\">BẢO HIỂM Y TẾ</h1>\n");
      out.write("            <button class=\"button-header button-login\" onclick=\"document.getElementById('modalLogin').style.display='block'\">Login</button>\n");
      out.write("            <button class=\"button-header button-register\" onclick=\"document.getElementById('modalRegister').style.display='block'\">Register</button>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"modalLogin\" class=\"modal\">\n");
      out.write("            <form class=\"modal-content animate\" action=\"/action_page.php\" method=\"post\">\n");
      out.write("              <div class=\"imgcontainer\">\n");
      out.write("                <span onclick=\"document.getElementById('modalLogin').style.display='none'\" class=\"close\" title=\"Close Modal\">&times;</span>\n");
      out.write("                <img src=\"../Images/img_avatar2.png\" alt=\"Avatar\" class=\"avatar\">\n");
      out.write("              </div>\n");
      out.write("\n");
      out.write("              <div class=\"container\">\n");
      out.write("                <label for=\"uname\"><b>Username</b></label>\n");
      out.write("                <input type=\"text\" placeholder=\"Enter Username\" name=\"uname\" required>\n");
      out.write("\n");
      out.write("                <label for=\"psw\"><b>Password</b></label>\n");
      out.write("                <input type=\"password\" placeholder=\"Enter Password\" name=\"psw\" required>\n");
      out.write("\n");
      out.write("                <button class=\"button-modal\" type=\"submit\">Login</button>\n");
      out.write("              </div>\n");
      out.write("\n");
      out.write("              <div class=\"container\" style=\"background-color:#f1f1f1\">\n");
      out.write("                <button type=\"button\" onclick=\"document.getElementById('modalLogin').style.display='none'\" class=\"button-modal cancelbtn\">Cancel</button>\n");
      out.write("              </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"modalRegister\" class=\"modal\">\n");
      out.write("            <form class=\"modal-content animate\" action=\"/action_page.php\" method=\"post\">\n");
      out.write("                <div class=\"imgcontainer\">\n");
      out.write("                  <span onclick=\"document.getElementById('modalRegister').style.display='none'\" class=\"close\" title=\"Close Modal\">&times;</span>\n");
      out.write("                  <h1>Register</h1>\n");
      out.write("                </div>\n");
      out.write("                <hr/>\n");
      out.write("                <div class=\"container\">\n");
      out.write("                  <label for=\"uname\"><b>Username</b></label>\n");
      out.write("                  <input type=\"text\" placeholder=\"Enter Username\" name=\"uname\" required>\n");
      out.write("\n");
      out.write("                  <label for=\"psw\"><b>Password</b></label>\n");
      out.write("                  <input type=\"password\" placeholder=\"Enter Password\" name=\"psw\" required>\n");
      out.write("                  \n");
      out.write("                  <label for=\"psw\"><b>Repeat Password</b></label>\n");
      out.write("                  <input type=\"password\" placeholder=\"Repeat Password\" name=\"psw\" required>\n");
      out.write("                  \n");
      out.write("                  <label for=\"name\"><b>Name</b></label>\n");
      out.write("                  <input type=\"text\" placeholder=\"Name\" name=\"name\" required>\n");
      out.write("                  \n");
      out.write("                  <label for=\"email\"><b>Email</b></label>\n");
      out.write("                  <input type=\"text\" placeholder=\"Email\" name=\"email\" required>\n");
      out.write("                  \n");
      out.write("                  <label for=\"address\"><b>Address</b></label>\n");
      out.write("                  <input type=\"text\" placeholder=\"Address\" name=\"address\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"container\" style=\"background-color:#f1f1f1; display: flex\">\n");
      out.write("                  <button style=\"width: 48%; margin-right: 2%\" type=\"button\" onclick=\"document.getElementById('modalRegister').style.display='none'\" class=\"button-modal cancelbtn\">Cancel</button>\n");
      out.write("                  <button style=\"width: 48%; margin-left: 2%\" class=\"button-modal\" type=\"submit\">Register</button>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            // Get the modal\n");
      out.write("            var modalLogin = document.getElementById('modalLogin');\n");
      out.write("            var modalRegister = document.getElementById('modalRegister');\n");
      out.write("            // When the user clicks anywhere outside of the modal, close it\n");
      out.write("            window.onclick = function(event) {\n");
      out.write("                if (event.target === modalLogin) {\n");
      out.write("                    modalLogin.style.display = \"none\";\n");
      out.write("                }\n");
      out.write("                if (event.target === modalRegister) {\n");
      out.write("                    modalRegister.style.display = \"none\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
