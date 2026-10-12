/*
Chained Servlet: ChainFirstServlet forwards to ChainSecondServlet using RequestDispatcher.
*/
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class ChainFirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        req.setAttribute("message", "Hello " + name);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/second");
        dispatcher.forward(req, resp);
    }
}
