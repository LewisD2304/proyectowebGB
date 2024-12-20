<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	%>
	<div class="mb-3" >
		<h3>Nuevo Autor</h3>
		<form role="form" action="<%=url%>AutoresController" method="POST">
			<input type="hidden" name="op" value="insertar"> <label
				for="nombre">Nombre del autor: </label> <input type="text"
				class="form-control" name="nombre" id="nombre" value=""
				placeholder="Ingresa el nombre del autor"> <span
				class="input-group-addon"><span
				class="glyphicon glyphicon-asterisk"></span></span>


			<div class="form-group">
				<label for="contacto">Nacionalidad del autor: </label>
				<div class="input-group">
					<input type="text" class="form-control" id="contacto" value=""
						name="nacionalidad"
						placeholder="Ingresa la nacionalidad del autor"> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>

			<input type="submit" class="btn btn-info" value="Guardar"
				name="Guardar"> <a class="btn btn-danger"
				href="<%=url%>AutoresController?op=listar">Cancelar</a>
		</form>
	</div>


</body>
</html>