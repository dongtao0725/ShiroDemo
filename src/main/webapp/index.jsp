<%@ page import="com.dongt.shiroDemo.domain.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    User user = (User)session.getAttribute("currentUser");
%>
<html>
<body>
<shiro:authenticated>
    <%=user.toString()%>
    <a href="${pageContext.request.contextPath}/user/logout">登出</a>
</shiro:authenticated>
<h2><shiro:principal/>Hello World!</h2>
<shiro:notAuthenticated>
    未身份验证（包括记住我）
</shiro:notAuthenticated>
</body>
</html>
