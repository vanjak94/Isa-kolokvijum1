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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "Paket")
public class Paket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "text")
	private String naziv;
	
	@Column
	@Type(type = "double")
	private Double cena;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "paket")
	private List<Pretplata> pretplata = new ArrayList<>();
	
	@ManyToOne(optional = false)
	private Operater operater;

	public Paket() {
		super();
	}

	public Paket(Long id, String naziv, Double cena, List<Pretplata> pretplata, Operater operater) {
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.pretplata = pretplata;
		this.operater = operater;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public List<Pretplata> getPretplata() {
		return pretplata;
	}

	public void setPretplata(List<Pretplata> pretplata) {
		this.pretplata = pretplata;
	}

	public Operater getOperater() {
		return operater;
	}

	public void setOperater(Operater operater) {
		this.operater = operater;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Paket)) {
			return false;
		}
		Paket other = (Paket) obj;
		return Objects.equals(cena, other.cena) && Objects.equals(id, other.id) && Objects.equals(naziv, other.naziv)
				&& Objects.equals(operater, other.operater) && Objects.equals(pretplata, other.pretplata);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
	}
}
