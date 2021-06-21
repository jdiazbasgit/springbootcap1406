<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>ESTAMOS EN UN CURSO DE SPRING</h1>
	
		<h1>ESTA ES MI PAGINA DE LOGIN</h1>

	<spring:form action="autenticar" modelAttribute="login" method="POST">
usuario:<spring:input path="usuario" />
		<br>
clave: <spring:password path="clave" /><br>
		<button>ENVIAR</button>
	</spring:form>




</body>
</html>