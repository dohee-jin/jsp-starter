<%@ page import="com.jsp.basic.chap02.Dancer" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Web Study</title>
    <style>
        .del-btn {
            padding: 5px 10px;
            outline: none;
            border: none;
            background: red;
            border-radius: 10px;
            color: #fff;
            margin-left: 10px;
            margin-bottom: 10px;
            cursor: pointer;
            border: 1px solid transparent;
        }

        .del-btn:hover {
            border: 1px solid orange;
            opacity: 0.8;
        }
    </style>
</head>
<body>
    <h1>MVC버전 댄서정보 모아보기</h1>

    <ul class="dancer-list">
        <%--        <% for (Dancer d : (List<Dancer>)request.getAttribute("dancers")) { %>--%>
        <c:forEach var="d" items="${dancers}">
            <li>
                # 이름: ${d.name},
                # 크루이름: ${d.crewName},
                # 수준: ${d.danceLevel},
                # 장르: ${d.genres}
                <button class="del-btn">삭제</button>
            </li>
        </c:forEach>
        <%--        <% } %>--%>
    </ul>
    <a href="/mvc/v1/new">다시 댄서 등록하기</a>

    <script>
        // li 태그들에게 인덱스를 부여
        [...document.querySelectorAll('li')].forEach(($li, idx) => {
            $li.dataset.index = idx.toString();
        });

        document.querySelector('.dancer-list').addEventListener('click', e => {
            if(!e.target.matches('.del-btn')) return;

            // 삭제 타겟의 인덱스
            const index = e.target.closest('li').dataset.index;

            // 실제로 작세 요청(Url 요청)을 보내서 서버가 리스트에서 지우도록 해야함.
            window.location.href =`/mvc/v1/remove?targetId=` + index;

        })
    </script>
</body>
</html>