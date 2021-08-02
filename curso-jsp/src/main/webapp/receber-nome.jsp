<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String nome = request.getParameter("nome");
	out.print("Nome: " + nome);
	out.print("\n \t");
	String idade = request.getParameter("idade");
	out.println("Idade: " + idade);
%>

</body>
</html>