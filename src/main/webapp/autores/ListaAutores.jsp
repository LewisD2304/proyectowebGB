<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="com.unu.proyectoWeb.beans.Autor" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAGINA WEB</title>

</head>
<body>
<table id="tabla" border="1">
	<thead>
		<tr>
			<th>Codigo del Autor</th>
			<th>Nombre del autor</th>
			<th>Nacionalidad</th>
			<th>Operaciones</th>
		</tr>	
	</thead>
	<tbody>
		<% //SE PUEDE USAR EN MAS DE UNA LINEA
		List<Autor> listaAutores = (List<Autor>) request.getAttribute("ListaAutores");
			if(listaAutores != null){
				for(Autor autor : listaAutores){
					%>
					<tr>
						<td><%= autor.getIdAutor() %></td>
						<td><%= autor.getNombre() %></td>
				 		<td><%= autor.getNacionalidad() %></td>
				 		<td></td>
					</tr>
					<%
				}
			}else{
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

</body>
</html>