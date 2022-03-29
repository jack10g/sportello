package com.sportello.sportello.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportello.sportello.model.Reservation;
import com.sportello.sportello.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	ReservationRepository gestione;
	
	@Override
	public void addReservation(Reservation reservation1) {
		gestione.save(reservation1);
	}

	@Override
	public void addReservationForLastName(String lastName) {
		Reservation reservation = new Reservation(lastName);
		gestione.save(reservation);
	}


	@Override
	public void removeReservationForId(Long idReservation) {
		gestione.deleteById(idReservation);
	}

	@Override
	public Long searchReservation(String lastName) {
		if(gestione.searchForLastName(lastName)==null) {
			throw new IllegalArgumentException("Prenotazione non presente"); 
		}
		return gestione.searchForLastName(lastName).getId_reservation();
	}

	@Override
	public Optional<Reservation> searchReservationForN(Long idReservation) {
		if(gestione.findById(idReservation)==null) {
			throw new IllegalArgumentException("Prenotazione non presente");
		}
		return gestione.findById(idReservation);
	}

	@Override
	public int queue(Long idReservation) {
		return gestione.queueRemain(idReservation);
	}

	@Override
	public Reservation nextClient(Long idReservation) {
		if(gestione.nextClient(idReservation)==null) {
			throw new IllegalArgumentException("Prenotazione non presente");
		}
		return gestione.nextClient(idReservation);
	}
	
	
	
	
}
