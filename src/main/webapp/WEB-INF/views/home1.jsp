<%--
  Created by IntelliJ IDEA.
  User: taeho
  Date: 2023/01/05
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="hello">안녕하세요</a><br/>
    <a href="message/detail/11">URL에 포함된 매개변수</a><br/>
    <a href="redirect">리다이렉트</a>
    <!-- action은 생략하면 현재요청-->
    <form action="param1">
        이름 : <input type="text" name="name" /><br/>
        비번 : <input type="password" name="password" /><br/>
        <input type="submit" value="전송">
    </form>
    <form action="param2" method="post">
        이름 : <input type="text" name="name" /><br/>
        비번 : <input type="password" name="password" /><br/>
        <input type="submit" value="전송">
    </form>
    <form action="param3" method="post">
        이름 : <input type="text" name="name" /><br/>
        비번 : <input type="password" name="password" /><br/>
        <input type="submit" value="전송">
    </form>
</body>
</html>
