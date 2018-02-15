package com.crud.model;

public class Pessoa  extends Object{
	private int id;
	private String nome;
	private String email;
	private Integer idade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
      
	@Override
	public String toString() {
		return "{id = " + id + ", nome = " + nome +", email= " + email + ", idade= " + idade + "}";
	}
}

