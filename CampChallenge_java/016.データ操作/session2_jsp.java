package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class session2_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');

    //requestで取得する値の文字コードを指定
    request.setCharacterEncoding("UTF-8");
    
    //セッションの開始
    HttpSession hs = request.getSession();
    
    //名前(text)に入力された情報をセッションに登録し、String型に変換
    hs.setAttribute("Name", request.getParameter("txtName"));
    String name = (String)hs.getAttribute("Name");
    
    //性別(radio)に入力された情報をセッションに登録
    hs.setAttribute("Sex", request.getParameter("rdoSex"));
    String sex = (String)hs.getAttribute("Sex");
    
    //趣味(textarea)に入力された情報をセッションに登録し、String型に変換
    hs.setAttribute("Hobby", request.getParameter("mulHobby"));
    String hobby = (String)hs.getAttribute("Hobby");    

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>入力フォーム</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"./session2.jsp\" method=\"post\">\n");
      out.write("            名前：\n");
      out.write("            <input type=\"text\" name=\"txtName\" value=\"");
 if(name != null){out.print(name);} 
      out.write("\"><br>\n");
      out.write("            性別：\n");
      out.write("            <input type=\"radio\" name=\"rdoSex\" value=\"0\" ");
 if(sex != null && sex.equals("0")){out.print("checked");} 
      out.write(">男性　\n");
      out.write("            <input type=\"radio\" name=\"rdoSex\" value=\"1\" ");
 if(sex != null && sex.equals("1")){out.print("checked");} 
      out.write(">女性<br>\n");
      out.write("            趣味：\n");
      out.write("            <textarea name=\"mulHobby\">");
 if(hobby != null){out.print(hobby);} 
      out.write("</textarea><br>\n");
      out.write("            <input type=\"submit\" name=\"btnSubmit\">\n");
      out.write("        \n");
      out.write("        </form>\n");
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
