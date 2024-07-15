package com.engagehub.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private LocalDateTime dateTime;
    private String service;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;

    private boolean isConfirmed;
    private boolean isCancelled;
    private boolean isReminderSent;
}
