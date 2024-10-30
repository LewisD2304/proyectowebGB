package com.unu.proyectoWeb.models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.unu.proyectoWeb.beans.Autor;
import com.unu.proyectoWeb.beans.Editorial;

public class EditorialModel extends Conexion {
	CallableStatement cs;
	ResultSet rs;
	/*
	public List<Editorial> listarEditorial() throws SQLException{
		try {
			List<Editorial> lista = new ArrayList<>();
			String sql = "CALL sp_listarEditorial";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Editorial editorial = new Editorial();
				editorial.setNombre(sql);
				editorial.setNombre(rs.getString("nombre"));
				//editorial.setNacionalidad(rs.getString("nacionalidad"));
				//lista.add(autor);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	*/
}
