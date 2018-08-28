<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>进入中</title>
</head>
<body>
    <%
    	String site="http://localhost/";
    	response.setStatus(response.SC_MOVED_TEMPORARILY);
    	response.setHeader("Location",site);
    %>
</body>
<script>
     window.location.href="http://localhost/homepage.jsp";
</script>
</html>
