/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.41
 * Generated at: 2021-05-26 13:15:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.muldel.dto.MDBoardDto;
import java.util.List;
import com.muldel.biz.MDBoardBizImpl;
import com.muldel.biz.MDBoardBiz;

public final class boardlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.muldel.biz.MDBoardBizImpl");
    _jspx_imports_classes.add("com.muldel.dto.MDBoardDto");
    _jspx_imports_classes.add("com.muldel.biz.MDBoardBiz");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
request.setCharacterEncoding("UTF-8"); 
      out.write('\n');
response.setContentType("text/html; charset=UTF-8"); 
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-latest.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("\t$(function(){\n");
      out.write("\t\t// muldelform이라는 id를 가진 태그 (form 태그)에서 submit 이벤트가 발생 시\n");
      out.write("\t\t$(\"#muldelform\").submit(function(){\n");
      out.write("\t\t\t// 유효성 검사\n");
      out.write("\t\t\tif($(\"#muldelform input:checked\").length == 0){\n");
      out.write("\t\t\t\talert(\"하나 이상 체크해 주세요\");\n");
      out.write("\t\t\t\t// submit 이벤트가 중지 (이벤트 전파 막기)\n");
      out.write("\t\t\t\treturn false;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t$(\"input[name=chk]\").click(function(){\n");
      out.write("\t        if($(\"input[name=chk]\").length == $(\"input[name=chk]:checked\").length){\n");
      out.write("\t            //input name chk 가 3개니까 렝쓰가 3인데 그거랑 체크된개 만약 같다면 즉 3이라면 전체선택하자 \n");
      out.write("\t            $(\"input[name=all]\").prop(\"checked\",true);\n");
      out.write("\t        }else{\n");
      out.write("\t            $(\"input[name=all]\").prop(\"checked\",false);\n");
      out.write("\t        }\n");
      out.write("\t    });\n");
      out.write("\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\tfunction allchk(bool){\n");
      out.write("\t\tvar chks = document.getElementsByName(\"chk\");\n");
      out.write("\t\tfor(var i = 0; i < chks.length; i++){\n");
      out.write("\t\t\tchks[i].checked = bool;\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("</head>\n");

	MDBoardBiz biz = new MDBoardBizImpl();
	List<MDBoardDto> list = biz.selectList();

      out.write("\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t\n");
      out.write("\t<h1>list</h1>\n");
      out.write("\t\n");
      out.write("\t<form action=\"./multidelete.jsp\" method=\"post\" id=\"muldelform\">\n");
      out.write("\t\t<table border=\"1\">\n");
      out.write("\t\t\t<col width=\"30px\">\n");
      out.write("\t\t\t<col width=\"50px\">\n");
      out.write("\t\t\t<col width=\"100px\">\n");
      out.write("\t\t\t<col width=\"300px\">\n");
      out.write("\t\t\t<col width=\"250px\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<th><input type=\"checkbox\" name=\"all\" onclick=allchk(this.checked);></th>\n");
      out.write("\t\t\t\t<th>번호</th>\n");
      out.write("\t\t\t\t<th>작성자</th>\n");
      out.write("\t\t\t\t<th>제목</th>\n");
      out.write("\t\t\t\t<th>작성일</th>\n");
      out.write("\t\t\t</tr>\n");

		if(list.size() == 0){

      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td colspan=\"5\">----------작성된 글이 없습니다----------</td>\n");
      out.write("\t\t\t</tr>\n");

		} else {
			for(MDBoardDto dto : list){

      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<th><input type=\"checkbox\" name=\"chk\" value=\"");
      out.print(dto.getSeq() );
      out.write("\"></th>\n");
      out.write("\t\t\t\t<td>");
      out.print(dto.getSeq() );
      out.write("</td>\n");
      out.write("\t\t\t\t<td>");
      out.print(dto.getWriter() );
      out.write("</td>\n");
      out.write("\t\t\t\t<td><a href=\"boardselect.jsp?seq=");
      out.print(dto.getSeq() );
      out.write('"');
      out.write('>');
      out.print(dto.getTitle() );
      out.write("</a></td>\n");
      out.write("\t\t\t\t<td>");
      out.print(dto.getRegdate() );
      out.write("</td>\n");
      out.write("\t\t\t</tr>\n");

		}
	}

      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td colspan=\"5\" align=\"right\">\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"선택삭제\">\n");
      out.write("\t\t\t\t\t<input type=\"button\" onclick=\"location.href='boardinsert.jsp'\" value=\"글작성\">\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\t\n");
      out.write("\t\t</table>\n");
      out.write("\t</form>\n");
      out.write("\t\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
