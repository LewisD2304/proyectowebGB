package com.unu.proyectoWeb.beans;

public class Genero {
	private int idGenero;
	private String nombre;
	private String descripcion;

	public Genero() {
		super();
	}

	public Genero(int idGenero, String nombre, String descripcion) {
		super();
		this.idGenero = idGenero;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
