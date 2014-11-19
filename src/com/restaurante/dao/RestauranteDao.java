package com.restaurante.dao;

import java.util.ArrayList;
import java.util.List;

import com.restaurante.entidade.Restaurante;

public class RestauranteDao {
	
	private static RestauranteDao instancia;
	private static List<Restaurante> restaurantes = new ArrayList<Restaurante>();
	
	public static RestauranteDao criarInstancia(){
		if(instancia == null){
			instancia = new RestauranteDao();
		}
		
		return instancia;
	}
	
	public void cadastrar (Restaurante restaurante){
		restaurantes.add(restaurante);
	}
	
	public static List<Restaurante> listarRestaurantes(){
		return restaurantes;
	}
}
