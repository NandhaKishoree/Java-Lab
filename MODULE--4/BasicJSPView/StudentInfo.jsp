<%-- Basic JSP lifecycle demonstration and student details rendering --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String stdName = "Asha";
    int stdRoll = 101;
    String stdCourse = "Java Enterprise";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Basic JSP View</title>
</head>
<body>
    <h1>Student Information</h1>
    <p>Student Name: <%= stdName %></p>
    <p>Roll Number: <%= stdRoll %></p>
    <p>Course: <%= stdCourse %></p>
    <h2>JSP Life Cycle Stages</h2>
    <ol>
        <li>Translation of JSP into a Java Servlet source file</li>
        <li>Compilation of the generated servlet bytecode</li>
        <li>Execution of the servlet by the container to serve requests</li>
    </ol>
</body>
</html>
