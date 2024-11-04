package com.unu.proyectoWeb.models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.unu.proyectoWeb.beans.Autor;
import com.unu.proyectoWeb.beans.Genero;
import com.unu.proyectoWeb.beans.Libro;

public class LibroModel extends Conexion {
	CallableStatement cs;
	ResultSet rs;
	
	public List<Libro> listaLibro() throws SQLException{
		List<Libro> lista = new ArrayList<>();
		try {
			
			String sql = "CALL sp_listarlibro()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while(rs.next()) {
				Libro libro = new Libro();
				libro.setIdlibro(rs.getInt("idlibro"));
				libro.setNombre(rs.getString("nombre"));
				libro.setExistencias(rs.getInt("existencias"));
				libro.setPrecio(rs.getDouble("precio"));
				libro.setAutor(rs.getString("autor"));
				libro.setEditorial(rs.getString("editorial"));
				libro.setGenero(rs.getString("genero"));
				lista.add(libro);
			}
			this.cerrarConexion();
			
		} catch (SQLException e) {
			e.getStackTrace();
			this.cerrarConexion();
			
		}
		return lista;
	}
	/*
	public int insertarLibro(Libro libro) throws SQLException{
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_insertarLibro(?,?,?,?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setString(1, libro.getNombre());
			cs.setInt(2, libro.getExistencias());
			cs.setDouble(3, libro.getPrecio());
			cs.setString(4, libro.getIdautor());
			cs.setString(5, libro.getIdeditorial());
			cs.setString(6, libro.getIdgenero());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (Exception e) {
			e.getStackTrace();
			this.cerrarConexion();
			return 0;
		}
	}
	
	public Libro obtenerLibro(int idLibro) {
		Libro libro = new Libro();
		
		try {
			String sql = "CALL sp_obtenerLibro(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idLibro);
			rs = cs.executeQuery();
			if(rs.next()) {
				libro.setIdlibro(rs.getInt("idlibro"));
				libro.setNombre(rs.getString("nombre"));
				libro.setExistencias(rs.getInt("existencias"));
				libro.setPrecio(rs.getDouble("precio"));
				libro.setIdautor(rs.getString("idautor"));
				libro.setIdeditorial(rs.getString("ideditorial"));
				libro.setIdgenero(rs.getString("idgenero"));
				this.cerrarConexion();
			}
		} catch (Exception e) {
			e.getStackTrace();
			this.cerrarConexion();
			return null;
		}
		
		
		return libro;
	}
	
	public int modificarLibro(Libro libro) throws SQLException{
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_modificarLibro(?,?,?,?,?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, libro.getIdlibro());
			cs.setString(2, libro.getNombre());
			cs.setInt(3, libro.getExistencias());
			cs.setDouble(4, libro.getPrecio());
			cs.setString(5, libro.getIdautor());
			cs.setString(6, libro.getIdeditorial());
			cs.setString(7, libro.getIdgenero());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		
			
		} catch (Exception e) {
			e.printStackTrace();
			this.cerrarConexion();
			return 0;
		}
	}
	
	public int eliminarLibro(int idlibro) throws SQLException{
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_eliminarLibro(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idlibro);
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;

		} catch (Exception e) {
			e.printStackTrace();
			this.cerrarConexion();
			return 0;
		}
	}
	*/
}
