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


	public boolean contains(String s) {
		if(s.equals(this.getValue()))
		return true;
		else
		return false;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caratteri == null) ? 0 : caratteri.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anagramma other = (Anagramma) obj;
		if (caratteri == null) {
			if (other.caratteri != null)
				return false;
		} else if (!caratteri.equals(other.caratteri))
			return false;
		return true;
	}
	
	
	
}
