package com.ils.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kategori {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idKategori;
	@Column
	private String kategori;
	
	public Kategori(){}

	public int getIdKategori() {
		return idKategori;
	}

	public void setIdKategori(int idKategori) {
		this.idKategori = idKategori;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	
}
