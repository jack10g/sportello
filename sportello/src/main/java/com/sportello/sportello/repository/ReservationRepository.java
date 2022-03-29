package com.sportello.sportello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sportello.sportello.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	
	@Query(nativeQuery = true, value="SELECT * FROM `prenotazioni` WHERE prenotazioni.client_last_name=?1")
	Reservation searchForLastName(String lastName);
	
	@Query(nativeQuery = true, value="SELECT COUNT(prenotazioni.id_reservation) AS people FROM prenotazioni WHERE prenotazioni.id_reservation<?1")
	int queueRemain(Long idReservation);
	
	@Query(nativeQuery = true, value="SELECT * FROM `prenotazioni` WHERE prenotazioni.id_reservation>?1 LIMIT 1")
	Reservation nextClient(Long idReservation);
}
