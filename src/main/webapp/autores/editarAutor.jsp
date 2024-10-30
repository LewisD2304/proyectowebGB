<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.unu.proyectoWeb.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>


</head>
<body>
	<%
	//AÑADIR UN BOTON	
	String url = "http://localhost:8080/proyectoWeb/";
	//con el ? referencia a enviar un parametro
	Autor autor;

	if (request.getAttribute("autor") == null) {
		autor = new Autor();
	} else {
		autor = (Autor) request.getAttribute("autor");
		System.out.println(autor.getIdAutor());
		System.out.println(autor.getNombre());
		System.out.println(autor.getNacionalidad());

	}
	%>
	<div class="mb-3">
		<form role="form" action="<%=url%>AutoresController" method="POST">

			<input type="hidden" class="form-control" name="op" value="modificar">
			<input type="hidden" name="id" value="<%=autor.getIdAutor()%>" />
	</div>
	<h1>REGISTRO DE AUTOR</h1>
	<div class="mb-3">
		<label for="nombre">Nombre del autor: </label> <br> <input
			type="text" name="nombre" id="nombre" value="<%=autor.getNombre()%>" /><br>
	</div>
	<div class="mb-3">
		<label for="nacionalidad">Nacionalidad del autor: </label> <br> <input
			type="text" name="nacionalidad" id="nacionalidad"
			value="<%=autor.getNacionalidad()%>" /> <br> <input
			type="submit" class="btn btn-info" value="Guardar" name="Guardar">
		<a class="btn btn-danger" href="<%=url%>AutoresController?op=listar">Cancelar</a>
		</form>
	</div>


</body>
</html>