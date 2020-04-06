package com.example.kolokvijum1.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "Pretplata")
public class Pretplata {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "double")
	private Double cena;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datumRegistracije;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datumOdjave;
	
	@ManyToOne(optional = false)
	private Klijent klijent;

	public Pretplata() {
		super();
	}

	public Pretplata(Long id, Double cena, Date datumRegistracije, Date datumOdjave, Klijent klijent) {
		super();
		this.id = id;
		this.cena = cena;
		this.datumRegistracije = datumRegistracije;
		this.datumOdjave = datumOdjave;
		this.klijent = klijent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Date getDatumRegistracije() {
		return datumRegistracije;
	}

	public void setDatumRegistracije(Date datumRegistracije) {
		this.datumRegistracije = datumRegistracije;
	}

	public Date getDatumOdjave() {
		return datumOdjave;
	}

	public void setDatumOdjave(Date datumOdjave) {
		this.datumOdjave = datumOdjave;
	}

	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Pretplata)) {
			return false;
		}
		Pretplata other = (Pretplata) obj;
		return Objects.equals(cena, other.cena) && Objects.equals(datumOdjave, other.datumOdjave)
				&& Objects.equals(datumRegistracije, other.datumRegistracije) && Objects.equals(id, other.id)
				&& Objects.equals(klijent, other.klijent);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
	}
	
	
	
}
