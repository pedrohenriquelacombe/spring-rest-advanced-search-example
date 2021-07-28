package com.example.advancedsearch.repository.impl;

import com.example.advancedsearch.dto.PersonFilter;
import com.example.advancedsearch.model.Person;
import com.example.advancedsearch.repository.PersonRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class PersonRepositoryImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Person> persons(PersonFilter filter) {
        Map<String, Object> conditions = this.buildConditions(filter);

        String hqlConditions = conditions.get("hql").toString();
        Map<String, String> parameters = (Map<String, String>) conditions.get("parameters");
        Pageable pageable = PageRequest.of(filter.getPageNumber(), filter.getPageSize(), filter.getSort());

        String hql = "FROM Person p " + hqlConditions;
        TypedQuery<Person> query = this.entityManager.createQuery("SELECT DISTINCT p " + hql, Person.class);
        TypedQuery<Long> countQuery = this.entityManager.createQuery("SELECT COUNT(DISTINCT p.id) " + hql, Long.class);

        for (Map.Entry<String, String> param : parameters.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
            countQuery.setParameter(param.getKey(), param.getValue());
        }

        query.setMaxResults(pageable.getPageSize());
        query.setFirstResult(Long.valueOf(pageable.getOffset()).intValue());

        return new PageImpl(query.getResultList(), pageable, countQuery.getSingleResult());
    }

    private Map<String, Object> buildConditions(PersonFilter filter) {
        String andOrWhere = "WHERE";
        Map<String, Object> parameters = new HashMap();
        StringJoiner stringJoiner = new StringJoiner(" ");

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

        Map<String, Object> conditions = new HashMap();
            conditions.put("parameters", parameters);
            conditions.put("hql", stringJoiner.toString());
        return conditions;
    }

}
