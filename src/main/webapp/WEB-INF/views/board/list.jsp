<%@ page language="java" isELIgnored="false" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>

<P>  The time on the server is ${serverTime}. </P>

<ul>
<c:forEach items="${list}" var="item">
    <li>${item.title} - ${item.content}</li>
</c:forEach>
</ul>

<br/>
<br/>
${page}
<br/>
<div id="pagination">
<c:forEach var="i" begin="${page.begin}" end="${page.end}">

    <c:if test="${page.begin != 1}">
        <c:if test="${page.begin == i}">
        [<a href='#' data-page='${i-1}'>Prev Page</a>]
        </c:if>
    </c:if>

    [<a href='#' data-page='${i}'>${i}</a>]

    <c:if test="${page.end < page.total}">
        <c:if test="${page.end == i}">
        [<a href='#' data-page='${i+1}'>Next Page</a>]
        </c:if>
    </c:if>
</c:forEach>
</div>


<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script>
$(document).ready(function() {
    $('#pagination a').on('click', function() {
        var page = $(this).data('page');
        location.href='./board.do?page=' + page;
    });
});
</script>
</body>
</html>
