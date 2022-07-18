<%--
  Created by IntelliJ IDEA.
  User: ds
  Date: 2022-05-10
  Time: 오후 4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.Calendar" %>
<%
    Calendar c = Calendar.getInstance();
    int hour = c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);
    int second = c.get(Calendar.SECOND);
%>
<html>
<head>
    <title>Hello Spring JSP</title>
</head>
<body>
<h1>JSP Hello SPRING</h1>
<h1>현재 시간은 <%=hour%>시 <%=minute%>분 <%=second%>초 입니다.</h1>
</body>
</html>
