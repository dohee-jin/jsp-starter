package com.jsp.basic.chap04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc/v1/new")
public class AddNewDancerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // dancer-register.jsp를 열어줌
        // 뷰 포워딩: jsp나 thymeleaf 같은 뷰 템플릿을 찾아서 열어주는 개념

        RequestDispatcher dp = req.getRequestDispatcher("/WEB-INF/chap04/dancer/dancer-register.jsp");
        dp.forward(req, resp);
    }
}
