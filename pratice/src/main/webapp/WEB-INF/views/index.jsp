<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<c:set var="loginId" value="${HttpServletRequest.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jewook pratice</title>
	<link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
</head>
<body>
<div id="menu">
	<ul>
		<li id="logo">pratice</li>
		<li><a href="<c:url value='/'/>">Home</a></li>
		<li><a href="<c:url value='/board/list'/>">Board</a></li>
		<li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
		<li><a href="<c:url value='/register/add'/>">Sign in</a></li>
		<li><a href=""><i class="fa fa-search"></i></a></li>
	</ul>
</div>
<div style="text-align:center">
	<h1>This is HOME</h1>
	<li><a href="<c:url value='/2'/>">심정체크</a></li>
	<li><a href="<c:url value='/'/>">심정체크 초기화</a></li>
	<P>지금 내심정 ${hi}. </P>
</div>
</body>
</html>

