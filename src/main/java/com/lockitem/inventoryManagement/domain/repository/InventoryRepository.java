package com.lockitem.inventoryManagement.domain.repository;

import com.lockitem.inventoryManagement.domain.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    // Optional<Inventory> findByIotDevice(IotDevice iotDevice);

}