package com.unu.proyectoWeb.beans;

public class Libro {
	private int idlibro;
	private String nombre;
	private int existencias;
	private double precio;
	private String autor;
	private String editorial;
	private String genero;
	
	
	
	public Libro() {
		this(0,"",0,0,"","","");
	}



	public Libro(int idlibro, String nombre, int existencias, double precio, String autor, String editorial,
			String genero) {
		super();
		this.idlibro = idlibro;
		this.nombre = nombre;
		this.existencias = existencias;
		this.precio = precio;
		this.autor = autor;
		this.editorial = editorial;
		this.genero = genero;
	}



	public int getIdlibro() {
		return idlibro;
	}



	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getExistencias() {
		return existencias;
	}



	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public String getEditorial() {
		return editorial;
	}



	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}




	
	
	
	
}
