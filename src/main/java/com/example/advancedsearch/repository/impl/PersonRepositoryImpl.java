package com.example.advancedsearch.repository.impl;

import com.example.advancedsearch.dto.PersonFilter;
import com.example.advancedsearch.model.Person;
import com.example.advancedsearch.repository.PersonRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class PersonRepositoryImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Person> findAllByFilter(PersonFilter filter) {
        var conditions = this.buildConditions(filter);
        var hqlConditions = conditions.get("hql").toString();
        var parameters = (Map<String, String>) conditions.get("parameters");
        var pageable = filter.toPageable();

        var hql = new StringBuilder("FROM Person p ").append(hqlConditions);

        pageable.getSort().stream().findFirst().ifPresent(order ->
                hql.append(" ORDER BY p.").append(order.getProperty()).append(" ").append(order.getDirection().name())
        );

        var query = this.entityManager.createQuery("SELECT DISTINCT p " + hql, Person.class);
        var countQuery = entityManager.createQuery("SELECT COUNT(DISTINCT p.id) FROM Person p " + hqlConditions, Long.class);

        parameters.forEach((key, value) -> {
            query.setParameter(key, value);
            countQuery.setParameter(key, value);
        });

        query.setMaxResults(pageable.getPageSize());
        query.setFirstResult((int) pageable.getOffset());

        return new PageImpl<>(query.getResultList(), pageable, countQuery.getSingleResult());
    }

    private Map<String, Object> buildConditions(PersonFilter filter) {
        var andOrWhere = "WHERE";
        var parameters = new HashMap<String, Object>();
        var stringJoiner = new StringJoiner(" ");

        if (!ObjectUtils.isEmpty(filter)) {
            if (!ObjectUtils.isEmpty(filter.getName())) {
                stringJoiner.add(andOrWhere).add("p.name LIKE :name");
                parameters.put("name", filter.getName().concat("%"));
                andOrWhere = "AND";
            }

            if (!ObjectUtils.isEmpty(filter.getEmail())) {
                stringJoiner.add(andOrWhere).add("p.email LIKE :email");
                parameters.put("email", filter.getEmail().concat("%"));
                andOrWhere = "AND";
            }

            if (!ObjectUtils.isEmpty(filter.getMaritalStatus())) {
                stringJoiner.add(andOrWhere).add("p.maritalStatus = :maritalStatus");
                parameters.put("maritalStatus", filter.getMaritalStatus());
                andOrWhere = "AND";
            }

            if (!ObjectUtils.isEmpty(filter.getDistrict())) {
                stringJoiner.add(andOrWhere).add("p.district = :district");
                parameters.put("district", filter.getDistrict());
                andOrWhere = "AND";
            }

            if (!ObjectUtils.isEmpty(filter.getCity())) {
                stringJoiner.add(andOrWhere).add("p.city = :city");
                parameters.put("city", filter.getCity());
                andOrWhere = "AND";
            }

            if (!ObjectUtils.isEmpty(filter.getState())) {
                stringJoiner.add(andOrWhere).add("p.state = :state");
                parameters.put("state", filter.getState());
                andOrWhere = "AND";
            }

            if (!ObjectUtils.isEmpty(filter.getInitialBirthday())) {
                stringJoiner.add(andOrWhere).add("p.birthday >= :initialBirthday");
                parameters.put("initialBirthday", filter.getInitialBirthday());
                andOrWhere = "AND";
            }

            if (!ObjectUtils.isEmpty(filter.getFinalBirthday())) {
                stringJoiner.add(andOrWhere).add("p.birthday <= :finalBirthday");
                parameters.put("finalBirthday", filter.getFinalBirthday());
            }
        }

        return Map.of("parameters", parameters, "hql", stringJoiner.toString());
    }

}
