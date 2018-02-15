package com.crud.util;
import com.crud.model.Pessoa;
import com.crud.repository.PessoaRepository;

public class TesteConexao {
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(2);
		pessoa.setNome("Chris");
		pessoa.setEmail("Chris@gmail.com");
		pessoa.setIdade(20);
	    PessoaRepository.listar();
	}
}
