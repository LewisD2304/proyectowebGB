package com.unu.proyectoWeb.controllers;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JSpinner.ListEditor;

import com.unu.proyectoWeb.beans.Autor;
import com.unu.proyectoWeb.beans.Editorial;
import com.unu.proyectoWeb.beans.Genero;
import com.unu.proyectoWeb.models.Conexion;
import com.unu.proyectoWeb.models.EditorialModel;
import com.unu.proyectoWeb.models.GeneroModel;

/**
 * Servlet implementation class EditorialController
 */
@WebServlet("/GeneroController")
public class GeneroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	GeneroModel modeloGen = new GeneroModel();

	public GeneroController() {
		super();
	}

	protected void proccessRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

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
			request.getRequestDispatcher("/genero/NuevoGenero.jsp").forward(request, response);
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
			

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		proccessRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		proccessRequest(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("ListaGenero", modeloGen.listaGenero());

			Iterator<Genero> it = modeloGen.listaGenero().iterator();

			while (it.hasNext()) {
				Genero e = it.next();
				System.out.println(e.getIdGenero() + " " + e.getNombre() + " " + e.getDescripcion());
			}
			request.getRequestDispatcher("/genero/ListaGenero.jsp").forward(request, response);
		}catch (ServletException | IOException ex) {
			ex.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Genero miGen = new Genero();
			miGen.setNombre(request.getParameter("nombre"));
			miGen.setDescripcion(request.getParameter("descripcion"));
			if (modeloGen.insertarGenero(miGen) > 0) {
				request.getSession().setAttribute("EXITO", "Genero registrado");
			} else {
				request.getSession().setAttribute("fracaso",
						"El genero no ha sido ingresado" + "ya hay un genero con este codigo");
			}
			response.sendRedirect(request.getContextPath() + "/GeneroController?op=listar");
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}
	
	private void modificar(HttpServletRequest request, HttpServletResponse response){
		try {
			Genero miGen = new Genero();
			miGen.setIdGenero(Integer.parseInt(request.getParameter("id")));
			miGen.setNombre(request.getParameter("nombre"));
			miGen.setDescripcion(request.getParameter("descripcion"));
			if(modeloGen.modificarGenero(miGen) > 0) {
				request.getSession().setAttribute("EXITO", "Genero Modificado Correctamente");
			} else {
				request.getSession().setAttribute("ERROR", "Genero NO FUE Modificado Correctamente");
			}
			response.sendRedirect(request.getContextPath()+"/GeneroController?op=listar");
		}  catch (Exception ex) {
			ex.getStackTrace();
		}
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		try {

			int idgenero = Integer.parseInt(request.getParameter("id"));

			if(modeloGen.eliminarGenero(idgenero) > 0) {
				request.getSession().setAttribute("EXITO", "Genero Modificado Correctamente");
			} else {
				request.getSession().setAttribute("ERROR", "Genero NO FUE Modificado Correctamente");
			}
			response.sendRedirect(request.getContextPath()+"/GeneroController?op=listar");
			
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
	
	private void obtener(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = request.getParameter("id");
			Genero migen = modeloGen.obtenerGenero(Integer.parseInt(id));
			
			if(migen != null) {
				request.setAttribute("genero", migen);
				request.getRequestDispatcher("/genero/editarGenero.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/error404.jsp");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
