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
import com.unu.proyectoWeb.models.Conexion;
import com.unu.proyectoWeb.models.EditorialModel;

/**
 * Servlet implementation class EditorialController
 */
public class EditorialController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EditorialModel modeloedt = new EditorialModel();

	public EditorialController() {
		super();
	}

	protected void proccessRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String operacion = request.getParameter("op");
		if (operacion == null) {
			listarEdit(request, response);
			return;
		}

		switch (operacion) {
		case "listarEdit":
			listarEdit(request, response);
			break;
		case "agregarEdit":
			request.getRequestDispatcher("/editoriales/NuevoEditorial.jsp").forward(request, response);
			break;
		case "insertarEdit":
			insertarEdit(request, response);
			break;
		case "obtenerEdit":
			obtenerEdit(request, response);
			break;
		case "modificarEdit":
			modificarEdit(request, response);
			break;
		case "eliminarEdit":
			eliminarEdit(request, response);
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

	private void listarEdit(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("ListaEditorial", modeloedt.listaEditoriales());

			Iterator<Editorial> it = modeloedt.listaEditoriales().iterator();

			while (it.hasNext()) {
				Editorial e = it.next();
				System.out.println(e.getIdEditorial() + " " + e.getNombre() + " " + e.getContacto() + " " + e.getTelefono());
			}
			request.getRequestDispatcher("/editoriales/ListaEditorial.jsp").forward(request, response);
		}catch (ServletException | IOException ex) {
			ex.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void insertarEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Editorial miEdit = new Editorial();
			miEdit.setNombre(request.getParameter("nombre"));
			miEdit.setContacto(request.getParameter("contacto"));
			miEdit.setTelefono(request.getParameter("telefono"));
			if (modeloedt.insertarEditorial(miEdit) > 0) {
				request.getSession().setAttribute("EXITO", "Editorial registrado");
			} else {
				request.getSession().setAttribute("fracaso",
						"El autor no ha sido ingresado" + "ya hay un editorial con este codigo");
			}
			response.sendRedirect(request.getContextPath() + "/EditorialController?op=listarEdit");
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}
	
	private void modificarEdit(HttpServletRequest request, HttpServletResponse response){
		try {
			Editorial editorial = new Editorial();
			editorial.setIdEditorial(Integer.parseInt(request.getParameter("id")));
			editorial.setNombre(request.getParameter("nombre"));
			editorial.setContacto(request.getParameter("contacto"));
			editorial.setTelefono(request.getParameter("telefono"));
			if(modeloedt.modificarEditorial(editorial) > 0) {
				request.getSession().setAttribute("EXITO", "Editorial Modificado Correctamente");
			} else {
				request.getSession().setAttribute("ERROR", "Editorial NO FUE Modificado Correctamente");
			}
			response.sendRedirect(request.getContextPath()+"/EditorialController?op=listarEdit");
		}  catch (Exception ex) {
			ex.getStackTrace();
		}
	}
	
	private void eliminarEdit(HttpServletRequest request, HttpServletResponse response) {
		try {

			int ideditorial = Integer.parseInt(request.getParameter("id"));

			if(modeloedt.eliminarEditorial(ideditorial) > 0) {
				request.getSession().setAttribute("EXITO", "Editorial Modificado Correctamente");
			} else {
				request.getSession().setAttribute("ERROR", "Editorial NO FUE Modificado Correctamente");
			}
			response.sendRedirect(request.getContextPath()+"/EditorialController?op=listarEdit");
			
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
	
	private void obtenerEdit(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = request.getParameter("id");
			Editorial miedit = modeloedt.obtenerEditorial(Integer.parseInt(id));
			
			if(miedit != null) {
				request.setAttribute("editorial", miedit);
				request.getRequestDispatcher("/editoriales/editarEditorial.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/error404.jsp");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
