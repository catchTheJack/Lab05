package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Anagramma {
	
	private List<Character> caratteri ;
	
	
	public Anagramma(){
		
		this.caratteri = new ArrayList<Character>();
		
	}
	
	
	public List<Character> getCaratteri() {
		return caratteri;
	}

	public void add(Character c) {
		this.caratteri.add(c);
	}
	
	public void remove(Character c) {
		this.caratteri.remove(c);
	}
	
	
	public Anagramma clone() {
		Anagramma clone = new Anagramma();
		clone.caratteri = new ArrayList<>(this.caratteri);
		return clone;
	}


	public boolean contains(Character c) {
		return this.caratteri.contains(c);
	}
	
	public String getValue() {
		String val="";
		for(Character c: this.caratteri) {
			val= val+""+c;
		}
		return val;
	}


	@Override
	public String toString() {
		return String.format("Anagramma [caratteri=%s]", caratteri);
	}
	
	
}
