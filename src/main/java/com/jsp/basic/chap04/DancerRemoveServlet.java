package com.jsp.basic.chap04;

import com.jsp.basic.chap02.DancerRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc/v1/remove")
public class DancerRemoveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("삭제 요청이 들어옴!!");

        // 클라이언트가 보낸 데이터 읽기
        String index = req.getParameter("targetId");

        // 실제로 댄서리스트에서 요청이 들어온 댄서를 지워줘야함
        DancerRepository.removeDancer(Integer.parseInt(index));

        req.setAttribute("dancers", DancerRepository.getDancerList());

        // 뷰 포워딩 X
        // 리다이렉팅 -> 자동 재요청
        resp.sendRedirect("/mvc/v1/show");
    }
}
