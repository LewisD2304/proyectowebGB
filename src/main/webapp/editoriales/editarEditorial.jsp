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
	Editorial editorial;

	if (request.getAttribute("editorial") == null) {
		editorial = new Editorial();
	} else {
		editorial = (Editorial) request.getAttribute("editorial");

	}
	%>
	<div class="mb-3">
		<form role="form" action="<%=url%>EditorialController?" method="POST">

			<input type="hidden" class="form-control" name="op" value="modificarEdit">
			<input type="hidden" name="id" value="<%=editorial.getIdEditorial()%>" />
	</div>
	<h1>REGISTRO DE EDITORIAL</h1>
	<div class="mb-3">
		<label class="form-label" for="nombre">Nombre: </label> <br> <input
			type="text" class="form-control" name="nombre" id="nombre" aria-describedby="nombre" value="<%=editorial.getNombre()%>" /><br>
	</div>
	<div class="mb-3">
		<label class="form-label" for="contacto">Contacto: </label> <br> <input
			type="text" class="form-control" name="contacto" id="contacto" aria-describedby="contacto" value="<%=editorial.getContacto()%>" /><br>
	</div>
	<div class="mb-3">
		<label class="form-label" for="telefono">Telefono: </label> <br> <input
			class="form-control" type="text" name="telefono" id="telefono" aria-describedby="telefono"
			value="<%=editorial.getTelefono()%>" /> <br> <input
			type="submit" class="btn btn-info" value="Guardar" name="Guardar">
		<a class="btn btn-danger" href="<%=url%>EditorialController?op=listarEdit">Cancelar</a>
		</form>
	</div>


</body>
</html>