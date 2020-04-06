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
@Table(name = "Operater")
public class Operater {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "text")
	private String poslovnoIme;
	
	@Column
	@Type(type = "text")
	private String pib;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "operater" )
	private List<Paket> paketi = new ArrayList<>();
	
	public Operater() {
		super();
	}
	public Operater(Long id, String poslovnoIme, String pib, List<Paket> paketi) {
		this.id = id;
		this.poslovnoIme = poslovnoIme;
		this.pib = pib;
		this.paketi = paketi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPoslovnoIme() {
		return poslovnoIme;
	}

	public void setPoslovnoIme(String poslovnoIme) {
		this.poslovnoIme = poslovnoIme;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public List<Paket> getPaketi() {
		return paketi;
	}

	public void setPaketi(List<Paket> paketi) {
		this.paketi = paketi;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Operater)) {
			return false;
		}
		Operater other = (Operater) obj;
		return Objects.equals(id, other.id) && Objects.equals(paketi, other.paketi) && Objects.equals(pib, other.pib)
				&& Objects.equals(poslovnoIme, other.poslovnoIme);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
	}
}
