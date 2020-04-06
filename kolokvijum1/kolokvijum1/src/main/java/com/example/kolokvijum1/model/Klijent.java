package com.example.kolokvijum1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "Klijent")
public class Klijent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "text")
	private String ime;
	
	@Column
	@Type(type = "text")
	private String prezime;
	
	@Column
	@Type(type = "text")
	private String jmbg;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "klijent")
	private List<Pretplata> pretplate = new ArrayList<>();

	public Klijent() {
		super();
	}

	public Klijent(Long id, String ime, String prezime, String jmbg, List<Pretplata> pretplate) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pretplate = pretplate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public List<Pretplata> getPretplate() {
		return pretplate;
	}

	public void setPretplate(List<Pretplata> pretplate) {
		this.pretplate = pretplate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Klijent)) {
			return false;
		}
		Klijent other = (Klijent) obj;
		return Objects.equals(id, other.id) && Objects.equals(ime, other.ime) && Objects.equals(jmbg, other.jmbg)
				&& Objects.equals(pretplate, other.pretplate) && Objects.equals(prezime, other.prezime);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
	}

}
