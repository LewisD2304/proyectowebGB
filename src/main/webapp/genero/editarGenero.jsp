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
	Genero genero;

	if (request.getAttribute("genero") == null) {
		genero = new Genero();
	} else {
		genero = (Genero) request.getAttribute("genero");
		System.out.println(genero.getIdGenero());
		System.out.println(genero.getNombre());
		System.out.println(genero.getDescripcion());

	}
	%>
	<div class="mb-3">
		<form role="form" action="<%=url%>GeneroController" method="POST">

			<input type="hidden" class="form-control" name="op" value="modificar">
			<input type="hidden" name="id" value="<%=genero.getIdGenero()%>" />
	</div>
	<h1>MODIFICAR GENERO</h1>
	<div class="mb-3">
		<label class="form-label" for="nombre">Nombre del Genero: </label> <br> <input
			type="text" class="form-control" name="nombre" id="nombre" aria-describedby="nombre" value="<%=genero.getNombre()%>" /><br>
	</div>
	<div class="mb-3">
		<label class="form-label" for="descripcion">Descripcion: </label> <br> <input
			class="form-control" type="text" name="descripcion" id="descripcion" aria-describedby="descripcion"
			value="<%=genero.getDescripcion()%>" /> <br> <input
			type="submit" class="btn btn-info" value="Guardar" name="Guardar">
		<a class="btn btn-danger" href="<%=url%>GeneroController?op=listar">Cancelar</a>
		</form>
	</div>


</body>
</html>