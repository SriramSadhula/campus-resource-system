
package com.ram.campusresourcesystem.repo;

import com.ram.campusresourcesystem.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByResourceIdAndReservationDateAndStartTimeLessThanAndEndTimeGreaterThan(
            Long resourceId,
            LocalDate reservationDate,
            LocalTime endTime,
            LocalTime startTime
    );

    List<Reservation> findByClientId(int clientId);
}
