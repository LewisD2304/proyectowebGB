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
		<h3>Nuevo Genero</h3>
		<form role="form" action="<%=url%>GeneroController" method="POST">
			<input type="hidden" name="op" value="insertar"> <label
				for="nombre">Nombre del genero: </label> <input type="text"
				class="form-control" name="nombre" id="nombre" value=""
				placeholder="Ingresa el nombre del Genero"> <span
				class="input-group-addon"><span
				class="glyphicon glyphicon-asterisk"></span></span>


			<div class="form-group">
				<label for="descripcion">Descripcion: </label>
				<div class="input-group">
					<input type="text" class="form-control" id="descripcion" value=""
						name="descripcion"
						placeholder="Ingresa descripcion"> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>

			<input type="submit" class="btn btn-info" value="Guardar"
				name="Guardar"> <a class="btn btn-danger"
				href="<%=url%>GeneroController?op=listar">Cancelar</a>
		</form>
	</div>


</body>
</html>