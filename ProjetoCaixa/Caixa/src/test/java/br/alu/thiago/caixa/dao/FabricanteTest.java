package br.alu.thiago.caixa.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.alu.thiago.caixa.domain.Fabricante;
import br.alu.thiago.caixa.domain.Fachada;

public class FabricanteTest {

	private Fabricante fabricante;

	private Fachada fachada;

	public FabricanteTest() {
		
		this.fachada = Fachada.getInstancia();
		
		this.fabricante = new Fabricante();
	}

	@Test
	@Ignore
	public void salvar() {

		this.fabricante = new Fabricante();

		this.fabricante.setDescricao("Panasonic");
		
		this.fachada.salvarFabricante(fabricante);

	}
	
	@Test
	@Ignore
	public void listar() {
		
		List<Fabricante>fabricantes = this.fachada.listarFabricante();
		
		for(Fabricante f: fabricantes) {
			
			System.out.println(f);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		
		Fabricante f1  = this.fachada.buscarPorCodigoFabricante(1L);
		
		System.out.println(f1);
	}
	
	@Test
	@Ignore
	public void excluir() {
		
		Fabricante fabricante = this.fachada.buscarPorCodigoFabricante(4L);
		
		this.fachada.excluirFabricante(fabricante);
		
	}
	
	@Test
	@Ignore
	public void editar() {
		
		this.fabricante.setCodigo(1L);
		
		this.fabricante.setDescricao("Apple");
		
		this.fachada.editarFabricante(fabricante);
		
	}

}
