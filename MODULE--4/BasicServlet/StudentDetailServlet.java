/*
Servlet displaying student profile details using HttpServletResponse.
*/
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student-profile")
public class StudentDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><h1>Student Profile</h1>"
                + "<p>Student Name: Asha</p><p>Roll Number: 101</p><p>Department: Computer Science</p>"
                + "</body></html>");
    }
}
