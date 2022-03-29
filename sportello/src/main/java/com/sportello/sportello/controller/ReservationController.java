package com.sportello.sportello.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportello.sportello.model.Reservation;
import com.sportello.sportello.service.ReservationServiceImpl;

@RestController
public class ReservationController {

	@Autowired
	ReservationServiceImpl gestione;
	
	@PostMapping("/addReservation")
	public void addReservation(@RequestBody Reservation reservation1) {
		gestione.addReservation(reservation1);
	}
	
	@PostMapping("/addReservationName/{lastName}")
	public void addReservationForName(@PathVariable String lastName) {
		gestione.addReservationForLastName(lastName);
	}
	
	@GetMapping("/ricercaPrenotazione/{lastName}")
	public Long searchReservation(@PathVariable String lastName) {
		return gestione.searchReservation(lastName);
	}
	
	@GetMapping("ricercaUtenteId/{idReservation}")
	public Optional<Reservation> searchReservationForN(@PathVariable Long idReservation){
		return gestione.searchReservationForN(idReservation);
	}
	
	@GetMapping("/personeInCoda/{idReservation}")
	public int queue(@PathVariable Long idReservation) {
		return gestione.queue(idReservation);
	}
	
	@PostMapping("/deleteReservation/{idReservation}")
	public void deleteReservation(@PathVariable Long idReservation) {
		gestione.removeReservationForId(idReservation);
	}
	
	@GetMapping("/nextClient/{idReservation}")
	public Reservation nextClient(@PathVariable Long idReservation) {
		return gestione.nextClient(idReservation);
	}
}
