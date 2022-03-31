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
    <c:if test="${not empty board}">
    <tr>
        <td>Id</td>
        <td>${board.id}</td>
    </tr>
    </c:if>
    <tr>
        <td>제목</td>
        <td><input type="text" name="title" value="${board.title}" /></td>
    </tr>
    <tr>
        <td>내용</td>
        <td>
            <textarea name="content">${board.content}</textarea>
        </td>
    </tr>
    <c:if test="${not empty board}">
    <tr>
        <td>등록일</td>
        <td>${board.reg_date}</td>
    </tr>
    </c:if>
</table>

<br/>
<br/>

<input type="button" name="btnList" value="목록" onclick="location.href='./board.do'"/>
<c:if test="${empty board}">
<input type="button" name="btnNew" value="신규등록"/>
</c:if>
<c:if test="${not empty board}">
<input type="button" name="btnSave" data-id="${board.id}" value="수정하기"/>
</c:if>

<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script>
$(document).ready(function() {

    // 수정
    $('[name="btnSave"]').on('click', function() {
        var dataObj = {
            'id': $(this).data('id'),
            'title': $('[name="title"]').val(),
            'content': $('[name="content"]').val()
        }

        $.ajax({
          type: "PUT",
          url: "./boardUpdate",
          data: JSON.stringify(dataObj),
          contentType: "application/json",
          success: function (response) {
            alert('Registered');
            location.href='./board.do'
          }
        });
        //-----------------------
    });


    // 신규등록
    $('[name="btnNew"]').on('click', function() {
        var dataObj = {
            'title': $('[name="title"]').val(),
            'content': $('[name="content"]').val()
        }

        $.ajax({
          type: "POST",
          url: "./boardNew",
          data: JSON.stringify(dataObj),
          contentType: "application/json",
          success: function (response) {
            alert('Registered');
            location.href='./board.do'
          }
        });
        //-----------------------
    });
});
</script>
</body>
</html>
