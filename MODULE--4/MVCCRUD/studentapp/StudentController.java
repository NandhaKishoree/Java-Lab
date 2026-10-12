/*
MVC application to add, view, update and delete student records using JSP, Servlet and JDBC.
*/
package studentapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_db", "root", "root");
            String action = req.getParameter("action");

            if ("edit".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                PreparedStatement ps = conn.prepareStatement(
                        "SELECT id, name, course FROM students WHERE id = ?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    Student std = new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("course"));
                    req.setAttribute("student", std);
                }
            } else {
                List<Student> students = new ArrayList<>();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, name, course FROM students");

                while (rs.next()) {
                    Student std = new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("course"));
                    students.add(std);
                }

                req.setAttribute("students", students);
            }

            conn.close();
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_db", "root", "root");

            if ("delete".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                PreparedStatement ps = conn.prepareStatement(
                        "DELETE FROM students WHERE id = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
            } else if ("update".equals(action)) {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE students SET name = ?, course = ? WHERE id = ?");
                ps.setString(1, req.getParameter("name"));
                ps.setString(2, req.getParameter("course"));
                ps.setInt(3, Integer.parseInt(req.getParameter("id")));
                ps.executeUpdate();
            } else {
                PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO students (name, course) VALUES (?, ?)");
                ps.setString(1, req.getParameter("name"));
                ps.setString(2, req.getParameter("course"));
                ps.executeUpdate();
            }

            conn.close();
            resp.sendRedirect("students");
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}
