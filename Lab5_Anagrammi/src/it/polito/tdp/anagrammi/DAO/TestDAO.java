package it.polito.tdp.anagrammi.DAO;

public class TestDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ParolaDAO pdao = new ParolaDAO();
		pdao.getDizionario();
		System.out.println("\n il caricamento dal database funziona");

	}

}
