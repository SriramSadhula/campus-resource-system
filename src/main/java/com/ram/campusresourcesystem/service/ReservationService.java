package com.ram.campusresourcesystem.service;

import com.ram.campusresourcesystem.entity.Reservation;
import com.ram.campusresourcesystem.entity.Resource;
import com.ram.campusresourcesystem.repo.ReservationRepository;
import com.ram.campusresourcesystem.repo.ResourceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ResourceRepository resourceRepository;

    public ReservationService(ReservationRepository reservationRepository, ResourceRepository resourceRepository) {
        this.reservationRepository = reservationRepository;
        this.resourceRepository = resourceRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation addReservation(Reservation reservation) {
        Resource resource = resourceRepository.findById(reservation.getResourceId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        Integer quantity = resource.getQuantity();
        int availCount = (quantity != null) ? quantity : 0;

        if (availCount > 0) {
            reservation.setStatus("pending");
            return reservationRepository.save(reservation);
        } else {
            reservation.setStatus("not available");
            return reservation;
        }
    }

    public Reservation approveReservation(Reservation reservation) {
        Reservation res = reservationRepository.findById(reservation.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));

        Resource resource = resourceRepository.findById(res.getResourceId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        if (resource.getQuantity() != null && resource.getQuantity() > 0) {
            resource.setQuantity(resource.getQuantity() - 1);
            resourceRepository.save(resource);
        }

        res.setStatus("approved");
        return reservationRepository.save(res);
    }

    public Reservation rejectReservation(Reservation reservation) {
        Reservation res = reservationRepository.findById(reservation.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));

        res.setStatus("rejected");
        return reservationRepository.save(res);
    }

    public Reservation cancelReservation(Reservation reservation) {
        Reservation res = reservationRepository.findById(reservation.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));

        Resource resource = resourceRepository.findById(res.getResourceId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        resource.setQuantity((resource.getQuantity() != null ? resource.getQuantity() : 0) + 1);
        resourceRepository.save(resource);

        res.setStatus("cancelled");
        return reservationRepository.save(res);
    }

    public List<Reservation> getReservationByClient(int id) {
        return reservationRepository.findByClientId(id);
    }
}
