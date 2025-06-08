package com.lockitem.iotDevice.repository;

import com.lockitem.iotDevice.entity.IotDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IotDeviceRepository extends JpaRepository<IotDevice, Long> {

}
