<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.unu.proyectoWeb.beans.Autor"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>PAGINA WEB</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

<script>
function eliminar(id){
	if(confirm("¿Desea eliminar el registro?") == true){
		location.href = "AutoresController?op=eliminar&id="+id;
	}
}

</script>

</head>
<body>

	<%
	String url = "http://localhost:8080/proyectoWeb/";
	//con el ? referencia a enviar un parametro
	%>

	<div class="container">


		<table class="table table-striped">
			<thead class="table">
				<tr>
					<th>Codigo del autor</th>
					<th>Nombre del autor</th>
					<th>Nacionalidad</th>
					<th>Operaciones</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Autor> listaAutores = (List<Autor>) request.getAttribute("ListaAutores");

				// Verificar si la lista no es nula
				if (listaAutores != null) {
					for (Autor autor : listaAutores) {
				%>
				<tr>
					<td><%=autor.getIdAutor()%></td>
					<td><%=autor.getNombre()%></td>
					<td><%=autor.getNacionalidad()%></td>
					<td>
						<a type="button" href="<%=url%>AutoresController?op=agregar" class="btn btn-primary">Añadir Autor</a>
						<a href="<%=url%>AutoresController?op=obtener&id=<%=autor.getIdAutor()%>"
						class="btn btn-secondary">Modificar</a> <!-- 
						<a
						href="<%=url%>AutoresController?op=eliminar&id=<%=autor.getIdAutor()%>">Eliminar</a>
					 --> <a
						href="javascript:eliminar('<%=autor.getIdAutor()%>')" class="btn btn-danger">Eliminar</a></td>

				</tr>
				<%
				}
				} else {
				%>

				<tr>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td></td>
				</tr>

				<%
				}
				%>


			</tbody>
		</table>

	</div>


</body>
</html>