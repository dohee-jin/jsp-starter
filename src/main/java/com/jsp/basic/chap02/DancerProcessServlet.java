package com.jsp.basic.chap02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chap02/dancer/process")
public class DancerProcessServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // form 에서 입력된 데이터를 읽어서 실제로 댄서목록에 추가해줘야 함
        System.out.println("댄서 등록 수행중....");
        String name = req.getParameter("name");
        String crewName = req.getParameter("crewName");
        String danceLevel = req.getParameter("danceLevel");
        String[] genres = req.getParameterValues("genres");


        List<Genre> genreList = new ArrayList<>();
        for (String g : genres) {
            genreList.add(Genre.valueOf(g));
        }

        Dancer dancer = new Dancer(
                name, crewName, DanceLevel.valueOf(danceLevel), genreList
        );
//        System.out.println("dancer = " + dancer);

        DancerRepository.addDancer(dancer);

        // 목록에 잘 쌓이는지 확인
        List<Dancer> dancerList = DancerRepository.getDancerList();
        dancerList.forEach(System.out::println);

        // 응답 html 생성
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();

        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("</head>\n");
        w.write("<body>\n");

        w.write("<h1>" + dancer.getName() + "님이 등록되었습니다. </h1>");
        w.write("<a href=\"/chap02/dancer/show-list\">댄서 정보 모아보기</a>");

        w.write("</body>\n");
        w.write("</html>");

    }
}
