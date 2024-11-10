package com.kevin.gestionhistoriaclinica.dao.shedule.specifications;

import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleParams;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;

import jakarta.persistence.criteria.Predicate;

public class DoctorSheduleSpecifications {
    public static Specification<DoctorShedule> withParams(DoctorSheduleParams params) {
        return (root, query, criteriaBuilder) -> {
            var predicates = new ArrayList<Predicate>();

            if (params.getDoctorId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("doctor").get("id"), params.getDoctorId()));
            }

            if (params.getSpecialityId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("speciality").get("id"), params.getSpecialityId()));
            }

            if (params.getConsultingRoomId() != null) {
                predicates
                        .add(criteriaBuilder.equal(root.get("consultingRoom").get("id"), params.getConsultingRoomId()));
            }

            if (params.getDayOfWeek() != null) {
                predicates.add(criteriaBuilder.equal(root.get("dayOfWeek"), params.getDayOfWeek()));
            }

            if (params.getStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), params.getStatus()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
