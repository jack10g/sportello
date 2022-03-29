package com.sportello.sportello.service;

import java.util.Optional;

import com.sportello.sportello.model.Reservation;

public interface ReservationService {
	
	public void addReservation(Reservation reservation1);
	
	public void addReservationForLastName(String lastName);
	
	public void removeReservationForId(Long idReservation);
	
	public Long searchReservation(String lastaName);
	
	public Optional<Reservation> searchReservationForN(Long idReservation);
	
	public int queue(Long idReservation);
	
	public Reservation nextClient(Long idReservation);
	
	
	
}
