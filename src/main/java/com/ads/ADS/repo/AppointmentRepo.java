package com.ads.ADS.repo;

import com.ads.ADS.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment , Long> {
}
