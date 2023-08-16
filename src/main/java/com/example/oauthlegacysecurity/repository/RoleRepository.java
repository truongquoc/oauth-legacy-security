package com.example.oauthlegacysecurity.repository;

import com.example.oauthlegacysecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends Repository<Role, Long> {
   List<Role> findByListOfRoleName(Set<String> roleNames);
}
