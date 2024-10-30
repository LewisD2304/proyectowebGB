<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//AÑADIR UN BOTON
	String url = "http://localhost:8080/proyectoWeb/";
	//con el ? referencia a enviar un parametro
	%>
	<div class="mb-3">
		<h3>Nuevo Autor</h3>
	<form role="form" action="<%=url%>AutoresController" method="POST">
		<input type="hidden" name="op" value="insertar">

		<label for="nombre">Nombre del autor: </label> <input type="text"
			class="form-control" name="nombre" id="nombre" value=""
			placeholder="Ingresa el nombre del autor"> <span
			class="input-group-addon"><span
			class="glyphicon 
glyphicon-asterisk"></span></span>


		<div class="form-group">
			<label for="contacto">Nacionalidad del autor: </label>
			<div class="input-group">
				<input type="text" class="form-control" id="contacto" value=""
					name="nacionalidad" placeholder="Ingresa la nacionalidad del autor">
				<span class="input-group-addon"><span
					class="glyphicon 
glyphicon-asterisk"></span></span>
			</div>
		</div>
		
		<input type="submit" class="btn btn-info" value="Guardar"
			name="Guardar"> <a class="btn btn-danger"
			href="<%=url%>AutoresController?op=listar">Cancelar</a>
	</form>
	</div>
	

</body>
</html>