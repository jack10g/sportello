package com.sportello.sportello.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "prenotazioni")

public class Reservation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_reservation")
	private Long idReservation;
	@Column(name="client_name")
	private String nome;
	@Column(name="client_last_name")
	private String lastName;
	
	
	public Reservation(Long idReservation, String nome, String lastName) {
		this.idReservation = idReservation;
		this.nome = nome;
		this.lastName = lastName;
	}
	
	public Reservation(String nome, String lastName) {
		this.nome = nome;
		this.lastName = lastName;
	}
	
	public Reservation(String lastName) {
		this.lastName = lastName;
	}
	
	public Reservation() {
		
	}

	public Long getId_reservation() {
		return idReservation;
	}

	public void setId_reservation(Long id_reservation) {
		this.idReservation = id_reservation;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
	
}
