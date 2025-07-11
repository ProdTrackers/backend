package com.lockitem.inventoryManagement.entity;

import com.lockitem.inventoryManagement.enums.InventoryStatus;
import com.lockitem.iotDevice.entity.IotDevice;
import com.lockitem.reservationManagement.entity.Reservation;
import com.lockitem.storeManagement.entity.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@Table(name = "inventory")
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    private String size;
    @Column(name = "image_url")
    private String imageUrl;
    private Double price;
    @Enumerated(EnumType.STRING)
    private InventoryStatus status = InventoryStatus.DISPONIBLE;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
    @OneToOne(mappedBy = "inventory")
    private IotDevice iotDevice;
}