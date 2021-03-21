<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Login form
</h1>

<P>  The time on the server is ${serverTime}. </P>

    <table>
        <tr>
            <td>login ID</td>
            <td>
                <input type="text" name="userLogin" value="dragonfly95">
            </td>
        </tr>
        <tr>
            <td>Passowrd</td>
            <td>
                <input type="password" name="loginPassword" value="123456">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="로그인" name="btnLogin">
            </td>
        </tr>
    </table>

    <script src="https://code.jquery.com/jquery-3.1.0.js"></script>
    <script>
        $(document).ready(function () {
            $('[name="btnLogin"]').on('click', function() {

                if($('[name="userLogin"]').val() == '') {
                    alert('아이디를 입력해주세요');
                    return;
                }

                if($('[name="loginPassword"]').val() == '') {
                    alert('패스워드를 입력해주세요');
                    return;
                }

                $.ajax({
                    type: "post",
                    url: "mysite/login",
                    data: JSON.stringify({"userLogin": $('[name="userLogin"]').val(), "userPassword": $('[name="loginPassword"]').val()}),
                    contentType: 'application/json',
                    success: function (response) {
                        debugger
                        location.href='main.do';
                    }, error: function(error) {
                        alert(error.responseJSON.errorMessage);
                    }
                });

            })
        });
    </script>
</body>
</html>

