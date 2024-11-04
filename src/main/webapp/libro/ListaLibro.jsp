<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.unu.proyectoWeb.beans.*"%>

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
		location.href = "LibroController?op=eliminar&id="+id;
	}
}

</script>

</head>
<body>

	<%
	String url = "http://localhost:8080/proyectoWeb/";
	//con el ? referencia a enviar un parametro
	%>
	
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <a class="navbar-brand" href="/proyectoWeb/index.jsp">INICIO</a>
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="AutoresController?op=listar">Autores <span class="sr-only">(Libros)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="EditorialController?op=listarEdit">Editoriales</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="GeneroController?op=listar">Generos</a>
      </li>
    </ul>
    
    
  </div>
</nav>
	
<div class="d-flex justify-content-end mb-3">
  <p class="d-inline-flex gap-1">
    <a class="btn btn-primary" role="button" aria-expanded="false" type="button" href="<%=url%>LibroController?op=agregar">
      Añadir Libro
    </a>
  </p>
</div>

 

	<div class="container">


		<table class="table table-striped">
			<thead class="table">
				<tr>
					<th>Codigo del Libro</th>
					<th>Nombre del Libro</th>
					<th>Existencia</th>
					<th>Precio</th>
					<th>Autor</th>
					<th>Editorial</th>
					<th>Genero</th>
					<th>Operaciones</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Libro> listaLibro = (List<Libro>) request.getAttribute("ListaLibro");

				// Verificar si la lista no es nula
				if (listaLibro != null) {
					for (Libro libro : listaLibro) {
				%>
				<tr>
					<td><%=libro.getIdlibro()%></td>
					<td><%=libro.getNombre()%></td>
					<td><%=libro.getExistencias()%></td>
					<td><%=libro.getPrecio()%></td>
					<td><%=libro.getAutor()%></td>
					<td><%=libro.getEditorial()%></td>
					<td><%=libro.getGenero()%></td>
					<td><a
						href="<%=url%>LibroController?op=obtener&id=<%=libro.getIdlibro()%>"
						class="btn btn-secondary">Modificar</a> <!-- 
						<a
						href="<%=url%>AutoresController?op=eliminar&id=<%=libro.getIdlibro()%>">Eliminar</a>
					 --> <a href="javascript:eliminar('<%=libro.getIdlibro()%>')"
						class="btn btn-danger">Eliminar</a></td>

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