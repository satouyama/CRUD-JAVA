package com.crud.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.model.Pessoa;
import com.crud.util.ConnectionFactory;

public class PessoaRepository {

	public static void salvar(Pessoa pessoa) {
		String sql = "insert into pessoa (nome,email,idade) values (?,?,?)";
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getEmail());
			ps.setInt(3, pessoa.getIdade());
			ps.execute();
			System.out.println("pessoa salva");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deletar(int id) {
		String sql = "delete from pessoa where id = ?";
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			System.out.println("Pessoa Deletada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void alterar(Pessoa pessoa) {
		String sql = "update pessoa set nome = ? , email = ? , idade = ? where id = ?";
		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getEmail());
			ps.setInt(3, pessoa.getIdade());
			ps.setInt(4, pessoa.getId());
			ps.execute();

			System.out.println("Pessoa Atualizada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void listar() {
		String sql = "select *from pessoa";
		List<Pessoa> pessoas = new ArrayList<>();
		try (Connection connection = ConnectionFactory.getConnection();
		   PreparedStatement ps = connection.prepareStatement(sql);) {
		   ResultSet rs = ps.executeQuery();      
           while(rs.next()) {
        	  Pessoa pessoa = new Pessoa();
              pessoa.setId(rs.getInt("id"));
              pessoa.setNome(rs.getString("nome"));
              pessoa.setEmail(rs.getString("email"));
              pessoa.setIdade(rs.getInt("idade"));
              pessoas.add(pessoa);
           }
			System.out.println(pessoas);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
