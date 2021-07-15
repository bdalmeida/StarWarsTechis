package com.starwars.StarWars.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planeta {
	
	
	
	public Planeta(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	@Id
	private String id;
	private String nome;
//	private String clima;
//	private String terreno;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
