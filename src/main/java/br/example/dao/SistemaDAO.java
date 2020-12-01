package br.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.example.config.ConnectionFactory;
import br.example.domain.Sistema;

public class SistemaDAO {

	public List<Sistema> recuperaAll() {
		List<Sistema> lista = new ArrayList<>();
		StringBuilder sql = new StringBuilder("select * from dbparametro.sistema s ");
		try {
			PreparedStatement prepareStatement = ConnectionFactory.getConnection().prepareStatement(sql.toString());
			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {
				Sistema sistema = new Sistema();
				sistema.setId(result.getLong(1));
				sistema.setName(result.getString(2));
				lista.add(sistema);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;

	}

}
