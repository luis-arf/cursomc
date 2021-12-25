package com.luisarf.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luisarf.cursomc.domain.Categoria;
import com.luisarf.cursomc.domain.Cidade;
import com.luisarf.cursomc.domain.Cliente;
import com.luisarf.cursomc.domain.Endereco;
import com.luisarf.cursomc.domain.Estado;
import com.luisarf.cursomc.domain.Produto;
import com.luisarf.cursomc.domain.enums.TipoCliente;
import com.luisarf.cursomc.repositories.CategoriaRepository;
import com.luisarf.cursomc.repositories.CidadeRepository;
import com.luisarf.cursomc.repositories.ClienteRepository;
import com.luisarf.cursomc.repositories.EnderecoRepository;
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
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
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
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com","12345678901", TipoCliente.PESSOA_FISICA);
		cli1.getTelefone().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(	null, "Rua Flores","300", "Apto 203", "Jardim", "38220134", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38770012", cli1, c2);
		
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
