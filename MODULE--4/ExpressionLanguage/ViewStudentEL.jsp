<%--
Develop a JSP application using Expression Language (EL) to access JavaBean properties, request parameters, and request attributes.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="student" class="Student" scope="request" />
<%
    request.setAttribute("infoMsg", "This is an active request attribute.");
%>
<!DOCTYPE html>
<html>
<head><title>Expression Language View</title></head>
<body>
    <h1>Expression Language Example</h1>
    <p>Student name: ${student.name}</p>
    <p>Course: ${student.course}</p>
    <p>Request parameter: ${param.subject}</p>
    <p>Request attribute: ${requestScope.infoMsg}</p>
    <form method="get">
        <label>Subject: <input name="subject"></label>
        <button type="submit">Show values</button>
    </form>
</body>
</html>
