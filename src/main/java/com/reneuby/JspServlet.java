package com.reneuby;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/jspServlet"})
public class JspServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> users = new ArrayList<User>() {
            {
                add(new User("John", "USA", 30));
                add(new User("Jamal", "Spain", 34));
                add(new User("Ivan", "Ukraine", 28));
            }
        };
        req.setAttribute("Users", users);
        getServletContext().getRequestDispatcher("/first.jsp").forward(req, resp);
    }
}
