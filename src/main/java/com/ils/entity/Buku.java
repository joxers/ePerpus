package com.ils.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author danangku
 *
 */

@Entity
public class Buku {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idBuku;
	@Column 
	private String judul;
	
	private Date tglBeli;
	private String penerbit;
	@OneToOne
	private Kategori kategori;
	
	public Buku(){}
	
	public Buku(int idBuku, String judul, Date tglBeli, String penerbit){
		super();
		this.idBuku = idBuku;
		this.judul = judul;
		this.tglBeli = tglBeli;
		this.penerbit = penerbit;

	}

	

	@Override
	public String toString() {
		return "Buku [idBuku=" + idBuku + ", judul=" + judul + ", tglBeli="
				+ tglBeli + ", penerbit=" + penerbit + ", kategori=" + kategori
				+ "]";
	}

	public int getIdBuku() {
		return idBuku;
	}

	public void setIdBuku(int idBuku) {
		this.idBuku = idBuku;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public Date getTglBeli() {
		return tglBeli;
	}

	public void setTglBeli(Date tglBeli) {
		this.tglBeli = tglBeli;
	}

	public String getPenerbit() {
		return penerbit;
	}

	public void setPenerbit(String penerbit) {
		this.penerbit = penerbit;
	}

	public Kategori getKategori() {
		return kategori;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}
	
	
}
