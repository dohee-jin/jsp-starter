<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Web Study</title>
</head>
<body>
    <% for(int i = 1; i < 3; i ++){ %>
    <a href="https://www.naver.com">링크 <%= i%></a>
    <% } %>
</body>
</html>