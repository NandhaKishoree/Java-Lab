/*
Shopping cart session application using HttpSession to maintain user state.
*/
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String items = (String) session.getAttribute("items");

        if (items == null) {
            items = "Cart is empty";
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Shopping Cart</h1>");
        out.println("<p>Items: " + items + "</p>");
        out.println("<form method='post' action='cart'>");
        out.println("<button name='item' value='Book'>Add Book</button> ");
        out.println("<button name='item' value='Pen'>Add Pen</button> ");
        out.println("<button name='item' value='clear'>Clear Cart</button>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String item = req.getParameter("item");
        String items = (String) session.getAttribute("items");

        if ("clear".equals(item)) {
            session.setAttribute("items", "Cart is empty");
        } else if (items == null || "Cart is empty".equals(items)) {
            session.setAttribute("items", item);
        } else {
            session.setAttribute("items", items + ", " + item);
        }

        resp.sendRedirect("cart");
    }
}
