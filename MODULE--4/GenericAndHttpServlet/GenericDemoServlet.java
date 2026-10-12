/*
Create one Servlet using GenericServlet and another using HttpServlet, and demonstrate their differences.
*/
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/generic")
public class GenericDemoServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>GenericServlet</h1><p>Uses protocol-independent request and response objects.</p>");
    }
}
