package com.example.oauthlegacysecurity.repository;

import com.example.oauthlegacysecurity.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class RoleRepositoryImpl implements RoleRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> findByListOfRoleName(Set<String> roleNames) {
//        this
        TypedQuery<Role> query = entityManager.createQuery("SELECT r FROM Role r WHERE r.name IN :roleNames", Role.class);
        query.setParameter("roleNames", roleNames);

        return query.getResultList();
    }
}
