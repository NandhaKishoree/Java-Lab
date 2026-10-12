<%-- JSP pages demonstrating page directive attributes: import, contentType, and errorPage. --%>
<%@ page import="java.util.Date" contentType="text/html; charset=UTF-8" errorPage="DirectiveError.jsp" %>
<%
    String mode = request.getParameter("mode");
    if ("error".equals(mode)) {
        throw new ArithmeticException("Requested demonstration error");
    }
    Date serverTime = new Date();
%>
<!DOCTYPE html>
<html>
<head><title>Page Directives</title></head>
<body>
    <h1>Page Directive Attributes</h1>
    <p>The import attribute makes Date available to this JSP.</p>
    <p>The contentType attribute sets this response to HTML with UTF-8 encoding.</p>
    <p>Today: <%= serverTime %></p>
    <p>The errorPage attribute sends exceptions to DirectiveError.jsp.</p>
    <p><a href="DirectivesTest.jsp?mode=error">Test the error page</a></p>
</body>
</html>
