<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="com.jsp.basic.chap02.*" %>

<%
    // 댄서 목록 불러오기
    List<Dancer> dancerList = DancerRepository.getDancerList();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>JSP버전 댄서정보 모아보기</h1>

    <ul>
        <% for (Dancer d : dancerList) { %>
        <li>
            # 이름: <%= d.getName() %>,
            # 크루이름: <%= d.getCrewName() %>,
            # 수준: <%= d.getDanceLevel() %>,
            # 장르: <%= d.getGenres() %>
        </li>
        <% } %>
    </ul>
    <a href="/chap03/dancer/register.jsp">다시 댄서 등록하기</a>

</body>
</html>