<%--
  Created by IntelliJ IDEA.
  User: GDD
  Date: 2021/11/26
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/upload.do">
        上传头像:<input type="submit" value="上传"/>
        </form>
    </div>
    hello,${sessionScope.user.username}!!!
    你今年${sessionScope.age}岁。
</body>
</html>


