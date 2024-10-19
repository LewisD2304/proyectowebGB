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
<table id="tabla">
	<thead>
		<tr>
			<th>Codigo del Autor</th>
			<th>Nombre del autor</th>
			<th>Nacionalidad</th>
			<th>Operaciones</th>
		</tr>	
	</thead>
	<tbody>
		<%
			List<Autor> listaAutores = (list<Autor>)reques.getAttribute("ListaAutores");
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
			}
		
		%>
	
	</tbody>
	
	
</table>

</body>
</html>