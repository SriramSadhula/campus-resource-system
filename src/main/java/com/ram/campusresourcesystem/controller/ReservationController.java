package com.ram.campusresourcesystem.controller;

import com.ram.campusresourcesystem.entity.Reservation;
import com.ram.campusresourcesystem.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://hoppscotch.io"
})
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // GET /api/reservations OR GET /api/reservations?clientId=1
    @GetMapping
    public List<Reservation> getAllReservations(@RequestParam(required = false) Integer clientId) {
        if (clientId != null) {
            return reservationService.getReservationByClient(clientId);
        }
        return reservationService.getAllReservations();
    }

    // POST /api/reservations
    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    // POST /api/reservations/approve
    @PostMapping("/approve")
    public Reservation approveReservation(@RequestBody Reservation reservation) {
        return reservationService.approveReservation(reservation);
    }

    // POST /api/reservations/reject
    @PostMapping("/reject")
    public Reservation rejectReservation(@RequestBody Reservation reservation) {
        return reservationService.rejectReservation(reservation);
    }

    // POST /api/reservations/cancel
    @PostMapping("/cancel")
    public Reservation cancelReservation(@RequestBody Reservation reservation) {
        return reservationService.cancelReservation(reservation);
    }
}
