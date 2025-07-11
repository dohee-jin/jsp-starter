package com.jsp.basic.chap04;

import com.jsp.basic.chap02.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mvc/v1/show")
public class ShowDancerListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dancer> dancerList = DancerRepository.getDancerList();

        // jsp 에게 댄서 목록을 전달
        req.setAttribute("dancers", dancerList);

        // 뷰 포워딩
        RequestDispatcher dp = req.getRequestDispatcher("/WEB-INF/chap04/dancer/list.jsp");
        dp.forward(req, resp);
    }
}
