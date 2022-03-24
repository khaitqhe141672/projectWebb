package org.apache.jsp.component;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script src=\"https://kit.fontawesome.com/c386bc4f78.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("<!-- Footer -->\n");
      out.write("<style>\n");
      out.write("    .footer {\n");
      out.write("        background-color: #252525;\n");
      out.write("        padding: 6rem 1rem;\n");
      out.write("        line-height: 3rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .footer-top__box span svg {\n");
      out.write("        width: 1.6rem;\n");
      out.write("        height: 1.6rem;\n");
      out.write("        fill: #ccc;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .footer-top__box span {\n");
      out.write("        margin-right: 1rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .footer__top {\n");
      out.write("        display: grid;\n");
      out.write("        grid-template-columns: repeat(4, 1fr);\n");
      out.write("        color: #ccc;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .footer-top__box a:link,\n");
      out.write("    .footer-top__box a:visited {\n");
      out.write("        display: block;\n");
      out.write("        color: #959595;\n");
      out.write("        font-size: 1.4rem;\n");
      out.write("        transition: 0.6s;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .footer-top__box a:hover {\n");
      out.write("        color: #eb0028;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .footer-top__box div {\n");
      out.write("        color: #959595;\n");
      out.write("        font-size: 1.4rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .footer-top__box h3 {\n");
      out.write("        font-size: 1.8rem;\n");
      out.write("        font-weight: 400;\n");
      out.write("        margin-bottom: 1rem;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<footer id=\"footer\" class=\"section footer\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"footer__top\">\n");
      out.write("            <div class=\"footer-top__box\">\n");
      out.write("                <h3>EXTRAS</h3>\n");
      out.write("                <a href=\"#\">Brands</a>\n");
      out.write("                <a href=\"#\">Gift Certificates</a>\n");
      out.write("                <a href=\"#\">Affiliate</a>\n");
      out.write("                <a href=\"#\">Specials</a>\n");
      out.write("                <a href=\"#\">Site Map</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer-top__box\">\n");
      out.write("                <h3>INFORMATION</h3>\n");
      out.write("                <a href=\"#\">About Us</a>\n");
      out.write("                <a href=\"#\">Privacy Policy</a>\n");
      out.write("                <a href=\"#\">Terms & Conditions</a>\n");
      out.write("                <a href=\"#\">Contact Us</a>\n");
      out.write("                <a href=\"#\">Site Map</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer-top__box\">\n");
      out.write("                <h3>MY ACCOUNT</h3>\n");
      out.write("                <a href=\"#\">My Account</a>\n");
      out.write("                <a href=\"#\">Order History</a>\n");
      out.write("                <a href=\"#\">Wish List</a>\n");
      out.write("                <a href=\"#\">Newsletter</a>\n");
      out.write("                <a href=\"#\">Returns</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer-top__box\">\n");
      out.write("                <h3>CONTACT US</h3>\n");
      out.write("                <div>\n");
      out.write("                    <span>\n");
      out.write("                        <svg>\n");
      out.write("                        <use xlink:href=\"./images/sprite.svg#icon-location\"></use>\n");
      out.write("                        </svg>\n");
      out.write("                    </span> 42 Dream House, Dreammy street, 7131 Dreamville, USA\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <span>\n");
      out.write("                        <svg>\n");
      out.write("                        <use xlink:href=\"./images/sprite.svg#icon-envelop\"></use>\n");
      out.write("                        </svg>\n");
      out.write("                    </span> company@gmail.com\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <span>\n");
      out.write("                        <svg>\n");
      out.write("                        <use xlink:href=\"./images/sprite.svg#icon-phone\"></use>\n");
      out.write("                        </svg>\n");
      out.write("                    </span> 456-456-4512\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <span>\n");
      out.write("                        <svg>\n");
      out.write("                        <use xlink:href=\"./images/sprite.svg#icon-paperplane\"></use>\n");
      out.write("                        </svg>\n");
      out.write("                    </span> Dream City, USA\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"footer__bottom\">\n");
      out.write("        <div class=\"footer-bottom__box\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer-bottom__box\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</footer>\n");
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
