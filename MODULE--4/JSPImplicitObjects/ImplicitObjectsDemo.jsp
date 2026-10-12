<%-- JSP page demonstrating commonly used implicit objects. --%>
<%@ page contentType="text/html; charset=UTF-8" errorPage="ImplicitError.jsp" %>
<%
    if ("yes".equals(request.getParameter("fail"))) {
        Integer.parseInt("not-a-number");
    }
    String userName = request.getParameter("name");
    if (userName == null) {
        userName = "No name supplied";
    }
    session.setAttribute("studentName", "Mina");
    application.setAttribute("courseName", "Java");
    response.setHeader("X-Assignment", "JSPImplicitObjects");
%>
<!DOCTYPE html>
<html>
<head><title>JSP Implicit Objects</title></head>
<body>
    <h1>Implicit Objects</h1>
    <p>request parameter: <%= userName %></p>
    <p>response content type: <%= response.getContentType() %></p>
    <p>session student: <%= session.getAttribute("studentName") %></p>
    <p>application course: <%= application.getAttribute("courseName") %></p>
    <p>out writes this message: <% out.print("Hello from out."); %></p>
    <p>config servlet name: <%= config.getServletName() %></p>
    <p>pageContext context path: <%= pageContext.getRequest().getServletContext().getContextPath() %></p>
    <p>page object: <%= page.getClass().getSimpleName() %></p>
    <p><a href="ImplicitObjectsDemo.jsp?fail=yes">Test the error page and exception object</a></p>
</body>
</html>
