<%--
Custom JSP Tag and Expression Language (EL) application.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="lab" uri="/WEB-INF/student.tld" %>
<jsp:useBean id="student" class="studentapp.Student" scope="request" />
<jsp:setProperty name="student" property="name" param="name" />
<jsp:setProperty name="student" property="course" param="course" />
<%
    request.setAttribute("message", "Student details from a request attribute.");
%>
<!DOCTYPE html>
<html>
<head><title>Custom Tag and EL</title></head>
<body>
    <h1>Custom Student Tag</h1>
    <p><lab:studentInfo student="${student}" /></p>
    <h2>Expression Language</h2>
    <p>Bean name: ${student.name}</p>
    <p>Request parameter: ${param.department}</p>
    <p>Request attribute: ${requestScope.message}</p>
    <form method="get">
        <label>Name: <input name="name"></label>
        <label>Course: <input name="course"></label>
        <label>Department: <input name="department"></label>
        <button type="submit">Show values</button>
    </form>
</body>
</html>
