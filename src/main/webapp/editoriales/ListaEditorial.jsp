<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.unu.proyectoWeb.beans.Editorial"%>
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
	
	
	<script>
	function eliminarEdit(id){
		if(confirm("¿Desea eliminar el registro?") == true){
			location.href = "EditorialController?op=eliminarEdit&id="+id;
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
			<a class="btn btn-primary" role="button" aria-expanded="false"
				type="button" href="<%=url%>EditorialController?op=agregarEdit">
				Añadir Editorial </a> <span
				class="position-absolute top-0 start-100 translate-middle badge rounded-pill text-bg-secondary">+99
				<span class="visually-hidden">unread messages</span>
			</span>
		</p>
	</div>

	<div class="container">


		<table class="table table-striped">
			<thead class="table">
				<tr>
					<th>Codigo de Editorial</th>
					<th>Nombre de EDitorial</th>
					<th>contacto</th>
					<th>Telefono</th>
					<th>Operaciones</th>
				</tr>
			</thead>
			<tbody>
				<%
				//List<Editorial> listaEdt = (List<Editorial>) request.getAttribute("ListaEditorial");
				List<Editorial> listaEdt = (List<Editorial>) request.getAttribute("ListaEditorial");

				// Verificar si la lista no es nula
				if (listaEdt != null) {
					for (Editorial editorial : listaEdt) {
				%>
				<tr>
					<td><%=editorial.getIdEditorial()%></td>
					<td><%=editorial.getNombre()%></td>
					<td><%=editorial.getContacto()%></td>
					<td><%=editorial.getTelefono()%></td>
					<td>
						
						<a
						href="<%=url%>EditorialController?op=obtenerEdit&id=<%=editorial.getIdEditorial()%>"
						class="btn btn-secondary">Modificar</a> 
						<a href="javascript:eliminarEdit('<%=editorial.getIdEditorial()%>')"
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