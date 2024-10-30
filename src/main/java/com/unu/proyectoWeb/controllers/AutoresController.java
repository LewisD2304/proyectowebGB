package com.unu.proyectoWeb.controllers;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import com.unu.proyectoWeb.beans.Autor;
import com.unu.proyectoWeb.models.*;

/**
 * Servlet implementation class AutoresController
 */
public class AutoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AutoresModel modelo = new AutoresModel();

	public AutoresController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		/*
		 * try (PrintWriter out = response.getWriter()) { if (request.getParameter("op")
		 * == null) { listar(request, response); return; } }
		 */
		String operacion = request.getParameter("op");

		if (operacion == null) {
			listar(request, response);
			return;
		}

		switch (operacion) {
		case "listar":
			listar(request, response);
			break;
		case "agregar":
			request.getRequestDispatcher("/autores/NuevoAutor.jsp").forward(request, response);
			break;
		case "insertar":
			insertar(request, response);
			break;
		case "obtener":
			obtener(request, response);
			break;
		case "modificar":
			modificar(request, response);
			break;
		case "eliminar":
			eliminar(request, response);
			break;

		/*
		 * 
		 * request.getRequestDispatcher("/autores/nuevoAutor.jsp").forward(request,
		 * response); break; case "insertar": insertar(request, response); break; case
		 * "obtener": obtener(request, response); break; case "modificar":
		 * modificar(request, response); break; case "eliminar": eliminar(request,
		 * response); break;
		 */

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setAttribute("ListaAutores", modelo.listarAutores());

			Iterator<Autor> it = modelo.listarAutores().iterator(); // Objeto tipo iterator

			while (it.hasNext()) {
				Autor a = it.next();
				System.out.println(a.getIdAutor() + " " + a.getNombre() + " " + a.getNacionalidad());
			}

			request.getRequestDispatcher("/autores/ListaAutores.jsp").forward(request, response);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void insertar(HttpServletRequest request, HttpServletResponse response) {
		try {
			Autor miAutor = new Autor();
			miAutor.setNombre(request.getParameter("nombre"));
			miAutor.setNacionalidad(request.getParameter("nacionalidad"));
			if (modelo.insertarAutor(miAutor) > 0) {
				request.getSession().setAttribute("exito", "autor registrado exitosamente");
			} else {
				request.getSession().setAttribute("fracaso",
						"El autor no ha sido ingresado" + "ya hay un autor con este codigo");
			}
			response.sendRedirect(request.getContextPath() + "/AutoresController?op=listar");
		} catch (IOException | SQLException ex) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void modificar(HttpServletRequest request, HttpServletResponse response) {
		try {
			Autor miAutor = new Autor();

			miAutor.setIdAutor(Integer.parseInt(request.getParameter("id")));
			miAutor.setNombre(request.getParameter("nombre"));
			miAutor.setNacionalidad(request.getParameter("nacionalidad"));
			//request.setAttribute("autor", miAutor);

			if (modelo.modificarAutor(miAutor) > 0) {
				request.getSession().setAttribute("EXITO", "Autor Modificado Correctamente");
			} else {
				request.getSession().setAttribute("ERROR", "Autor NO FUE Modificado Correctamente");
			}
			response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
			
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		try {

			int idautor = Integer.parseInt(request.getParameter("id"));

			if (modelo.eliminarAutor(idautor) > 0) {
				request.getSession().setAttribute("EXITO", "Autor Modificado Correctamente");
			} else {
				request.getSession().setAttribute("ERROR", "Autor NO FUE Modificado Correctamente");
			}
			response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
			
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
	
	private void obtener(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = request.getParameter("id");
			Autor miAutor = modelo.obtenerAutor(Integer.parseInt(id));
			
			if(miAutor != null) {
				request.setAttribute("autor", miAutor);
				request.getRequestDispatcher("/autores/editarAutor.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/ERROR 404.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
}
