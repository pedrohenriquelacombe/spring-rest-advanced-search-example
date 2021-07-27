package com.example.advancedsearch.specification;

import com.example.advancedsearch.dto.PersonFilter;
import com.example.advancedsearch.model.Person;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonSpecification {

    public Specification<Person> persons(PersonFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList();

            if (!ObjectUtils.isEmpty(filter.getName())) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.upper(root.get("name")), filter.getName().toUpperCase().concat("%"))
                );
            }

            if (!ObjectUtils.isEmpty(filter.getEmail())) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.upper(root.get("email")), filter.getEmail().toUpperCase().concat("%"))
                );
            }

            if (!ObjectUtils.isEmpty(filter.getMaritalStatus())) {
                predicates.add(criteriaBuilder.equal(root.get("maritalStatus"), filter.getMaritalStatus()));
            }

            if (!ObjectUtils.isEmpty(filter.getDistrict())) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.upper(root.get("district")), filter.getDistrict().toUpperCase())
                );
            }

            if (!ObjectUtils.isEmpty(filter.getCity())) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.upper(root.get("city")), filter.getCity().toUpperCase())
                );
            }

            if (!ObjectUtils.isEmpty(filter.getState())) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.upper(root.get("state")), filter.getState().toUpperCase())
                );
            }

            if (!ObjectUtils.isEmpty(filter.getInitialBirthday())) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("birthday"), filter.getInitialBirthday()));
            }

            if (!ObjectUtils.isEmpty(filter.getFinalBirthday())) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("birthday"), filter.getFinalBirthday()));
            }

            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
    }

}
