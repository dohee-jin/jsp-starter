package com.jsp.basic.chap04;

import com.jsp.basic.chap02.DanceLevel;
import com.jsp.basic.chap02.Dancer;
import com.jsp.basic.chap02.DancerRepository;
import com.jsp.basic.chap02.Genre;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mvc/v1/process")
public class MvcProcessServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        // DancerProcessServlet
        // 넘어온 쿼리스트링(?a=b)을 읽어야 함
        String name = request.getParameter("name");
        String crewName = request.getParameter("crewName");
        String danceLevel = request.getParameter("danceLevel");
        String[] genres = request.getParameterValues("genres");

        List<Genre> genreList = new ArrayList<>();
        for (String g : genres) {
            genreList.add(Genre.valueOf(g));
        }
        Dancer dancer = new Dancer(name, crewName, DanceLevel.valueOf(danceLevel), genreList);
        DancerRepository.addDancer(dancer);

        // 이 서블릿은 jsp 에게 출력에 필요한 데이터들을 전달해줘야 함.
        request.setAttribute("dancerName", name);

        // 뷰 포워딩
        RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/chap04/dancer/result.jsp");
        dp.forward(request, resp);

    }
}
