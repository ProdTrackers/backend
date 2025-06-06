package com.lockitem.inventoryManagement.repository;

import com.lockitem.inventoryManagement.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    // Optional<Inventory> findByIotDevice(IotDevice iotDevice);

}