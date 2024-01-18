<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page import="java.net.URLDecoder"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Info</title>
</head>
<body>
    <h1>id=${memerInfoDto.id}</h1>
    <h1>pwd=${memerInfoDto.pwd}</h1>
    <h1>name=${memerInfoDto.name}</h1>
    <h1>email=${memerInfoDto.email}</h1>
    <h1>birth=${memerInfoDto.birth}</h1>
	<h1>SNS:
        <c:forEach var="snsValue" items="${memerInfoDto.sns}">
			${snsValue}
        </c:forEach>
    </h1>
    <h2> 가입축하</h2>
</body>
</html>