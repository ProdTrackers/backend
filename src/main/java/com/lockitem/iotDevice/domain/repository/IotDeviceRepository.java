package com.lockitem.iotDevice.domain.repository;

import com.lockitem.iotDevice.domain.entity.IotDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IotDeviceRepository extends JpaRepository<IotDevice, Long> {

}
