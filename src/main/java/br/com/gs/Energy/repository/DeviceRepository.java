package br.com.gs.Energy.repository;

import br.com.gs.Energy.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
