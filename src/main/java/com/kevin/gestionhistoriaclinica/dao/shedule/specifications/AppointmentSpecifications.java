package com.kevin.gestionhistoriaclinica.dao.shedule.specifications;

import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentParams;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;

import jakarta.persistence.criteria.Predicate;

public class AppointmentSpecifications {
    public static Specification<Appointment> withParams(AppointmentParams params) {
        return (root, query, criteriaBuilder) -> {
            var predicates = new ArrayList<Predicate>();

            // if (params.getAppointmentDate() != null) {
            // predicates.add(criteriaBuilder.equal(root.get("appointment_date"),
            // params.getAppointmentDate().toString()));
            // }

            if (params.getSlotNumber() != null) {
                predicates.add(criteriaBuilder.equal(root.get("slot_number"),
                        params.getSlotNumber()));
            }

            if (params.getStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"),
                        params.getStatus()));
            }

            if (params.getPatientId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("patient").get("id"),
                        params.getPatientId()));
            }

            if (params.getDoctorSheduleId() != null) {
                predicates
                        .add(criteriaBuilder.equal(root.get("doctor_shedule").get("id"),
                                params.getDoctorSheduleId()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
