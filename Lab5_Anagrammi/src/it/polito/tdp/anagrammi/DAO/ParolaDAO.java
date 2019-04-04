package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Parola;



public class ParolaDAO {
	/*
	 * Ottengo tutte le parole salvate nel Db
	 */
	public List<Parola> getDizionario() {

		final String sql = "SELECT * FROM parola ";

		List<Parola> dizionario = new LinkedList<Parola>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				

				//System.out.println(id+ " " + nome);

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Parola al dizionario
				Parola px = new Parola(id,nome);
				dizionario.add(px);
				
			}
			return dizionario;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public boolean getCorretto(Anagramma a) {

		final String sql = "SELECT * FROM parola WHERE nome= ?";
		String anagram = a.getValue();
		boolean corretto = false; 
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagram);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				corretto=true;
			}
			return corretto;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

