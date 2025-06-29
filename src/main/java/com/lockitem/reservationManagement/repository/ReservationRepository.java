package com.lockitem.reservationManagement.repository;

import com.lockitem.inventoryManagement.entity.Inventory;
import com.lockitem.reservationManagement.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    boolean existsByInventory(Inventory inventory);
}
