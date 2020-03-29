package com.reneuby;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/secondPathForServlet"})
public class MainServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("init");
    }

    @Override
    public void destroy() {
        log("destroy");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String res = req.getParameterMap().entrySet().stream().map(e -> {
            String s = "Key: " + e.getKey() + " Values: " + String.join(" and ", e.getValue());
            return s;
        }).collect(Collectors.joining());
        resp.getWriter().write("\nUri: " + requestURI +
                "\n Result:\n" + res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("DoGET\n");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Service\n");
        super.service(req, resp);
    }
}
