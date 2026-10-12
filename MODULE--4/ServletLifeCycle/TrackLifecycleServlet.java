/*
Servlet demonstrating init(), service(), and destroy() life-cycle methods.
*/
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class TrackLifecycleServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        getServletContext().log("init() method executed");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().log("service() method executed");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><h1>Servlet Life Cycle</h1>"
                + "<p>init() is called once when the servlet starts.</p>"
                + "<p>service() is called for this request.</p>"
                + "<p>destroy() is logged when the servlet stops.</p></body></html>");
    }

    @Override
    public void destroy() {
        getServletContext().log("destroy() method executed");
    }
}
