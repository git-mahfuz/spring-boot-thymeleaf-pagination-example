package com.newroz.thymeleafpagination;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class UserSearchSpecs {
    public static Specification<User> getSearchTickets(UserSearchFormParam params) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (params.getName() != null && params.getName().length() > 0)
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + params.getName() + "%"));

            if (params.getEmail() != null && params.getEmail().length() > 0)
                predicates.add(criteriaBuilder.equal(root.get("email"), params.getEmail()));

            if (params.getStatus() != null && !params.getStatus().equals(UserStatus.All))
                predicates.add(criteriaBuilder.equal(root.get("status"), params.getStatus().equals(UserStatus.Active)));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
