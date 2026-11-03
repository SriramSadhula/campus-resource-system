
package com.ram.campusresourcesystem.service;

import com.ram.campusresourcesystem.entity.Reservation;
import com.ram.campusresourcesystem.repo.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Creates a reservation after checking time conflicts
    public Reservation addReservation(Reservation reservation) {

        boolean conflict =
                reservationRepository
                        .existsByResourceIdAndReservationDateAndStartTimeLessThanAndEndTimeGreaterThan(
                                reservation.getResourceId(),
                                reservation.getReservationDate(),
                                reservation.getEndTime(),
                                reservation.getStartTime()
                        );

        if (conflict) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "This resource is already reserved during this time!"
            );
        }

        reservation.setStatus("Pending");

        return reservationRepository.save(reservation);
    }

}
