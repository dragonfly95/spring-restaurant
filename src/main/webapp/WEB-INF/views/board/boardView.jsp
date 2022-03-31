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


<table>
    <tr>
        <td>Id</td>
        <td>${board.id}</td>
    </tr>
    <tr>
        <td>제목</td>
        <td>${board.title}</td>
    </tr>
    <tr>
        <td>내용</td>
        <td>${board.content}</td>
    </tr>
    <tr>
        <td>등록일</td>
        <td>${board.reg_date}</td>
    </tr>
</table>

<br/>
<br/>
<input type="button" name="btnList" value="목록" onclick="location.href='./board.do'"/>
<input type="button" name="btnEdit" data-id="${board.id}" value="수정하기"/>

<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script>
$(document).ready(function() {
    $('[name="btnEdit"]').on('click', function() {
        var id = $(this).data('id');
        location.href = './boardForm.do?id=' + id;
    });
});
</script>
</body>
</html>
