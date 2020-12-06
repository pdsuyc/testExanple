<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login_title"/></title>
</head>
<a href="two?language=zh_CN">中文</a>|
<a href="two?language=en_US">English</a><br>
<body>
	<form action="two" method="post">
	<spring:message code="login_name"/><input type="text" name="uname"><br>
	<spring:message code="login_pass"/><input type="password" name="upass"><br>
	<input type="submit" value="<spring:message code="submit"/>">
	</form>
	语言:
	${sessionScope.lang}
	${sessionScope.session_locale}
</body>
</html>