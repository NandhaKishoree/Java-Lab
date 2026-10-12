<%-- Standard JSP actions: jsp:include, jsp:forward, jsp:useBean, jsp:setProperty, jsp:getProperty. --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    if ("yes".equals(request.getParameter("forward"))) {
%>
<jsp:forward page="ForwardTarget.jsp"/>
<%
    }
%>
<jsp:useBean id="stdBean" class="studentactions.StudentBean" scope="page"/>
<jsp:setProperty name="stdBean" property="name" param="name"/>
<jsp:setProperty name="stdBean" property="course" param="course"/>
<!DOCTYPE html>
<html>
<head><title>JSP Action Tags</title></head>
<body>
    <h1>Standard JSP Actions</h1>
    <form method="get">
        <label>Name: <input name="name"></label>
        <label>Course: <input name="course"></label>
        <button type="submit">Set properties</button>
    </form>
    <p>Name: <jsp:getProperty name="stdBean" property="name"/></p>
    <p>Course: <jsp:getProperty name="stdBean" property="course"/></p>
    <jsp:include page="Included.jsp"/>
    <p><a href="StudentActions.jsp?forward=yes">Forward to the target page</a></p>
</body>
</html>
