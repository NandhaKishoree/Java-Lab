/*
Login application with protected resources accessible only to authenticated users.
*/
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login", "/protected"})
public class AuthLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if ("/protected".equals(req.getServletPath())) {
            HttpSession session = req.getSession(false);

            if (session == null || session.getAttribute("username") == null) {
                resp.sendRedirect("login");
                return;
            }

            out.println("<h1>Protected Page</h1>");
            out.println("<p>You are logged in as " + session.getAttribute("username") + ".</p>");
            return;
        }

        out.println("<h1>Login</h1>");
        out.println("<form method='post' action='login'>");
        out.println("Username: <input name='username' required><br>");
        out.println("Password: <input name='password' type='password' required><br>");
        out.println("<button type='submit'>Login</button></form>");
        out.println("<p>Use student and java123.</p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("student".equals(username) && "java123".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("protected");
        } else {
            PrintWriter out = resp.getWriter();
            out.println("<p>Login failed.</p>");
            out.println("<a href='login'>Try again</a>");
        }
    }
}
