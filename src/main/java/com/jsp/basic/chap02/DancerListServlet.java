package com.jsp.basic.chap02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/chap02/dancer/show-list")
public class DancerListServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 사용자에게 댄서 목록을 랜더링해줌
        // 댄서 목록 불러오기
        List<Dancer> dancerList = DancerRepository.getDancerList();

        // 이 리스트를 화면에 출력
        // 결과 출력
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter w = resp.getWriter();

        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("</head>\n");
        w.write("<body>\n");

        w.write("<ul>");

        for (Dancer foundDancer : dancerList) {
            w.write(String.format("<li># 이름 : %s, 크루명: %s, 수준: %s, 장르: %s</li>\n"
                    , foundDancer.getName(),
                    foundDancer.getCrewName(),
                    foundDancer.getDanceLevel(),
                    foundDancer.getGenres()));
        }

        w.write("</ul>");

        w.write("<a href=\"/chap02/dancer/register\">새로운 등록하기</a>");

        w.write("</body>\n");
        w.write("</html>");
    }
}
