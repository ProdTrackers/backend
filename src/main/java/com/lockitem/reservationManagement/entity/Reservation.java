package com.lockitem.reservationManagement.entity;

import com.lockitem.inventoryManagement.entity.Inventory;
import com.lockitem.userProfile.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
    private LocalDateTime reservationTime;
    private LocalDateTime expirationTime;
}
