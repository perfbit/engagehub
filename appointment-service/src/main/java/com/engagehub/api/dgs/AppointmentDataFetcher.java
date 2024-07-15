package com.engagehub.api.dgs;

import com.engagehub.api.model.Appointment;
import com.engagehub.api.repository.*;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DgsComponent
public class AppointmentDataFetcher {

    @Autowired
    private appointmentRepo appointmentRepo;

    @DgsData(parentType = "Query", field = "allAppointments")
    public List<Appointment> allAppointments() {
        return appointmentRepo.findAll();
    }

    @DgsData(parentType = "Query", field = "appointmentById")
    public Appointment getAppointmentById(@InputArgument Long id) {
        return appointmentRepo.findById(id).orElse(null);
    }


    @DgsData(parentType = "Mutation", field = "addAppointment")
    public Appointment addAppointment(@InputArgument LocalDateTime dateTime,
                                      @InputArgument String service,
                                      @InputArgument String customerName,
                                      @InputArgument String customerEmail,
                                      @InputArgument String customerPhoneNumber,
                                      @InputArgument boolean isConfirmed,
                                      @InputArgument boolean isCancelled,
                                      @InputArgument boolean isReminderSent) {
        Appointment appointment = new Appointment();
        appointment.setDateTime(dateTime);
        appointment.setService(service);
        appointment.setCustomerName(customerName);
        appointment.setCustomerEmail(customerEmail);
        appointment.setCustomerPhoneNumber(customerPhoneNumber);
        appointment.setConfirmed(isConfirmed);
        appointment.setCancelled(isCancelled);
        appointment.setReminderSent(isReminderSent);
        return appointmentRepo.save(appointment);
    }

    @DgsData(parentType = "Mutation", field = "updateAppointment")
    public Appointment updateAppointment(@InputArgument Long id,
                                         @InputArgument LocalDateTime dateTime,
                                         @InputArgument String service,
                                         @InputArgument String customerName,
                                         @InputArgument String customerEmail,
                                         @InputArgument String customerPhoneNumber,
                                         @InputArgument boolean isConfirmed,
                                         @InputArgument boolean isCancelled,
                                         @InputArgument boolean isReminderSent) {
        Optional<Appointment> appointmentOptional = appointmentRepo.findById(id);
        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            appointment.setDateTime(dateTime);
            appointment.setService(service);
            appointment.setCustomerName(customerName);
            appointment.setCustomerEmail(customerEmail);
            appointment.setCustomerPhoneNumber(customerPhoneNumber);
            appointment.setConfirmed(isConfirmed);
            appointment.setCancelled(isCancelled);
            appointment.setReminderSent(isReminderSent);
            return appointmentRepo.save(appointment);
        }
        return null;
    }

    @DgsData(parentType = "Mutation", field = "deleteAppointment")
    public String deleteAppointment(@InputArgument Long id) {
        appointmentRepo.deleteById(id);
        return "Appointment deleted successfully";
    }

    @DgsData(parentType = "Mutation", field = "createAppointment")
    public String createAppointment(@InputArgument Appointment appointment) {
        appointmentRepo.save(appointment);
        return "Appointment created successfully";
    }
}
