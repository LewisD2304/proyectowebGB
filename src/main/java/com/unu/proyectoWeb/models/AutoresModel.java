package com.unu.proyectoWeb.models;
import com.unu.proyectoWeb.beans.*;
import java.util.ArrayList;
import java.util.List;

public class AutoresModel {
	
	public List<Autor> listarAutores(){
		
		ArrayList<Autor> autores = new ArrayList<>();
		
		autores.add(new Autor(1,"Garcia Marquez", "colombia"));
		autores.add(new Autor(2,"Borgues", "Peruana"));
		autores.add(new Autor(3,"Allende", "Chilena"));
		autores.add(new Autor(4,"Sarai","limeña"));
		
		return autores;
	};
	
	
		
	
}
