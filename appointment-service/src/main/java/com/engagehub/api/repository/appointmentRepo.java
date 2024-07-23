package com.engagehub.api.repository;

import com.engagehub.api.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface appointmentRepo extends JpaRepository<Appointment, Long> {
}
