<%@ page import="com.jsp.basic.chap02.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
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
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Web Study</title>
</head>
<body>
    <h1><%= dancer.getName()%>님 이 등록되셨습니다.</h1>
    <a href="/chap03/dancer/show-list.jsp">댄서 목록 보아보기(jsp버전)</a>
</body>
</html>