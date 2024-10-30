package com.unu.proyectoWeb.models;

import com.mysql.cj.jdbc.CallableStatement;
import com.unu.proyectoWeb.beans.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoresModel extends Conexion {

	java.sql.CallableStatement cs;
	ResultSet rs;

	public List<Autor> listarAutores() throws SQLException {
		try {
			List<Autor> lista = new ArrayList<>();
			String sql = "CALL sp_listarAutor()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("idautor"));
				autor.setNombre(rs.getString("nombre"));
				autor.setNacionalidad(rs.getString("nacionalidad"));
				lista.add(autor);
			}
			this.cerrarConexion();
			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			this.cerrarConexion();
			;
			return null;

		}
	}

	public int insertarAutor(Autor autor) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_insertarAutor(?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setString(1, autor.getNombre());
			cs.setString(2, autor.getNacionalidad());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;

		} catch (SQLException e) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, e);
			this.cerrarConexion();
			return 0;
		}
	}

	public Autor obtenerAutor(int idautor) {
		Autor autor = new Autor();
		try {
			String sql = "CALL sp_obtenerAutor(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idautor);
			rs = cs.executeQuery();
			if (rs.next()) {

				autor.setIdAutor(rs.getInt("idautor"));
				autor.setNombre(rs.getString("nombre"));
				autor.setNacionalidad(rs.getString("nacionalidad"));
				this.cerrarConexion();
			}

		} catch (Exception e) {
			this.cerrarConexion();
			return null;
		}
		return autor;
	}
	
	public int modificarAutor(Autor autor) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_modificarAutor(?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, autor.getIdAutor());
			cs.setString(2, autor.getNombre());
			cs.setString(3, autor.getNacionalidad());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;

		} catch (SQLException e) {
			e.printStackTrace();
			this.cerrarConexion();
			return 0;
		}
	}
	
	public int eliminarAutor(int idautor) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_eliminarAutor(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idautor);
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;

		} catch (SQLException e) {
			e.printStackTrace();
			this.cerrarConexion();
			return 0;
		}
	}
	
	

}
