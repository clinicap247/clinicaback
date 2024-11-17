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

            if (params.getAppointmentDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("appointment_date"),
                        params.getAppointmentDate().toString()));
            }

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
                        .add(criteriaBuilder.equal(root.get("doctorShedule").get("id"),
                                params.getDoctorSheduleId()));
            }

            if (params.getDoctorId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("doctorShedule").get("doctor").get("id"),
                        params.getDoctorId()));
            }

            if (params.getSpecialityId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("doctorShedule").get("speciality").get("id"),
                        params.getSpecialityId()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
