package com.luisarf.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisarf.cursomc.domain.Categoria;
import com.luisarf.cursomc.repositories.CategoriaRepository;
import com.luisarf.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objecto não encontrado: " + id + ", Tipo:" + Categoria.class.getName()));
	}
	

}
