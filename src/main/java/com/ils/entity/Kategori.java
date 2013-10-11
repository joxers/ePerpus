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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idKategori;
		result = prime * result
				+ ((kategori == null) ? 0 : kategori.hashCode());
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
		Kategori other = (Kategori) obj;
		if (idKategori != other.idKategori)
			return false;
		if (kategori == null) {
			if (other.kategori != null)
				return false;
		} else if (!kategori.equals(other.kategori))
			return false;
		return true;
	}

	
}
