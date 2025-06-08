package com.lockitem.iotDevice.entity;

import com.lockitem.inventoryManagement.entity.Inventory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "iot_device")
@NoArgsConstructor
@AllArgsConstructor
public class IotDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double latitude;
    private double longitude;
    @OneToOne
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private Inventory inventory;
}
