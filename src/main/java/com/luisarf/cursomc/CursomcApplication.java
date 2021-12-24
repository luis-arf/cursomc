package com.luisarf.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luisarf.cursomc.domain.Categoria;
import com.luisarf.cursomc.domain.Cidade;
import com.luisarf.cursomc.domain.Estado;
import com.luisarf.cursomc.domain.Produto;
import com.luisarf.cursomc.repositories.CategoriaRepository;
import com.luisarf.cursomc.repositories.CidadeRepository;
import com.luisarf.cursomc.repositories.EstadoRepository;
import com.luisarf.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoryRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado sp = new Estado(null, "São Paulo");
		Estado mg = new Estado(null, "Minas Gerais");
		
		Cidade c1 = new Cidade(null, "Uberlandia", mg);
		Cidade c2 = new Cidade(null, "Sao Paulo", sp);
		Cidade c3 = new Cidade(null, "Campinas",sp);
		
		sp.getCidades().addAll(Arrays.asList(c2,c3));
		mg.getCidades().add(c1);
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(sp,mg));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
	
	}

}
