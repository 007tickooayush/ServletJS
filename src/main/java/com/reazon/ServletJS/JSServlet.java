package com.reazon.ServletJS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "JSServlet", value = "/JSServlet")
public class JSServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<html>" +
                "<head>" +
                "<script>");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/javascript/validate.js");
        requestDispatcher.include(request,response);
        printWriter.print(
                "</script>" +
                "</head>" +
                "<body>" +
                "<form action=\"success.jsp\">" +
                "username: <input type = \"text\" name=\"username\"><br><br>" +
                "<button type=\"submit\" onsubmit=\"return validateUserName(this.username.value)\">Submit</button>" +
                "</form>" +
                "</body>" +
                "</html>");
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
