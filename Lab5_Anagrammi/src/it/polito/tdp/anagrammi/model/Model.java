package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {
	
	public Model() {
		
	}
	
	List<Anagramma> anagrammi;
	ParolaDAO pdao = new ParolaDAO();
	
	
	public void calcolaAnagrammaPubblico(String parola) {
		Anagramma parziale = new Anagramma();
		this.anagrammi = new ArrayList<Anagramma>();
		this.calcolaAnagramma(parola, parziale, 0);
		
	}
	
	private void calcolaAnagramma(String parola, Anagramma parziale,int L) {
		
		 
		if(L==parola.length()) {
			anagrammi.add(parziale.clone());
			return;
			}
	
		
		for(Character c : parola.toCharArray()) {
			
			if(!parziale.contains(c)) {
				parziale.add(c);
				
				calcolaAnagramma(parola,parziale,L+1);
				
				//backtrack
				parziale.remove(c);
			}
			
		}
		
		
	}
	
	public String getCorretti(){
		String res="";
		for(Anagramma a : anagrammi) {
			if(pdao.getCorretto(a)==true) {
			res+= a.getValue()+"\n";
			}
		}
		return res;
	}
	
	public String getErrati(){
		String res="";
		for(Anagramma a : anagrammi) {
			if(pdao.getCorretto(a)==false) {
			res+= a.getValue()+"\n";
			}
		}
		return res;
	}

	
}
