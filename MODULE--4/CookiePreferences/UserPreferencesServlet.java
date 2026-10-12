/*
Servlet application storing user preferences in a cookie and retrieving it across requests.
*/
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/preferences")
public class UserPreferencesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String savedUser = "No name saved";
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie ck : cookies) {
                if ("userName".equals(ck.getName())) {
                    savedUser = ck.getValue().replace('_', ' ');
                    break;
                }
            }
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Cookie Preferences</h1>");
        out.println("<p>Saved name: " + savedUser + "</p>");
        out.println("<form method='post' action='preferences'>");
        out.println("Name: <input name='userName' required>");
        out.println("<button type='submit'>Save</button></form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("userName");
        if (userName != null) {
            Cookie userCookie = new Cookie("userName", userName.trim().replace(' ', '_'));
            userCookie.setMaxAge(60 * 60 * 24);
            resp.addCookie(userCookie);
        }
        resp.sendRedirect("preferences");
    }
}
